# 🌳 Árbol AVL en Java
Descripción
Este proyecto implementa un árbol AVL (un tipo de árbol binario de búsqueda autobalanceable) en Java. Permite insertar números enteros uno por uno y visualizar el árbol después de cada inserción, manteniendo siempre sus propiedades de balanceo.

# Problema resuelto:
Los árboles AVL resuelven el problema de desbalanceo que puede ocurrir en árboles binarios de búsqueda BST convencionales, garantizando que la altura del árbol se mantenga logarítimica O(log n) para todas las operaciones, incluso en el peor de los casos. Para esta resolución se requirió una estructura específica:

# Clase Node: Representa cada nodo del árbol almacenado:
  valor: dato númerico
  izquierda/derecha: referencias a los nodos hios
  altura: altura del subárbol para calcular factores de balanceo.

# Clase AVLTree: contiene la lógica principal con métodos para:
  inserción balanceada (insertarRec)
  cálculo de altura y factores de balance (getAltura, getFactorBalance)
  rotaciones (rotarDerecha, rotarIzquierda)

# Mecanismo de auto balanceo:
  Después de cada inserción, se verifica el factor de balance (diferencia de alturas entre subárboles)
  Si el factor excede +/- 1, aplica una de 4 posibles rotaciones:
    +Rotación simple derecha (LL)
    +Rotación simple izquierda (RR)
    +Rotación doble izquierda-derecha (LR)
    +Rotación doble derecha-izquierda (RL)

# Visualización:
Usa una matriz de strings (grid) para posicionar nodos y conectores, también calcula dinámicamente los espacios basados en la altura del árbol.

# CAPTURAS DE EJEMPLO:


# Instrucciones de ejecución:
1. Requisitos: Java JDK 8+
2. Compilación: javac Main.java
3. Ejecución: java Main
4. Uso:
     - Insertar números uno por uno
     - El programa muestra el árbol después de cada inserción
     - Escribir "salir" para finalizar
5. Estructura Clave del código:
     // Estructura básica de un nodo AVL
class Node {
    int valor;
    Node izquierda, derecha;
    int altura; // Crucial para calcular balance
    
    public Node(int valor) {
        this.valor = valor;
        this.altura = 1; // Los nuevos nodos siempre altura 1
    }
}

// Lógica principal del AVL
class AVLTree {
    private Node raiz;
    
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor); // Inserción recursiva
    }
    
    private Node balancear(Node nodo) {
        // Implementa las 4 rotaciones posibles
        // basado en el factor de balance
    }
    // ... otros métodos ...
}

El diseño orientado a objetos permite encapsular la complejidad del balanceo AVL, haciendo que la inserción y visualización sea un proceso transparente para el usuario.

## ENLACE DEL VÍDEO DE YOUTUBE.




