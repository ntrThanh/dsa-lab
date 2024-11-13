package hus.dsa.datastructure.finalpractice.collections.tree;

public class Solution {
    // mot so bai toan ve tree

    // kiem tra cay co la o cung muc
    int level = 0;

    boolean isLeafLevel(Node root) {

        return false;
    }

    boolean isLeafLevel(Node root, int index) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            if (level == 0) {
                return true;
            }

            return index == level;
        }

        return isLeafLevel(root.left, index + 1) && isLeafLevel(root.right, index + 1);
    }

    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
}
