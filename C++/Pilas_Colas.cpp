#include "pilas_colas.hpp"

void Pila::apilar(int valor) {
    NodoPila* nuevo = new NodoPila(valor);
    nuevo->siguiente = tope;
    tope = nuevo;
}

void Pila::desapilar() {
    if (tope) {
        NodoPila* temp = tope;
        tope = tope->siguiente;
        delete temp;
    }
}

void Pila::mostrar() {
    NodoPila* temp = tope;
    while (temp) {
        std::cout << temp->dato << " -> ";
        temp = temp->siguiente;
    }
    std::cout << "NULL\n";
}

void Cola::encolar(int valor) {
    NodoCola* nuevo = new NodoCola(valor);
    if (!final) {
        frente = final = nuevo;
    } else {
        final->siguiente = nuevo;
        final = nuevo;
    }
}

void Cola::desencolar() {
    if (frente) {
        NodoCola* temp = frente;
        frente = frente->siguiente;
        delete temp;
        if (!frente) final = nullptr;
    }
}

void Cola::mostrar() {
    NodoCola* temp = frente;
    while (temp) {
        std::cout << temp->dato << " -> ";
        temp = temp->siguiente;
    }
    std::cout << "NULL\n";
}

void manejarPilas() {
    Pila pila;
    pila.apilar(30);
    pila.apilar(40);
    pila.mostrar();
}

void manejarColas() {
    Cola cola;
    cola.encolar(50);
    cola.encolar(60);
    cola.mostrar();
}
