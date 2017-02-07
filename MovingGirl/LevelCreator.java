import java.util.List;
import java.util.ArrayList;
import java.nio.file.*;
/**
 * Write a description of class LevelCreator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelCreator  
{

    /**
     * Constructor for objects of class LevelCreator
     */
    public LevelCreator()
    {
    }
    
    public String[] getLevel(int levelNumber){
        Path path = Paths.get("levels/level" + levelNumber + ".txt");
        
        if(!Files.exists(path)){
            return null;
        }
        
        List<String> level = null;
        
        try{
            level = Files.readAllLines(path);
        }catch (java.io.IOException ioe) {
            return null;
        }
        
        return level.toArray(new String[level.size()]);
    }
}
