package com.Servidor;

import com.fazecast.jSerialComm.SerialPort;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Esta clase permite la conexion con Arduino
 */
public class ArduinoSerial extends Thread {
    private SerialPort port;
    private Robot robot;

    /**
     * Esta funcion lo que permite es abrir la conexion con el puerto, en este caso el COM3 y imprime un mensaje de verificacion.
     * @throws AWTException esto es parte de la syntaxis de la funcion, funciona como posible error
     */
    public ArduinoSerial() throws AWTException {
        port = SerialPort.getCommPort("COM7");
        port.openPort();
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 100, 0);
        System.out.println("Puerto serie abierto: " + port.getSystemPortName());
        robot = new Robot();
    }

    /**
     * Esta funcion permite, por medio de un thread, recibir los datos que envia el arduino y convertir dichos datos a las teclas
     * del teclado que en este caso, nos permiten movernos en el juego.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            byte[] readBuffer = new byte[1024];
            int numRead = port.readBytes(readBuffer, readBuffer.length);
            String data = new String(readBuffer, 0, numRead);
            if (data.equals("1")) {
                robot.keyPress(KeyEvent.VK_RIGHT);
                robot.keyRelease(KeyEvent.VK_RIGHT);
            } else if (data.equals("2")) {
                robot.keyPress(KeyEvent.VK_UP);
                robot.keyRelease(KeyEvent.VK_UP);
            } else if (data.equals("3")) {
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
            } else if (data.equals("4")) {
                robot.keyPress(KeyEvent.VK_LEFT);
                robot.keyRelease(KeyEvent.VK_LEFT);
            } else if (data.equals("5")) {
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            }
        }
        port.closePort();
    }
}
