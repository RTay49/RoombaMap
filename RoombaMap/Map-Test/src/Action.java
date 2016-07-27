import java.util.List;

public class Action {
	
	
	private boolean activated;
	
	private boolean complete; 
	
	private Communication com;
	
	private Simulator sim; 
	
	private Robot bot;
	
	private BotPlot bCon;
	
	private PathFinder pf;

	public Action(Simulator sim){
	
		
		this.sim = sim;
		
		activated = false;
		complete = false;
		com = new Communication();
		this.bot = sim.getBot();
		bCon = new BotPlot(bot);
		
	
	}
	
	public void setUp(){
		ComPack comPack = com.makeComPack();
		
		String message =  comPack.getMessage();
		
		if(message == "start" && activated != true){
			activated = true;
			List<Integer> freeSpaces = pf.findEmptySpace();
			int fs = freeSpaces.get(0);
		}
		
		
	}
	
	
	public void act(){
		
		ComPack comPack = com.makeComPack();
		
		String message =  comPack.getMessage();
		
	
		
		if(message == "start" && activated != false){
			String dir = bot.getDir();
			com.sendMessage("st");
			bot.setMov("st");
			Location botLoc = bot.getLocation();
		}
		else {
			int mov = comPack.getMov();
			decide(message, mov);
		}
		
	}

	public void decide(String message, int mov){
		
		String dir = bot.getDir();
		
		if(message == "nw" && dir == "up"){
			
			List<Integer> freeSpaces = pf.findEmptySpace();
			freeSpaces.get(0);
			
			
			
		}

		
	}

	public boolean isActivated() {
		return activated;
	}

	public boolean isComplete() {
		return complete;
	}
	
	
	
	
}
