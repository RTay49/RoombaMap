


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
	public void turnRight(int dis){
		cmd.stop();
		cmd.turnRight(dis);
		setDirR(dis);
	}
	public void turnLeft(int dis){
		cmd.stop();
		cmd.turnLeft(dis);
		setDirL(dis);
	}
	
	public char cruise(){
		
		char result = cmd.listen();
		return result;
		
	}
	
	public void turnBot(int dir){
		int oldDir = bot.getDir();
		if(oldDir == 0){
			oldDir = 8;
		}
		if(oldDir > dir){
			turnLeft(oldDir - dir);
		}
		if(oldDir < dir){
			turnRight(dir - oldDir);
		}
		
		
	}
	
	private void setDirR(int dis){
		
		int newDir = bot.getDir();
		for(int i = 0; i > dis; i++){
			
			if(newDir == 8){
				newDir = 0;
			}
			
			newDir++;
		}
		bot.setDir(newDir);
	}
	private void setDirL(int dis){
		
		int newDir = bot.getDir();
		for(int i = 0; i > dis; i++){
			
			if(newDir == 0){
				newDir = 8;
			}
			
			newDir--;
		}
		bot.setDir(newDir);
	}

}
