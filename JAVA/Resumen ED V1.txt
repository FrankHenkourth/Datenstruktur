/**
 * RESUMEN PARA EXAMEN DE ESTRUCTURAS DE DATOS
 * @author Henkourth
 * @version 5:24AM 
 * Este codigo incluye:
 *  - NodoSE: Nodo para listas simplemente enlazadas
 *  - NodoDE: Nodo para listas doblemente enlazadas
 *  - ListaSE: Lista simplemente enlazada con metodos de insercion,
 *      busqueda, extraccion, reemplazo, eliminacion, duplicacion y acceso a elementos
 *  - ListaDE: Lista doblemente enlazada con metodos de insercion, busqueda,
 *      eliminacion y obtencion de elementos en ambos sentidos
 *  - Pila: Implementacion de una pila (LIFO) con metodos adicionar y extraer
 *  - Cola: Implementacion de una cola (FIFO) con metodos adicionar y extraer
 *  - Ejemplos: Clase que contiene metodos teoricos para practicar la logica de
 *      manipulacion de estructuras (busqueda, procesamiento condicional, fusion, filtrado, etc)
 *      sin interaccion de entrada o salida
 * 
 * 
 *  Si desean pudeen hacer algunas modificaciones para ejecutarlo como un programa 100% funcional
 *  o intentar hacer unos metodos de practica usando las ED. (No anado los pasos porque seria muy tedioso)
 *  OJOOOO ALGUNOS COMENTARIOS Y LAS CLASES AUXILIARES ESTAN CREADAS CON IA 
 *  El codigo 100 revisado esta en la Clase EJEMPLOS en la linea 600
 *  Voy a dormir que llevo 6 horas en esto.... y todavia falta arboles
 */

/*========================================
 =            Nodos de Estructuras        =
 ========================================*/

/**
 * Clase NodoSE
 * Representa un nodo en una lista simplemente enlazada
 */
class NodoSE {
    int valor         // Valor almacenado en el nodo
    NodoSE siguiente  // Referencia al siguiente nodo

    // Constructor que inicializa el nodo con un valor
    public NodoSE(int valor) {
        this.valor = valor
        this.siguiente = null
    }
}

/**
 * Clase NodoDE
 * Representa un nodo en una lista doblemente enlazada
 */
class NodoDE {
    private int valor         // Valor almacenado en el nodo
    private NodoDE siguiente  // Referencia al siguiente nodo
    private NodoDE anterior   // Referencia al nodo anterior

    // Constructor que inicializa el nodo con un valor
    public NodoDE(int valor) {
        this.valor = valor
        this.siguiente = null
        this.anterior = null
    }

    // Metodos de acceso y modificacion
    public int getDato() {
        return valor
    }
    
    public NodoDE getSiguiente() {
        return siguiente
    }
    
    public void setSiguiente(NodoDE siguiente) {
        this.siguiente = siguiente
    }
    
    public NodoDE getAnterior() {
        return anterior
    }
    
    public void setAnterior(NodoDE anterior) {
        this.anterior = anterior
    }
}

/*========================================
 =        Estructuras de Datos            =
 ========================================*/

/**
 * Clase ListaSE
 * Implementa una lista simplemente enlazada con metodos para:
 * insercion (al inicio y al final), busqueda, extraccion, reemplazo,
 * eliminacion, duplicacion y obtencion de elementos
 */
class ListaSE {
    private NodoSE cabeza  // Referencia al primer nodo de la lista

    public ListaSE() {
        this.cabeza = null
    }

    /**
     * Inserta un nuevo nodo al inicio de la lista
     * @param valor Valor a insertar
     */
    public void insertarInicio(int valor) {
        NodoSE nuevo = new NodoSE(valor)
        nuevo.siguiente = cabeza
        cabeza = nuevo
    }

    /**
     * Inserta un nuevo nodo al final de la lista
     * @param valor Valor a insertar
     */
    public void insertarFinal(int valor) {
        NodoSE nuevo = new NodoSE(valor)
        if (cabeza == null) {
            cabeza = nuevo
        } else {
            NodoSE actual = cabeza
            while (actual.siguiente != null) {
                actual = actual.siguiente
            }
            actual.siguiente = nuevo
        }
    }

    /**
     * Busca si existe al menos un nodo con el valor indicado
     * @param valor Valor a buscar
     * @return true si se encuentra; false en caso contrario
     */
    public boolean buscar(int valor) {
        NodoSE actual = cabeza
        while (actual != null) {
            if (actual.valor == valor)
                return true
            actual = actual.siguiente
        }
        return false
    }

    /**
     * Extrae (elimina) el primer nodo de la lista y retorna su valor
     * @return Valor del nodo extraido
     * @throws java.util.NoSuchElementException si la lista esta vacia
     */
    public int extraer() {
        if (cabeza == null)
            throw new java.util.NoSuchElementException("Lista vacia")
        int valor = cabeza.valor
        cabeza = cabeza.siguiente
        return valor
    }

