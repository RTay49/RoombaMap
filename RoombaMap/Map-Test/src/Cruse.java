
public class Cruse {
	
	private Command cmd;
	private Plot pl;
	private Robot bot;
	private RMap rMap;
	
	
	public Cruse (Command cmd, Plot pl, Robot bot, RMap rMap){
		this.cmd = cmd;
		this.pl = pl;
		this.bot = bot;
		this.rMap = rMap;
	}
	
	public void start(Location location, int dir, boolean wall){
		
		{
			
			
			if(wall){
				pl.plotWall();
			}
			pl.plotFreeSpace();
			
			crusing();
		}
	
	public void crusing(){
		
		char wall = cmd.cruse();
		
	
		
		
		
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
