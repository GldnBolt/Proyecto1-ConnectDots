package com.Clientes;

//import gnu.io.CommPortIdentifier;
//import gnu.io.SerialPort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

public class ArduinoSerial {
    private static BufferedReader input;
    private static OutputStream output;
    private static final int TIMEOUT = 2000;
    private static final int BAUD_RATE = 9600;
    private static final String PORT_NAME = "COM3"; // Change this to match your port name

    public static void main(String[] args) {
        try {
       //     CommPortIdentifier portId = null;
         //   Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

           // while (portEnum.hasMoreElements()) {
            //    CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
                if (currPortId.getName().equals(PORT_NAME)) {
                    portId = currPortId;
                    break;
                }
            }

            if (portId == null) {
                System.err.println("Could not find COM port.");
                return;
            }

            SerialPort serialPort = (SerialPort) portId.open("ArduinoSerial", TIMEOUT);
            serialPort.setSerialPortParams(BAUD_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            while (true) {
                String line = input.readLine();
                if (line != null) {
                    System.out.println("Button " + line + " pressed");
                }
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}