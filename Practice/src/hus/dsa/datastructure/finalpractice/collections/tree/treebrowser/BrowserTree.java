package hus.dsa.datastructure.finalpractice.collections.tree.treebrowser;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BrowserTree {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    void preorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        preorder(root.left, list);
        list.add(root.data);
        preorder(root.right, list);
    }

    void inorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.data);
        inorder(root.left, list);
        inorder(root.right, list);
    }

    void postorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        inorder(root.right, list);
        list.add(root.data);
    }

    // level
    void levelOrder(Node root, List<Integer> list) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            list.add(temp.data);

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    // left view
    int level = 0;
    void leftOrder(Node root, List<Integer> list) {
        leftOrder(root, list, 1);
    }

    void leftOrder(Node root, List<Integer> list, int currentLevel) {
        if (root == null) {
            return;
        }

        if (level < currentLevel) {
            list.add(root.data);
            level = currentLevel;
        }

        leftOrder(root.left, list, currentLevel + 1);
        leftOrder(root.right, list, currentLevel + 1);
    }
}
