
import java.util.List;

public class Plot {
	
	private Simulator sim;
	
	public Plot (Simulator sim){
		this.sim = sim;
	}
	
	public void plotFreeLine(List<Location> freeLine){
		
		
		for(Location freeSpace : freeLine){
			
			sim.addFreeSpace(freeSpace);
				
				
				
			}
		
	}
	
	public void plotWallLine(List<Location> wallLine){
		
		for(Location wall : wallLine){
			
			sim.addWall(wall);
				
				
				
			}
		
	}
	

}
