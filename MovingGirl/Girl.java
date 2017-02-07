import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * A Girl that can jump on platforms and have fun.
 * 
 * @author Thomas Ejnefjäll 
 * @version 2014-06-04
 */
public class Girl extends Mover
{
    /**
     * Constructs a Girl.
     */
    public Girl()
    {
        
    }
    
    @Override
    public void act() 
    {
       checkKeys();
       checkCollisions();
       checkForBlobCollision();
       
    } 
    
    /**
     * Check if the user has pressed any keys used in the game. If so act accordingly.
     */
    private void checkKeys()
    {
        if (Greenfoot.isKeyDown("left") )
        {            
            moveLeft();
        }
        if (Greenfoot.isKeyDown("right") )
        {            
            moveRight();
        }
        if (Greenfoot.isKeyDown("up"))
        {
            if (isOnGround())
            {
                jump();
            }
        }
    }
    
    private void checkForBlobCollision(){
        
        if(isTouching(GreenBlob.class)){
            
            List<TransparentGreenPlatform> blobList = getWorld().getObjects(TransparentGreenPlatform.class);
            for(int i = 0; i < blobList.size(); i++){
                int xLoc = blobList.get(i).getX();
                int yLoc = blobList.get(i).getY();
                getWorld().removeObject(blobList.get(i));
                getWorld().addObject(new GreenPlatform(), xLoc, yLoc);
            }
            /*
            ArrayList<TransparentPlatform> blobList = new ArrayList<>();
            blobList = getWorld().getObjects(TransparentGreenPlatform.class);
            activatePlatforms(blobList, "green");
            */
        }
        
        if(isTouching(BlueBlob.class)){
            
            List<TransparentBluePlatform> blobList = getWorld().getObjects(TransparentBluePlatform.class);
            for(int i = 0; i < blobList.size(); i++){
                int xLoc = blobList.get(i).getX();
                int yLoc = blobList.get(i).getY();
                getWorld().removeObject(blobList.get(i));
                getWorld().addObject(new BluePlatform(), xLoc, yLoc);
            }
        }
        
        //getWorld().removeObjects(getWorld().getObjects(GreenPlatform.class));
    }
    /*
    public void activatePlatforms(List<Transparentplatform> blobList, String color){
            String platform;
            
            if(color == "green"){
                platform = "new GreenPlatform()";
            }
            else{
                platform = "new BluePlatform()";
            }
            
            for(int i = 0; i < blobList.size(); i++){
                int xLoc = blobList.get(i).getX();
                int yLoc = blobList.get(i).getY();
                getWorld().removeObject(blobList.get(i));
                getWorld().addObject( platform, xLoc, yLoc);
            }
    }
    */
}
