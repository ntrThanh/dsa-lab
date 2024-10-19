package hus.dsa.homework5.practice.lab10;

import hus.dsa.homework5.practice.Node;

import java.util.*;

public class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);

        return list;
    }

    void inOrder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }
}