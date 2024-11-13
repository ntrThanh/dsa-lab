package hus.dsa.datastructure.stack;

public class ArrayStack<T> {
    T[] data;
    int size;

    public ArrayStack() {
        size = 0;
        data = (T[]) new Object[1000];
    }

    int size() {
        return size;
    }

    void more() {
        int length = data.length * 2;
        T[] newdata = (T[]) new Object[length];
        System.arraycopy(data, 0, newdata, 0, length);
        data = newdata;
    }

    void push(T ele) {
        if (size >= data.length) {
            more();
        }
        data[size++] = ele;
    }

    T pop() {
        if (size == 0) {
            return null;
        }

        T result = data[size - 1];
        data[--size] = null;

        return result;
    }

    T peek() {
        return data[size - 1];
    }

    boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        stack.push(12);
        stack.pop();
        stack.push(1);
        stack.push(0);
        stack.push(32);
        stack.push(52);
        stack.pop();
        stack.push(10);
        stack.push(-1);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
