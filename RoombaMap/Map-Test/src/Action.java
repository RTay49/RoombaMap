import java.util.Iterator;
import java.util.List;

public class Action {
	
	
	private boolean activated;
	
	private boolean complete; 
	
	private Communication com;
	
	private Command cmd;
	
	private Simulator sim; 
	
	private Robot bot;
	
	private BotPlot bP;
	
	private Plot plot;
	
	private PathFinder pf;

	public Action(Simulator sim){
	
		
		this.sim = sim;
		
		activated = false;
		complete = false;
		com = new Communication();
		this.bot = sim.getBot();
		bP = new BotPlot(bot);
		
		pf = new PathFinder(sim.getrMap(), bot);
		
		cmd = new Command(com);
		plot = new Plot(sim);
		
	
	}
	
	public void setUp(){
		System.out.println("enter start");
		
		ComPack comPack = com.makeComPack();
		
		String message =  comPack.getMessage();
		
		System.out.println("message recived: '" + message + "'");
		if(message .equals("start") && activated == false){
			activated = true;
			System.out.println("activated: " + activated);
			cmd.stop();
			bot.setMov("st");
			int dir = 0;
			bot.setDir(dir);
			cmd.scan();
			ComPack scan = com.makeComPack();
			String result = scan.getMessage(); 
			scan(result,dir);
			sim.update();
			findRoute();
			System.out.println("setup success");
		}
		else{
			System.out.println("setup fail");
			System.out.println("message recived: '" + message + "'");
			System.out.println("activated: " + activated);
			}
		
		
	}
	
	
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
	
	public void scan(String message, int dir){
		
	
		
			if (message.equals("nw")){
				plot.plotFreeSpace();
			}
		
			else if(message.equals("ft")){
				botTurnRight();
				plot.plotFreeSpace();
				plot.plotWall(0,dir);
			}
			else if(message.equals("fr")){
				plot.plotWall(0,dir);
				plot.plotWall(1,dir);
				botTurnLeft();
				plot.plotFreeSpace();
			}
			else if(message.equals("rt")){
				plot.plotFreeSpace();
				plot.plotWall(1,dir);
			}
			else if(message.equals("lt")){
				plot.plotFreeSpace();
				plot.plotWall(3,dir);
			}
			else if(message.equals("fl")){
				plot.plotWall(0,dir);
				plot.plotWall(3,dir);
				botTurnRight();
				plot.plotFreeSpace();
			}
		sim.update();
		
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
	
	
}
