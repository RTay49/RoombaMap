package mapMaker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * A class that will set up the robot and begin initial cruise.
 * @author Richard Taylor
 *
 */
public class SetUp {
	
	
	
	private BotSimulator sim;
	
	private Robot bot;
	
	private Plot plot;
	
	private Action act;
	
	private boolean wall;
	

	
	private RMap rMap;
	
	private Cruise cr;
	
	
	
	public SetUp(){
	
		
		sim =  new BotSimulator(101,101);
		
		this.bot = sim.getBot();
		
		plot = new Plot(sim);
		
		act = new Action(bot);
		
		rMap = sim.getrMap();
		
		cr = new Cruise(act, plot, bot, rMap);
		
		setUp();
	}
	
	public void setUp(){
		
		//System.out.println("starting");
		act.start();
		
		//System.out.println("Scanning");
		scan();
		//System.out.println("Scan complete");
		
		//System.out.println("finding direction");
		List<Integer> freedir = findSpaces();
		Collections.sort(freedir);
		int dir = freedir.get(0);
		//System.out.println("direction found");
		
		//System.out.println("Turning bot");
		act.turnBot(dir);
		cr.start (wall);
		//System.out.println("cruiseing");
		act.finish();//Since this is all the Robot does it will finish here
		
	}
	
	public void scan(){
		
		
		 List<Integer> scans = act.scan();
		
		if(!scans.isEmpty()){
			for(Integer scan: scans){
				plot.plotWall(scan);
			}
		}
			
	}
	

	public List<Integer> findSpaces(){
		

	
	Location location = bot.getLocation();
	
	
	List<Location> adjacentLocations = rMap.getFreeAdjacentLocations(location);
	List<Integer> adjacentDir = new ArrayList<Integer>();   
	
	
	for(Location l: adjacentLocations){
		
		int dir = Utilities.convertToDir(location, l);
		adjacentDir.add(dir);
		
	}
	
	if(!adjacentDir.isEmpty()){
		return adjacentDir;
	}
	else{
		return null;
	}
	
	}
	
		



	public BotSimulator getSim(){
		return sim;
	}

}