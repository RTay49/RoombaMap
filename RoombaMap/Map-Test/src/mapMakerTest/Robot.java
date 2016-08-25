package mapMakerTest;
/**
 * A class that keeps track of the Robot.
 * 
 * @author Richard Taylor
 *
 */

public class Robot {
	
	private RMap rMap;
	
	private int dir;
	
	private Location location;
	 
	 
	 public Robot(RMap rMap, Location location){
	 
	 this.rMap = rMap;
	 setLocation(location);
	}
	 protected void setLocation(Location newLocation)
	 {
	     if(location != null) {
	    	 rMap.clear(location);
	     }
	     location = newLocation;
	     rMap.place(this, newLocation);
	     System.out.println("Bot location:" + newLocation.getXCord() + "," + newLocation.getYCord() + ".");
	 
	 }
	 
	 
	 
	 public void moveBot(int dir){
		 System.out.println("getting location");
		 location = Utilities.convertToLoc(dir,location.getXCord(),location.getYCord());
		 System.out.println("Setting bot to location " + location.getXCord() + "," + location.getYCord() + ".");
		 setLocation(location);
	 }
	 
	 
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
	
	public RMap getrMap() {
		return rMap;
	}
	public Location getLocation() {
		return location;
	}
	

}