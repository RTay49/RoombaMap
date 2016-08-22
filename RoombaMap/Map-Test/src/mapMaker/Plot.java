package mapMaker;

public class Plot {
	
	private BotSimulator sim;
	private Robot bot;
	
	private Location botLocation;
	
	private int botXCord;
	private int botYCord;
	

	
	public Plot (BotSimulator sim){
		this.sim = sim;
		
		bot = sim.getBot();
		botLocation = bot.getLocation();
		botXCord = botLocation.getXCord();
		botYCord = botLocation.getYCord();
		
	}
	
	public void plotWall(int dir){
		Location location = Utilities.convertToLoc(dir,botXCord,botYCord);
		sim.addWall(location);
		//sim.update();
	}
	
	public void plotWallS(int dir){
		if(dir == 0){
			dir = 8;
		}
		else if(dir == 1){
			dir = 9;
		}
		
		Location location = Utilities.convertToLoc(dir-2,botXCord,botYCord);
		sim.addWall(location);
		System.out.println("Wall plotted at:" + location.getXCord() + "," + location.getYCord() );
		//sim.update();
		
	}
	
	public void plotWallC(int dir){
		plotWallS(dir);
		if(dir == 0){
			dir = 8;
		}
		Location location = Utilities.convertToLoc(dir-1,botXCord,botYCord);
		sim.addWall(location);
		System.out.println("Wall plotted at:" + location.getXCord() + "," + location.getYCord() );
		//sim.update();
		
	}
	
	
	public void plotFreeSpace(){
		updateBotCord();	
		sim.addFreeSpace(botLocation);
		System.out.println("Freespace plotted at:" + botLocation.getXCord() + "," + botLocation.getYCord() );
		//sim.update();
	}
		

	private void updateBotCord(){
		botLocation = bot.getLocation();
		botXCord = botLocation.getXCord();
		botYCord = botLocation.getYCord();
	}

	

}
