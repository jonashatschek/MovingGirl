import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlueBlob here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueBlob extends Blob
{
    
    private int mAnimateTimer = 15; //regulates how often ice can be shot (every 50th turn)
    private int mAnimate = 15; //instatiates a variable for regulating how often ice can me shot

    private int mCounter;
    /**
     * Act - do whatever the GreenBlob wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mAnimate++;
        if(mAnimate >= mAnimateTimer) //limits the amount of ice that can be shot to one every 50th turn
        {
            animate();
            mAnimate = 0; //resets the variable to 0
        }

    }

    public void animate() {

        mCounter++;

        if(mCounter == 1){  

            setImage("blue_blob1.png");

        }
        else if (mCounter == 2){

            setImage("blue_blob2.png");

        }
        else if (mCounter == 3){

            setImage("blue_blob3.png");
            mCounter = 0;
        }
    }
}
