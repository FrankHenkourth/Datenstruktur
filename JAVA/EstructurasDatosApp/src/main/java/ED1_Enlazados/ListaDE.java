/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ED1_Enlazados;

/**
 *
 * @author Henkourth
 */
public class ListaDE<T> implements ILista<T> {
    private NodoDE<T> head;
    private NodoDE<T> tail;
    private int length;

    public ListaDE() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    @Override
    public void adicionar(T valor) {
        NodoDE<T> nuevoNodo = new NodoDE<>(valor);
        if (head == null) {
            head = nuevoNodo;
            tail = nuevoNodo;
        } else {
            tail.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(tail);
            tail = nuevoNodo;
        }
        length++;
    }

    @Override
    public void insertar(int pos, T valor) {
        if (pos < 0 || pos > length) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }
        NodoDE<T> nuevoNodo = new NodoDE<>(valor);
        if (pos == 0) {
            nuevoNodo.setSiguiente(head);
            if (head != null) {
                head.setAnterior(nuevoNodo);
            }
            head = nuevoNodo;
            if (tail == null) {
                tail = nuevoNodo;
            }
        } else if (pos == length) {
            tail.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(tail);
            tail = nuevoNodo;
        } else {
            NodoDE<T> actual = head;
            for (int i = 0; i < pos - 1; i++) {
                actual = actual.getSiguiente();
            }
            nuevoNodo.setSiguiente(actual.getSiguiente());
            nuevoNodo.setAnterior(actual);
            actual.getSiguiente().setAnterior(nuevoNodo);
            actual.setSiguiente(nuevoNodo);
        }
        length++;
    }

    @Override
    public T obtener(int pos) {
        if (pos < 0 || pos >= length) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }
        NodoDE<T> actual = head;
        for (int i = 0; i < pos; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getInfo();
    }

    @Override
    public void eliminar(int pos) {
        if (pos < 0 || pos >= length) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }
        if (pos == 0) {
            head = head.getSiguiente();
            if (head != null) {
                head.setAnterior(null);
            } else {
                tail = null;
            }
        } else if (pos == length - 1) {
            tail = tail.getAnterior();
            tail.setSiguiente(null);
        } else {
            NodoDE<T> actual = head;
            for (int i = 0; i < pos; i++) {
                actual = actual.getSiguiente();
            }
            actual.getAnterior().setSiguiente(actual.getSiguiente());
            actual.getSiguiente().setAnterior(actual.getAnterior());
        }
        length--;
    }

    @Override
    public boolean vacia() {
        return length == 0;
    }

    @Override
    public int longitud() {
        return length;
    }

    @Override
    public int buscar(T valor) {
        NodoDE<T> actual = head;
        int pos = 0;
        while (actual != null) {
            if (actual.getInfo().equals(valor)) {
                return pos;
            }
            actual = actual.getSiguiente();
            pos++;
        }
        return -1;
    }
}
