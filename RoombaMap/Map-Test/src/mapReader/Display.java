package mapReader;
import java.awt.Color;
import java.util.ArrayList;

/**
 * A class used to display a map with inputed Coordinates.
 * @author Richard Taylor
 *
 */

public class Display {
	
	private ArrayList<String> walls;
	private ArrayList<String> fSs;
	private RMap rMap;
	private SimulatorView sv;
	
	public Display(ArrayList<String> walls, ArrayList<String> fSs){
		
		this.walls = walls;
		this.fSs = fSs;
		
		rMap = new RMap(101,101);
		sv = new SimulatorView(101, 101);
		sv.setColor(FreeSpace.class, Color.GREEN);
	    sv.setColor(Wall.class, Color.RED);
		makeWalls();
		makeFreeSpaces();
		sv.showStatus(0, rMap);

	}
	
public void makeWalls(){
		
		for(String wall: walls){
			
			Location location = convertToLocation(wall);
			new Wall(rMap,location);
			
		
		}
		
	}
	
public void makeFreeSpaces(){
		
		for(String fs: fSs){
			
			Location location = convertToLocation(fs);
			new FreeSpace(rMap,location);
			
		
		}
		
	}
	
	public Location convertToLocation(String loc){
		
		int l = loc.length();
		
		boolean xc = true;
		String x = "";
		String y = "";
			
		for(int i = 0; i < l; i++){
				char c = loc.charAt(i);
				if(c == ','){
					xc = false;
				}
				
				if(xc){
					x = x + c;
				}
				else if (c != ','){
					y = y + c;
				}
		}
		
		int XCoord = Integer.parseInt(x);
		int YCoord = Integer.parseInt(y);
		
		Location location  = new Location(XCoord,YCoord);
		
		return location;
	}

}
