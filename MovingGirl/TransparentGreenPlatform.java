import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TransparentGreenPlatform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TransparentGreenPlatform extends TransparentPlatform
{
    /**
     * Act - do whatever the TransparentGreenPlatform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getImage().setTransparency(100);
    }    
}
