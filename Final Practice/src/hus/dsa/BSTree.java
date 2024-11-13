package hus.dsa;

public class BSTree<T extends Comparable<T>> {
    class Node {
        T data;
        Node left, right;

        public Node(T data) {
            this.data = data;
        }
    }

    public void insert(T data) {
        if (size == 0) {
            root = new Node(data);
        } else {
            insert(root, data);
        }
        size++;
    }

    private void insert(Node node, T data) {
        if (data.compareTo(node.data) > 0) {
            if (node.right == null) {
                node.right = new Node(data);
            } else {
                insert(node.right, data);
            }
        } else {
            if (node.left == null) {
                node.left = new Node(data);
            } else {
                insert(node.left, data);
            }
        }
    }

    public Node delete(Node root, T data) {
        if (root == null) {
            return null;
        } else if (data.compareTo(root.data) > 0) {
            delete(root.right, data);
        } else if (data.compareTo(root.data) < 0) {
            delete(root.left, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            T currData = getMin(root.right);
            root.data = currData;
            root.right = delete(root.right, data);
        }

        return root;
    }

    public T getMin(Node root) {
        Node temp = root;
        T data = null;

        while (temp != null) {
            temp = temp.left;
            data = temp.data;
        }
        return data;
    }

    public T binarySearch(Node root, T data) {
        Node temp = root;

        while (temp != null) {
            if (data.compareTo(temp.data) == 0) {
                return data;
            }

            if (data.compareTo(root.data) > 0) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }

        return null;
    }
    Node root;
    int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
