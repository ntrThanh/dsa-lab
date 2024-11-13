package hus.dsa.datastructure.finalpractice.collections.tree;

import java.util.Iterator;
import java.util.Stack;

public class BSTree<T extends Comparable<T>>implements Iterable<T> {
    class Node {
        T data;
        Node left, right;

        public Node(T data) {
            this.data = data;
        }
    }

    Node root;
    int size;


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

    public T search(T data) {
        Node temp = root;

        while (temp != null) {
            if (data.compareTo(temp.data) == 0) {
                return temp.data;
            }

            if (data.compareTo(temp.data) > 0) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }

        return temp.data;
    }

    public Node delete(Node root, T data) {
        if (root == null) {
            return root;
        } else if (data.compareTo(root.data) > 0) {
            root.right = delete(root.right, data);
        } else if (data.compareTo(root.data) < 0) {
            root.left = delete(root.left, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = getMin(root.right);
            root.right = delete(root.right, root.data);
        }

        return root;
    }

    public T getMin(Node root) {
        Node temp = root;
        T data = null;

        while (temp != null) {
            if (temp.left != null) {
                temp = temp.left;
                data = temp.data;
            }
        }

        return data;
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new BSTreeIterator();
    }

    public class BSTreeIterator implements Iterator<T> {
        Stack<T> stack;

        public BSTreeIterator() {
            stack = new Stack<>();
            preorder(root);
        }

        private void preorder(Node root) {
            if (root == null) {
                return;
            }

            preorder(root.right);
            stack.push(root.data);
            preorder(root.left);
        }

        @Override
        public boolean hasNext() {
            return stack.isEmpty();
        }

        @Override
        public T next() {
            return stack.pop();
        }
    }
}

