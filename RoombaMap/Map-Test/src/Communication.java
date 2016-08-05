

public class Communication {

	private SerialListen sl;
	private SerialWrite sw;
	
	public Communication(){
		sl = new SerialListen();
		sw = new SerialWrite();
	}
	
	public String listenForMessage(){
		
		
		try {
			sl.listen();
			String message = sl.getLastMessage();
			
			if(message != null){
				sl.resetLastMessage();
			}
			return message;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	
	
	public void writeMessage(String message){
		
		sw.write(message);
		
		
	}
	
}
