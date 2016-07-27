import java.util.Iterator;
import java.util.List;

public class Action {
	
	
	private boolean activated;
	
	private boolean complete; 
	
	private Communication com;
	
	private Command cmd;
	
	private Simulator sim; 
	
	private Robot bot;
	
	private BotPlot bP;
	
	private Plot plot;
	
	private PathFinder pf;

	public Action(Simulator sim){
	
		
		this.sim = sim;
		
		activated = false;
		complete = false;
		com = new Communication();
		this.bot = sim.getBot();
		bP = new BotPlot(bot);
		
		cmd = new Command(com);
		plot = new Plot(sim);
		
	
	}
	
	public void setUp(){
		ComPack comPack = com.makeComPack();
		
		String message =  comPack.getMessage();
		
		if(message == "start" && activated != true){
			activated = true;
			cmd.stop();
			bot.setMov("st");
			
			ComPack scan = com.makeComPack();
			
			findRoute();
		}
		
		
	}
	
	
	public void act(){
		
		ComPack comPack = com.makeComPack();
		
		String message =  comPack.getMessage();
		
		
		if(message == "start" && activated != false){
			int dir = bot.getDir();
			com.sendMessage("st");
			String oldMov = bot.getMov();
			bot.setMov("st");
			boolean posCon = false;
			
			List<Integer> freeSpaces = pf.findEmptySpace();
			Iterator<Integer> it = freeSpaces.iterator();
			
			
			while(it.hasNext()){
				int fs = it.next();
				if (fs == dir){
					posCon = true;
				}
			}
				
				
				if (posCon == true){
					com.sendMessage(oldMov);
				}
				else {
					findRoute();
					}
		} 
		else {
			
			decide(message);
		}
		
		
	}

	public void decide(String message){
		
		int dir = bot.getDir();
		
		if (message == "nw"){
			plot.plotFreeSpcae();
			moveBot(dir);
		}
		
		else if(message == "ft"){
			botTurnRight();
			plot.plotFreeSpcae();
			plot.plotWallfront();
			
		}
		else if(message == "rt"){
			botTurnRight();
			plot.plotFreeSpcae();
			plot.plotWallLeft();
		}
		else if(message == "fr"){
			botTurnRight();
			plot.plotFreeSpcae();
			plot.plotWallfront();
			plot.plotWallLeft();
		}
		else if(message == "rt"){
			plot.plotFreeSpcae();
			plot.plotWallLeft();
		}
		else if(message == "lt"){
			plot.plotFreeSpcae();
			plot.plotWallRight();
		}
		else if(message == "lf"){
			botTurnLeft();
			plot.plotFreeSpcae();
			plot.plotWallfront();
			plot.plotWallRight();
		}
	
		
		//to do incorpeate backwards movement.
			

		
	}

	public boolean isActivated() {
		return activated;
	}

	public boolean isComplete() {
		return complete;
	}
	
	public void moveBot(int dir){
		if(dir == 0){
			bP.moveBotUp();
		}
		else if (dir == 1){
			bP.moveBotRight();
		}
		else if (dir == 2){
			bP.moveBotDown();
		}
		else if (dir == 3){
			bP.moveBotLeft();
		}
	}	
	
	public void findRoute(){
		
		List<Integer> freeSpaces = pf.findEmptySpace();
		
		
		int fsl = freeSpaces.size();
		int fs = freeSpaces.get(fsl-1);
		
		if(fs == 0){
			bot.setDir(0);
			bot.setMov("fw");
			cmd.fowardCon();
		}
		else if(fs == 1){
			bot.setDir(0);
			cmd.turnRightN(90);
			bot.turnDirRight();
			bot.setMov("fw");
			cmd.fowardCon();
		}
		else if(fs == 2){
			bot.setDir(2);
			cmd.backwardCon();
			bot.setMov("bk");

		}
		else if(fs == 3){
			bot.setDir(0);
			cmd.turnLeftN(90);
			bot.turnDirLeft();
			bot.setMov("fw");
			cmd.fowardCon();
			}
	}
	
	public void botTurnRight(){
		cmd.stop();
		bot.setMov("st");
		cmd.turnRightN(90);
		bot.turnDirRight();
		cmd.fowardCon();
		bot.setMov("fw");
	}
	public void botTurnLeft(){
		cmd.stop();
		bot.setMov("st");
		cmd.turnLeftN(90);
		bot.turnDirLeft();
		cmd.backwardCon();
		bot.setMov("bk");
	}
	
	
}
