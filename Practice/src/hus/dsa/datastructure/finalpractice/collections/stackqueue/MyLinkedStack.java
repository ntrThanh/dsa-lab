package hus.dsa.datastructure.finalpractice.collections.stackqueue;

import java.util.Iterator;

public class MyLinkedStack<K> implements MyStack<K> {
    class Node {
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

    Node stack;
    int size;

    private Node getNodeByIndex(int index) {
        Node temp = stack;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public MyLinkedStack() {
        size = 0;
    }

    @Override
    public void push(K data) {
        stack = new Node(data, stack);
        size++;
    }

    @Override
    public K pop() {
        if (isEmpty()) {
            return null;
        }

        K result = stack.data;
        stack = stack.next;
        size--;

        return result;
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
    public Iterator<K> iterator() {
        return null;
    }

    class StackIterator implements Iterator<K> {
        @Override
        public boolean hasNext() {
            return isEmpty();
        }

        @Override
        public K next() {
            return pop();
        }
    }
}
