package hus.dsa.datastructure.list;

import java.util.Iterator;

public class MyArrayList<T> implements List<T>{

    private T[] data;
    private final int DEFAULT_SIZE = 100;
    private int n;

    public MyArrayList() {
        data = (T[]) new Object[DEFAULT_SIZE];
        n = 0;
    }

    @Override
    public void add(T data) {
        this.data[n++] = data;
    }

    @Override
    public void add(T data, int index) {
        if (isValid(index)) {
            return;
        }

        for (int i = n; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }

        n++;
    }

    @Override
    public void remove(int index) {
        if (isValid(index)) {
            return;
        }

        for (int i = index; i < n; i++) {
            data[i] = data[i + 1];
        }

        n--;
    }

    @Override
    public T get(int index) {
        if (isValid(index)) {
            return null;
        }

        return data[index];
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int getSize() {
        return n;
    }

    private boolean isValid(int index) {
        return index >= 0 && index < n;
    }


    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    class MyArrayListIterator implements Iterator<T> {
        private int index;

        public MyArrayListIterator() {
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
}
