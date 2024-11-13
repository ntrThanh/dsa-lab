package hus.dsa.datastructure.queue;

public class ArrayQueue<T> implements MyQueue<T> {
    T[] data;
    int size;

    public ArrayQueue() {
        data = (T[]) new Object[1000];
        size = 0;
    }

    void more() {
        int length = data.length * 2;
        T[] newdata = (T[]) new Object[length];
        System.arraycopy(data, 0, newdata, 0, length);
        data = newdata;
    }

    @Override
    public void enqueue(T data) {
        if (size >= this.data.length) {
            more();
        }

        this.data[size++] = data;
    }

    @Override
    public T dequeue() {
        T data = this.data[0];

        for (int i = 0; i < size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }

        size--;

        return data;
    }

    @Override
    public T peek() {
        return data[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> data = new ArrayQueue<>();

        data.enqueue(123);
        data.enqueue(12);
        data.enqueue(113);
        data.dequeue();
        data.enqueue(3);
        data.enqueue(12);
        data.enqueue(0);
        data.enqueue(-1);

        while (!data.isEmpty()) {
            System.out.println(data.dequeue());
        }
    }
}
