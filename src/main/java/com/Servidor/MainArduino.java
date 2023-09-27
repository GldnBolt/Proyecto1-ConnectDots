package com.Servidor;

import java.awt.AWTException;

/**
 * Esta clase ejecuta el codigo que permite la conexion con el Arduino
 */
public class MainArduino {
    public static void main(String[] args) throws AWTException, AWTException {
        ArduinoSerial serial = new ArduinoSerial();
        serial.start();
    }
}

