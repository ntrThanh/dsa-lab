package hus.dsa.datastructure.finalpractice.collections.stackqueue;

public class MyLinkedQueue<K> implements MyQueue<K> {

    class Node {
        K data;
        Node next;

        public Node(K data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(K data) {
            this.data = data;
        }
    }

    Node head;
    int size;

    @Override
    public void add(K data) {
        if (size == 0) {
            head = new Node(data, head);
        } else {
            Node temp = getNodeByIndex(size - 1);
            temp.next = new Node(data, null);
        }

        size++;
    }

    private Node getNodeByIndex(int index) {
        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public K poll() {
        K data = head.data;

        head = head.next;
        size--;

        return data;
    }

    @Override
    public K peek() {
        return head.data;
    }

    @Override
    public int size() {
        return size;
    }
}