    /**
     * Reemplaza el primer nodo que contenga el valor 'antiguo' por el valor 'nuevo'
     * @param antiguo Valor a reemplazar
     * @param nuevo Nuevo valor
     * @return true si se realizo el reemplazo; false si no se encontro el valor
     */
    public boolean reemplazar(int antiguo, int nuevo) {
        NodoSE actual = cabeza
        while (actual != null) {
            if (actual.valor == antiguo) {
                actual.valor = nuevo
                return true
            }
            actual = actual.siguiente
        }
        return false
    }

    /**
     * Obtiene la posicion (indice) del primer nodo que contiene el valor especificado
     * @param valor Valor a buscar
     * @return Indice del nodo o -1 si no se encuentra
     */
    public int obtenerPosicion(int valor) {
        NodoSE actual = cabeza
        int pos = 0
        while (actual != null) {
            if (actual.valor == valor)
                return pos
            pos++
            actual = actual.siguiente
        }
        return -1
    }

    /**
     * Elimina el primer nodo que contiene el valor especificado
     * @param valor Valor a eliminar
     * @return true si se elimino el nodo; false si no se encontro
     */
    public boolean eliminar(int valor) {
        if (cabeza == null)
            return false
        if (cabeza.valor == valor) {
            cabeza = cabeza.siguiente
            return true
        }
        NodoSE actual = cabeza
        while (actual.siguiente != null) {
            if (actual.siguiente.valor == valor) {
                actual.siguiente = actual.siguiente.siguiente
                return true
            }
            actual = actual.siguiente
        }
        return false
    }

    /**
     * Crea y retorna una copia de la lista manteniendo el mismo orden
     * @return Nueva instancia de ListaSE con los mismos valores
     */
    public ListaSE duplicarLista() {
        ListaSE nuevaLista = new ListaSE()
        NodoSE actual = cabeza
        while (actual != null) {
            nuevaLista.insertarFinal(actual.valor)
            actual = actual.siguiente
        }
        return nuevaLista
    }

    /**
     * Retorna la referencia al primer nodo de la lista (cabeza)
     * @return NodoSE cabeza
     */
    public NodoSE getCabeza() {
        return cabeza
    }

    /**
     * Obtiene los elementos de la lista en un arreglo de enteros
     * @return Arreglo con los valores de la lista
     */
    public int[] obtenerElementos() {
        int count = 0
        NodoSE cursor = cabeza
        while (cursor != null) {
            count++
            cursor = cursor.siguiente
        }
        int[] arr = new int[count]
        cursor = cabeza
        int index = 0
        while (cursor != null) {
            arr[index++] = cursor.valor
            cursor = cursor.siguiente
        }
        return arr
    }
}

/**
 * Clase ListaDE
 * Implementa una lista doblemente enlazada con metodos para insertar, buscar,
 * eliminar y obtener los elementos en orden directo e inverso
 */
class ListaDE {
    private NodoDE cabeza
    private NodoDE cola

    public ListaDE() {
        cabeza = null
        cola = null
    }

    /**
     * Inserta un nodo al inicio de la lista doblemente enlazada
     * @param valor Valor a insertar
     */
    public void insertarInicio(int valor) {
        NodoDE nuevo = new NodoDE(valor)
        if (cabeza == null) {
            cabeza = nuevo
            cola = nuevo
        } else {
            nuevo.setSiguiente(cabeza)
            cabeza.setAnterior(nuevo)
            cabeza = nuevo
        }
    }

    /**
     * Inserta un nodo al final de la lista doblemente enlazada
     * @param valor Valor a insertar
     */
    public void insertarFinal(int valor) {
        NodoDE nuevo = new NodoDE(valor)
        if (cola == null) {
            cabeza = nuevo
            cola = nuevo
        } else {
            cola.setSiguiente(nuevo)
            nuevo.setAnterior(cola)
            cola = nuevo
        }
    }

    /**
     * Busca si existe un nodo con el valor indicado
     * @param valor Valor a buscar
     * @return true si se encuentra; false en caso contrario
     */
    public boolean buscar(int valor) {
        NodoDE actual = cabeza
        while (actual != null) {
            if (actual.getDato() == valor)
                return true
            actual = actual.getSiguiente()
        }
        return false
    }

    /**
     * Elimina el primer nodo que contiene el valor especificado
     * @param valor Valor a eliminar
     * @return true si se elimino el nodo; false si no se encontro
     */
    public boolean eliminar(int valor) {
        NodoDE actual = cabeza
        while (actual != null) {
            if (actual.getDato() == valor) {
                if (actual.getAnterior() != null)
                    actual.getAnterior().setSiguiente(actual.getSiguiente())
                else
                    cabeza = actual.getSiguiente()
                if (actual.getSiguiente() != null)
                    actual.getSiguiente().setAnterior(actual.getAnterior())
                else
                    cola = actual.getAnterior()
                return true
            }
            actual = actual.getSiguiente()
        }
        return false
    }

