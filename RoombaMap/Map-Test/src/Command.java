import java.util.ArrayList;
import java.util.List;

public class Command {
	
	
	
	private Communication com;
	
	private ArrayList<Integer> scanResults;
	
	private boolean wallDetect;
	
	public Command(Communication com){
		this.com = com;
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
	public void turnRightCon(){
		String send = "r";
		com.writeMessage(send);
		checkAcknowlege(send);
	}
	public void turnRightN(int n){
		String send = "d";
		com.writeMessage(send);
		checkAcknowlege(send);
		checkReady();
		com.writeMessage(""+n);
		checkComplete();
	}
	public void turnLeftCon(){
		String send = "l";
		com.writeMessage(send);
		checkAcknowlege(send);
	}
	public void turnLeftN(int n){
		String send = "a";
		com.writeMessage(send);
		checkAcknowlege(send);
		checkReady();
		com.writeMessage(""+n);
		checkComplete();
	}
	public void scan(){
		String send = "p";
		com.writeMessage(send);
		checkAcknowlege(send);
		checkReady();
		String message = com.listenForMessage();
		if (message == "y"){
			wallDetect = true;
			
			boolean complete  = false;
			
				while(!complete){
				 message = com.listenForMessage();
				if (message == "c"){
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
