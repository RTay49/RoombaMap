
public class Cruse {
	
	private Command cmd;
	private Plot pl;
	private Robot bot;
	private RMap rMap;
	
	
	public Cruse (Command cmd, Plot pl, Robot bot, RMap rMap){
		this.cmd = cmd;
		this.pl = pl;
		this.bot = bot;
		this.rMap = rMap;
	}
	
	public void start(Location location, int dir, boolean wall){
		
		{
			
			if(wall){
				pl.plotFreeSpace();
				pl.plotWall();
				cmd.fowardCon();
			}
			else{
				pl.plotFreeSpace();
			}
			crusing()
		}
	
	public void crusing(){
		
		char wall = cmd.cruse();
		
		if()
		
		
		
	}

}
