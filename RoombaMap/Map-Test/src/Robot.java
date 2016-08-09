

public class Robot {
	
	private RMap rMap;
	
	private int dir;//0 = up, 1 = right, 2 = down , 3 = left.
	
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
		 location = convertToLoc(dir);
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
	public void setrMap(RMap rMap) {
		this.rMap = rMap;
	}
	public Location getLocation() {
		return location;
	}
	public Location convertToLoc(int dir){
		
		
		LocationMaker lm = new LocationMaker();
		
		int botx = location.getXCord();
		int boty = location.getYCord();
		
		if(dir == 0){
			Location location = lm.makeLocationXY(botx, boty+1);
			return location;
		}
		else if (dir == 1){
			Location location = lm.makeLocationXY(botx+1, boty+1);
			return location;
		}
		else if (dir == 2){
			Location location = lm.makeLocationXY(botx+1, boty);
			return location;
		}
		else if (dir == 3){
			Location location = lm.makeLocationXY(botx+1, boty-1);
			return location;
		}
		else if (dir == 4){
			Location location = lm.makeLocationXY(botx, boty-1);
			return location;
		}
		else if (dir == 5){
			Location location = lm.makeLocationXY(botx-1, boty-1);
			return location;
		}
		else if (dir == 6){
			Location location = lm.makeLocationXY(botx-1, boty);
			return location;
		}
		else if (dir == 7){
			Location location = lm.makeLocationXY(botx-1, boty+1);
			return location;
		}
		
			return null;
	}

}