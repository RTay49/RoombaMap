package mapMaker;
import java.util.ArrayList;
import java.util.List;

public class Command {
	
	private String lastMessage;
	private boolean newMessage;
	
	
	private Communication com;
	
	private boolean wallDetect;
	
	public Command(){
		com = new Communication ();
		wallDetect = false;
		com.open();
		System.out.println("serial opened");
	
	}
	
	private boolean isnewMessage(String message){
		if(message!= lastMessage){
			return true;
		}
		else{
			return false;
		}
	}

	public void start(){
		System.out.println("cmd starting");
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
	public char cruise(){
		String send = "c";
		com.writeMessage(send);
		checkAcknowlege(send);
		String message = com.listenForMessage();
		System.out.println("cruise result:"+message);
		char result = message.charAt(0);
		System.out.println("returning:"+result);
		checkComplete();
		return result;
	}
	public void fowardCon(){
		String send = "f";
		com.writeMessage(send);
		checkAcknowlege(send);
		checkComplete();
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
		while(true){
			System.out.println("message:"+message);
			System.out.println("lastMessage:"+lastMessage);
			if(isnewMessage(message)){
				lastMessage = message;
				break;
			}
			message = com.listenForMessage();
		 }
		
		if(!message.equals(check)){
			System.out.println("acknowlege error message:" + message);
			close();
		}
	}
	
	public void checkReady(){
		String message = com.listenForMessage();
		System.out.println("message:"+message);
		System.out.println("lastMessage:"+lastMessage);
		while(true){
			if(isnewMessage(message)){
				lastMessage = message;
				break;
			}
			message = com.listenForMessage();
		 }
		if(!message.equals("?")){
			System.out.println("ready error message:" + message);
			close();
		}
	}
	
	
	public void checkComplete(){
		String message = com.listenForMessage();
		System.out.println("message:"+message);
		System.out.println("lastMessage:"+lastMessage);
		while(true){
			if(isnewMessage(message)){
				lastMessage = message;
				break;
			}
			message = com.listenForMessage();
		 }
		if(!message.equals("!")){
			System.out.println("complete error message:" + message);
			close();
		}
	}
	public boolean isWallDetected(){
		return wallDetect;
	}
	public void close(){
		com.close();
	}

}
