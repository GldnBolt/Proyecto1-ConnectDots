package com.EstructurasDatos;

public class Cola {
    private Nodo front;
    private Nodo rear;
    private int size;

    public Cola() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Obtener el tamaño de la cola
    public int tamano() {
        return size;
    }

    // Agregar un elemento al final de la cola
    public void enqueue(Object valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (size == 0) {
            front = nuevoNodo;
            rear = nuevoNodo;
        } else {
            rear.next = nuevoNodo;
            rear = nuevoNodo;
        }
        size++;
    }

    // Eliminar y devolver el elemento en la parte frontal de la cola
    public Object dequeue() {
        if (size == 0) {
            throw new IllegalStateException("La cola está vacía.");
        }

        Object valorFrontal = front.data;
        front = front.next;
        size--;

        if (front == null) {
            rear = null; // La cola está vacía después de eliminar el último elemento
        }

        return valorFrontal;
    }

    // Obtener el elemento en la parte frontal de la cola sin eliminarlo
    public Object peek() {
        if (size == 0) {
            throw new IllegalStateException("La cola está vacía.");
        }
        return front.data;
    }
}
