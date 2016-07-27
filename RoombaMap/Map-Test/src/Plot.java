
public class Plot {
	
	private Simulator sim;
	private Robot bot;
	
	private Location botLocation;
	
	private int botXCord;
	private int botYCord;
	
	public Plot (Simulator sim){
		this.sim = sim;
		bot = sim.getBot();
		botLocation = bot.getLocation();
		botXCord = botLocation.getXCord();
		botYCord = botLocation.getYCord();
		
	}
	
	public void plotFreeSpcae(){
		updateBotCord();	
		sim.addFreeSpace(botLocation);	
	}
	
	public void plotWallfront(){	
		updateBotCord();
		Location wallLocation = new Location(botXCord, botYCord+1); 
		sim.addWall(wallLocation);
	}
	
	public void plotWallback(){	
		updateBotCord();
		Location wallLocation = new Location(botXCord, botYCord-1); 
		sim.addWall(wallLocation);
	}
	public void plotWallRight(){	
		updateBotCord();
		Location wallLocation = new Location(botXCord+1, botYCord); 
		sim.addWall(wallLocation);
	}
	public void plotWallLeft(){	
		updateBotCord();
		Location wallLocation = new Location(botXCord-1, botYCord); 
		sim.addWall(wallLocation);
	}
		

	public void updateBotCord(){
		botLocation = bot.getLocation();
		botXCord = botLocation.getXCord();
		botYCord = botLocation.getYCord();
	}
	

}
