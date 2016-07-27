
public class BotPlot {
	
	private Robot bot;
	

	
	public BotPlot(Robot bot){
		
		this.bot = bot;
	
		
	}
	
	
	public Location getBotLocation(){
		
		Location location = bot.getLocation();
		
		return location;
		
	}
	
	public void moveBotUp(){
		
		 Location oldLocation = getBotLocation();
		 
		 int oldXCord = oldLocation.getXCord();
		 int oldYCord = oldLocation.getYCord();
		 
		 int newYCord = oldYCord + 1;
		 
		 Location newLocation = new Location(oldXCord, newYCord);
		 
		 bot.setLocation(newLocation);
		 
		
	}
	
	public void moveBotDown(){
		
		 Location oldLocation = getBotLocation();
		 
		 int oldXCord = oldLocation.getXCord();
		 int oldYCord = oldLocation.getYCord();
		 
		 int newYCord = oldYCord - 1;
		 
		 Location newLocation = new Location(oldXCord, newYCord);
		 
		 bot.setLocation(newLocation);
		 
		
	}
	
	public void moveBotRight(){
		
		 Location oldLocation = getBotLocation();
		 
		 int oldXCord = oldLocation.getXCord();
		 int oldYCord = oldLocation.getYCord();
		 
		 int newXCord = oldXCord + 1;
		 
		 Location newLocation = new Location(newXCord, oldYCord);
		 
		 bot.setLocation(newLocation);
		 
		
	}
	
	public void moveBotLeft(){
		
		 Location oldLocation = getBotLocation();
		 
		 int oldXCord = oldLocation.getXCord();
		 int oldYCord = oldLocation.getYCord();
		 
		 int newXCord = oldXCord - 1;
		 
		 Location newLocation = new Location(newXCord, oldYCord);
		 
		 bot.setLocation(newLocation);
		 
		
	}

}
