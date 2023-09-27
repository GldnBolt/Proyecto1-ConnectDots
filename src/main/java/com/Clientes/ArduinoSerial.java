package com.Clientes;

import com.fazecast.jSerialComm.SerialPort;
import java.awt.*;
import java.awt.event.KeyEvent;

public class ArduinoSerial extends Thread {
    private SerialPort port;
    private Robot robot;

    public ArduinoSerial() throws AWTException {
        port = SerialPort.getCommPort("COM7");
        port.openPort();
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 100, 0);
        System.out.println("Puerto serie abierto: " + port.getSystemPortName());
        robot = new Robot();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            byte[] readBuffer = new byte[1024];
            int numRead = port.readBytes(readBuffer, readBuffer.length);
            String data = new String(readBuffer, 0, numRead);
            if (data.equals("1")) {
                robot.keyPress(KeyEvent.VK_1);
            } else if (data.equals("2")) {
                robot.keyPress(KeyEvent.VK_2);
            } else if (data.equals("3")) {
                robot.keyPress(KeyEvent.VK_3);
            } else if (data.equals("4")) {
                robot.keyPress(KeyEvent.VK_4);
            } else if (data.equals("5")) {
                robot.keyPress(KeyEvent.VK_5);
            }
        }
        port.closePort();
    }
}
