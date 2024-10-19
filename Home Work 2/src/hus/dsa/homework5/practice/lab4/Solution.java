package hus.dsa.homework5.practice.lab4;

public class Solution {
    public static int getSize(Node node) {
        return size(node) - 1;
    }

    public static int size(Node node) {
        // code here
        if (node == null) {
            return 1;
        }

        int left = size(node.left);
        int right = size(node.right);

        return left + right;
    }
}

class Node {
    int data;
    Node left;
    Node right;
}