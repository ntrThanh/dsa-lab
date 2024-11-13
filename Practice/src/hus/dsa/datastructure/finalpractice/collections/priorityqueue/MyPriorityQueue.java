package hus.dsa.datastructure.finalpractice.collections.priorityqueue;

public interface MyPriorityQueue<Key extends Comparable<Key>> {
    void insert(Key v);//insert a key into the priority queue
    Key delMax();//return and remove a largest key
    boolean isEmpty(); //is the priority queue empty?
    Key max(); //return a largest key
    int size();
}