    /**
     * Obtiene los elementos de la lista en un arreglo de enteros desde el inicio hasta el final
     * @return Arreglo con los valores en orden directo
     */
    public int[] obtenerElementos() {
        int count = 0
        NodoDE cursor = cabeza
        while (cursor != null) {
            count++
            cursor = cursor.getSiguiente()
        }
        int[] arr = new int[count]
        cursor = cabeza
        int index = 0
        while (cursor != null) {
            arr[index++] = cursor.getDato()
            cursor = cursor.getSiguiente()
        }
        return arr
    }

    /**
     * Obtiene los elementos de la lista en un arreglo de enteros desde el final hasta el inicio
     * @return Arreglo con los valores en orden inverso
     */
    public int[] obtenerElementosInverso() {
        int count = 0
        NodoDE cursor = cola
        while (cursor != null) {
            count++
            cursor = cursor.getAnterior()
        }
        int[] arr = new int[count]
        cursor = cola
        int index = 0
        while (cursor != null) {
            arr[index++] = cursor.getDato()
            cursor = cursor.getAnterior()
        }
        return arr
    }
}

/**
 * Clase Pila
 * Implementa una pila (LIFO) utilizando nodos de una lista simplemente enlazada
 * LIFO = Ultimo en Entrar Primero en Salir (Last In Firs Out)
 */
class Pila {
    private NodoSE tope  // Representa la cima de la pila

    public Pila() {
        this.tope = null
    }

    /**
     * Adiciona (push) un elemento al tope de la pila
     * @param valor Valor a adicionar
     */
    public void adicionar(int valor) {
        NodoSE nuevo = new NodoSE(valor)
        nuevo.siguiente = tope
        tope = nuevo
    }

    /**
     * Extrae (pop) el elemento del tope de la pila y lo retorna
     * @return Valor extraido
     * @throws java.util.NoSuchElementException si la pila esta vacia
     */
    public int extraer() {
        if (estaVacia())
            throw new java.util.NoSuchElementException("Pila vacia")
        int valor = tope.valor
        tope = tope.siguiente
        return valor
    }

    /**
     * Retorna el valor del tope sin extraerlo
     * @return Valor del tope
     * @throws java.util.NoSuchElementException si la pila esta vacia
     */
    public int cima() {
        if (estaVacia())
            throw new java.util.NoSuchElementException("Pila vacia")
        return tope.valor
    }

    /**
     * Indica si la pila esta vacia
     * @return true si esta vacia; false en caso contrario
     */
    public boolean estaVacia() {
        return tope == null
    }

    /**
     * Obtiene los elementos de la pila en un arreglo de enteros desde el tope hasta la base
     * @return Arreglo con los valores de la pila
     */
    public int[] obtenerElementos() {
        int count = 0
        NodoSE cursor = tope
        while (cursor != null) {
            count++
            cursor = cursor.siguiente
        }
        int[] arr = new int[count]
        cursor = tope
        int index = 0
        while (cursor != null) {
            arr[index++] = cursor.valor
            cursor = cursor.siguiente
        }
        return arr
    }
}

/**
 * Clase Cola
 * Implementa una cola (FIFO) utilizando nodos de una lista simplemente enlazada
 * FIFO = Primero en Entrar Primero en Salir (First In First Out)
 */
class Cola {
    private NodoSE frente  // Primer elemento de la cola
    private NodoSE fin     // Ultimo elemento de la cola

    public Cola() {
        this.frente = null
        this.fin = null
    }

    /**
     * Adiciona (enqueue) un elemento al final de la cola
     * @param valor Valor a adicionar
     */
    public void adicionar(int valor) {
        NodoSE nuevo = new NodoSE(valor)
        if (fin != null)
            fin.siguiente = nuevo
        fin = nuevo
        if (frente == null)
            frente = nuevo
    }

    /**
     * Extrae (dequeue) el elemento del frente de la cola y lo retorna
     * @return Valor extraido
     * @throws java.util.NoSuchElementException si la cola esta vacia
     */
    public int extraer() {
        if (estaVacia())
            throw new java.util.NoSuchElementException("Cola vacia")
        int valor = frente.valor
        frente = frente.siguiente
        if (frente == null)
            fin = null
        return valor
    }

    /**
     * Retorna el valor del elemento al frente sin extraerlo
     * @return Valor en el frente
     * @throws java.util.NoSuchElementException si la cola esta vacia
     */
    public int frente() {
        if (estaVacia())
            throw new java.util.NoSuchElementException("Cola vacia")
        return frente.valor
    }

    /**
     * Indica si la cola esta vacia
     * @return true si esta vacia; false en caso contrario
     */
    public boolean estaVacia() {
        return frente == null
    }

    /**
     * Obtiene los elementos de la cola en un arreglo de enteros desde el frente hasta el final
     * @return Arreglo con los valores de la cola
     */
    public int[] obtenerElementos() {
        int count = 0
        NodoSE cursor = frente
        while (cursor != null) {
            count++
            cursor = cursor.siguiente
        }
        int[] arr = new int[count]
        cursor = frente
        int index = 0
        while (cursor != null) {
            arr[index++] = cursor.valor
            cursor = cursor.siguiente
        }
        return arr
    }
}



























































