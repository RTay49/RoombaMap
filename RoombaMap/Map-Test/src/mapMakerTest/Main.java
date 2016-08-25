package mapMakerTest;

/**
 * 
 * The main class that will set up the robot and output the 
 * coordinates of the map it made.
 * 
 * @author Richard Taylor
 *
 */
public class Main {

	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		
        System.out.println("Setting up");
        SetUp setUp = new SetUp();
        System.out.println("finished");
        Simulator sim = setUp.getSim();
        MapWrite write = new MapWrite(sim.getFreeSpaces(),sim.getWalls());
        write.write();
	
	}

		
	
}
