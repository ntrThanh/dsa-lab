package hus.dsa.datastructure.finalpractice.collections.tree.bst;

import java.util.*;

public class BSTree<Key extends Comparable<Key>> implements SimpleBinaryTree<Key> {
    class Node {
        Key data;
        Node left;
        Node right;

        public Node(int i) {
        }

        public Node(Key data) {
            this.data = data;
        }
    }

    Node root;
    int size;

    public BSTree() {
        size = 0;
    }

    @Override
    public void insert(Key k) {
        if (root == null) {
            root = new Node(k);
        } else {
            insert(root, k);
        }

        size++;
    }

    public void insert(Node node, Key k) {
        if (k.compareTo(node.data) > 0) {
            if (node.right != null) {
                insert(node.right, k);
            } else {
                node.right = new Node(k);
            }
        } else {
            if (node.left != null) {
                insert(node.left, k);
            } else {
                node.left = new Node(k);
            }
        }
    }

    @Override
    public Key search(Key k) {
        Node temp = root;

        while (temp != null) {
            if (k.compareTo(temp.data) == 0) {
                return temp.data;
            }

            if (k.compareTo(temp.data) > 0) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<Key> iterator() {
        return new BSTreeIterator<>();
    }

    class BSTreeIterator<Key> implements Iterator<Key> {
        Node temp = root;
        Stack<Key> stack = new Stack<>();

        public BSTreeIterator() {
            preorder(temp);
        }

        void preorder(Node root) {
            if (root == null) {
                return;
            }

            preorder(root.left);
            stack.push((Key) root.data);
            preorder(root.right);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Key next() {
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        BSTree<Integer> tree = new BSTree<>();

        tree.insert(2);
        tree.insert(6);
        tree.insert(8);
        tree.insert(-1);
        tree.insert(9);
        tree.insert(0);

        Iterator<Integer> iterator = tree.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();

        System.out.println("Search 9: " + tree.search(9));
        System.out.println("==========================================");

        
    }


}

// a new Solution
//{ Driver Code Starts
// Initial Template for Java
class Tree {
    int data;
    Tree left;
    Tree right;

    Tree(int d) {
        data = d;
        left = null;
        right = null;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    public Tree convert(Node head, Tree node) {
        Node temp = head;

        List<Tree> list = new ArrayList<>();


        while(temp != null) {
            Tree curr = new Tree(temp.data);
            list.add(curr);
            temp = temp.next;
        }

        for(int i = 0; i < list.size(); i++) {
            if (2 * i + 1 < list.size()) {
                list.get(i).left = list.get(2 * i + 1);
            }

            if (2 * i + 2 < list.size()) {
                list.get(i).right = list.get(2 * i + 2);
            }
        }

        return list.get(0);
    }
}

