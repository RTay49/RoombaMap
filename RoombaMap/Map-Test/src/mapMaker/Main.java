package mapMaker;
/**
 * The main method that will set up the Robot and then 
 * output a map of what it finds
 * @author Richard Taylor
 *
 */
public class Main {

	
	
	private static boolean complete;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		
        System.out.println("Setting up");
        SetUp setUp = new SetUp();
        System.out.println("finished");
        BotSimulator sim = setUp.getSim();
        MapWrite write = new MapWrite(sim.getFreeSpaces(),sim.getWalls());
        write.write();
		
        complete = false;
        System.out.println("complete set to " + complete);

	}

		
	
}
