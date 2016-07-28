import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static Simulator sim;
	
	private static boolean complete;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("loading sim...");
        sim = new Simulator(11,11);
        System.out.println("sim loaded");
		
        System.out.println("loading Action");
        Action action = new Action(sim);
        System.out.println("action loaded");
        
        System.out.println("action set up");
        System.out.println("awaiting start responce...");
        action.setUp();
        System.out.println("responce recived");
		
        complete = false;
        System.out.println("complete set to " + complete);
	
		
        System.out.println("system engadeged");
		while(complete != true){
			 
			complete = action.isComplete();
			System.out.println("complete set to " + complete);
			System.out.println("system engadeged");
			
			action.act();
			
		}
		
	}

	
	public static Simulator getSim(){
		
		return sim;
		
	}
	
}
