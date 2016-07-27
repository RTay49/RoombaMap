
public class Action {
	
	
	private boolean activated;
	
	private boolean complete; 
	
	private Communication com;
	
	private Simulator sim; 
	
	private Robot bot;
	
	private BotControl bCon;
	
	private PathFinder pf;

	public Action(Simulator sim){
	
		
		this.sim = sim;
		
		activated = false;
		complete = false;
		com = new Communication();
		this.bot = sim.getBot();
		bCon = new BotControl(bot);
		
	
	}
	
	public void setUp(){
		ComPack comPack = com.makeComPack();
		
		String message =  comPack.getMessage();
		
		if(message == "start"){
			activated = true;
			com.sendMessage("f0");
			bot.setDir("up");
			bot.setMov("fw");
		}
		
		
	}
	
	
	public void act(){
		
		ComPack comPack = com.makeComPack();
		
		String message =  comPack.getMessage();
		
	
		
		if(message == "start"){
			String dir = bot.getDir();
			bot.setMov("st");
			Location botLoc = bot.getLocation();
		}
		else {
			int mov = comPack.getMov();
			decide(message, mov);
		}
		
	}

	public void decide(String message, int mov){
		
		
		if(message == "nw"){
			
		}

		
	}

	public boolean isActivated() {
		return activated;
	}

	public boolean isComplete() {
		return complete;
	}
	
	
	
	
}
