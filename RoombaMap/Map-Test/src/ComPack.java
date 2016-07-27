
public class ComPack {

	private String message;
	
	private int mov;
	
	
	public ComPack(String message, int mov){
		this.message = message;
		
		this.mov = mov;
			
	}
	
	public ComPack(String message){
		
		this.message = message;
		
		mov = (Integer) null;
	}

	public String getMessage() {
		return message;
	}
	
	public int getMov(){
		return mov;
	}
	
}
