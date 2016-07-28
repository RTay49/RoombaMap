
public abstract class Place {
	
 private RMap rMap;
 
 private Location location;
 
 private String name;
 
 
 public Place(RMap rMap, Location location, String name){
 
 this.rMap = rMap;
 setLocation(location);
 this.name = name;
}
 protected void setLocation(Location newLocation)
 {
     if(location != null) {
    	 rMap.clear(location);
     }
     location = newLocation;
     rMap.place(this, newLocation);
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
public String getName(){
	return name;
}

}
