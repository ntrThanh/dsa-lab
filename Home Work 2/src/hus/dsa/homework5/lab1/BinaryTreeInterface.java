package hus.dsa.homework5.lab1;

public interface BinaryTreeInterface<T> {
    T root();
    int size();
    boolean isEmpty();
    int numChildren(T p);
    T parent(T p);
    T right(T p);
    T sibling(T p);
}
