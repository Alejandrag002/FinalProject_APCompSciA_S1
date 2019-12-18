import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FlyWorld extends World
{
   Butterfly buttery;
   int lineCounter; //global variable
   int starCounter;
   Counter counter;
    /**
     * Constructor for objects of class FlyWorld.
     */
    public FlyWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600,1, false);//size of world, //false = buttery can pass screen 
        
        // Butterfly object
        buttery = new Butterfly();
        counter = new Counter();
        //Add buttery to my  world
        addObject(buttery, 100, getHeight()/2);
        addObject(counter, getWidth()/2, 50);
        lineCounter = 0;
        starCounter = 0;
       
    } //End of FlyWorld()
    /**
     * FlyWorld act() method handles the game conditions and determines whether a player can
     * continue to play. When 5 stars have been collected, the points are added up and displayed
     * on the FlyWorld.
     */
    public void act()
    {
     if (buttery.starSet.size() < 5){
         lineCounter++;
         starCounter++;
         addnewobstacle();
         addNewStar();
         buttery.gameState();
         buttery.addStar();
     } else {
         //buttery.addPoints();
         counter.addScore(buttery);
         buttery.gameWon();
      }
   } //End of act()
    
    /**
     * Creates a Line Object and Places it on the FlyWorld at a given position. 
     * The lineCounter determines when a line comes into the FlyWorld view and sets its position. 
     */
    public void addnewobstacle()
    { 
       if(lineCounter == 100)
       {
         // Line Object
         Line line = new Line();
         GreenfootImage image = line.getImage();
         addObject(line,getWidth(), getHeight()/2 + image.getHeight()/2);
         // lineCounter is reset to 0 in order to begin to increment for a new line's position.
         lineCounter = 0;
       }   
    } //End of addNewObstacle()
    
    /**
     * Creates a Star Object and Places it on the FlyWorld at a given position. 
     * The starCounter determines when a star comes into the FlyWorld view and sets its position.
     * The stars are placed differently than the lines, and have different collision behavior. 
     */
    
    public void addNewStar()
    { 
        if(starCounter == 100)
        {
            // Star Object
            Star star = new Star();
            star.randomPointVal();
            star.isSpecialStar();
            GreenfootImage image = star.getImage();
            addObject(star, getWidth(),getHeight()/2 - getHeight()/4);
            starCounter = 0;
        }
    } //End of addNewStar()
}// End of FlyWord
