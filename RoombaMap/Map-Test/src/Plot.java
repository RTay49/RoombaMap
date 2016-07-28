
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
	
	public void plotWall(int wall, int dir){
		 System.out.println("plotting wall with wall: " + wall + " and dir: " + dir +"." );
		int result = 0;
		int time = wall + dir;
		
		System.out.println("entering loop with time = " + time + ".");
		for(int i=0 ; i < time; i++){
			result++;
			System.out.println("loop i = " + i + " result = " + result + ".");

			if (result == 4){
					result = 0;
			}
		System.out.println("loop i = " + i + " result = " + result + ".");
		}
		
		System.out.println("loop finshed result = " + result + ".");
		
		if(result == 0){
			plotWallFront();
			System.out.println("front wall plotted");
		}
		else if (result == 1){
			plotWallRight();
			System.out.println("right wall plotted");
		}
		else if (result == 2){
			plotWallBack();
			System.out.println("back wall plotted");
		}
		else if (result == 3){
			plotWallLeft();
			System.out.println("left wall plotted");
		}
		
	}
	
	public void plotFreeSpace(){
		updateBotCord();	
		sim.addFreeSpace(botLocation);
		System.out.println("Freespace plotted at:" + botLocation.getXCord() + "," + botLocation.getYCord() );
	}
	
	private void plotWallFront(){	
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
	

}
