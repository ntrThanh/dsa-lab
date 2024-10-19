package hus.dsa.homework5.practice.lab6;

public class Solution {
    //Function to check if two trees are identical.
    boolean isIdentical(Node root1, Node root2) {
        // Code Here
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.data == root2.data && isIdentical(root1.left, root2.left)
                && isIdentical(root2.right, root1.right);
    }

}


class Node {
    int data;
    Node left;
    Node right;
}
