#include "arboles.hpp"
/*
void ABB::insertar(int valor) {
    raiz = insertarRec(raiz, valor);
}

NodoArbol* insertarRec(NodoArbol* nodo, int valor) {
    if (!nodo) return new NodoArbol(valor);
    if (valor < nodo->dato)
        nodo->izquierda = insertarRec(nodo->izquierda, valor);
    else
        nodo->derecha = insertarRec(nodo->derecha, valor);
    return nodo;
}

void ABB::inorden(NodoArbol* nodo) {
    if (!nodo) return;
    inorden(nodo->izquierda);
    std::cout << nodo->dato << " ";
    inorden(nodo->derecha);
}

void manejarArbolBusqueda() {
    ABB arbol;
    arbol.insertar(25);
    arbol.insertar(15);
    arbol.insertar(30);
    arbol.inorden(arbol.raiz);
}

void manejarABB() {
    manejarArbolBusqueda();
}

*/