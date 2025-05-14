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

# EJEMPLOS PRESENTADOS CON CAPTURAS:
### EJEMPLO 1
Primero: se ingresas los comandos para la compilación y ejecución. Pedirá inmediatamente ingresar un nombre para personalizar más la interacción con el usuario.
![imagen](https://github.com/user-attachments/assets/49c587e5-a70c-4c74-bbba-d86c7465e4b8)

Segundo: mostrará el nombre ingresado y pedirá entonces que se ingrese un número o que se escriba salir para terminar.
![imagen](https://github.com/user-attachments/assets/1bc2d742-db49-405b-9397-6654fe4f2a27)

Tercero: se ingresará la siguiente secuencia de números para ejemplicar su funcionamiento [10, 20, 30, 25] Cada que se ingrese un número se mostrará el factor de balance y la rotación que se haya realizado, se imprimirá el árbol, por esto mismo no se requiere imprimir el arból AVL final puesto que después de cada ingreso se imprime el árbol. 
![imagen](https://github.com/user-attachments/assets/b091887c-931c-4d37-a33b-778d74b31f6a)
![imagen](https://github.com/user-attachments/assets/59f8db95-1ce9-4b44-9d2e-05e396fc4149)

Cuarto: si se ha terminado la secuencia pues se escribe salir y la implementación estará terminada.
![imagen](https://github.com/user-attachments/assets/baf32f43-d594-4e0d-b0e2-a59228e2c5b1)
![imagen](https://github.com/user-attachments/assets/091624be-0ae3-4801-8978-821df1972e66)

### Ejemplo 2: [30, 20, 40, 10, 25, 35, 50]
![imagen](https://github.com/user-attachments/assets/da8521b0-8006-4047-9948-314193d645eb)
![imagen](https://github.com/user-attachments/assets/3d0a6361-3cad-4f61-b03c-c8777ebabb66)

# Instrucciones de ejecución:
1. Requisitos: Java JDK 8+
2. Compilación: javac Main.java
3. Ejecución: java Main
4. Ingresar nombre: se le pedirá al usuario ingresar su nombre para personalizar la interacción
5. Uso:
     - Insertar números uno por uno
     - El programa muestra el árbol después de cada inserción
     - Escribir "salir" para finalizar
6. Estructura Clave del código:
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




