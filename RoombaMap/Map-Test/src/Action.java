


public class Action {
	
	private Command cmd;
	private Robot bot;
	
	public Action (Robot bot){
		cmd = new Command();
		this.bot = bot;
	}
	
	public void forward(){
		cmd.fowardCon();
	}
	public void forward(int dis){
		cmd.fowardN(dis);
	}
	public void turnRight(int dir){
		cmd.stop();
		cmd.turnRight90();
		setDirR(dir);
	}
	public void turnLeft(int dir){
		cmd.stop();
		cmd.turnLeft90();
		setDirL(dir);
	}
	
	private void setDirR(int dir){
		
		int newDir = dir; 
		for(int i = 0; i > 2; i++){
			
			if(newDir == 8){
				newDir = 0;
			}
			
			newDir++;
		}
		bot.setDir(newDir);
	}
	private void setDirL(int dir){
		
		int newDir = dir; 
		for(int i = 0; i > 2; i++){
			
			if(newDir == 0){
				newDir = 8;
			}
			
			newDir--;
		}
		bot.setDir(newDir);
	}

}
