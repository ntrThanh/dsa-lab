package hus.dsa.homework4.lab4;

public interface ArrayQueueInterface<E> extends Iterable<E>  {
    void enqueue(E element);
    E dequeue();
    boolean isEmpty();
}
