package hus.dsa.datastructure.list;

import java.util.Iterator;

public class MyLinkedList<T> implements List<T>{
    private int n;
    private Node head;
    class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    Node getNodeByIndex(int index) {
        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public MyLinkedList() {
        n = 0;
    }

    @Override
    public void add(T data) {
        add(data, n);
    }

    @Override
    public void add(T data, int index) {
        if (check(index)) {
            return;
        }

        if (index == 0) {
            head = new Node(data, head);
        } else {
            Node node = getNodeByIndex(index - 1);
            node.next = new Node(data, node.next);
        }

        n++;
    }

    private boolean check(int index) {
        return !(index >= 0 || index < n);
    }

    @Override
    public void remove(int index) {
        if (check(index)) {
            return;
        }

        if (index == 0) {
            head = head.next;
            n--;

            return;
        }

        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        n--;
    }

    @Override
    public T get(int index) {
        if (check(index)) {
            return null;
        }

        return getNodeByIndex(index).data;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int getSize() {
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    class MyLinkedListIterator implements Iterator<T> {
        private int index;

        public MyLinkedListIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < n;
        }

        @Override
        public T next() {
            return get(index++);
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(12);
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(8);

        list.remove(0);
        list.add(45, 0);

        for (int i = 0; i < list.getSize(); i++) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println();
    }
}
