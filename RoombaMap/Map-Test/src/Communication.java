

public class Communication {

	private Serial serial;
	
	public Communication(){
		serial = new Serial();
	}
	
	public void open(){
		serial.open();
	}
	
	public String listenForMessage(){
		
		
		
		String message = "" + serial.read();
		return message;
		
	}
	
	
	
	
	public void writeMessage(String message){
		serial.write(message);
	
	}
	
	public void reset(){
		serial.write("r");
		serial.close();
		System.out.println("Serial closed");
	}
	
}