/*========================================
 =              Clase Ejemplos          =
 ========================================*/

/**
 * Clase Ejemplos
 * Contiene metodos teoricos que utilizan las estructuras de datos definidas
 * para practicar la logica mi gente
 */
public class Ejemplos {

    /**
     * Metodo buscarElementos
     * ------------------------------------
     * Objetivo: Recorrer una lista y devolver una nueva lista que contenga
     *          todos los elementos cuyo valor sea igual al valor pasado como parametro
     *
     * @param lista La lista original a recorrer
     * @param valor El valor que se quiere buscar en la lista
     * @return Una nueva ListaSE con los elementos que cumplen la condicion
     */
    public ListaSE buscarElementos(ListaSE lista, int valor) {
        // Crear una nueva lista vacia para almacenar los elementos encontrados
        ListaSE resultado = new ListaSE()
        // Obtener el primer nodo de la lista original
        NodoSE actual = lista.getCabeza()
        // Mientras aun existan nodos en la lista
        while (actual != null) {
            // Si el valor del nodo actual es igual al valor buscado
            if (actual.valor == valor) {
                // Insertar ese valor al final de la lista de resultados
                resultado.insertarFinal(actual.valor)
            }
            // Moverse al siguiente nodo
            actual = actual.siguiente
        }
        // Devolver la lista que contiene todos los elementos encontrados
        return resultado
    }

    /**
     * Metodo procesarPila
     * ------------------------------------
     * Objetivo: Extraer todos los elementos de la pila y devolverlos en una nueva lista
     *
     * @param pila La pila que se va a procesar
     * @return Una nueva ListaSE con los elementos extraidos en el orden en que fueron removidos
     */
    public ListaSE procesarPila(Pila pila) {
        // Crear una nueva lista vacia para almacenar los elementos extraidos
        ListaSE resultado = new ListaSE()
        // Mientras la pila no este vacia
        while (!pila.estaVacia()) {
            // Extraer el elemento del tope de la pila
            int elem = pila.extraer()
            // Insertar el elemento al final de la lista de resultados
            resultado.insertarFinal(elem)
        }
        // Devolver la lista con los elementos extraidos
        return resultado
    }

    /**
     * Metodo procesarCola
     * ------------------------------------
     * Objetivo: Extraer todos los elementos de la cola y devolverlos en una nueva lista
     *
     * @param cola La cola que se va a procesar
     * @return Una nueva ListaSE con los elementos extraidos en el orden en que fueron removidos
     */
    public ListaSE procesarCola(Cola cola) {
        // Crear una nueva lista vacia para almacenar los elementos extraidos
        ListaSE resultado = new ListaSE()
        // Mientras la cola no este vacia
        while (!cola.estaVacia()) {
            // Extraer el elemento del frente de la cola
            int elem = cola.extraer()
            // Insertar el elemento al final de la lista de resultados
            resultado.insertarFinal(elem)
        }
        // Devolver la lista con los elementos extraidos
        return resultado
    }

    /**
     * Metodo fusionarListas
     * ------------------------------------
     * Objetivo: Combinar dos listas en una nueva lista que contenga todos sus elementos
     *
     * @param lista1 La primera lista a fusionar
     * @param lista2 La segunda lista a fusionar
     * @return Una nueva ListaSE que contiene los elementos de ambas listas
     */
    public ListaSE fusionarListas(ListaSE lista1, ListaSE lista2) {
        // Crear una nueva lista vacia para la fusion
        ListaSE fusionada = new ListaSE()
        // Obtener el primer nodo de la primera lista
        NodoSE cursor = lista1.getCabeza()
        // Recorrer la primera lista
        while (cursor != null) {
            // Insertar cada elemento al final de la lista fusionada
            fusionada.insertarFinal(cursor.valor)
            // Pasar al siguiente nodo
            cursor = cursor.siguiente
        }
        // Obtener el primer nodo de la segunda lista
        cursor = lista2.getCabeza()
        // Recorrer la segunda lista
        while (cursor != null) {
            // Insertar cada elemento al final de la lista fusionada
            fusionada.insertarFinal(cursor.valor)
            // Pasar al siguiente nodo
            cursor = cursor.siguiente
        }
        // Devolver la lista que contiene la fusion de ambas
        return fusionada
    }

