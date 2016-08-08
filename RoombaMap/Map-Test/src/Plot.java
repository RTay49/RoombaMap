
public class Plot {
	
	private Simulator sim;
	private Robot bot;
	
	private Location botLocation;
	
	private int botXCord;
	private int botYCord;
	
	private LocationMaker lm;
	
	public Plot (Simulator sim){
		this.sim = sim;
		lm = new LocationMaker();
		
		bot = sim.getBot();
		botLocation = bot.getLocation();
		botXCord = botLocation.getXCord();
		botYCord = botLocation.getYCord();
		
	}
	
	public void plotWall(int dir){
		Location location = convertToLoc(dir);
		sim.addWall(location);
	}
	
	public void plotWallS(int dir){
		if(dir == 0){
			dir = 8;
		}
		else if(dir == 1){
			dir = 9;
		}
		
		Location location = convertToLoc(dir-2);
		sim.addWall(location);
		
	}
	
	public void plotWallC(int dir){
		plotWallS(dir);
		if(dir == 0){
			dir = 8;
		}
		Location location = convertToLoc(dir-1);
		sim.addWall(location);
		
	}
	
	
	public void plotFreeSpace(){
		updateBotCord();	
		sim.addFreeSpace(botLocation);
		System.out.println("Freespace plotted at:" + botLocation.getXCord() + "," + botLocation.getYCord() );
	}
	
	private void plotWallF(){	
		updateBotCord();
		Location wallLocation = lm.makeLocationXY(botXCord, botYCord+1); 
		sim.addWall(wallLocation);
		System.out.println("Wall plotted at:" + wallLocation.getXCord() + "," + wallLocation.getYCord() );
	}
	
	private void plotWallBack(){	
		updateBotCord();
		Location wallLocation = lm.makeLocationXY(botXCord, botYCord-1); 
		sim.addWall(wallLocation);
		System.out.println("Wall plotted at:" + wallLocation.getXCord() + "," + wallLocation.getYCord() );
	}
	private void plotWallRight(){	
		updateBotCord();
		Location wallLocation = lm.makeLocationXY(botXCord+1, botYCord); 
		sim.addWall(wallLocation);
		System.out.println("Wall plotted at:" + wallLocation.getXCord() + "," + wallLocation.getYCord() );
	}
	private void plotWallLeft(){	
		updateBotCord();
		Location wallLocation = lm.makeLocationXY(botXCord-1, botYCord); 
		sim.addWall(wallLocation);
		System.out.println("Wall plotted at:" + wallLocation.getXCord() + "," + wallLocation.getYCord() );
	}
		

	private void updateBotCord(){
		botLocation = bot.getLocation();
		botXCord = botLocation.getXCord();
		botYCord = botLocation.getYCord();
	}
public Location convertToLoc(int dir){
		
		
		if(dir == 0){
			Location location = lm.makeLocationXY(botXCord, botYCord+1);
			return location;
		}
		else if (dir == 1){
			Location location = lm.makeLocationXY(botXCord+1, botYCord+1);
			return location;
		}
		else if (dir == 2){
			Location location = lm.makeLocationXY(botXCord+1, botYCord);
		}
		else if (dir == 3){
			Location location = lm.makeLocationXY(botXCord+1, botYCord-1);
			return location;
		}
		else if (dir == 4){
			Location location = lm.makeLocationXY(botXCord, botYCord-1);
			return location;
		}
		else if (dir == 5){
			Location location = lm.makeLocationXY(botXCord-1, botYCord-1);
			return location;
		}
		else if (dir == 6){
			Location location = lm.makeLocationXY(botXCord-1, botYCord);
			return location;
		}
		else if (dir == 7){
			Location location = lm.makeLocationXY(botXCord-1, botYCord+1);
			return location;
		}
		
			return null;
	}
	

}
