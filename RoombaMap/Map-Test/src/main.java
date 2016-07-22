import java.io.IOException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Simulator sim = new Simulator(185,225);
		
		Communication com = new Communication();
		
		
		boolean complete = false;
	
		
		while(complete != true){
			
			try {
			ComPack input = com.makeComPack();
				
				
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
			
			
			
			
		}
		
	}

	
}