    /**
     * Metodo filtrarMayores
     * ------------------------------------
     * Objetivo: Recorrer una lista y devolver una nueva lista con aquellos elementos
     *          cuyo valor sea mayor que un umbral dado
     *
     * @param lista La lista original a filtrar
     * @param umbral El valor umbral que deben superar los elementos
     * @return Una nueva ListaSE con los elementos que son mayores al umbral
     */
    public ListaSE filtrarMayores(ListaSE lista, int umbral) {
        // Crear una lista vacia para almacenar los elementos que cumplen la condicion
        ListaSE filtrada = new ListaSE()
        // Obtener el primer nodo de la lista
        NodoSE cursor = lista.getCabeza()
        // Recorrer cada nodo de la lista
        while (cursor != null) {
            // Si el valor del nodo es mayor que el umbral
            if (cursor.valor > umbral) {
                // Insertar el valor en la lista filtrada
                filtrada.insertarFinal(cursor.valor)
            }
            // Moverse al siguiente nodo
            cursor = cursor.siguiente
        }
        // Devolver la lista con los elementos filtrados
        return filtrada
    }

    /**
     * Metodo moverElemento
     * ------------------------------------
     * Objetivo: Mover un elemento de una posicion a otra dentro de la lista
     *          Se crea una nueva lista que es una copia de la original con el elemento movido
     *
     * @param lista La lista original
     * @param posOrigen Posicion del elemento a mover
     * @param posDestino Posicion a la que se desea mover el elemento
     * @return Una nueva ListaSE con el elemento movido a la posicion deseada
     */
    public ListaSE moverElemento(ListaSE lista, int posOrigen, int posDestino) {
        // Obtener todos los elementos de la lista en un arreglo
        int[] arr = lista.obtenerElementos()
        // Si la posicion de origen es invalida, devolver una copia de la lista original
        if (posOrigen < 0 || posOrigen >= arr.length)
            return lista.duplicarLista()
        // Guardar el elemento que se quiere mover
        int elem = arr[posOrigen]
        // Crear una nueva lista para almacenar los elementos sin el que se movera
        ListaSE nueva = new ListaSE()
        // Recorrer el arreglo de elementos
        for (int i = 0; i < arr.length; i++) {
            // Si no es la posicion del elemento a mover, agregar el elemento a la nueva lista
            if (i != posOrigen)
                nueva.insertarFinal(arr[i])
        }
        // Obtener los elementos de la nueva lista en un arreglo
        int[] sinElem = nueva.obtenerElementos()
        // Crear la lista resultado donde se insertaran los elementos en el orden deseado
        ListaSE resultado = new ListaSE()
        // Recorrer desde 0 hasta el tamano de la lista sin el elemento
        for (int i = 0; i <= sinElem.length; i++) {
            // Si se llega a la posicion destino, insertar el elemento que se movio
            if (i == posDestino)
                resultado.insertarFinal(elem)
            // Si aun hay elementos, insertar el elemento actual
            if (i < sinElem.length)
                resultado.insertarFinal(sinElem[i])
        }
        // Devolver la nueva lista con el elemento movido
        return resultado
    }

    /**
     * Metodo procesarPilaCondicional
     * ------------------------------------
     * Objetivo: Procesar una pila extrayendo unicamente aquellos elementos que sean
     *          mayores que un umbral. Los elementos que no cumplen la condicion se
     *          conservan en la pila
     *
     * @param pila La pila a procesar
     * @param umbral El umbral que deben superar los elementos para ser extraidos
     * @return Una nueva ListaSE con los elementos extraidos que cumplen la condicion
     */
    public ListaSE procesarPilaCondicional(Pila pila, int umbral) {
        // Crear una lista vacia para almacenar los elementos que cumplen la condicion
        ListaSE resultado = new ListaSE()
        // Crear una pila auxiliar para guardar los elementos que no cumplen la condicion
        Pila aux = new Pila()
        // Mientras existan elementos en la pila
        while (!pila.estaVacia()) {
            // Extraer el elemento del tope
            int elem = pila.extraer()
            // Si el elemento es mayor que el umbral
            if (elem > umbral)
                // Agregarlo a la lista de resultados
                resultado.insertarFinal(elem)
            else
                // Si no cumple, guardarlo en la pila auxiliar
                aux.adicionar(elem)
        }
        // Restaurar los elementos que no cumplian la condicion a la pila original
        Pila auxRestaurar = new Pila()
        while (!aux.estaVacia()) {
            auxRestaurar.adicionar(aux.extraer())
        }
        while (!auxRestaurar.estaVacia()) {
            pila.adicionar(auxRestaurar.extraer())
        }
        // Devolver la lista con los elementos que si cumplian la condicion
        return resultado
    }

    /**
     * Metodo atenderPilaConCola
     * ------------------------------------
     * Objetivo: Mientras tanto la pila y la cola tengan elementos, si el valor del tope
     *          de la pila es mayor o igual al valor al frente de la cola, se extraen ambos
     *          y se agregan a una lista de resultados; de lo contrario, se extrae solo de la cola
     *
     * @param pila La pila a atender
     * @param cola La cola a atender
     * @return Una nueva ListaSE con los elementos extraidos de la pila cuando se cumple la condicion
     */
    public ListaSE atenderPilaConCola(Pila pila, Cola cola) {
        // Crear una lista vacia para almacenar los resultados
        ListaSE resultado = new ListaSE()
        // Mientras la pila y la cola no esten vacias
        while (!cola.estaVacia() && !pila.estaVacia()) {
            // Si el valor en el tope de la pila es mayor o igual al valor al frente de la cola
            if (pila.cima() >= cola.frente()) {
                // Extraer el elemento de la pila y agregarlo a la lista de resultados
                resultado.insertarFinal(pila.extraer())
                // Tambien extraer el elemento de la cola
                cola.extraer()
            } else {
                // Si no se cumple la condicion, extraer solo el elemento de la cola
                cola.extraer()
            }
        }
        // Devolver la lista de resultados
        return resultado
    }

