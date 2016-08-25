package mapMaker;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulates the map for the Robot by keeping track of its position
 * and places.
 * @author Richard Taylor
 *
 */

public class BotSimulator {
	
	private RMap rMap;
	private Robot bot;
	private List<Wall> walls;
	private List<FreeSpace> freeSpaces;
	
	public BotSimulator(int depth, int width){
		rMap = new RMap(depth,width);
		bot = new Robot(rMap, new Location(0, 0));
		freeSpaces = new ArrayList<FreeSpace>();
        walls = new ArrayList<Wall>();
	}
	
	  public RMap getrMap() {
		return rMap;
	}

	public Robot getBot() {
		return bot;
	}

	public List<Wall> getWalls() {
		return walls;
	}

	public List<FreeSpace> getFreeSpaces() {
		return freeSpaces;
	}

	public void addFreeSpace(Location location){
	    	
	   	 	FreeSpace freespace = new FreeSpace(rMap, location);
	        freeSpaces.add(freespace);
	        
	   	
	   }
	    
	   public void addWall(Location location){
	    	
	   	 	Wall wall = new Wall(rMap, location);
	        walls.add(wall);
	        
	   }

}
