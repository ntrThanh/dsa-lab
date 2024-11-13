package hus.dsa.datastructure.finalpractice.collections.list;

public class MyLinkedList<K extends Comparable<K>> implements MyList<K> {

    private class Node {
        K data;
        Node next;

        public Node(K data) {
            this.data = data;
        }

        public Node(K data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private int size;

    private void check(int index, int size) {
        if (index > size) {
            throw new NullPointerException();
        }
    }

    private Node getNodeByIndex(int index) {
        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public MyLinkedList() {
        size = 0;
    }

    @Override
    public void add(K data) {
        add(data, size);
    }

    @Override
    public void add(K data, int index) {
        check(index, size);

        if (index == 0) {
            head = new Node(data, head);
        } else {
            Node temp = getNodeByIndex(index - 1);

            temp.next = new Node(data, temp.next);
        }

        size++;
    }

    @Override
    public K get(int index) {
        check(index, size);
        return getNodeByIndex(index).data;
    }

    @Override
    public void delete(int index) {
        check(index, size);

        if (index == 0) {
            head = head.next;
        } else {
            Node temp = getNodeByIndex(index - 1);

            temp.next = temp.next.next;
        }

        size--;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public K set(K data, int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
