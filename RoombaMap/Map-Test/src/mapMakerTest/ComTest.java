package mapMakerTest;
import java.util.Scanner;


/**
 * a class used in place of the Communication class if
 * you want to simulate the robot by manually typing in 
 * the messages yourself
 * @author Richard Taylor
 */

public class ComTest {

	private Scanner sc;
	
	
	public void open(){
		System.out.println("com opened");
	}
	
	public ComTest(){
		sc = new Scanner(System.in);
	}
	
	public String listenForMessage(){
		
		String message = sc.nextLine();
		
		return message;
		
	}
	
	
	
	
	public void writeMessage(String message){
		
		System.out.println(message);
		
		
	}
	public void reset(){
		System.out.println("reset");
		System.out.println("com closed");
	}
	public void close(){
		System.out.println("com closed");
	}
	
}
