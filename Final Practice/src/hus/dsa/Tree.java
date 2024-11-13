package hus.dsa;

import java.util.LinkedList;
import java.util.List;

public class Tree {

    class Node {
        int data;
        Node left, right;
    }

    public void leftView(Node root) {
        List<Integer> list = new LinkedList<>();
        leftView(root, list, 0);
    }

    int local = 0;
    private void leftView(Node root, List<Integer> list, int currLevel) {
        if (root == null) {
            return;
        }

        if (local < currLevel) {
            local = currLevel;
            list.add(root.data);
        }

        leftView(root.left, list, currLevel + 1);
        leftView(root.right, list, currLevel + 1);
    }

    public boolean isPerfectTree(Node root) {
        return isFullTree(root) && isEqualsLevel(root, 0);
    }

    public boolean isFullTree(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left == null || root.right == null) {
            return false;
        }

        return isFullTree(root.left) && isFullTree(root.right);
    }

    int level = 0;

    public boolean isEqualsLevel(Node root, int currLevel) {
        if (root == null) {
            return true;
        }

        if (level < currLevel) {
            if (level == 0) {
                level = currLevel;
            }

            return currLevel == level;
        }

        return isEqualsLevel(root.left, currLevel + 1)
                && isEqualsLevel(root.right, currLevel + 1);
    }

}
