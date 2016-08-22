package mapMakerTest;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class MapWrite {
	private List freeSpaces;
	private List walls;
	
	public MapWrite(List freeSpaces, List walls){
		this.freeSpaces = freeSpaces;
		this.walls = walls;
		
	
	}
	public void write(){
		try {
			
			List<String> fSs = convertToWrite(freeSpaces);
			List<String> ws = convertToWrite(walls);

			File file = new File("/home/richard/Map.txt");

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("Walls");
			bw.newLine();
			for(String w: ws){
				bw.write(w);
				bw.newLine();
			}
			
			
			bw.write("FreeSpaces");
			bw.newLine();
			
			for(String fs: fSs){
				bw.write(fs);
				bw.newLine();
			}
			
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public List<String> convertToWrite(List<Object> places){
		List<String> write = new ArrayList<String>();
		for(Object place: places){
			Object pl = (Place) place;
			Location location = ((Place) pl).getLocation();
			int xCord = location.getXCord();
			int yCord = location.getYCord();
			write.add(xCord+","+yCord);	
		}
		return write;
	}
	

}
