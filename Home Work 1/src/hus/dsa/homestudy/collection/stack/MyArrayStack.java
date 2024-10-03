package hus.dsa.homestudy.collection.stack;

public class MyArrayStack<T> implements MyStack<T> {
    protected int capacity;
    private static final int CAPACITY = 16;
    private static final int MIN_CAPACITY = 1 << 15;
    protected T[] stack;
    private int top;

    @Override
    public int getSize() {
        return top + 1;
    }

    public MyArrayStack() {
        this(CAPACITY);
    }

    public MyArrayStack(int capacity) {
        this.capacity = capacity;
        stack = (T[]) new  Object[capacity];
        top = -1;
    }

    @Override
    public void push(T element) {
        if (getSize() == stack.length) {
            more();
        }

        stack[++top] = element;
    }

    @Override
    public void pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        shrink();
        stack[top--] = null;


    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return stack[top];
    }

    public void more() {
        int currentLength = stack.length * 2;
        T[] currentStack = (T[]) new Object[currentLength];
        System.arraycopy(stack, 0, currentStack, 0, stack.length);
        stack = currentStack;
    }

    public void shrink() {
        int length = top + 1;
        if (length <= MIN_CAPACITY || top << 2 >= length) {
            length = length + (top << 1);
        }
        if (top  < MIN_CAPACITY) {
            length = MIN_CAPACITY;
        }

        T[] newStack = (T[]) new Object[length];
        System.arraycopy(stack, 0, newStack, 0, top + 1);

        stack = newStack;
        this.capacity = length;
    }
}
