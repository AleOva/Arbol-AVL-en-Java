import java.util.Scanner;

class Node {
    int valor;
    Node izquierda, derecha;
    int altura;

    public Node(int valor) {
        this.valor = valor;
        this.altura = 1;
    }
}

class AVLTree {
    private Node raiz;
    private String ultimaRotacion; // Para registrar la última rotación realizada

    // Método público para insertar valores
    public void insertar(int valor) {
        ultimaRotacion = "Ninguna"; // Resetear antes de cada inserción
        raiz = insertarRec(raiz, valor);
    }

    // Método privado recursivo para inserción
    private Node insertarRec(Node nodo, int valor) {
        if (nodo == null) {
            return new Node(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierda = insertarRec(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = insertarRec(nodo.derecha, valor);
        } else {
            return nodo; // No se permiten duplicados
        }

        // Actualizar altura y balancear
        actualizarAltura(nodo);
        return balancear(nodo);
    }

    // Método para actualizar altura de un nodo
    private void actualizarAltura(Node nodo) {
        nodo.altura = 1 + Math.max(getAltura(nodo.izquierda), getAltura(nodo.derecha));
    }

    // Método para obtener altura de un nodo
    private int getAltura(Node nodo) {
        return nodo == null ? 0 : nodo.altura;
    }

    // Método para calcular factor de balance
    private int getFactorBalance(Node nodo) {
        return nodo == null ? 0 : getAltura(nodo.izquierda) - getAltura(nodo.derecha);
    }

    // Método para balancear el árbol
    private Node balancear(Node nodo) {
        int factorBalance = getFactorBalance(nodo);

        // Rotación derecha (LL)
        if (factorBalance > 1 && getFactorBalance(nodo.izquierda) >= 0) {
            ultimaRotacion = "Rotacion Derecha (LL)";
            return rotarDerecha(nodo);
        }

        // Rotación izquierda (RR)
        if (factorBalance < -1 && getFactorBalance(nodo.derecha) <= 0) {
            ultimaRotacion = "Rotacion Izquierda (RR)";
            return rotarIzquierda(nodo);
        }

        // Rotación izquierda-derecha (LR)
        if (factorBalance > 1 && getFactorBalance(nodo.izquierda) < 0) {
            ultimaRotacion = "Rotacion Izquierda-Derecha (LR)";
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }

        // Rotación derecha-izquierda (RL)
        if (factorBalance < -1 && getFactorBalance(nodo.derecha) > 0) {
            ultimaRotacion = "Rotacion Derecha-Izquierda (RL)";
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    // Rotación derecha
    private Node rotarDerecha(Node y) {
        Node x = y.izquierda;
        Node T2 = x.derecha;

        x.derecha = y;
        y.izquierda = T2;

        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }

    // Rotación izquierda
    private Node rotarIzquierda(Node x) {
        Node y = x.derecha;
        Node T2 = y.izquierda;

        y.izquierda = x;
        x.derecha = T2;

        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }

    // Método para imprimir el árbol con espaciado mejorado
    public void imprimirArbol() {
        if (raiz == null) {
            System.out.println("Arbol vacio");
            return;
        }

        int altura = getAltura(raiz);
        int ancho = (int) (Math.pow(2, altura + 1) * 1.5); // Espaciado asimétrico

        String[][] grid = new String[altura * 2][ancho];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " ";
            }
        }

        llenarGrid(grid, raiz, 0, 0, ancho);

        for (String[] fila : grid) {
            for (String s : fila) {
                System.out.print(s);
            }
            System.out.println();
        }

        System.out.println("Factor de Balance: " + getFactorBalance(raiz));
        System.out.println("Rotacion realizada: " + ultimaRotacion);
    }

    private void llenarGrid(String[][] grid, Node nodo, int nivel, int izquierda, int derecha) {
        if (nodo == null) return;

        int medio = (izquierda + derecha) / 2;
        grid[nivel * 2][medio] = String.valueOf(nodo.valor);

        if (nodo.izquierda != null) {
            int posConector = (izquierda + medio) / 2;
            grid[nivel * 2 + 1][posConector] = "/";
            llenarGrid(grid, nodo.izquierda, nivel + 1, izquierda, medio - 1);
        }

        if (nodo.derecha != null) {
            int posConector = (medio + derecha + (derecha - medio) / 3) / 2;
            grid[nivel * 2 + 1][posConector] = "\\";
            llenarGrid(grid, nodo.derecha, nivel + 1, medio + (derecha - medio) / 4, derecha);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVLTree arbol = new AVLTree();
        String nombre;

        System.out.print("Ingrese su nombre: ");
        nombre = scanner.nextLine();
        System.out.println("Bienvenido, " + nombre + "!");

        while (true) {
            System.out.print("Ingrese un numero (o 'salir' para terminar): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("salir")) {
                break;
            }
            try {
                int valor = Integer.parseInt(input);
                arbol.insertar(valor);
                arbol.imprimirArbol();
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un numero valido.");
            }
        }

        System.out.println("Saliendo...");
        scanner.close();
    }
}