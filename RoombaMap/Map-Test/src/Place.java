
public abstract class Place {
	
 private RMap field;
 
 private Location location;
 
 public Place(RMap field, Location location){
 
 this.field = field;
 setLocation(location);
}
 protected void setLocation(Location newLocation)
 {
     if(location != null) {
         field.clear(location);
     }
     location = newLocation;
     field.place(this, newLocation);
 }
}
