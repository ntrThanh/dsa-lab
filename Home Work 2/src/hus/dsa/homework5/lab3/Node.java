package hus.dsa.homework5.lab3;


class Node<T> {
    T value;
    Node<T> left;
    Node<T> right;
    Node<T> parent;

    public Node(T value) {
        this.value = value;
    }
}

