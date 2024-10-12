package hus.dsa.homework4.lab2;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node stack = null;
    private int size = 0;


    @Override
    public void push(E element) {
        stack = new Node(element, stack);
        size++;
    }

    @Override
    public E pop() {
        E data = stack.element;
        stack = stack.next;
        size--;

        return data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E top() {
        if (size == 0) {
            return null;
        }
        return stack.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator<>();
    }

    class StackIterator<E> implements Iterator<E> {
        Node currentNode = stack;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E data = (E) currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> listStack = new LinkedListStack<>();
        listStack.push(12);
        listStack.push(1);
        listStack.push(15);
        listStack.push(11);
        listStack.push(3);
        listStack.push(5);
        listStack.push(9);

        listStack.pop();
        listStack.pop();
        listStack.pop();
        listStack.pop();
        listStack.pop();
        listStack.pop();
        listStack.pop();

        Iterator<Integer> iterator = listStack.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
