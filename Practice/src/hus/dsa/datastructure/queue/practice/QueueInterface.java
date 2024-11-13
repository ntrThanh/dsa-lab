package hus.dsa.datastructure.queue.practice;

public interface QueueInterface<T> {
    void enqueue(T element);
    T dequeue();
    boolean isEmpty();
}
