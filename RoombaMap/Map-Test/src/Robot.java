

public class Robot {
	
	private RMap rMap;
	
	private String mov;
	
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
	 
	 }
	 
	 public void turnDirRight(){
		if(dir != 3){
			dir = dir + 1;
		}
		else{
			dir = 0;
		}
	 }
	 
	 public void turnDirLeft(){
			if(dir != 0){
				dir = dir - 1;
			}
			else{
				dir = 3;
			}
		 }
	 
	 
	 
	 
	 
	public String getMov() {
		return mov;
	}
	public void setMov(String mov) {
		this.mov = mov;
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

	}