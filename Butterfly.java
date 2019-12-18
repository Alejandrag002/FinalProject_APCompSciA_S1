import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Butterfly extends Actor
{ 
   double stopped = 0; // buttery by default is stopped
   double grav = 1.3; // gravity is incresing by 2
   double BoostedSpeed = -15;
   int points;
   int starCount;
   Set<Star> starSet = new HashSet<Star>(); 
   
   public Butterfly()
   {
     points = 0;  
     starCount = 10;
   } //End of Butterfly()
    
    /**
     * The Act() method for Butterfly responds to pressing the space bar and makes the butterfly 
     * fly through the Flyworld View.
     * It also resets the speed at which the Butterfly Actor Flies and how it reacts to gravity. 
     */
    
    public void act() 
    {
        setLocation(getX(), (int)(getY() + stopped) );// sets buttery's starting location
       
        // If the user presses UP arrow, it will launch buttery upward
        if (Greenfoot.isKeyDown​("space") == true)
        {
            stopped = BoostedSpeed;
        }
        stopped = stopped + grav;// buttery is falling faster by 2  
    } //End of act()
    
    /**
     * Presents the Game Complete icon when this method is called. 
     */
    public void gameWon()
    {
            GameWon gameWon = new GameWon();
            getWorld().addObject(gameWon,getWorld().getWidth()/2,getWorld().getHeight()/2);
            Greenfoot.stop();
    }//End of gameWon()
        
    /**
     * Presents the Game Over icon when this method is called. 
     */
    
    public void gameOver()
    {
            GameOver gameOver = new GameOver();
            getWorld().addObject(gameOver,getWorld().getWidth()/2,getWorld().getHeight()/2);
            Greenfoot.stop();
    }//End of gameOver()
    
    /**
     * Determines when the Butterfly has intersected with a line or crashed to the ground leading 
     * to a game over.
     */
    
    public boolean gameState()
    {
     
         // If Buttery touches a line then GAME OVER
         if(getOneIntersectingObject(Line.class) != null)
        {
            gameOver();
            return true;
        }  
          // If Buttery Crashes to the ground then GAME OVER
         else if (getY()>getWorld().getHeight())
        {
            gameOver();
            return true;
        } 
   
        return false;
      
    }//End of gameState()
    
    /**
     * When the Butterfly intersects with a Star, the Star object is added to a set of stars that 
     * the Butterfly has ran into. Print statements were used to keep track of collected stars. 
     */    
    
    public void addStar()
    {
        Star collidingStar = (Star) getOneIntersectingObject(Star.class);
        if(collidingStar != null)
        {
            starSet.add(collidingStar);
            //===
            System.out.println("Star set size: " + starSet.size());
            for(Star star:starSet) {
                System.out.println("PointVal: " + star.pointVal + " || Is Special: " + star.specialStar);
            }
            // ======
        }
    } //End of addStar()
}//End of Butterfly Class