    /**
     * Metodo filtrarMenores
     * ------------------------------------
     * Objetivo: Recorrer una lista y devolver una nueva lista con aquellos elementos
     *          cuyo valor sea menor que el umbral indicado
     *
     * @param lista La lista original
     * @param umbral El valor umbral
     * @return Una nueva ListaSE con los elementos que son menores al umbral
     */
    public ListaSE filtrarMenores(ListaSE lista, int umbral) {
        // Crear una lista vacia para los elementos que cumplen la condicion
        ListaSE filtrada = new ListaSE()
        // Obtener el primer nodo de la lista
        NodoSE cursor = lista.getCabeza()
        // Recorrer cada nodo
        while (cursor != null) {
            // Si el valor es menor que el umbral
            if (cursor.valor < umbral) {
                // Insertar el valor en la lista filtrada
                filtrada.insertarFinal(cursor.valor)
            }
            // Pasar al siguiente nodo
            cursor = cursor.siguiente
        }
        // Devolver la lista filtrada
        return filtrada
    }

    /**
     * Metodo contarElementos
     * ------------------------------------
     * Objetivo: Contar la cantidad total de elementos en la lista
     *
     * @param lista La lista a contar
     * @return El numero total de elementos en la lista
     */
    public int contarElementos(ListaSE lista) {
        // Inicializar un contador en cero
        int count = 0
        // Obtener el primer nodo de la lista
        NodoSE cursor = lista.getCabeza()
        // Recorrer la lista incrementando el contador por cada nodo
        while (cursor != null) {
            count++
            cursor = cursor.siguiente
        }
        // Retornar el total de elementos contados
        return count
    }

    /**
     * Metodo sumarElementos
     * ------------------------------------
     * Objetivo: Sumar todos los valores de los elementos en la lista
     *
     * @param lista La lista cuyos elementos se sumaran
     * @return La suma total de los valores
     */
    public int sumarElementos(ListaSE lista) {
        // Inicializar la suma en cero
        int suma = 0
        // Obtener el primer nodo de la lista
        NodoSE cursor = lista.getCabeza()
        // Recorrer la lista, agregando el valor de cada nodo a la suma
        while (cursor != null) {
            suma += cursor.valor
            cursor = cursor.siguiente
        }
        // Retornar la suma total
        return suma
    }

    /**
     * Metodo invertirLista
     * ------------------------------------
     * Objetivo: Crear una nueva lista que contenga los elementos de la lista original
     *          en orden inverso
     *
     * @param lista La lista original
     * @return Una nueva ListaSE con el orden de los elementos invertido
     */
    public ListaSE invertirLista(ListaSE lista) {
        // Crear una nueva lista vacia para la lista invertida
        ListaSE invertida = new ListaSE()
        // Obtener el primer nodo de la lista original
        NodoSE cursor = lista.getCabeza()
        // Recorrer la lista original
        while (cursor != null) {
            // Insertar cada elemento al inicio de la nueva lista
            invertida.insertarInicio(cursor.valor)
            // Moverse al siguiente nodo
            cursor = cursor.siguiente
        }
        // Devolver la lista invertida
        return invertida
    }

    /**
     * Metodo obtenerSublista
     * ------------------------------------
     * Objetivo: Obtener una sublista de la lista original que incluya los elementos
     *          desde el indice "inicio" (inclusive) hasta el indice "fin" (exclusivo)
     *
     * @param lista La lista original
     * @param inicio Indice de inicio (inclusive) de la sublista
     * @param fin Indice final (exclusivo) de la sublista
     * @return Una nueva ListaSE que es la sublista extraida
     */
    public ListaSE obtenerSublista(ListaSE lista, int inicio, int fin) {
        // Obtener todos los elementos de la lista original en un arreglo
        int[] arr = lista.obtenerElementos()
        // Crear una nueva lista vacia para la sublista
        ListaSE sublista = new ListaSE()
        // Si los indices son invalidos, se retorna una lista vacia
        if (inicio < 0 || fin > arr.length || inicio >= fin)
            return sublista
        // Recorrer el arreglo desde el indice de inicio hasta el indice fin - 1
        for (int i = inicio; i < fin; i++) {
            // Insertar cada elemento en la sublista
            sublista.insertarFinal(arr[i])
        }
        // Devolver la sublista
        return sublista
    }

