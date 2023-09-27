package com.Servidor;

import com.EstructurasDatos.Cola;
import com.EstructurasDatos.ListaEnlazada;
import com.EstructurasDatos.MatrizListas;
import com.EstructurasDatos.Nodo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private final ListaEnlazada clientes = new ListaEnlazada();
    private final Cola colaClientes = new Cola();
    private final ListaEnlazada flujosSalida = new ListaEnlazada();
    private final ListaEnlazada flujosEntrada = new ListaEnlazada();
    private ServerSocket serverSocket;

    /**
     * Esta funcion genera la matriz que se utilizara en el archivo JSON
     */
    public void GenerarMatriz(){
        MatrizListas matriz = new MatrizListas();

        for (int i = 0; i < 4; i++) { // Recorrer las filas
            for (int j = 0; j < 4; j++) { // Recorrer las columnas
                matriz.agregarElemento(i, j, 0); // Agregar el valor a la matriz
            }
        }
        matriz.imprimirMatrizRandom();
    }

    /**
     * Esta funcion permite que el se cree el socket al cual se van a conectar los clientes y genera una cola de clientes
     * para almacenar cuantos hay y poder cargar las partidas.
     * @param puerto es el puerto que se pone a la hora de que se abre la ventana del servidor.
     */
    public void ejecutar(int puerto) {
        Thread hiloServidor = new Thread(() -> {
            try {
                serverSocket = new ServerSocket(puerto);
                System.out.println("Servidor esperando jugadores en el puerto " + puerto + "...");
                while (true) {
                    Socket clienteSocket = serverSocket.accept();
                    System.out.println("Un jugador se ha conectado");

                    clientes.agregar(clienteSocket);
                    colaClientes.enqueue(clienteSocket);
                    DataOutputStream salida = new DataOutputStream(clienteSocket.getOutputStream());
                    flujosSalida.agregar(salida);
                    DataInputStream entrada = new DataInputStream(clienteSocket.getInputStream());
                    flujosEntrada.agregar(entrada);

                    Thread hiloClientes = new Thread(() -> {
                        try {
                            recibir(clienteSocket, entrada);
                        } finally {
                            cerrarConexion(clienteSocket, salida, entrada);
                        }
                    });
                    hiloClientes.start();

                    if (colaClientes.tamano() >= 2){
                        System.out.println("empezar"); //poner funcion empezar
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al iniciar el servidor");
            }
        });
        hiloServidor.start();
    }

    /**
     * Esta funcion permite enviar los mensajes entre el servidor y los clientes.
     * @param mensaje es el mensaje que se envia entre el servidor y los clientes.
     */
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

    /**
     * Esta funcion permite recibir los mensajes que envian los clientes.
     * @param clienteSocket
     * @param entrada la entrada de la cual esta leyendo el mensaje
     */
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

    /**
     * Esta funcion permite cerrar la conexion entre el servidor y los clientes de manera que no haya errores.
     * @param clienteSocket
     * @param salida
     * @param entrada
     */
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
