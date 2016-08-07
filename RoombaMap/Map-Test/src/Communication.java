

public class Communication {

	private SerialListen sl;
	private SerialWrite sw;
	
	public Communication(){
		sl = new SerialListen();
		sw = new SerialWrite();
	}
	
	public String listenForMessage(){
		
		
		try {
			System.out.println("listening");
			sl.listen();
			String message = sl.getLastMessage();
			boolean waiting = true;
			while (waiting){
			//System.out.println("waiting... com message recived: " + message);
			if(message != null){
				waiting = false;
				return message;	
				
		} 
			}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		return null;
	}
	
	
	
	
	public void writeMessage(String message){
		
		sw.write(message);
		sw.write(".");
		
		
	}
	
}
