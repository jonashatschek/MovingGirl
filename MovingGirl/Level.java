import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * A level is a world where a Girl can move around and jump on platforms.
 * 
 * @author Thomas Ejnefjäll
 * @version 2014-06-04
 */
public class Level extends World
{
    private LevelCreator mLevelCreator;
    private int mCurrentLevel;
    private int mDoorXLoc;
    private int mDoorYLoc;
    
    /**
     * Constructs a Level.
     */
    public Level()
    {         
        super(800, 600, 1); 
        //populateWorld();
        mLevelCreator = new LevelCreator();
        mCurrentLevel = 1;
        nextLevel();
    }
    
    @Override
    public void act(){
        
        List<Door> door = new ArrayList<Door>();
        door = getObjects(Door.class);
        
        mDoorXLoc = door.get(0).getX();
        mDoorYLoc = door.get(0).getY();
        
        List<Girl> girl = new ArrayList<Girl>();
        girl = getObjectsAt(mDoorXLoc, mDoorYLoc, Girl.class);
        
        //if(girl.get(0) != null){
            //nextLevel();
        //}
    }
    
    
    private void buildLevel(String[] level){
        int cellSize = 50;
        for(int y = 0; y < level.length; y++){
            
            String row = level[y];
            for(int x = 0; x < row.length(); x++){
                
                Actor actor = createObjects(row.charAt(x));              
                if(actor != null){
                    addObject(actor, cellSize/2 + x * cellSize, cellSize/2 + y * cellSize);
                    
                }
            }
        }
    }
    
    private Actor createObjects(char c){
        Actor actor = null;
        
        if(c == 'C'){
            actor = new Girl();
        }
        else if(c == 'B'){
            actor = new BlueBlob();
        }
        else if(c == 'G') {
            actor = new GreenBlob();
        }
        else if(c == 'g') {
            actor = new TransparentGreenPlatform();
        }
        else if(c == 'b') {
            actor = new TransparentBluePlatform();
        }
        else if(c == 'P'){
            actor = new Platform();
        }
        else if(c == 'D'){
            actor = new Door();
        }
        
        return actor;
    }
    
    /**
     * Populate the world with a Woman and platforms.
     */
    private void populateWorld()
    {
        //Make the ground
        for(int i = 0; i < 16; i ++)
        {
            addObject(new Platform(), 25 + i * 50, 575);
        }   
        
        //Add a Woman who can move around in the world
       
        addObject(new Girl(), 50, 50);
        
        //Add some platforms that can be jumped onto
        addObject(new Platform(), 150, 475);
        addObject(new Platform(), 200, 475);
        addObject(new Platform(), 250, 475);
        
        addObject(new GreenBlob(), 100, 475);
        
        addObject(new Platform(), 350, 375);
        addObject(new Platform(), 400, 375);
        addObject(new Platform(), 450, 375);
        addObject(new Platform(), 500, 375);
        
        addObject(new Platform(), 200, 275);
        addObject(new Platform(), 250, 275);
        
        addObject(new Platform(), 250, 175);
        
        addObject(new TransparentGreenPlatform(), 300, 175);
               
        addObject(new Platform(), 500, 275);
        addObject(new Platform(), 550, 275);
               
        setPaintOrder(Girl.class);
        
    }
    
    public void nextLevel(){
        String[] level = mLevelCreator.getLevel(mCurrentLevel++);
        if(level != null){
            removeObjects(getObjects(null));
            buildLevel(level);
        }
        else{
            Greenfoot.stop();
        }
    }
    
}
