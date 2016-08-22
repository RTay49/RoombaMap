package mapReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the file path");
		String filePath = sc.nextLine();
		FileRead fr = new FileRead(filePath);
		try {
			fr.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Display d = new Display(fr.getWalls(),fr.getFSs());

	}

}
