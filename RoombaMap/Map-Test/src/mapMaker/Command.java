package mapMaker;
import java.util.ArrayList;
import java.util.List;
/**
 * This class will handles what messages are received and sent from the program
 * and Robot and depending on desired actions.
 * 
 * The command class should send a message in as a char and wait to see if the
 * same char is sent back to make sure the right message has been received.
 * 
 * Some commands may require further input and a '?' should be received meaning 
 * the robot is awaiting further input usually a distance.
 * 
 * A '!' should be received when the command if complete except for the close command
 * as it will close the com port.
 * @author Richard Taylor
 */
public class Command {
	
	private String lastMessage;
	
	
	private Communication com;
	
	private boolean wallDetect;
	
	public Command(){
		com = new Communication();
		wallDetect = false;
		com.open();
		System.out.println("serial opened");
	
	}
	
	/*
	 * Make sure messages received form the robot are new. The system 
	 * has been designed that when working correctly messages should
 	 * should always be different from the last.
	 */
	private boolean isnewMessage(String message){
		if(message!= lastMessage){
			return true;
		}
		else{
			return false;
		}
	}
	/*
	 * Starts the Robot up
	 */
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
	/*
	 * A command that will make the robot go forward and report back any detected walls
	 * in use once a direction has been set.
	 */
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
	/*
	 * A Command that will order the robot to spin around to detect 
	 * walls with its front sensor any walls detected will be return in a list
	 * of ints representing there direction
	 */
	public List<Integer> scan(){
		String send = "p";
		List<Integer> scanResults = new ArrayList<Integer>();  
		com.writeMessage(send);
		checkAcknowlege(send);
			
		while(true){
				String message = com.listenForMessage();
				//System.out.println(message);
				if (message.equals("!")){
					break;
				}
				else{
					int scanResult = Integer.parseInt(message); 
					scanResults.add(scanResult);
				}	
		}
			
		return scanResults;
	}
	/*
	 * used to check if the right command was received.
	 */
	public void checkAcknowlege(String check){
		String message = com.listenForMessage();
		while(true){
			//System.out.println("message:"+message);
			//System.out.println("lastMessage:"+lastMessage);
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
	/*
	 * used to check if Robot is awaiting further input.
	 */
	public void checkReady(){
		String message = com.listenForMessage();
		//System.out.println("message:"+message);
		//System.out.println("lastMessage:"+lastMessage);
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
	
	/*
	 * used to check if a robot has comleted its task
	 */
	public void checkComplete(){
		String message = com.listenForMessage();
		//System.out.println("message:"+message);
		//System.out.println("lastMessage:"+lastMessage);
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
	/*
	 * closes the com port to allow to free it up.
	 */
	public void close(){
		com.close();
	}

}
