
public class Cruse {
	
	private Action act;
	private Plot pl;
	private Robot bot;
	private RMap rMap;
	private int dir;
	
	
	public Cruse (Action act, Plot pl, Robot bot, RMap rMap){
		this.act = act;
		this.pl = pl;
		this.bot = bot;
		this.rMap = rMap;
	}
	
	public void start(boolean wall){
		
		dir = bot.getDir();
			
			if(wall){
				pl.plotWall_S(dir);
				wallCrusing();
			}
			else{
				fsCrusing();
			}
			pl.plotFreeSpace();
			act.forward();
			
			
		}
	
	private void fsCrusing(){
		boolean crusing = true;
		
		while(crusing){
			
			char wall = act.cruse();
		
			if (wall == 'o');{
				fs_R_Turn();
				crusing = false;
			}
			else if(wall == 'j'){
				fs_R_Corner();
				crusing = false;
			}
			else if(wall = "k"){
				start();
				crusing = false;
			}
			bot.moved(dir);
			pl.plotFreeSpace();
			crusing = isBeen();
		}
	}
	
	private void wallCrusing(){
	
		boolean crusing = true;
		
		while(crusing){
			
			char wall = act.cruse();
		
			if (wall == 'o');{
				wall_R_Turn();
				crusing = false;
			}
			else if(wall == 'j'){
				wall_R_Turn();
				crusing = false;
			}
			else if(wall = "m"){
				wall_L_Turn();
				crusing = false;
			}
			bot.moved(dir);
			pl.plotWallS(dir);
			pl.plotFreeSpace();
			crusing = isBeen();
			
		}
	}
	
	private void fs_R_Turn(){
		act.turnRight(dir);
		start(true);
	}
	private void fs_R_Corner(){
		pl.plotWallC(dir);
		act.turnRight(dir);
		start(true);
	}
	private void wall_R_Turn(){
		pl.plotWallC(dir);
		act.turnRight(dir);
		start(true);
	}
	private void wall_L_Turn(){
		act.forward(10);
		act.turnLeft(dir);
		start(true);
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
