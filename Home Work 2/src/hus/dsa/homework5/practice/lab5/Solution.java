package hus.dsa.homework5.practice.lab5;

public class Solution {
    int countNonLeafNodes(Node root) {
        //code here
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        int left = countNonLeafNodes(root.left);
        int right = countNonLeafNodes(root.right);

        return 1 + left + right;
    }
}

class Node {
    int data;
    Node left;
    Node right;
}