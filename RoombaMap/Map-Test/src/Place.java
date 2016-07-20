
public abstract class Place {
	
 private Field field;
 
 private Location location;
 
 public Place(Field field, Location location){
 
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
