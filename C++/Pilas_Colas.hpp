#ifndef PILAS_COLAS_HPP
#define PILAS_COLAS_HPP

#include <iostream>

struct NodoPila {
    int dato;
    NodoPila* siguiente;
    NodoPila(int valor) : dato(valor), siguiente(nullptr) {}
};

class Pila {
public:
    NodoPila* tope;
    Pila() : tope(nullptr) {}
    void apilar(int valor);
    void desapilar();
    void mostrar();
};

struct NodoCola {
    int dato;
    NodoCola* siguiente;
    NodoCola(int valor) : dato(valor), siguiente(nullptr) {}
};

class Cola {
public:
    NodoCola* frente;
    NodoCola* final;
    Cola() : frente(nullptr), final(nullptr) {}
    void encolar(int valor);
    void desencolar();
    void mostrar();
};

void manejarPilas();
void manejarColas();

#endif
