import java.util.Scanner;

public class main {

  Simulator sim;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner reader = new Scanner(System.in);
		
		Simulator sim = new Simulator(185,225);
		
		RMap rMap = sim.getrMap();
		
		boolean complete = false;
		
		while(complete != true){
			
			System.out.println("Enter new location.");
			System.out.println("Enter X coordinate.");
			int X = reader.nextInt();
			System.out.println("Enter Y coordinate.");
			int Y = reader.nextInt();
			
			Location location = convertCoord(rMap, X, Y);
			
			sim.addFreeSpace(location);
			
			System.out.println("Location " + X + ", " + Y + ".");
			
			
			
			
		}
		
	}

	public static Location convertCoord (RMap rMap,int X, int Y){
		
		int w_conv = (rMap.getWidth()-1)/2;
		System.out.println("w_conv = " + w_conv);
		int d_conv = (rMap.getDepth()-1)/2;
		System.out.println("d_conv = " + d_conv);
		
		int col = X + w_conv;
		System.out.println("row = " + col);
		int row = (Y * -1) + d_conv;
		System.out.println("col = " + row);
		
		Location location = new Location(row, col);
		
		return location;
		
		
	}
}
