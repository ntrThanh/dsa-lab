package hus.dsa.datastructure.list;

public interface List<T> extends Iterable<T> {
    void add(T data);
    void add(T data, int index);
    void remove(int index);
    T get(int index);

    boolean isEmpty();

    int getSize();
}
