package mapMaker;
import java.util.List;
/**
 * This class handles actions given to the robot will take.
 * It will both keep track of direction an other aspects when dealing with
 * the actions the robot will be performing.
 * @author Richard Taylor
 */

public class Action {
	
	private Command cmd;
	private Robot bot;
	
	public Action (Robot bot){
		cmd = new Command();
		this.bot = bot;
	}

	public void start(){
		cmd.start();
	}
	/*
	 * returns the a list of of wall detected for a scan.
	 * if the there are no walls detected the list will be empty. 
	 */
	public List<Integer> scan(){
		List<Integer> scan = cmd.scan();
		return scan;
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
		
		char result = cmd.cruise();
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
	/*
	 * a command to stop the robot and close the connection.
	 */
	public void finish(){
		cmd.stop();
		cmd.close();
	}
	/*
	 * the robot moves in 8 directions 0-7 this will increase the counter
	 * as the directions increase clockwise. 
	 */
	private void setDirR(int dis){
		
		int newDir = bot.getDir();
		for(int i = 0; i < dis; i++){
			
			if(newDir == 8){ //resets the count as 7 is the max before being zero
				newDir = 0;
			}
			
			newDir++;
		}
		System.out.println("changing bot to direction: " + newDir +".");
		bot.setDir(newDir);
	}
	/*
	 * the robot moves in 8 directions 0-7 this will decrease the counter
	 * as the directions increase clockwise. 
	 */
	private void setDirL(int dis){
		
		int newDir = bot.getDir();
		for(int i = 0; i < dis; i++){
			
			if(newDir == 0){//resets the count as 7 is the max before being zero
				newDir = 8;
			}
			
			newDir--;
		}
		System.out.println("changing bot to direction: " + newDir +".");
		bot.setDir(newDir);
	}

}
