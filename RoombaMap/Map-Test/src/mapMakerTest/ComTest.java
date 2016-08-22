package mapMakerTest;
import java.util.Scanner;

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
