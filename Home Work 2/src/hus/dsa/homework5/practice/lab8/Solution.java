package hus.dsa.homework5.practice.lab8;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root ==  null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.val;
        }

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}