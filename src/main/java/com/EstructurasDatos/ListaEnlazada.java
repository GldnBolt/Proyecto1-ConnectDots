package com.EstructurasDatos;

/**
 * Esta clase es una representacion de una lista enlazada simple.
 */
public class ListaEnlazada {
    private Nodo head;
    private int size;

    /**
     * Constructor de la lista vacia.
     */
    public ListaEnlazada() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Obtiene el tamaño actual de la lista.
     * @return el tamaño de la lista.
     */
    public int getSize() {
        return size;
    }

    /**
     * Obtiene el primer elemento de la lista.
     * @return el primer elemento de la lista.
     */
    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    /**
     *  Agrega un elemento al final de la lista.
     * @param valor elemento a agregar.
     */
    public void agregar(Object valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (head == null) {
            head = nuevoNodo;
        } else {
            Nodo actual = head;
            while (actual.next != null) {
                actual = actual.next;
            }
            actual.next = nuevoNodo;
        }
        size++;
    }

    /**
     * Recorre la lista y elimina el elemento dado.
     * @param valor elemento a eliminar.
     */
    public void eliminar(Object valor) {
        if (head == null) {
            return;
        }

        if (head.data.equals(valor)) {
            head = head.next;
            size--;
            return;
        }

        Nodo actual = head;
        while (actual.next != null) {
            if (actual.next.data.equals(valor)) {
                actual.next = actual.next.next;
                size--;
                return;
            }
            actual = actual.next;
        }
    }

    // Método para imprimir la lista TEMPORAL
    public void imprimir() {
        Nodo actual = head;
        while (actual != null) {
            System.out.print(actual.data + " ");
            actual = actual.next;
        }
        System.out.println();
    }
}
