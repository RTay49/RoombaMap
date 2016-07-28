import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathFinder {
	
	private RMap rMap;
	
	private Robot bot;
	
	public PathFinder(RMap rMap, Robot bot){
		this.rMap = rMap;
		this.bot = bot;
	}
	
	public List findEmptySpace(){
		
		System.out.println("finding free spaces");
		
		List<Integer> freeSpaces = new ArrayList<Integer>();
		
		
		Location location = bot.getLocation();
		
		System.out.println("bot location found" );
		
		
		int locX = location.getXCord();
		
		int locY = location.getYCord();
		
		System.out.println("bot location:" + locX + "," + locY + ".");
		
		System.out.println("finding free ajacent locations");
		List<Location> freeLocations = rMap.getFreeAdjacentLocations(location);
		System.out.println("free ajacent locations recived");
		
		for(Location next: freeLocations){
			
			
			int nXCord = next.getXCord();
			int nYCord = next.getYCord();
			
			System.out.println("new X cord:" + nXCord);
			System.out.println("new Y cord:" + nYCord);
			
			if ( locX == nXCord && locY == nYCord + 1){
				
				freeSpaces.add(3);
				System.out.println("up(3) added");
			}
			else if(locY == nYCord -1 && locX == nXCord){
				
				freeSpaces.add(2);
				System.out.println("right(2) added");
			}
			else if(locY == nYCord  && locX == nXCord + 1){
				
				freeSpaces.add(1);
				System.out.println("down(1) added");
			}
			
			else if(locY == nYCord  && locX == nXCord - 1){
				
				freeSpaces.add(0);
				System.out.println("left(0) added");
			}		
		}
		
		Collections.sort(freeSpaces);
		System.out.println("free spaces sorted");
		
		return freeSpaces;
		
		
		
		
	}
	
	
	
	
	

}
