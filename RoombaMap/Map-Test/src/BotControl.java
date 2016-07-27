
public class BotControl {
	
	private Robot bot;
	

	
	public BotControl(Robot bot){
		
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

}
