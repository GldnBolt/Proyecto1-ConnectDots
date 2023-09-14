package com.Servidor;

import com.EstructurasDatos.ListaEnlazada;
import com.EstructurasDatos.Nodo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private ListaEnlazada clientes = new ListaEnlazada();
    private ListaEnlazada flujosSalida = new ListaEnlazada();
    private ListaEnlazada flujosEntrada = new ListaEnlazada();
    private ServerSocket serverSocket;

    public void ejecutar(int puerto) {
        Thread hiloServidor = new Thread(() -> {
            try {
                serverSocket = new ServerSocket(puerto);
                System.out.println("Servidor esperando jugadores en el puerto " + puerto + "...");
                while (true) {
                    Socket clienteSocket = serverSocket.accept();
                    System.out.println("Un jugador se ha conectado");

                    clientes.agregar(clienteSocket);
                    DataOutputStream salida = new DataOutputStream(clienteSocket.getOutputStream());
                    flujosSalida.agregar(salida);
                    DataInputStream entrada = new DataInputStream(clienteSocket.getInputStream());
                    flujosEntrada.agregar(entrada);

                    Thread hiloClientes = new Thread(() -> {
                        try {
                            clientes.imprimir();
                            recibir(clienteSocket, entrada);
                        } finally {
                            cerrarConexion(clienteSocket, salida, entrada);
                        }
                    });
                    hiloClientes.start();
                }
            } catch (IOException e) {
                System.out.println("Error al iniciar el servidor");
            }
        });
        hiloServidor.start();
    }

    public void enviar(String mensaje) {
        try {
            Nodo nodoSalida = flujosSalida.getHead();
            while (nodoSalida != null) {
                DataOutputStream salida = (DataOutputStream) nodoSalida.data;
                salida.writeUTF(mensaje);
                salida.flush();
                nodoSalida = nodoSalida.getNext();
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
            clientes.eliminar(clienteSocket);

            Nodo nodoSalida = flujosSalida.getHead();
            while (nodoSalida != null) {
                if (nodoSalida.data == salida) {
                    flujosSalida.eliminar(salida);
                    break;
                }
                nodoSalida = nodoSalida.getNext();
            }

            Nodo nodoEntrada = flujosEntrada.getHead();
            while (nodoEntrada != null) {
                if (nodoEntrada.data == entrada) {
                    flujosEntrada.eliminar(entrada);
                    break;
                }
                nodoEntrada = nodoEntrada.getNext();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
