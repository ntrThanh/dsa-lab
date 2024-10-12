package hus.dsa.homework4.lab4;

import java.util.Iterator;

public class ArrayQueue<E> implements ArrayQueueInterface<E> {

    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int defaultSize = 100;

    public ArrayQueue(int n) {
        this.n = n;
        queue = (E[]) new Object[n];
    }

    public ArrayQueue() {
        n = defaultSize;
        queue = (E[]) new Object[n];
    }

    @Override
    public void enqueue(E element) {
        if (count == queue.length) {
            more();
        }
     
        queue[count++] =  element;
    }

    @Override
    public E dequeue() {
        if (count == 0) {
            return null;
        }

        E data = queue[top];

        for (int i = 0; i <= count; i++) {
            queue[i] = queue[i + 1];
        }

        count--;

        return data;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator<>();
    }

    public void more() {
        int newLength = queue.length * 2;
        E[] tempArray = (E[]) new Object[newLength];

        System.arraycopy(queue, 0, tempArray, 0, tempArray.length);

        queue = tempArray;
    }

    class ArrayQueueIterator<E> implements Iterator<E> {
        private int current = top;
        private int num = 0;
        @Override
        public boolean hasNext() {
            return num < count;
        }

        @Override
        public E next() {
            E data = (E) queue[(current + num) % n];
            num++;
            return data;
        }
    }

    public static void main(String[] args) {
        ArrayQueueInterface<Integer> list = new ArrayQueue<>();

        list.enqueue(1);
        list.enqueue(1);
        list.enqueue(1);
        list.enqueue(4);
        list.enqueue(4);
        list.enqueue(2);
        list.enqueue(7);
        list.enqueue(8);
        list.enqueue(0);

        list.dequeue();
        list.dequeue();
        list.dequeue();
        list.dequeue();
        list.dequeue();
        list.dequeue();
        list.dequeue();
        list.dequeue();
        list.dequeue();

        Iterator<Integer> integerIterator = list.iterator();

        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }
    }
}
