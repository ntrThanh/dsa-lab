package hus.dsa.homework5.tree;

public class LinkedBinaryTree<T> {
    private Node<T> root;
    private int size;

    public LinkedBinaryTree() {
        this.size = 0;
    }

    public LinkedBinaryTree(T value) {
        this.root = new Node<>();
        root.value = value;
        this.size = 0;
    }

    public void addRoot(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void addNodeLeft(Node<T> root, Node<T> left) {
        root.left = left;
        left.parent = root;

        this.size++;
    }

    public void addNodeRight(Node<T> root, Node<T> right) {
        root.right = right;
        right.parent = root;

        this.size++;
    }

    public Node<T> getNodeLeft(Node<T> root) {
        if (root == null) {
            throw new NullPointerException();
        }

        return root.left;
    }

    public Node<T> getNodeRight(Node<T> root) {
        if (root == null) {
            throw new NullPointerException();
        }

        return root.right;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printTree() {
        if (root == null) {
            return;
        }

        print(root, 4);
    }

    private void print(Node<T> root, int space) {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += 10;

        // Process right child first
        print(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.print(root.value + "\n");

        // Process left child
        print(root.left, space);
    }
}

class Node<T> {
    T value;
    Node<T> left;
    Node<T> right;
    Node<T> parent;
}
