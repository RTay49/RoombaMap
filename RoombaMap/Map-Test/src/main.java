import java.util.Scanner;

public class main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner reader = new Scanner(System.in);
		
		Simulator sim = new Simulator(10,10);
		
		
		
		boolean complete = false;
		
		while(complete != true){
			
			System.out.println("Enter new location...");
			int row = reader.nextInt();
			int col = reader.nextInt();
			
			sim.addFreeSpace(row,col);
			
			System.out.println("Location " + row + ", " + col + ".");
			
			sim.simulateOneStep();
			
			
			
			
		}
		
	}

}
