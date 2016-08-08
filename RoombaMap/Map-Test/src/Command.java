import java.util.ArrayList;
import java.util.List;

public class Command {
	
	
	
	private ComTest com;
	
	private ArrayList<Integer> scanResults;
	
	private boolean wallDetect;
	
	public Command(){
		com = new ComTest();
		wallDetect = false;
		scanResults = new ArrayList<Integer>() {
		};
	
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
	public void turnRight45(){
		String send = "e";
		com.writeMessage(send);
		checkAcknowlege(send);
		checkComplete();
	}
	public void turnRight90(){
		String send = "d";
		com.writeMessage(send);
		checkAcknowlege(send);
		checkComplete();
	}
	public void turnLeft45(){
		String send = "q";
		com.writeMessage(send);
		checkAcknowlege(send);
		checkComplete();
	}
	public void turnLeft90(){
		String send = "a";
		com.writeMessage(send);
		checkAcknowlege(send);
		checkComplete();
	}
	public void scan(){
		String send = "p";
		com.writeMessage(send);
		checkAcknowlege(send);
		String message = com.listenForMessage();
		if (message == "y"){
			wallDetect = true;
			
			boolean complete  = false;
			
				while(!complete){
				 message = com.listenForMessage();
				if (message == "!"){
					complete = true;
				}
				else{
					int scanResult = Integer.parseInt(message); 
					scanResults.add(scanResult);
				}
				
			}
			
			
		}
		else{
			checkComplete();
		}
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
	public ArrayList<Integer> getScanResults(){
		return scanResults;
	}
	public void clearScanResults(){
		scanResults.clear();
	}

}
