import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Line extends Actor
{
    int lineSpeed = -4;
    /**
     * Sets line image.
     */
    public void act() 
    {
        setLocation(getX() + lineSpeed ,getY());
    }    
}
