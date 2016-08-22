package mapMakerTest;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;

/**
 * A simple predator-prey simulator, based on a rectangular field
 * containing rabbits and foxes.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Simulator
{
    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private final int DEFAULT_WIDTH = 175;
    // The default depth of the grid.
    private final int DEFAULT_DEPTH = 135;
    

    
    private int width;
    private int depth;
    // List of places on the map.
    private List<Wall> walls;
    private List<FreeSpace> freeSpaces;
    // The current state of the map.
    private RMap rMap;
    // The current step of the simulation.
    private int step;
    // A graphical view of the simulation.
    private SimulatorView view;
    private Robot bot;

    
    /**
     * Construct a simulation field with default size.
     */
    
    /**
     * Create a simulation field with the given size.
     * @param depth Depth of the field. Must be greater than zero.
     * @param width Width of the field. Must be greater than zero.
     */
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
        
        
        // Create a view of the state of each location in the field.
        view = new SimulatorView(depth, width);
        view.setColor(FreeSpace.class, Color.GREEN);
        view.setColor(Wall.class, Color.RED);
        view.setColor(Robot.class, Color.BLUE);
        
        // Setup a valid starting point.
        reset();
       //populate();
        view.showStatus(step, rMap);
    }
    
  


	public void reset()
    {
        step = 0;
        walls.clear();
        freeSpaces.clear();
        //populate();
        
        // Show the starting state in the view.
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

	public void setrMap(RMap rMap) {
		this.rMap = rMap;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public SimulatorView getView() {
		return view;
	}

	public void setView(SimulatorView view) {
		this.view = view;
	}

	public int getDefaultWidth() {
		return DEFAULT_WIDTH;
	}

	public int getDefaultDepth() {
		return DEFAULT_DEPTH;
	}
    
   
    
}