    /**
     * Metodo reemplazarTodos
     * ------------------------------------
     * Objetivo: Crear una nueva lista en la que todas las ocurrencias de un valor dado
     *          ("antiguo") se reemplazan por otro valor ("nuevo")
     *          La lista original no se modifica
     *
     * @param lista La lista original
     * @param antiguo El valor que se quiere reemplazar
     * @param nuevo El valor que reemplazara al anterior
     * @return Una nueva ListaSE con los valores reemplazados
     */
    public ListaSE reemplazarTodos(ListaSE lista, int antiguo, int nuevo) {
        // Crear una nueva lista vacia para almacenar el resultado
        ListaSE nueva = new ListaSE()
        // Obtener el primer nodo de la lista original
        NodoSE cursor = lista.getCabeza()
        // Recorrer la lista
        while (cursor != null) {
            // Si el valor del nodo es igual a "antiguo"
            if (cursor.valor == antiguo)
                // Insertar el valor "nuevo" en la lista resultado
                nueva.insertarFinal(nuevo)
            else
                // De lo contrario, insertar el valor original
                nueva.insertarFinal(cursor.valor)
            // Avanzar al siguiente nodo
            cursor = cursor.siguiente
        }
        // Devolver la lista con los reemplazos realizados
        return nueva
    }

    /**
     * Metodo eliminarDuplicados
     * ------------------------------------
     * Objetivo: Crear una nueva lista que contenga los mismos elementos que la original
     *          pero sin duplicados
     *
     * @param lista La lista original
     * @return Una nueva ListaSE sin elementos duplicados
     */
    public ListaSE eliminarDuplicados(ListaSE lista) {
        // Crear una nueva lista vacia para almacenar los elementos sin duplicados
        ListaSE sinDuplicados = new ListaSE()
        // Obtener el primer nodo de la lista original
        NodoSE cursor = lista.getCabeza()
        // Recorrer cada nodo de la lista
        while (cursor != null) {
            // Si el elemento actual no existe ya en la lista sin duplicados
            if (!sinDuplicados.buscar(cursor.valor))
                // Insertar el elemento en la lista sin duplicados
                sinDuplicados.insertarFinal(cursor.valor)
            // Avanzar al siguiente nodo
            cursor = cursor.siguiente
        }
        // Devolver la lista sin duplicados
        return sinDuplicados
    }

    /**
     * Metodo interseccionListas
     * ------------------------------------
     * Objetivo: Retornar una nueva lista que contenga unicamente los elementos que estan presentes
     *          en ambas listas (la interseccion)
     *
     * @param lista1 La primera lista
     * @param lista2 La segunda lista
     * @return Una nueva ListaSE con la interseccion de ambas listas
     */
    public ListaSE interseccionListas(ListaSE lista1, ListaSE lista2) {
        // Crear una nueva lista vacia para almacenar la interseccion
        ListaSE interseccion = new ListaSE()
        // Obtener el primer nodo de la primera lista
        NodoSE cursor = lista1.getCabeza()
        // Recorrer la primera lista
        while (cursor != null) {
            // Si el elemento existe en la segunda lista y aun no se ha agregado a la interseccion
            if (lista2.buscar(cursor.valor) && !interseccion.buscar(cursor.valor))
                // Insertarlo en la lista de interseccion
                interseccion.insertarFinal(cursor.valor)
            // Avanzar al siguiente nodo
            cursor = cursor.siguiente
        }
        // Devolver la lista que contiene la interseccion
        return interseccion
    }

    /**
     * Metodo unionListas
     * ------------------------------------
     * Objetivo: Retornar una nueva lista que contenga la union de dos listas sin duplicados
     *
     * @param lista1 La primera lista
     * @param lista2 La segunda lista
     * @return Una nueva ListaSE con la union de ambas listas
     */
    public ListaSE unionListas(ListaSE lista1, ListaSE lista2) {
        // Empezar con la primera lista eliminando duplicados
        ListaSE union = eliminarDuplicados(lista1)
        // Obtener el primer nodo de la segunda lista
        NodoSE cursor = lista2.getCabeza()
        // Recorrer la segunda lista
        while (cursor != null) {
            // Si el elemento no esta ya en la lista de union
            if (!union.buscar(cursor.valor))
                // Insertarlo en la lista de union
                union.insertarFinal(cursor.valor)
            // Avanzar al siguiente nodo
            cursor = cursor.siguiente
        }
        // Devolver la union de ambas listas
        return union
    }

    /**
     * Metodo diferenciaListas
     * ------------------------------------
     * Objetivo: Retornar una nueva lista con los elementos que estan en la primera lista
     *          pero no en la segunda (diferencia)
     *
     * @param lista1 La primera lista
     * @param lista2 La segunda lista
     * @return Una nueva ListaSE con la diferencia de ambas listas
     */
    public ListaSE diferenciaListas(ListaSE lista1, ListaSE lista2) {
        // Crear una nueva lista vacia para almacenar la diferencia
        ListaSE diferencia = new ListaSE()
        // Obtener el primer nodo de la primera lista
        NodoSE cursor = lista1.getCabeza()
        // Recorrer la primera lista
        while (cursor != null) {
            // Si el elemento no se encuentra en la segunda lista
            if (!lista2.buscar(cursor.valor))
                // Insertarlo en la lista de diferencia
                diferencia.insertarFinal(cursor.valor)
            // Avanzar al siguiente nodo
            cursor = cursor.siguiente
        }
        // Devolver la lista con la diferencia
        return diferencia
    }

