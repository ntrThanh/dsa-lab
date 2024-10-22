package dsa;

import java.util.*;

@SuppressWarnings("unchecked")
public class SimpleBST<Key extends Comparable<Key>> implements SimpleBTreeInterface<Key> {

    class Node {
        Key data;
        Node left, right;

        public Node(Key key) {
            this.data = key;
        }
    }

    private Node root = null;
    int n = 0;

    @Override
    public void insert(Key k) {
        // TODO Auto-generated method stub
        if (root == null) {
            root = new Node(k);
            n++;
            return;
        }
        insert(root, k);
        n++;
    }

    public void insert(Node root, Key k) {
        if (k.compareTo(root.data) < 0) {
            if (root.left == null) {
                root.left = new Node(k);
            } else {
                insert(root.left, k);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(k);
            } else {
                insert(root.right, k);
            }
        }
    }

    @Override
    public Key search(Key k) {
        // TODO Auto-generated method stub

        return search(root, k);
    }

    public Key search(Node root, Key k) {
        Node temp = root;
        if (temp == null) {
            return null;
        }

        while (true) {
            if (temp == null) {
                return null;
            }

            if (temp.data.compareTo(k) == 0) {
                return temp.data;
            } else if (temp.data.compareTo(k) > 0) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return n;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return n == 0;
    }

    @Override
    public Iterator<Key> iterator() {
        // TODO Auto-generated method stub

        return new SimpleBSTIterator();
    }

    class SimpleBSTIterator implements Iterator<Key> {
        private Node temp = root;
        private Stack<Node> stacks = new Stack<>();

        public SimpleBSTIterator() {
            preOrder();
        }

        private void preOrder() {
            preOrder(temp);
        }

        private void preOrder(Node root) {
            if (root == null) {
                return;
            }

            preOrder(root.left);
            stacks.push(root);
            preOrder(root.right);
        }

        @Override
        public boolean hasNext() {
            return !stacks.isEmpty();
        }

        @Override
        public Key next() {
            return stacks.pop().data;
        }
    }

    //duyệt cây theo thứ tự trước (tiền thứ tự)
    public void preTraverse() {
        preTraverse(root);
    }

    private void preTraverse(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.data);
        preTraverse(root.left);
        preTraverse(root.right);


    }

    // duyệt cây theo thứ tự sau (hậu thứ tự)
    public void postTraverse() {
        postTraverse(root);
    }

    private void postTraverse(Node root) {
        if (root == null) {
            return;
        }

        postTraverse(root.left);
        postTraverse(root.right);
        System.out.println(root.data);
    }


    // duyệt cây theo thứ tự giữa (trung thứ tự)
    public void inTraverse() {
        inTraverse(root);
    }

    private void inTraverse(Node root) {
        if (root == null) {
            return;
        }
        inTraverse(root.left);
        System.out.println(root.data);
        inTraverse(root.right);

    }


    public static void main(String[] args) {
        SimpleBST<Integer> bst = new SimpleBST<>();

        int[] data = {5, 6, 7, 1, 2, 3, 8, 6, 9, 0};
        for (int i = 0; i < data.length; i++)
            bst.insert(data[i]);

        System.out.println("All element in tree:");
        System.out.println("All element in tree:");
        int[] t = new int[data.length];
        int id = 0;
        for (int d : bst) {
            t[id] = d;
            id++;
        }

        Arrays.sort(t);
        for (int d : t) {
            System.out.print(d + " ");
        }

        System.out.println("");
        System.out.println("Size of tree = " + bst.size());

        System.out.println("Search key = 4> " + bst.search(4));
        System.out.println("Search key = 6> " + bst.search(6));

        System.out.println("Pre-order tree traversal");
        bst.preTraverse();
        System.out.println("Post-order tree traversal");
        bst.postTraverse();
        System.out.println("In-order tree traversal");
        bst.inTraverse();

    }


}
