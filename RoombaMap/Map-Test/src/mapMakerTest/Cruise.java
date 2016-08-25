package mapMakerTest;
/**
 * A class that handles detecting walls once a direction has been set.
 * The robot will cruise in a direction and report the presence of any walls of no
 * walls and by which sensor.
 * 
 * @author Richard Taylor
 *
 */
public class Cruise {
	
	private Action act;
	private Plot pl;
	private Robot bot;
	private RMap rMap;
	private int dir;
	
	
	public Cruise (Action act, Plot pl, Robot bot, RMap rMap){
		this.act = act;
		this.pl = pl;
		this.bot = bot;
		this.rMap = rMap;
	}
	
	/*
	 * starts a cruise based will operate differently if a wall is present or not.
	 */
	public void start(boolean wall){
		//System.out.println("Cruise start wall:" + wall);
		dir = bot.getDir();
		//System.out.println("dir: " + dir);	
		//System.out.println("Cruise plotting free spaces and moving forward");
		
		pl.plotFreeSpace();
		if(wall){
				pl.plotWallS(dir);
				wallCruiseing();
				
		}
		else{
			fsCruiseing();
		}			
	}
	
	
	/*
	 * For cruising with no walls detected expecting to bump in to one at some point
	 */
	private void fsCruiseing(){
		boolean cruiseing = true;
		System.out.println("free cruse");
		while(cruiseing){
			
			char wall = act.cruise();
		
			if (wall == 'o'){
				//System.out.println("Turning right");
				fs_R_Turn();
				cruiseing = false;
			}
			else if(wall == 'j'){
				fs_R_Corner();
				cruiseing = false;
			}
			else if(wall == 'k'){
				start(true);
				cruiseing = false;
			}
			else if(wall == 'm'){
				bot.moveBot(dir);
				pl.plotFreeSpace();
			}
			cruiseing = isBeen();
		}
	}
	
	
	/*
	 * For cruising with a wall detected expecting to bump another or attempt to follow the wall.
	 */
	
	private void wallCruiseing(){
	
		System.out.println("wallCruise");
		boolean cruiseing = true;
		
		while(cruiseing){
			System.out.println("wallCruise");
			char wall = act.cruise();
			
			if (wall == 'o'){
				wall_R_Turn();
				cruiseing = false;
			}
			else if(wall == 'j'){
				wall_R_Turn();
				cruiseing = false;
			}
			else if(wall == 'm'){
				wall_L_Turn();
				cruiseing = false;
			}
			else if(wall == 'k'){
				bot.moveBot(dir);
				pl.plotFreeSpace();
				pl.plotWallS(dir);
				pl.plotFreeSpace();
			}
			System.out.println("moving bot dir:" + dir +".");
			System.out.println("plotting walls and free spaces");
			cruiseing = isBeen();
			
		}
	}
	
	private void fs_R_Turn(){
		System.out.println("command right");
		act.turnRight(2);
		start(true);
	}
	private void fs_R_Corner(){
		pl.plotWallC(dir);
		act.turnRight(2);
		start(true);
	}
	private void wall_R_Turn(){
		pl.plotWallC(dir);
		act.turnRight(2);
		start(true);
	}
	private void wall_L_Turn(){
		act.forward(10);
		act.turnLeft(2);
		start(false);
	}
	
	/*
	 * will end the cruise phase if the robot is somewhere it has been before.
	 */
	public boolean isBeen(){
		Location botLoc = bot.getLocation();
		Location location = Utilities.convertToLoc(bot.getDir(),botLoc.getXCord(),botLoc.getYCord());
		Object frontSpace = rMap.getObjectAt(location);
		if(frontSpace != null){
			return false;
		}
		else{
			return true;
		}
		
	}

}
