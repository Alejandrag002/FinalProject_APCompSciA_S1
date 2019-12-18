import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Counter extends Actor
{
    private int score = 0;
    /**
     * Places the score label on FlyWorld.
     */
    public void act() 
    {
       setImage(new GreenfootImage("Score : "+ score, 60, Color.GREEN, Color.BLACK));
    } //End of act()  
    /**
     * Totals up the score of the stars the butterfly caught. If a Star is a Special Star AND its 
     * point Value is greater than or equal to 5 points, its value is doubled, then added to the 
     * total. All other scores are just added to the total 'score'.
     */ 
    public void addScore(Butterfly butterfly)
    {
            for(Star star:butterfly.starSet) {
                if(star.specialStar == true && star.pointVal >= 5)
                {
                    score += star.pointVal * 2;
                }else{
                    score += star.pointVal;
                }
            }
            System.out.println("Total: " + score); 
            setImage(new GreenfootImage("Score : " + score, 60, Color.GREEN, Color.BLACK));
    }//End of addScore()
    
}//End of Counter()


