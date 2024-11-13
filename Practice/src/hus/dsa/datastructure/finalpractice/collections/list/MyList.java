package hus.dsa.datastructure.finalpractice.collections.list;

public interface MyList<K extends Comparable<K>> {
    void add(K data);

    void add(K data, int index);

    K get(int index);

    void delete(int index);

    boolean isEmpty();

    K set(K data, int index);

    int size();
}
