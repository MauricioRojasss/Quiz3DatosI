import java.util.LinkedList;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // Método para insertar un elemento en el árbol
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        return root;
    }

    
}

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        LinkedList<Integer> list = new LinkedList<>();

        // Insertar los mismos elementos en ambas estructuras de datos
        int[] elements = {5, 3, 7, 2, 4, 6, 8};
        for (int element : elements) {
            tree.insert(element);
            list.add(element);
        }

        // Realizar búsquedas y medir el tiempo
        long startTime, endTime;
        int searchKey = 6;

        startTime = System.nanoTime();
        boolean foundInTree = tree.search(searchKey);
        endTime = System.nanoTime();
        long treeSearchTime = endTime - startTime;

        startTime = System.nanoTime();
        boolean foundInList = list.contains(searchKey);
        endTime = System.nanoTime();
        long listSearchTime = endTime - startTime;

        // Mostrar resultados
        System.out.println("Búsqueda en árbol binario de búsqueda:");
        System.out.println("¿El elemento " + searchKey + " fue encontrado? " + foundInTree);
        System.out.println("Tiempo de búsqueda: " + treeSearchTime + " nanosegundos");

        System.out.println("\nBúsqueda en lista enlazada:");
        System.out.println("¿El elemento " + searchKey + " fue encontrado? " + foundInList);
        System.out.println("Tiempo de búsqueda: " + listSearchTime + " nanosegundos");
    }
}