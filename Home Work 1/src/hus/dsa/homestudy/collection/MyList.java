package hus.dsa.homestudy.collection;

public interface MyList<T> {
    void add(T element);

    void set(int index, T element);

    void delete(int index);

    void insert(int index, T element);

    T get(int index);

    int getSize();
}
