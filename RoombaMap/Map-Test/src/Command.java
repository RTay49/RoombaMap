
public class Command {
	
	private Communication com;
	
	public Command(Communication com){
		this.com = com;
	}
	
	
	public void stop(){
		com.sendMessage("s0");
	}
	public void fowardCon(){
		com.sendMessage("f0");
	}
	public void fowardN(int n){
		com.sendMessage("f"+n);
		check();
	}
	public void backwardCon(){
		com.sendMessage("b0");
	}
	public void backwardN(int n){
		com.sendMessage("b"+n);
		check();
	}
	public void turnRightCon(){
		com.sendMessage("r0");
	}
	public void turnRightN(int n){
		com.sendMessage("r"+n);
		check();
	}
	public void turnLeftCon(){
		com.sendMessage("l0");
	}
	public void turnLeftN(int n){
		com.sendMessage("l"+n);
		check();
	}
	public void check(){
		ComPack complete = com.makeComPack();
		String message = complete.getMessage();
		if(message !=  "done"){
			com.sendMessage("reset");
		}
	}

}
