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
		com.writeMessage("start");
		checkComplete();
	}
	
	public void stop(){
		com.writeMessage("s");
		checkComplete();
	}
	public void fowardCon(){
		com.writeMessage("f");
		checkComplete();
	}
	public void fowardN(int n){
		com.writeMessage("w");
		checkReady();
		com.writeMessage(""+n);
		checkComplete();
	}
	public void backwardCon(){
		com.writeMessage("b");
		checkComplete();
	}
	public void backwardN(int n){
		com.writeMessage("s");
		checkReady();
		com.writeMessage(""+n);
		checkComplete();
	}
	public void turnRightCon(){
		com.writeMessage("r");
	}
	public void turnRightN(int n){
		com.writeMessage("d");
		checkReady();
		com.writeMessage(""+n);
		checkComplete();
	}
	public void turnLeftCon(){
		com.writeMessage("l");
		checkComplete();
	}
	public void turnLeftN(int n){
		com.writeMessage("a");
		checkReady();
		com.writeMessage(""+n);
		checkComplete();
	}
	public void scan(){
		com.writeMessage("p");
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
	public void checkReady(){
		String message = com.listenForMessage();
		if(!message.equals("ready")){
			com.writeMessage("reset");
		}
	}
	
	public void checkComplete(){
		String message = com.listenForMessage();
		if(!message.equals("done")){
			com.writeMessage("reset");
		}
	}

}
