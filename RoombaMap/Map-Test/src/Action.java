import java.util.Iterator;
import java.util.List;

public class Action {
	
	
	private boolean activated;
	
	private boolean complete; 
	
	private Communication com;
	
	private Simulator sim; 
	
	private Robot bot;
	
	private BotPlot bP;
	
	private PathFinder pf;

	public Action(Simulator sim){
	
		
		this.sim = sim;
		
		activated = false;
		complete = false;
		com = new Communication();
		this.bot = sim.getBot();
		bP = new BotPlot(bot);
		
	
	}
	
	public void setUp(){
		ComPack comPack = com.makeComPack();
		
		String message =  comPack.getMessage();
		
		if(message == "start" && activated != true){
			activated = true;
			bot.setMov("st");
			
			ComPack scan = com.makeComPack();
			
			List<Integer> freeSpaces = pf.findEmptySpace();
			int fs = freeSpaces.get(0);
			if(fs == 3){
				bot.setDir(3);
				bot.setMov("fw");
				System.out.println("f0");
			}
			else if(fs == 2){
				bot.setDir(2);
				bot.setMov("bk");
				System.out.println("b0");
			}
			else if(fs == 1){
				System.out.println("r90");
				ComPack order = com.makeComPack();
				if(order.getMessage() == "done"){
					bot.setDir(1);
					System.out.println("f0");
					bot.setMov("fw");
				}
			}
			else if(fs == 0){
				System.out.println("l90");
				ComPack order = com.makeComPack();
				if(order.getMessage() == "done"){
					bot.setDir(0);
					System.out.println("f0");
					bot.setMov("fw");
				}
			}
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
					System.out.println(oldMov);
				}
				else {
					int fs = freeSpaces.get(0);

					if(fs == 3){
						bot.setDir(3);
						bot.setMov("fw");
						System.out.println("f0");
					}
					else if(fs == 2){
						bot.setDir(2);
						bot.setMov("bk");
						System.out.println("b0");
					}
					else if(fs == 1){
						System.out.println("r90");
						ComPack order = com.makeComPack();
						if(order.getMessage() == "done"){
							bot.setDir(1);
							System.out.println("f0");
							bot.setMov("fw");
						}
					}
					else if(fs == 0){
						System.out.println("l90");
						ComPack order = com.makeComPack();
						if(order.getMessage() == "done"){
							bot.setDir(0);
							System.out.println("f0");
							bot.setMov("fw");
						}
					}
				}
		} 
			
		else {
			int mov = comPack.getMov();
			decide(message, mov);
		}
		
		
	}

	public void decide(String message, int mov){
		
		int dir = bot.getDir();
		
		if(message == "nw" && dir == 0){
		
			bot
			
			
		}

		
	}

	public boolean isActivated() {
		return activated;
	}

	public boolean isComplete() {
		return complete;
	}
	
	
	
	
}
