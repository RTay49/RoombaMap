
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
	
	public void start(boolean wall){
		System.out.println("Cruise start wall:" + wall);
		dir = bot.getDir();
		System.out.println("dir: " + dir);	
		System.out.println("Cruise plotting free spaces and moving forward");
		
		pl.plotFreeSpace();
		act.forward();
		if(wall){
				pl.plotWallS(dir);
				wallCruiseing();
				
		}
		else{
			fsCruiseing();
		}			
	}
	
	private void fsCruiseing(){
		boolean cruiseing = true;
		System.out.println("free cruse");
		while(cruiseing){
			
			char wall = act.cruise();
		
			if (wall == 'o'){
				System.out.println("Turning right");
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
			bot.moveBot(dir);
			pl.plotFreeSpace();
			cruiseing = isBeen();
		}
	}
	
	private void wallCruiseing(){
	
		System.out.println("wallCruise");
		boolean cruiseing = true;
		
		while(cruiseing){
			
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
			System.out.println("moving bot dir:" + dir +".");
			bot.moveBot(dir);
			System.out.println("plotting walls and free spaces");
			pl.plotWallS(dir);
			pl.plotFreeSpace();
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
	
	
	public boolean isBeen(){
		Location location = convertToLoc(bot.getDir());
		Object frontSpace = rMap.getObjectAt(location);
		if(frontSpace != null){
			return false;
		}
		else{
			return true;
		}
		
	}
	
	
	
		
		
		
	
	public Location convertToLoc(int dir){
		
		
		LocationMaker lm = new LocationMaker();
		
		Location botLoc = bot.getLocation();
		
		int botx = botLoc.getXCord();
		int boty = botLoc.getYCord();
		
		if(dir == 0){
			Location location = lm.makeLocationXY(botx, boty+1);
			return location;
		}
		else if (dir == 1){
			Location location = lm.makeLocationXY(botx+1, boty+1);
			return location;
		}
		else if (dir == 2){
			Location location = lm.makeLocationXY(botx+1, boty);
			return location;
		}
		else if (dir == 3){
			Location location = lm.makeLocationXY(botx+1, boty-1);
			return location;
		}
		else if (dir == 4){
			Location location = lm.makeLocationXY(botx, boty-1);
			return location;
		}
		else if (dir == 5){
			Location location = lm.makeLocationXY(botx-1, boty-1);
			return location;
		}
		else if (dir == 6){
			Location location = lm.makeLocationXY(botx-1, boty);
			return location;
		}
		else if (dir == 7){
			Location location = lm.makeLocationXY(botx-1, boty+1);
			return location;
		}
		
		return null;
		
		
		}

	

}
