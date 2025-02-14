/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ED1_Enlazados;

/**
 *
 * @author Henkourth
 */
public class ListaSE<T> implements ILista<T> {
    private NodoSE<T> head;
    private int length;

    public ListaSE() {
        this.head = null;
        this.length = 0;
    }

    @Override
    public void adicionar(T valor) {
        NodoSE<T> nuevoNodo = new NodoSE<>(valor);
        if (head == null) {
            head = nuevoNodo;
        } else {
            NodoSE<T> actual = head;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        length++;
    }

    @Override
    public void insertar(int pos, T valor) {
        if (pos < 0 || pos > length) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }
        NodoSE<T> nuevoNodo = new NodoSE<>(valor);
        if (pos == 0) {
            nuevoNodo.setSiguiente(head);
            head = nuevoNodo;
        } else {
            NodoSE<T> actual = head;
            for (int i = 0; i < pos - 1; i++) {
                actual = actual.getSiguiente();
            }
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
        }
        length++;
    }

    @Override
    public T obtener(int pos) {
        if (pos < 0 || pos >= length) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }
        NodoSE<T> actual = head;
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
        } else {
            NodoSE<T> actual = head;
            for (int i = 0; i < pos - 1; i++) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
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
        NodoSE<T> actual = head;
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
