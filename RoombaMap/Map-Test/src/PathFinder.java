import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathFinder {
	
	private RMap rMap;
	
	private Robot bot;
	
	public PathFinder(RMap rMap, Robot bot){
		this.rMap = rMap;
		this.bot =bot;
	}
	
	public List findEmptySpace(){
		
		List<Integer> freeSpaces = new ArrayList<Integer>();
		
		Location location = bot.getLocation();
		
		int locX = location.getXCord();
		
		int locY = location.getYCord();
		
		List<Location> freeLocations = rMap.getFreeAdjacentLocations(location);
		
		for(Location next: freeLocations){
			
			
			int nXCord = next.getXCord();
			int nYCord = next.getYCord();
			
			if (locY == nYCord +1 && locX == nXCord){
				
				freeSpaces.add(3);
			}
			else if(locY == nYCord -1 && locX == nXCord){
				
				freeSpaces.add(2);
			}
			else if(locY == nYCord  && locX == nXCord + 1){
				
				freeSpaces.add(1);
			}
			
			else if(locY == nYCord  && locX == nXCord - 1){
				
				freeSpaces.add(0);
			}		
		}
		
		Collections.sort(freeSpaces);
		
		return freeSpaces;
		
		
		
		
	}
	
	
	
	
	

}
