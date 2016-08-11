import java.util.Scanner;

public class ComTest {

	private Scanner sc;
	
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
	
}
