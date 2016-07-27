import java.util.Scanner;

public class Communication {

	private Scanner sc;
	
	public Communication(){
		
		sc = new Scanner(System.in);
	}
	
	public ComPack makeComPack() {
		
		String message = sc.nextLine();
		
		if(message != null){
			if(message != "start"){
	
				String wall = message.substring(0,1);
		
				String mov = message.substring(3);
		
				boolean isnumber = checkNumber(mov);
		
				
				if(wall != null && isnumber == true){
				
					int Intmov = Integer.parseInt(mov);
		
					ComPack comPack = new ComPack(wall, Intmov);
		
					return comPack;
				}
				else {
					return null;
				}
			}
			
			else {
				ComPack comPack = new ComPack (message);
				return comPack;
			}
		}
		else {
			return null;
		}
	
	}
	
	public boolean checkNumber(String mov){
		
		try{
			int i = Integer.parseInt(mov);
		} catch(NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}
	
	public void sendMessage(String message){
		
		System.out.println(message);
		
	}
	
}
