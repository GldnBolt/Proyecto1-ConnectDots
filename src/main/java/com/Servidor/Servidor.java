package com.Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
    private List<Socket> clientes = new ArrayList<>();
    private List<DataOutputStream> flujosSalida = new ArrayList<>();
    private List<DataInputStream> flujosEntrada = new ArrayList<>();
    private ServerSocket serverSocket;

    public void ejecutar(int puerto) {
        Thread hiloServidor = new Thread(() -> {
            try {
                serverSocket = new ServerSocket(puerto);
                System.out.println("Servidor esperando jugadores en el puerto " + puerto + "...");
                while (true) {
                    Socket clienteSocket = serverSocket.accept();
                    System.out.println("Un jugador se ha conectado");
                    clientes.add(clienteSocket);

                    DataOutputStream salida = new DataOutputStream(clienteSocket.getOutputStream());
                    flujosSalida.add(salida);

                    DataInputStream entrada = new DataInputStream(clienteSocket.getInputStream());
                    flujosEntrada.add(entrada);

                    // Crear un hilo para manejar la conexión del nuevo cliente
                    Thread hiloCliente = new Thread(() -> {
                        try {
                            recibir(clienteSocket, entrada);
                        } finally {
                            cerrarConexion(clienteSocket, salida, entrada);
                        }
                    });
                    hiloCliente.start();
                }
            } catch (IOException e) {
                System.out.println("Error al iniciar el servidor");
            }
        });
        hiloServidor.start();
    }

    public void enviar(String mensaje) {
        try {
            for (DataOutputStream salida : flujosSalida) {
                salida.writeUTF(mensaje);
                salida.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void recibir(Socket clienteSocket, DataInputStream entrada) {
        try {
            while (true) {
                String mensajeRecibido = entrada.readUTF();
                enviar("Cliente: " + mensajeRecibido); // Reenviar mensaje a todos los clientes
            }
        } catch (EOFException e) {
            System.out.println("Conexión cerrada por el cliente");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cerrarConexion(Socket clienteSocket, DataOutputStream salida, DataInputStream entrada) {
        try {
            clienteSocket.close();
            clientes.remove(clienteSocket);
            flujosSalida.remove(salida);
            flujosEntrada.remove(entrada);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
