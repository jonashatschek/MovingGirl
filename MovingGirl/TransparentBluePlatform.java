import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TransparentBluePlatform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TransparentBluePlatform extends TransparentPlatform
{
    /**
     * Act - do whatever the TransparentBluePlatform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       getImage().setTransparency(100);
    }    
}
