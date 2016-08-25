package mapReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
/**
 * 
 * A class that reads the coordinates from a text file
 * and stores them as lists.
 * Some help from
 * http://www.homeandlearn.co.uk/java/read_a_textfile_in_java.html
 * 
 * @author Richard Taylor
 *
 */

public class FileRead {

	private String line;
	private String filePath;
	private ArrayList<String> walls;
	private ArrayList<String> fSs;
	
	public FileRead (String filePath){
		this.filePath = filePath;
		walls = new ArrayList<String>();
		fSs = new ArrayList<String>();
	}
	
	public void read ()throws IOException{
		
		FileReader fr = new FileReader(filePath);
		
		BufferedReader br = new BufferedReader(fr);
		boolean wall = true;
		while ((line = br.readLine()) != null){
			System.out.println("line read =" + line);
			if(line != null){
				
				
				
				if(line.equals("FreeSpaces")){
					System.out.println(line);
					System.out.println("break!");
					wall = false;
				}
				else if(!line.equals("Walls") && wall == true){
					System.out.println(line +" added to walls");
					walls.add(line);
				}
				else if(wall == false){
					System.out.println(line +" added to fSs");
					fSs.add(line);
				
				}
		
			}
		}	
	}
	
	public ArrayList<String> getWalls(){
		return walls;
	}
	public ArrayList<String> getFSs(){
		return fSs;
	}
	
}
