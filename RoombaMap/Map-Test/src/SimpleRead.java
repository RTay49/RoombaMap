
import java.nio.charset.StandardCharsets;

import jssc.SerialPort; 
import jssc.SerialPortException;

public class SimpleRead {
	private static char r;

public static void read() {
    SerialPort serialPort = new SerialPort("/dev/tty.usbmodem1423");
    try {
        serialPort.openPort();//Open serial port
        serialPort.setParams(9600, 8, 1, 0);//Set params.
        byte[] buffer = serialPort.readBytes(2);//Read 10 bytes from serial port
        String all = new String(buffer, StandardCharsets.UTF_8);
        //System.out.println("all = " + all);
        r = all.charAt(0);
        
        serialPort.closePort();//Close serial port
    }
    catch (SerialPortException ex) {
        System.out.println(ex);
    }
    
    }
	public char getR(){
	return r;
	}
	
}
