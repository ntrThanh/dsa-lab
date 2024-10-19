package hus.dsa.homework5.practice.lab1;

public class Solution {
    //Function to find the height of a binary tree.
    int height(Node node)
    {
        // code here
        if (node == null) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        return left < right ? right + 1 : left + 1;
    }
}

class Node {
    int value;
    Node left;
    Node right;
}