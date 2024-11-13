package hus.dsa.datastructure.queue;

public class LinkedQueue<T> implements MyQueue<T> {
    class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
        }
    }

    public LinkedQueue() {
        size = 0;
    }

    Node head;
    int size;

    @Override
    public void enqueue(T data) {
        if (head == null) {
            head = new Node(data);
            size++;
            return;
        }

        Node temp = getNodeByIndex(size - 1);
        temp.next = new Node(data);
        size++;
    }

    Node getNodeByIndex(int index) {
        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    @Override
    public T dequeue() {
        T data = head.data;
        head = head.next;
        size--;

        return data;
    }

    @Override
    public T peek() {
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> data = new LinkedQueue<>();

        data.enqueue(123);
        data.enqueue(12);
        data.enqueue(113);
        data.dequeue();
        data.enqueue(3);
        data.enqueue(12);
        data.enqueue(0);
        data.enqueue(-1);

        while (!data.isEmpty()) {
            System.out.println(data.dequeue());
        }
    }
}
