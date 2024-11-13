package hus.dsa.datastructure.finalpractice.collections.stackqueue;

import java.util.Iterator;

public interface MyStack<K> extends Iterable<K> {
    void push(K data);
    K pop();
    int size();
    boolean isEmpty();

    @Override
    Iterator<K> iterator();
}