    /**
     * Metodo obtenerIndiceMaximo
     * ------------------------------------
     * Objetivo: Encontrar el indice del elemento con el valor maximo en la lista
     *
     * @param lista La lista a analizar
     * @return El indice del elemento maximo o -1 si la lista esta vacia
     */
    public int obtenerIndiceMaximo(ListaSE lista) {
        // Obtener el primer nodo de la lista
        NodoSE cursor = lista.getCabeza()
        // Si la lista esta vacia, retornar -1
        if (cursor == null)
            return -1
        // Inicializar el maximo con el valor del primer nodo
        int max = cursor.valor
        // Guardar el indice del elemento maximo (inicialmente 0)
        int indiceMax = 0
        // Contador para llevar el seguimiento del indice
        int indice = 0
        // Recorrer la lista
        while (cursor != null) {
            // Si el valor actual es mayor que el maximo almacenado
            if (cursor.valor > max) {
                // Actualizar el maximo
                max = cursor.valor
                // Actualizar el indice del maximo
                indiceMax = indice
            }
            // Incrementar el contador de indice
            indice++
            // Avanzar al siguiente nodo
            cursor = cursor.siguiente
        }
        // Retornar el indice del elemento maximo
        return indiceMax
    }

    /**
     * Metodo obtenerPromedio
     * ------------------------------------
     * Objetivo: Calcular el promedio de los valores de todos los elementos en la lista
     *
     * @param lista La lista cuyos elementos se promediaran
     * @return El promedio de los valores o 0 si la lista esta vacia
     */
    public double obtenerPromedio(ListaSE lista) {
        // Obtener el primer nodo de la lista
        NodoSE cursor = lista.getCabeza()
        // Si la lista esta vacia, retornar 0
        if (cursor == null)
            return 0
        // Inicializar la suma y el contador de elementos
        int suma = 0, count = 0
        // Recorrer la lista
        while (cursor != null) {
            // Agregar el valor del nodo a la suma
            suma += cursor.valor
            // Incrementar el contador
            count++
            // Avanzar al siguiente nodo
            cursor = cursor.siguiente
        }
        // Calcular y retornar el promedio
        return (double) suma / count
    }

    /**
     * Metodo ordenarLista
     * ------------------------------------
     * Objetivo: Ordenar los elementos de la lista en orden ascendente y devolver una nueva lista ordenada
     *
     * @param lista La lista original
     * @return Una nueva ListaSE con los elementos ordenados
     */
    public ListaSE ordenarLista(ListaSE lista) {
        // Obtener los elementos de la lista en un arreglo
        int[] arr = lista.obtenerElementos()
        // Ordenar el arreglo utilizando el metodo sort de la clase Arrays
        java.util.Arrays.sort(arr)
        // Crear una nueva lista vacia para almacenar los elementos ordenados
        ListaSE ordenada = new ListaSE()
        // Recorrer el arreglo ordenado
        for (int valor : arr) {
            // Insertar cada valor en la lista ordenada
            ordenada.insertarFinal(valor)
        }
        // Devolver la lista ordenada
        return ordenada
    }

    /**
     * Metodo concatenarListas
     * ------------------------------------
     * Objetivo: Concatenar dos listas de forma que la nueva lista contenga
     *          todos los elementos de la primera seguidos de los de la segunda
     *
     * @param lista1 La primera lista
     * @param lista2 La segunda lista
     * @return Una nueva ListaSE que es la concatenacion de ambas
     */
    public ListaSE concatenarListas(ListaSE lista1, ListaSE lista2) {
        // Crear una nueva lista vacia para la concatenacion
        ListaSE concatenada = new ListaSE()
        // Obtener el primer nodo de la primera lista
        NodoSE cursor = lista1.getCabeza()
        // Recorrer la primera lista e insertar cada elemento en la lista concatenada
        while (cursor != null) {
            concatenada.insertarFinal(cursor.valor)
            cursor = cursor.siguiente
        }
        // Obtener el primer nodo de la segunda lista
        cursor = lista2.getCabeza()
        // Recorrer la segunda lista e insertar cada elemento
        while (cursor != null) {
            concatenada.insertarFinal(cursor.valor)
            cursor = cursor.siguiente
        }
        // Devolver la lista resultante de la concatenacion
        return concatenada
    }

    /**
     * El metodo main se deja vacio ya que este codigo es teorico y se utiliza unicamente para practicar la logica interna
     */
    public static void main(String[] args) {
        // Sin interaccion de entrada o salida
    }
}
