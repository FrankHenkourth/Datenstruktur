#ifndef ARBOLES_HPP
#define ARBOLES_HPP

#include <iostream>

struct NodoArbol {
    int dato;
    NodoArbol* izquierda;
    NodoArbol* derecha;
    NodoArbol(int valor) : dato(valor), izquierda(nullptr), derecha(nullptr) {}
};

class ABB {
public:
    NodoArbol* raiz;
    ABB() : raiz(nullptr) {}
    void insertar(int valor);
    void inorden(NodoArbol* nodo);
};

void manejarArbolBusqueda();
void manejarABB();

#endif
