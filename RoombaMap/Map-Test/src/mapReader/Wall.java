package mapReader;
/**
 * an object that represents a place on the map with a wall
 * extends from places.
 * @author Richard Taylor
 *
 */

public class Wall extends Place {
	
	
	public Wall(RMap field, Location location){
		super(field, location, "Wall",true);
		
		
	}
}
