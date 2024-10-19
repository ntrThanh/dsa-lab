package hus.dsa.homework5.practice.lab2;

public class Solution {
    int countLeaves(Node node) {
        // Your code
        if (node == null) return 0;
        else {
            if (node.left == null && node.right == null) {
                return 1;
            }

            return countLeaves(node.left) + countLeaves(node.right);
        }
    }
}

class Node {
    int value;
    Node left;
    Node right;
}
