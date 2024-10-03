package hus.dsa.homestudy.collection;

import java.util.List;

public class MyArrayList<T> extends MyAbstractList<T> {
    private static final int CAPACITY = 16;
    private T[] data;

    public MyArrayList() {
        this(CAPACITY);
    }

    public MyArrayList(int capacity) {
        super();
        data = (T[]) new Object[capacity];
    }

    public void more() {
        int newLength = data.length * 2;
        T[] currentData = (T[]) new Object[newLength];

        System.arraycopy(data, 0, currentData, 0, data.length);

        data = currentData;
    }

    @Override
    public void add(T element) {
        if (size >= data.length) {
            more();
        }

        insert(size, element);
    }

    @Override
    public void insert(int index, T element) {
        checkBoundaries(index);

        if (size >= data.length) {
            more();
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = element;
        size++;
    }

    @Override
    public void set(int index, T element) {
        checkBoundaries(index);

        data[index] = element;
    }

    @Override
    public void delete(int index) {
        checkBoundaries(index);

        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }

        size--;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T get(int index) {
        checkBoundaries(index);

        return data[index];
    }

    public static void main(String[] args) {
        MyList<Node> listNode = new MyArrayList<>();

        for (int i = 0; i < 10; i++) {
            listNode.add(new Node(i));
        }

        listNode.insert(10, new Node(10));
        listNode.delete(10);
        System.out.println(listNode);
    }
}

class Node {
    int value;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node" + '[' +
                "value=" + value +
                ']';
    }
}
