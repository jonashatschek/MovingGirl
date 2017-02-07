import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Mover provides basic movement methods and methods to check and handle Mover's interaction
 * with floor, ceiling and walls. Use this as a superclass for actors that should be able to move 
 * left and right, jump up and fall down.
 * 
 * @author Griff (griff@kvusd.org)
 * @author Thomas Ejnefjäll
 * @version 2014-06-04
 */
public class Mover extends Actor
{
    private static final int ACCELERATION = 1;        //down (gravity)
    private static final int HORIZONTAL_SPEED = 4;    //running speed (sideways)
    private static final int JUMP_STRENGTH = 16;      //determines how high we can jump
    private static final int MAX_VERTICAL_SPEED = 9;  //we can not faster than this
    private int verticalSpeed = 0;                    //current vertical speed. 0 = on ground. >0 = jumping up. <0 = falling down
    
    /**
     * Constructs a Mover.
     */
    public Mover()
    {
        
    }
    
    /**
     * Check so the Mover do not move through plattforms.
     */
    public void checkCollisions()
    {
        checkFall();
        checkPlatformAbove();
        checkWalls();        
    }
    
    /**
     * Move right.
     */
    public void moveRight()
    {
        setLocation (getX() + HORIZONTAL_SPEED, getY());
    }
    
    /**
     * Move left.
     */
    public void moveLeft()
    {
        setLocation (getX() - HORIZONTAL_SPEED, getY());
    }
    
    /**
     * Jump.
     */
     public void jump()
    {
        verticalSpeed = -JUMP_STRENGTH;
        fall();
    }    
        
    /**
     * Check if the Mover is on the ground, ie is standing on a platform.
     * 
     * @return true if the Mover is on the ground, false if not.
     */
    public boolean isOnGround()
    {
        boolean onGround = false;
                  
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight()/2 , Platform.class);
        
        if(ground != null)       
        {
            moveOutOfGround(ground);
            onGround = true;              
        }        
        return onGround;
    }
    
    /**
     * Check if the Mover has moved inside a wall, if so move it out of the wall.
     */
    private void checkWalls()
    {        
        Actor rightWall = getOneObjectAtOffset(getImage().getWidth() / 2, 0, Platform.class);
        Actor leftWall = getOneObjectAtOffset(getImage().getWidth() / -2, 0, Platform.class);
        
        if(rightWall != null)
        {
            moveOutOfRightWall(rightWall);
        }
        else if(leftWall != null)
        {
            moveOutOfLeftWall(leftWall);            
        }                                
    }
    
    /**
     * Move out of a wall on our left side.
     * 
     * @param wall the wall we want to move out of.
     */
    private void moveOutOfLeftWall(Actor wall)
    {
        int wallWidth = wall.getImage().getWidth();
        int newX = wall.getX() + (wallWidth + getImage().getWidth())/2;
        setLocation(newX + HORIZONTAL_SPEED, getY());           
    }
    
    /**
     * Move out of a wall on our right side.
     * 
     * @param wall the wall we want to move out of.
     */
    private void moveOutOfRightWall(Actor wall)
    {
        int wallWidth = wall.getImage().getWidth();
        int newX = wall.getX() - (wallWidth + getImage().getWidth())/2;
        setLocation(newX - HORIZONTAL_SPEED, getY());                
    }
    
    /**
     * Check if we have jumped into a platform above (our ceiling), if so move 
     * out of the ceiling and make sure we start to fall down.
     */
    private void checkPlatformAbove()
    {        
        Actor ceiling = getOneObjectAtOffset(0, getImage().getHeight() / -2, Platform.class);
        
        if(ceiling != null)
        {
            verticalSpeed = 1;            
            moveOutOfCeiling(ceiling);            
        }        
    }
    
    /**
     * Move out of the ceiling.
     * 
     * @param ceiling the ceiling we want to move out of.
     */
    private void moveOutOfCeiling(Actor ceiling)
    {
        int ceilingHeight = ceiling.getImage().getHeight();
        int newY = ceiling.getY() + (ceilingHeight + getImage().getHeight()) / 2;
        setLocation(getX(), newY);        
    }
        
    /**
     * Check if we have reach ground. If we have reach ground stop falling.
     */
    private void checkFall()
    {
        if (isOnGround()) {
            verticalSpeed = 0;
        }
        else {
            fall();
        }
    }
            
    /**
     * Fall faster and faster.
     */
    private void fall()
    {
        setLocation (getX(), getY() + verticalSpeed);
        verticalSpeed = verticalSpeed + ACCELERATION;
        
        if(verticalSpeed > MAX_VERTICAL_SPEED)
        {
            verticalSpeed = MAX_VERTICAL_SPEED;
        }
    }
    
    /**
     * Move out of the ground.
     * 
     * @param ground the ground we want to move out of.
     */
    private void moveOutOfGround(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);              
    }
}
