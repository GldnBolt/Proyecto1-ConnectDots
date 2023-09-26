package com.Clientes;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import com.fazecast.jSerialComm.SerialPort;

public class SerialTest {
    public static void main(String[] args) throws AWTException {
        SerialPort port = SerialPort.getCommPort("COM7"); // Reemplaza "COM3" con el nombre del puerto serie que deseas utilizar
        port.openPort();
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 100, 0);
        System.out.println("Puerto serie abierto: " + port.getSystemPortName());
        Robot robot = new Robot();
        while (true) {
            byte[] readBuffer = new byte[1024];
            int numRead = port.readBytes(readBuffer, readBuffer.length);
            String data = new String(readBuffer, 0, numRead);
            System.out.print(data);
            if (data.equals("1")) {
                robot.keyPress(KeyEvent.VK_1);
                robot.keyRelease(KeyEvent.VK_1);
            } else if (data.equals("2")) {
                robot.keyPress(KeyEvent.VK_2);
                robot.keyRelease(KeyEvent.VK_2);
            } else if (data.equals("3")) {
                robot.keyPress(KeyEvent.VK_3);
                robot.keyRelease(KeyEvent.VK_3);
            } else if (data.equals("4")) {
                robot.keyPress(KeyEvent.VK_4);
                robot.keyRelease(KeyEvent.VK_4);
            } else if (data.equals("5")) {
                robot.keyPress(KeyEvent.VK_5);
                robot.keyRelease(KeyEvent.VK_5);
            }
        }
    }
}
