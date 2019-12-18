import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

public class Star extends Actor
{
    int starSpeed = -4;
    int pointVal;
    boolean specialStar;
    Random random;
    /**
     * Star Constructor
     */
    Star()
    {
        pointVal = 0;
        random = new Random();
        specialStar = false;
    } // End of Star()
    
     /**
     * Sets Star image.
     */
    public void act() 
    {
        setLocation(getX() + starSpeed ,getY());
    } // End of act()
    
    /**
     * Randomly assigns a point value to a star. 
     */
    public void randomPointVal()
    {
        pointVal = random.nextInt(10) + 1;
    }// End of randomPointVal()
    
    /**
     * Randomly assigns a boolean to specialStar. 
     */
    public void isSpecialStar()
    {
        specialStar = random.nextBoolean();
    }// End of isSpecialStar()
}// End of Star()
