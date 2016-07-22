import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Communication {

	private BufferedReader br;
	
	public Communication(){
		
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public ComPack makeComPack() throws IOException {
		
		try {
			br.wait();
			System.out.println("Awaiting input");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
		String input = br.readLine();
		
		char[] chaA = input.toCharArray(); 
		
		char wall = chaA[0];
		
		char dir = chaA[1];
		
		ComPack com = new ComPack(wall,dir);
		
		return com;
		
		} catch (IOException inputerror){
			
			System.out.println("Input error");
			return null;
		}
		
		
		
		
		
		
		
		
	}
	

	
}
