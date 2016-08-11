
import jssc.SerialPort; 
import jssc.SerialPortException;

public class SimpleWrite {


	public static void write(String write) {
	    SerialPort serialPort = new SerialPort("/dev/tty.usbmodem1423");
	    try {
	        serialPort.openPort();//Open serial port
	        serialPort.setParams(SerialPort.BAUDRATE_9600, 
	                             SerialPort.DATABITS_8,
	                             SerialPort.STOPBITS_1,
	                             SerialPort.PARITY_NONE);//Set params. Also you can set params by this string: serialPort.setParams(9600, 8, 1, 0);
	        serialPort.writeBytes(write.getBytes());//Write data to port
	        serialPort.closePort();//Close serial port
	    }
	    catch (SerialPortException ex) {
	        System.out.println(ex);
	    }
	}
}

