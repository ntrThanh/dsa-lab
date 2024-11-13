package hus.dsa.datastructure.queue.practice;

import java.util.LinkedList;
import java.util.List;

public class LinkedListQueue<T> implements QueueInterface<T> {

    class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    Node head;
    int size;

    public LinkedListQueue() {
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        if (head == null) {
            head = new Node(element, head);
        } else {
            Node temp = getNodeByIndex(size - 1);
            temp.next = new Node(element);
        }

        size++;
    }

    Node getNodeByIndex(int index) {
        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    @Override
    public T dequeue() {
        T data = head.data;
        head = head.next;
        size--;

        return data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        TreeNode<Integer> treeNode = new TreeNode<>();

        treeNode.root = new TreeNode.NodeOfTree(6);
        treeNode.root.left = new TreeNode.NodeOfTree(7);
        treeNode.root.right = new TreeNode.NodeOfTree(5);

        treeNode.root.left.left = new TreeNode.NodeOfTree(8);
        treeNode.root.left.right = new TreeNode.NodeOfTree(9);

        treeNode.root.right.left = new TreeNode.NodeOfTree(0);
        treeNode.root.right.right = new TreeNode.NodeOfTree(-2);

        print(treeNode.travelLevel(treeNode.root));
    }

    static void print(List<Integer> list) {
        for (Integer a : list) {
            System.out.print(a + " ");
        }

        System.out.println();
    }
}



class TreeNode<T> {

    static class NodeOfTree<T> {
        T data;
        NodeOfTree left, right;

        public NodeOfTree(T data) {
            this.data = data;
        }
    }

    NodeOfTree root;

    List<T> travelLevel(NodeOfTree root) {
        List<T> data = new LinkedList<>();

        QueueInterface<NodeOfTree> queue = new LinkedListQueue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            NodeOfTree temp = queue.dequeue();

            data.add((T) temp.data);

            if (temp.left != null) {
                queue.enqueue(temp.left);
            }
            if (temp.right != null) {
                queue.enqueue(temp.right);
            }
        }

        return data;
    }
}
