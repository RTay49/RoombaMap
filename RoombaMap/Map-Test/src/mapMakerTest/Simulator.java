package mapMakerTest;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

/**
 * A class taken from the Fox's and rabbits simulation this software was
 * converted from this class will set up a simulated map.
 * 
 * Original by
 * @author David J. Barnes and Michael Kölling
 * Converted by 
 * 	Richard Taylor
 */
public class Simulator
{
    
    private final int DEFAULT_WIDTH = 101;
   
    private final int DEFAULT_DEPTH = 101;
    
   
    private List<Wall> walls;
    private List<FreeSpace> freeSpaces;
    
    private RMap rMap;
   
    private int step;//how many places the robot has been.
    
    private SimulatorView view;
    private Robot bot;

    

    public Simulator(int depth, int width)
    {
        if(width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }
        else if((width & 1) == 0 || (width & 1) == 0){
            System.out.println("The dimensions must be odd numbers.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        	
        }
        freeSpaces = new ArrayList<FreeSpace>();
        walls = new ArrayList<Wall>();
        rMap = new RMap(depth, width);
        bot = new Robot(rMap, new Location(0, 0));
        
        
        
        view = new SimulatorView(depth, width);
        view.setColor(FreeSpace.class, Color.GREEN);
        view.setColor(Wall.class, Color.RED);
        view.setColor(Robot.class, Color.BLUE);
        
    
        reset();
     
        view.showStatus(step, rMap);
    }
    
  


	public void reset()
    {
        step = 0;
        walls.clear();
        freeSpaces.clear();
        view.showStatus(step, rMap);
    }
    
  
    
    
    public void changeBotLoc (Location location){
    	
    	bot.setLocation(location);
    	
    }
    
    public void addFreeSpace(Location location){
    	
   	 	FreeSpace freespace = new FreeSpace(rMap, location);
        freeSpaces.add(freespace);
        
   	
   }
    
   public void addWall(Location location){
    	
   	 	Wall wall = new Wall(rMap, location);
        walls.add(wall);
        
   }
   
   public void update(){
	   step++;
	   view.showStatus(step, rMap);
   }

	public List<FreeSpace> getFreeSpaces() {
		return freeSpaces;
	}
	public List<Wall> getWalls() {
		return walls;
	}
    public Robot getBot() {
		return bot;
	}

	public RMap getrMap() {
		return rMap;
	}

	public int getStep() {
		return step;
	}

	public SimulatorView getView() {
		return view;
	}

	public int getDefaultWidth() {
		return DEFAULT_WIDTH;
	}

	public int getDefaultDepth() {
		return DEFAULT_DEPTH;
	}
    
   
    
}
