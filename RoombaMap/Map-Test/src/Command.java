import java.util.ArrayList;
import java.util.List;

public class Command {
	
	
	
	private ComTest com;
	
	private boolean wallDetect;
	
	public Command(){
		com = new ComTest();
		wallDetect = false;
	
	}

	public void start(){
		String send = "t";
		com.writeMessage(send);
		checkAcknowlege(send);
		checkComplete();
	}
	
	public void stop(){
		String send = "s";
		com.writeMessage(send);
		checkAcknowlege(send);
		checkComplete();
	}
	public char listen(){
		String message = com.listenForMessage();
		char result = message.charAt(0);
		return result;
	}
	public void fowardCon(){
		String send = "f";
		com.writeMessage(send);
		checkAcknowlege(send);
	}
	public void fowardN(int n){
		String send = "w";
		com.writeMessage(send);
		checkAcknowlege(send);
		checkReady();
		com.writeMessage(""+n);
		checkComplete();
	}
	public void backwardCon(){
		String send = "b";
		com.writeMessage(send);
		checkAcknowlege(send);
	}
	public void backwardN(int n){
		String send = "s";
		com.writeMessage(send);
		checkAcknowlege(send);
		checkReady();
		com.writeMessage(""+n);
		checkComplete();
	}
	public void turnRight(int dis){
		String send = "d";
		com.writeMessage(send);
		checkAcknowlege(send);
		checkReady();
		com.writeMessage(""+dis);
		checkComplete();
	}
	
	public void turnLeft(int dis){
		String send = "a";
		com.writeMessage(send);
		checkAcknowlege(send);
		checkReady();
		com.writeMessage(""+dis);
		checkComplete();
		
	}
	
	public List<Integer> scan(){
		String send = "p";
		List<Integer> scanResults = new ArrayList<Integer>();  
		com.writeMessage(send);
		checkAcknowlege(send);
			
		while(true){
				String message = com.listenForMessage();
				System.out.println(message);
				if (message.equals("!")){
					System.out.println("break!!");
					break;
				}
				else{
					int scanResult = Integer.parseInt(message); 
					scanResults.add(scanResult);
				}	
		}
			
		return scanResults;
	}
	
	public void checkAcknowlege(String check){
		String message = com.listenForMessage();
		if(!message.equals(check)){
			com.writeMessage("reset");
		}
	}
	
	public void checkReady(){
		String message = com.listenForMessage();
		if(!message.equals("?")){
			com.writeMessage("reset");
		}
	}
	
	
	public void checkComplete(){
		String message = com.listenForMessage();
		if(!message.equals("!")){
			com.writeMessage("reset");
		}
	}
	public boolean isWallDetected(){
		return wallDetect;
	}

}
