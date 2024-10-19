package hus.dsa.homework5.lab1;

public class LinkedBinaryTree<E, T> implements BinaryTreeInterface<T> {
    private Node<E> root;
    int size;

    public Node<E> addRoot(E element) {
        if (isEmpty()) {
            root = new Node<>();
            root.element = element;
        }  else {
            throw new NullPointerException();
        }

        size++;
        return root;
    }

    public Node<E> addLeft(Node<E> p, E element) {
        p.left = new Node<>();
        p.left.element = element;
        p.left.parent = p;

        size++;
        return p;
    }

    public Node<E> addRight(Node<E> p, E element) {
        p.right = new Node<>();
        p.right.element = element;
        p.right.parent = p;

        size++;
        return p;
    }

    public LinkedBinaryTree() {
        size = 0;
    }

    @Override
    public T root() {
        return (T) root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int numChildren(T p) {
        Node<E> result = (Node<E>) p;

        if (result.left == null && result.right == null) {
            return 0;
        } else if (result.left == null || result.right == null) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public T parent(T p) {
        if (p == null) {
            throw new NullPointerException();
        }

        Node<E> result = (Node<E>) p;

        return (T) (result.parent);
    }

    @Override
    public T right(T p) {
        if (p == null) {
            throw new NullPointerException();
        }

        Node<E> result = (Node<E>) p;

        return (T) (result.right);
    }

    @Override
    public T sibling(T p) {
        if (p == null) {
            throw new NullPointerException();
        }

        Node<E> result = (Node<E>) p;
        Node<E> parent = result.parent;

        return (parent.right == result) ? (T) parent.left : (T) parent.right;
    }
}

class Node<E> {
    E element;
    Node<E> parent;
    Node<E> left;
    Node<E> right;

    public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
        this.element = element;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public Node() {
    }
}
