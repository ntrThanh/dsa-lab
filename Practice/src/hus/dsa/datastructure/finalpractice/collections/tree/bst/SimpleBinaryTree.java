package hus.dsa.datastructure.finalpractice.collections.tree.bst;

public interface SimpleBinaryTree<Key extends	Comparable<Key>> extends Iterable<Key> {
    public void insert(Key k);
    public Key search(Key k);
    public int size();
    public boolean isEmpty();
}
