package hus.dsa.homework2.lab4;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int defaultSize) {
        array = (T[]) new Object[defaultSize];
        this.defaultSize = defaultSize;
    }

    public void more() {
        int newLength = array.length * 2;
        T[] currentArray = (T[]) new Object[newLength];

        System.arraycopy(array, 0, currentArray, 0, array.length);

        array = currentArray;
    }

    @Override
    public void add(T data) {
        if (n >= array.length) {
            more();
        }

        array[n++] = data;
    }

    @Override
    public T get(int i) {
        if (i == n) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return array[i];
    }

    @Override
    public void set(int i, T data) {
        if (i == n) {
            throw new ArrayIndexOutOfBoundsException();
        }

        array[i] = data;
    }

    @Override
    public void remove(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i] != null && array[i].equals(data)) {
                for (int j = i; j < n - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[n - 1] = null;
                n--;
                i--;
            }
        }
    }

    @Override
    public boolean isContain(T data) {
        if (n == 0) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>();
    }

    class Iterator<T> implements java.util.Iterator<T> {

        private int index;

        public Iterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            if (index < n) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            return (T) array[index++];
        }
    }


}
