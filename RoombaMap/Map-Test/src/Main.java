import java.io.IOException;
import java.util.Scanner;

public class Main {

	
	
	private static boolean complete;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		
        System.out.println("loading Action");
        SetUp setUp = new SetUp();
        System.out.println("action loaded");
        
        System.out.println("action set up");
        System.out.println("awaiting start responce...");
        System.out.println("responce recived");
		
        complete = false;
        System.out.println("complete set to " + complete);
	
		/**
        System.out.println("system engadeged");
		while(complete != true){
			 
			complete = action.isComplete();
			System.out.println("complete set to " + complete);
			System.out.println("system engadeged");
			
			action.act();
			
		}
		*/
	}

		
	
}
