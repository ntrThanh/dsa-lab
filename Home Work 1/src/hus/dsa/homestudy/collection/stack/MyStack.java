package hus.dsa.homestudy.collection.stack;

public interface MyStack<T> {
    void push(T element);


    void pop();

    boolean isEmpty();

    T top();

    int getSize();
}
