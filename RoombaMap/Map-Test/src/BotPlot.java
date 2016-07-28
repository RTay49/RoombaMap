
public class BotPlot {
	
	private Robot bot;
	private LocationMaker lm;

	
	public BotPlot(Robot bot){
		
		this.bot = bot;
		lm = new LocationMaker();
		
	}
	
	
	public Location getBotLocation(){
		
		Location location = bot.getLocation();
		
		return location;
		
	}
	
	public void moveBotUp(){
		
		 Location oldLocation = getBotLocation();
		 RMap rMap = bot.getrMap();
		 
		 
		 
		 int oldXCord = oldLocation.getXCord();
		 int oldYCord = oldLocation.getYCord();
		
		 int oldCol = oldLocation.getCol();
		 int oldRow = oldLocation.getRow();
		 
		 Object place = rMap.getObjectAt(oldRow, oldCol);
		 if(!place.getClass().getName().equals("Wall")){
		 
			 int newYCord = oldYCord + 1;
		 
			 Location newLocation = lm.makeLocationXY(oldXCord, newYCord);
		 
			 bot.setLocation(newLocation);
			 System.out.println("bot move up");
		 
			 rMap.place(place, oldLocation);
		}
		
	}
	
	public void moveBotDown(){
		
		 Location oldLocation = getBotLocation();
		 RMap rMap = bot.getrMap();
		 
		 int oldXCord = oldLocation.getXCord();
		 int oldYCord = oldLocation.getYCord();
		 
		 int oldCol = oldLocation.getCol();
		 int oldRow = oldLocation.getRow();
		 
		 Object place = rMap.getObjectAt(oldRow, oldCol);
		 if(!place.getClass().getName().equals("Wall")){
			 int newYCord = oldYCord - 1;
		 
			 Location newLocation = lm.makeLocationXY(oldXCord, newYCord);
		 
			 bot.setLocation(newLocation);
			 System.out.println("bot move down");
			 rMap.place(place, oldLocation);
		 }
		
	}
	
	public void moveBotRight(){
		
		 Location oldLocation = getBotLocation();
		 RMap rMap = bot.getrMap();
		 
		 int oldXCord = oldLocation.getXCord();
		 int oldYCord = oldLocation.getYCord();
		 
		 int oldCol = oldLocation.getCol();
		 int oldRow = oldLocation.getRow();
		 
		 Object place = rMap.getObjectAt(oldRow, oldCol);
		 if(!place.getClass().getName().equals("Wall")){
			 int newXCord = oldXCord + 1;
		 
			 Location newLocation = lm.makeLocationXY(newXCord, oldYCord);
		 
			 bot.setLocation(newLocation);
			 System.out.println("bot move right");
			 rMap.place(place, oldLocation);
		 }
		
	}
	
	public void moveBotLeft(){
		
		 Location oldLocation = getBotLocation();
		 RMap rMap = bot.getrMap();
		 
		 
		 int oldXCord = oldLocation.getXCord();
		 int oldYCord = oldLocation.getYCord();
		 
		 int oldCol = oldLocation.getCol();
		 int oldRow = oldLocation.getRow();
		 
		 Object place = rMap.getObjectAt(oldRow, oldCol);
		 
		 if(!place.getClass().getName().equals("Wall")){
			 int newXCord = oldXCord - 1;
		 
			 Location newLocation = lm.makeLocationXY(newXCord, oldYCord);
		 
			 bot.setLocation(newLocation);
			 System.out.println("bot move left");
			 rMap.place(place, oldLocation);
		 
		 }
	}

}
