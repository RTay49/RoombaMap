package mapMakerTest;

import jssc.SerialPort; 
import jssc.SerialPortException;
/**
 * The class that will handle serial communcations
 * @author Richard Taylor
 *
 */
public class Serial {
	private char r;
	private SerialPort serialPort;
	
	public Serial(){
		serialPort = new SerialPort("/dev/tty.usbmodem1423");//write the serial port location here
	}
	public void open(){
		try {
	        serialPort.openPort();//Open serial port
	        serialPort.setParams(9600, 8, 1, 0);//Set params.
		}
		catch (SerialPortException ex) {
	        System.out.println(ex);
	    }
	}
		
	public char read(){
		try {
			byte[] buffer = serialPort.readBytes(1);//Read 10 bytes from serial port
	       // String all = new String(buffer, StandardCharsets.UTF_8);
	        //System.out.println("all = " + all);
	        r = (char) buffer[0];
	        return r;
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return '\0';
		}
	}
	
	
	public void write(String write){
       
			try {
				serialPort.writeBytes(write.getBytes());
			} catch (SerialPortException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//Write data to port
			
	}
	public void close(){
		try {
			serialPort.closePort();
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
