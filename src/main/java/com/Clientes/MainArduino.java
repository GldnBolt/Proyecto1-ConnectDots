package com.Clientes;

import java.awt.AWTException;

public class MainArduino {
    public static void main(String[] args) throws AWTException, AWTException {
        ArduinoSerial serial = new ArduinoSerial();
        serial.start();
    }
}

