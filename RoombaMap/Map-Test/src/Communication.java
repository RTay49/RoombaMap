

public class Communication {

	
	public Communication(){
		
	}
	
	public String listenForMessage(){
		
		SimpleRead sr = new SimpleRead();
		sr.read();
		String message = "" + sr.getR();
		return message;
		
	}
	
	
	
	
	public void writeMessage(String message){
		SimpleWrite sw = new SimpleWrite();
		sw.write(message);
		sw.write(".");
		
		
	}
	
}
