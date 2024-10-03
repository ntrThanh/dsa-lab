package hus.dsa.homework2.lab8;

public class LinkedList<T> {
    class Node<T> {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }

        public Node() {
        }
    }

    private Node head;
    private int n;

    public LinkedList() {
        n = 0;
    }

    // truy van phan tu
    public T get(int index) {
        if (index >= n) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            Node currentNode = head;

            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }

            return (T) currentNode.value;
        }
    }

    public void remove(int index) {
        if (index >= n) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node currentNode = head;

            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }

            currentNode.next = currentNode.next.next;
        }
        n--;
    }


    // them phan tu
    public void add(T data) {
        if (n == 0) {
            head = new Node();
            head.value = data;
        } else {
            Node currentNode = head;

            for (int i = 0; i < n - 1; i++) {
                currentNode = currentNode.next;
            }

            currentNode.next = new Node(data);
        }

        n++;
    }

    public T getNodeFromEnd(int index) {
        Node currentNode = head;

        for (int i = 0; i < n - index - 1; i++) {
            currentNode = currentNode.next;
        }

        return (T) currentNode.value;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(6);
        list.add(1);
        list.add(4);
        list.add(6);
        list.add(7);

        System.out.println(list.getNodeFromEnd(2));
    }
}
