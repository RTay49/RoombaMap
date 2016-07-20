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
    private static final int DEFAULT_WIDTH = 125;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 85;
    

    
    private int width;
    private int depth;
    // List of places on the map.
    private List<Place> places;
    // The current state of the map.
    private RMap rMap;
    // The current step of the simulation.
    private int step;
    // A graphical view of the simulation.
    private SimulatorView view;
    
    
    /**
     * Construct a simulation field with default size.
     */
    public Simulator()
    {
        this(DEFAULT_DEPTH, DEFAULT_WIDTH);
    }
    
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
        
        places = new ArrayList<Place>();
        rMap = new RMap(depth, width);

        // Create a view of the state of each location in the field.
        view = new SimulatorView(depth, width);
        view.setColor(FreeSpace.class, Color.GREEN);
        
        // Setup a valid starting point.
        reset();
       //populate();
    }
    
  
    public void reset()
    {
        step = 0;
        places.clear();
        //populate();
        
        // Show the starting state in the view.
        view.showStatus(step, rMap);
    }
    
  
    
    public void addFreeSpace(Location location){
    	
   	 	FreeSpace freespace = new FreeSpace(rMap, location);
        places.add(freespace);
        
        view.showStatus(step, rMap);
        
   	
   }

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
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

	public static int getDefaultWidth() {
		return DEFAULT_WIDTH;
	}

	public static int getDefaultDepth() {
		return DEFAULT_DEPTH;
	}
    
   
    
}
