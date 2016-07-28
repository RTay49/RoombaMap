import java.util.Scanner;

public class Communication {

	private Scanner sc;
	
	public Communication(){
		
		sc = new Scanner(System.in);
	}
	
	public ComPack makeComPack() {
		
		String message = sc.nextLine();
	
		ComPack comPack = new ComPack (message);
		return comPack;
	}

	
	
	
	public void sendMessage(String message){
		
		System.out.println(message);
		
	}
	
}
