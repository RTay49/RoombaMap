import java.io.*;
import java.util.*;
import gnu.io.*;

public class SimpleWrite {
static Enumeration portList;
static CommPortIdentifier portId;
static String messageString = "w";
static SerialPort serialPort;
static OutputStream outputStream;

public static void main(String[] args) {
    portList = CommPortIdentifier.getPortIdentifiers();


    while (portList.hasMoreElements()) {

        portId = (CommPortIdentifier) portList.nextElement();
        if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {

             if (portId.getName().equals("/dev/tty.usbmodem1423")) {

                try {
                    serialPort = (SerialPort)
                        portId.open("SimpleWriteApp", 2000);
                } catch (PortInUseException e) {System.out.println("err");}
                try {
                    outputStream = serialPort.getOutputStream();
                } catch (IOException e) {System.out.println("err1");}
                try {
                    serialPort.setSerialPortParams(9600,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE);
                } catch (UnsupportedCommOperationException e) {System.out.println("err2");}
                try {
                    outputStream.write(messageString.getBytes());
        System.out.println(messageString);

        outputStream.close();
        serialPort.close();

                } catch (IOException e) {System.out.println("err3");}
            }
        }
    }
}
}