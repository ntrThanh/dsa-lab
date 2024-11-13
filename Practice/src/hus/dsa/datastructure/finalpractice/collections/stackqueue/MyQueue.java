package hus.dsa.datastructure.finalpractice.collections.stackqueue;

import java.util.LinkedList;

public interface MyQueue<K> {
    void add(K data);
    boolean isEmpty();

    K poll();

    K peek();
    int size();
}

