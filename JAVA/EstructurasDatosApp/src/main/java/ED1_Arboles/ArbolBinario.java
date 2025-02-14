/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ED1_Arboles;

/**
 *
 * @author Henkourth
 * @param <T>
 */


public class ArbolBinario<T extends Comparable<T>> {
    private NodoArbol<T> raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(T info) {
        raiz = insertarRec(raiz, info);
    }

    private NodoArbol<T> insertarRec(NodoArbol<T> raiz, T info) {
        if (raiz == null) {
            raiz = new NodoArbol<>(info);
            return raiz;
        }

        if (info.compareTo(raiz.getInfo()) < 0) {
            raiz.setIzquierdo(insertarRec(raiz.getIzquierdo(), info));
        } else if (info.compareTo(raiz.getInfo()) > 0) {
            raiz.setDerecho(insertarRec(raiz.getDerecho(), info));
        }

        return raiz;
    }

    public void inOrden() {
        inOrdenRec(raiz);
    }

    private void inOrdenRec(NodoArbol<T> raiz) {
        if (raiz != null) {
            inOrdenRec(raiz.getIzquierdo());
            System.out.print(raiz.getInfo() + " ");
            inOrdenRec(raiz.getDerecho());
        }
    }

    public void preOrden() {
        preOrdenRec(raiz);
    }

    private void preOrdenRec(NodoArbol<T> raiz) {
        if (raiz != null) {
            System.out.print(raiz.getInfo() + " ");
            preOrdenRec(raiz.getIzquierdo());
            preOrdenRec(raiz.getDerecho());
        }
    }

    public void postOrden() {
        postOrdenRec(raiz);
    }

    private void postOrdenRec(NodoArbol<T> raiz) {
        if (raiz != null) {
            postOrdenRec(raiz.getIzquierdo());
            postOrdenRec(raiz.getDerecho());
            System.out.print(raiz.getInfo() + " ");
        }
    }

    public boolean buscar(T info) {
        return buscarRec(raiz, info);
    }

    private boolean buscarRec(NodoArbol<T> raiz, T info) {
        if (raiz == null) {
            return false;
        }

        if (info.compareTo(raiz.getInfo()) == 0) {
            return true;
        }

        return info.compareTo(raiz.getInfo()) < 0
                ? buscarRec(raiz.getIzquierdo(), info)
                : buscarRec(raiz.getDerecho(), info);
    }
}