import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SetUp {
	
	
	private boolean activated;//is the robot active
	
	private boolean complete;//is the map complete
	
	private ComTest com;//Handles serial communications
	
	private Simulator sim;//Handles the internal simulation
	
	private Robot bot;//Keeps track of the Robot
	
	private BotPlot bP;//Plots the Robot on the map.
	
	private Plot plot;//Plots everything else.
	
	private Command cmd;//SendsCommands to the Robot
	
	private Action act;
	
	private boolean wall;
	
	private Location botLoc;
	
	private RMap rMap;
	
	
	
	public SetUp(){
	
		
		sim =  new Simulator(101,101);
		
		activated = false;
		complete = false;
		com = new ComTest();
		this.bot = sim.getBot();
		bP = new BotPlot(bot);
		
		plot = new Plot(sim);
		
		act = new Action(bot);
		
		botLoc = bot.getLocation();
		
		rMap = sim.getrMap();
		
		setUp();
	}
	
	public void setUp(){
	
		cmd.start();
		activated = true;
		complete = false;
		bot.setDir(0);
		scan(0);
		List<Integer> freedir = findSpaces();
		Collections.sort(freedir);
		int dir = freedir.get(0);
		turnbot(dir);
		Cruse.start (dir, wall);
	
		
	}
	
	public void scan(int dir){
		
		
		cmd.scan();
		wall = cmd.isWallDetected();
		
		if(wall){
			ArrayList<Integer> result = cmd.getScanResults();
			for(Integer r : result){
				plot.plotWall(r, dir);
			}
		}
		
	sim.update();
	}
	

public List<Integer> findSpaces(){
		

	
	Location location = bot.getLocation();
	
	int x = location.getXCord();
	int y = location.getYCord();
	
	List<Location> adjacentLocations = rMap.getFreeAdjacentLocations(location);
	List<Integer> adjacentDir = new ArrayList<Integer>();   
	
	
	for(Location l: adjacentLocations){
		
		int dir = convertToDir(location, l);
		adjacentDir.add(dir);
		
	}
	
	if(!adjacentDir.isEmpty()){
		return adjacentDir;
	}
	else{
		return null;
	}
	
	}
	
		


public int convertToDir(Location bot, Location location){
	
	int dir = 8;//impossible value
	
	int x = location.getXCord() - bot.getXCord();
	int y = location.getYCord() - bot.getYCord();
	
	if(x == 0 && y == 1){
		dir = 0;
	}
	else if (x == 1 && y == 1){
		dir = 1;
	}
	else if (x == 1 && y == 0){
		dir = 2;
	}
	else if (x == 1 && y == -1){
		dir = 3;
	}
	else if (x == 0 && y == -1){
		dir = 4;
	}
	else if (x == -1 && y == -1){
		dir = 5;
	}
	else if (x == -1 && y == 0){
		dir = 6;
	}
	else if (x == -1 && y == 1){
		dir = 7;
	}
	
	
	return dir;
	
	
	}

}
	/**
	public void act(){
		
		ComPack comPack = com.makeComPack();
		
		String message =  comPack.getMessage();
		
		
		if(message.equals("start") && activated != false){
			int dir = bot.getDir();
			com.sendMessage("st");
			String oldMov = bot.getMov();
			bot.setMov("st");
			boolean posCon = false;
			
			List<Integer> freeSpaces = pf.findEmptySpace();
			Iterator<Integer> it = freeSpaces.iterator();
			
			
			while(it.hasNext()){
				int fs = it.next();
				if (fs == dir){
					posCon = true;
				}
			}
				
				
				if (posCon == true){
					com.sendMessage(oldMov);
					sim.update();
				}
				else {
					sim.update();
					findRoute();
					}
		} 
		else {
			
			move(message);
		}
		
		
	}

	public void move(String message){
		
		int dir = bot.getDir();
		String mov = bot.getMov();
		
		

		scan(message,dir);
		moveBot(dir);
		
		
		
		//else if(message.equals("sf")){
			//List<FreeSpace> freeSpaces = sim.getFreeSpaces();
			 
			//int i = 0;
			//for(FreeSpace freespace : freeSpaces){
				
				//i++;
				
				//Location location = freespace.getLocation();
				
				//System.out.println("free space " + i + "at " + location.getXCord() + ","  + location.getYCord() + ".");
				
			//}
		//}
		//else if(message.equals("sw")){
			//List<Wall> walls = sim.getWalls();
			 
			//int i = 0;
			//for(Wall wall : walls){
				
				//i++;
				
				//Location location = wall.getLocation();
				
				//System.out.println("wall " + i + "at " + location.getXCord() + ","  + location.getYCord() + ".");
				
			//}
		//}
		sim.update();
	
		
		//to do incorpeate backwards movement.
			

		
	}
	
	

	public boolean isActivated() {
		return activated;
	}

	public boolean isComplete() {
		return complete;
	}
	
	public void moveBot(int dir){
		if(dir == 0){
			bP.moveBotUp();
		}
		else if (dir == 1){
			bP.moveBotRight();
		}
		else if (dir == 2){
			bP.moveBotDown();
		}
		else if (dir == 3){
			bP.moveBotLeft();
		}
	}
	
	
	public void findRoute(){
		
		System.out.println("finding route");
		List<Integer> freeSpaces = pf.findEmptySpace();
		System.out.println("free spaces found");
		
		int fsl = freeSpaces.size();
		System.out.println("free spaces list size: " + fsl);
		int fs = freeSpaces.get(0);
		System.out.println("free spaces pick: 0 which is: " + fs);
		
		if(fs == 0){
			bot.setDir(0);
			bot.setMov("fw");
			cmd.fowardCon();
		}
		else if(fs == 1){
			bot.setDir(0);
			cmd.turnRightN(90);
			bot.turnDirRight();
			bot.setMov("fw");
			cmd.fowardCon();
		}
		else if(fs == 2){
			bot.setDir(2);
			cmd.backwardCon();
			bot.setMov("bk");

		}
		else if(fs == 3){
			bot.setDir(0);
			cmd.turnLeftN(90);
			bot.turnDirLeft();
			bot.setMov("fw");
			cmd.fowardCon();
			}
	}
	
	public void botTurnRight(){
		cmd.stop();
		bot.setMov("st");
		cmd.turnRightN(90);
		bot.turnDirRight();
		cmd.fowardCon();
		bot.setMov("fw");
	}
	public void botTurnLeft(){
		cmd.stop();
		bot.setMov("st");
		cmd.turnLeftN(90);
		bot.turnDirLeft();
		cmd.backwardCon();
		bot.setMov("bk");
	}
	
	*/

