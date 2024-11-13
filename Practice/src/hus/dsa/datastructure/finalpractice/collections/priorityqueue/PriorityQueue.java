package hus.dsa.datastructure.finalpractice.collections.priorityqueue;

public class PriorityQueue<Key extends Comparable<Key>> implements MyPriorityQueue<Key> {

    Key[] data;
    int n;

    public PriorityQueue() {
        n = 0;
        data = (Key[]) new Comparable[1000];
    }

    private void more() {
        int length = data.length * 2;

        Key[] arr = (Key[]) new Comparable[length];
        System.arraycopy(data, 0, arr, 0, data.length);
        data = arr;
    }

    @Override
    public void insert(Key v) {
        if (n >= data.length) {
            more();
        }

        data[n++] = v;
    }

    @Override
    public Key delMax() {
        int index = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i].compareTo(data[index]) > 0) {
                index = i;
            }
        }

        Key temp = data[index];
        data[index] = data[n - 1];
        data[n - 1] = temp;

        data[n--] = null;

        return temp;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Key max() {
        int index = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i].compareTo(data[index]) > 0) {
                index = i;
            }
        }

        return data[index];
    }

    @Override
    public int size() {
        return n;
    }
}
