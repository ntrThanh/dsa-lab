package hus.dsa.homework5.practice.lab11;

import hus.dsa.homework5.practice.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static ArrayList<Integer> preorder(Node root)
    {
        // Code here
        ArrayList<Integer> list = new ArrayList<>();
        preorder(root, list);

        return list;
    }

    private static void preorder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.data);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    ArrayList<Integer> postOrder(Node root)
    {
        // Your code goes here
        ArrayList<Integer> list = new ArrayList<>();
        postOrder(root, list);

        return list;
    }

    private void postOrder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.data);
    }

    static ArrayList<Integer> levelOrder(Node root)
    {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            list.add(curr.data);

            if (curr.left != null) {
                queue.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        return list;
    }

    ArrayList<Integer> zigZagTraversal(Node root)
    {
        //Add your code here.
        ArrayList<Integer> list = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        boolean check = false;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            list.add(curr.data);

            if (curr.left != null) {
                queue.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
            }
        }

        return list;
    }

}
