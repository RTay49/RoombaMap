package mapMaker;

/**
 * sets up the serial and is used to send and receive char messages 
 * as well as closing the serial port.
 *   @author Richard Taylor
 */
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
	
	public void close(){
		serial.close();
		System.out.println("Serial closed");
	}
	
}
