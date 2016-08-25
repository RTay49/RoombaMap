package mapReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * The main class will ask you to enter a file location for a .txt file
 * with coordinates.
 * if correct it should create a map based on those coordinates.
 * @author Richard Taylor
 *
 */

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
			System.out.println("File read error, please ensure file path is correct");
			e.printStackTrace();
		}
		new Display(fr.getWalls(),fr.getFSs());

	}

}
