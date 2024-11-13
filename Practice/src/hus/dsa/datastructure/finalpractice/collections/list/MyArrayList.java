package hus.dsa.datastructure.finalpractice.collections.list;

public class MyArrayList<K extends Comparable<K>> implements MyList<K> {
    public MyArrayList() {
        arrayData = (K[]) new Comparable[100];
        size = 0;
    }

    private K[] arrayData;
    private int size;
    private final int DEFAULT_SIZE = 1000;

    private void more() {
        int length = arrayData.length * 2;
        K[] newData = (K[]) new Comparable[length];
        System.arraycopy(arrayData, 0, newData, 0, size);
        arrayData = newData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(K data) {
        if (size == arrayData.length) {
            more();
        }

        arrayData[size++] = data;
    }

    @Override
    public void add(K data, int index) {
        if (size >= arrayData.length) {
            more();
        }

        check(index, size);

        if (index == size) {
            add(data);
        } else {
            for (int i = size; i > index; i--) {
                arrayData[i] = arrayData[i - 1];
            }

            arrayData[index] = data;
        }

        size++;
    }

    @Override
    public K get(int index) {
        check(index, size);

        return arrayData[index];
    }

    @Override
    public void delete(int index) {
        check(index, size);

        for (int i = index; i < size; i++) {
            arrayData[i] = arrayData[i + 1];
        }

        size--;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public K set(K data, int index) {
        check(index, size);

        arrayData[index] = data;
        return arrayData[index];
    }

    private void check(int index, int size) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
