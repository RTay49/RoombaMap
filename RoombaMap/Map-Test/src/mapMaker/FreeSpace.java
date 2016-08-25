package mapMaker;

/**
 * an object that represents a place on the map with no walls
 * extends from places.
 * @author Richard Taylor
 *
 */
public class FreeSpace extends Place {
	
	public FreeSpace(RMap field, Location location){
		super(field, location,"FreeSpace",false);
		
		
	}

}
