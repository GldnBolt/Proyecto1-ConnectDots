package com.EstructurasDatos;

public class MatrizListas {
    private ListaEnlazada matriz;

    public MatrizListas() {
        this.matriz = new ListaEnlazada();
        for (int i = 0; i < 4; i++) {
            ListaEnlazada fila = new ListaEnlazada();
            matriz.agregar(fila);
        }
    }

    public ListaEnlazada obtenerFila(int fila) {
        Nodo filaActual = matriz.getHead();

        for (int i = 0; i < fila; i++) {
            filaActual = filaActual.next;
        }

        return (ListaEnlazada) filaActual.data;
    }

    public void agregarElemento(int fila, int columna, Object valor) {
        ListaEnlazada filaActual = obtenerFila(fila);

        // Crear un nuevo nodo con el valor y la columna
        Nodo nuevoNodo = new Nodo(valor);
        Nodo nodoActual = filaActual.getHead();
        Nodo nodoAnterior = null;

        // Busca la columna o la última columna en la fila
        while (nodoActual != null) {
            if ((int) nodoActual.data == columna) {
                // Actualizar el valor existente en lugar de agregar uno nuevo
                nodoActual.data = valor;
                return; // Salir de la función si la columna ya existe
            }
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.next;
        }

        if (nodoAnterior == null) {
            // Si la nueva columna debe ir al principio de la fila
            nuevoNodo.setNext(nodoActual);
            filaActual.setHead(nuevoNodo);
        } else {
            // Agrega el nuevo nodo en medio de la fila
            nodoAnterior.setNext(nuevoNodo);
            nuevoNodo.setNext(nodoActual);
        }

    }

    public Object obtenerElemento(int fila, int columna) {
        ListaEnlazada filaActual = obtenerFila(fila);

        if (filaActual == null) {
            return null;
        }

        Nodo nodoActual = filaActual.getHead();

        // Busca el valor en la columna especificada
        while (nodoActual != null) {
            if ((int) nodoActual.data == columna) {
                return (nodoActual.data); // Devuelve el valor almacenado en esa posición
            }
            nodoActual = nodoActual.next;
        }

        return 0; // Devuelve 0 si el elemento no se encuentra en la fila y columna especificadas
    }

    public static void main(String[] args) {
        MatrizListas matriz = new MatrizListas();

        matriz.agregarElemento(1, 1, 1);
        matriz.agregarElemento(1, 2, 2);
        matriz.agregarElemento(1,3, 3);

        System.out.println(matriz.obtenerElemento(1, 1));
        System.out.println(matriz.obtenerElemento(1, 2));
        System.out.println(matriz.obtenerElemento(1, 3));
    }
}
