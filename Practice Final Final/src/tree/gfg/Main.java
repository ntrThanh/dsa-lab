package tree.gfg;

import java.util.*;

public class Main {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    // tim chieu cao cua cay
    int height(Node node) {
        // code here

        return getHeight(node) - 1;
    }

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    // dem so la cay
    int countLeaves(Node node) {
        // Your code
        List<Integer> res = new ArrayList<>();
        countLeave(res, node);
        return res.size();
    }

    public void countLeave(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            list.add(root.data);
        }

        if (root.left == null && root.right != null) {
            countLeave(list, root.right);
            return;
        }

        if (root.left != null && root.right == null) {
            countLeave(list, root.left);
            return;
        }

        countLeave(list, root.left);
        countLeave(list, root.right);
    }


    // dem so nut cua cay
    public static int getSize(Node node) {
        // code here
        if (node == null) {
            return 0;
        }

        return 1 + getSize(node.left) + getSize(node.right);
    }

    // dem khong phai la
    int countNonLeafNodes(Node root) {
        //code here
        List<Integer> res = new ArrayList<>();
        countNonLeaf(res, root);
        return res.size();
    }

    public void countNonLeaf(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        list.add(root.data);
        countNonLeaf(list, root.left);
        countNonLeaf(list, root.right);
    }

    // tim do sau toi thieu
    int minDepth(Node root) {
        //code here
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return 1 + minDepth(root.right);
        } else if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    // tim nut khong co anh em
    ArrayList<Integer> noSibling(Node node) {
        // code here
        ArrayList<Integer> arrayList = new ArrayList<>();
        getNodeNoHaveSibling(node, arrayList);
        Collections.sort(arrayList);

        if (arrayList.isEmpty()) {
            arrayList.add(-1);
        }
        return arrayList;
    }

    public void getNodeNoHaveSibling(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        if (root.left == null && root.right != null) {
            list.add(root.right.data);
        }

        if (root.right == null && root.left != null) {
            list.add(root.left.data);
        }

        getNodeNoHaveSibling(root.left, list);
        getNodeNoHaveSibling(root.right, list);
    }

    // la hai cay trung nhau
    boolean isIdentical(Node r1, Node r2) {
        // Code Here
        if (r1 == null && r2 == null) {
            return true;
        }

        if (r1 == null || r2 == null || r1.data != r2.data) {
            return false;
        }

        return isIdentical(r1.left, r2.left) && isIdentical(r1.right, r2.right);
    }

    // duyet cay theo 3 muc
    ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer> res = new ArrayList<>();
        inorder(res, root);
        return res;
    }

    public void inorder(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }

        inorder(list, root.left);
        list.add(root.data);
        inorder(list, root.right);
    }

    static ArrayList<Integer> preorder(Node root) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        preorderNode(root, res);
        return res;
    }

    public static void preorderNode(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.data);
        preorderNode(node.left, list);
        preorderNode(node.right, list);
    }

    ArrayList<Integer> postOrder(Node root) {
        // Your code goes here
        ArrayList<Integer> res = new ArrayList<>();
        postOrderNode(root, res);
        return res;
    }

    public void postOrderNode(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        postOrderNode(root.left, list);
        postOrderNode(root.right, list);
        list.add(root.data);
    }


    // duyet cay theo level
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = getHeight1(root);

        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }

        orderLevel(root, res, 0);
        return res;
    }

    public void orderLevel(Node root, List<ArrayList<Integer>> res, int index) {
        if (root == null) {
            return;
        }

        res.get(index).add(root.data);
        orderLevel(root.left, res, index + 1);
        orderLevel(root.right, res, index + 1);
    }

    public int getHeight1(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getHeight1(root.left), getHeight1(root.right));
    }

    // duyet cay zigzag
    ArrayList<Integer> zigZagTraversal(Node root) {
        //Add your code here.
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = getHeight1(root);

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        orderLevel(root, list, 0);

        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(list.get(i));
                res.addAll(list.get(i));
            } else {
                res.addAll(list.get(i));
            }
        }

        return res;
    }


    // duyet cay theo duong cheo
    public ArrayList<Integer> diagonal(Node root) {
        //add your code here.
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            while (temp != null) {
                arrayList.add(temp.data);

                if (temp.left != null) {
                    queue.add(temp.left);
                }

                temp = temp.right;
            }
        }

        return arrayList;
    }


    // duyet cay theo left view
    int level = 0;

    ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> arrayList = new ArrayList<>();
        leftOrder(root, 1, arrayList);
        return arrayList;
    }

    public void leftOrder(Node root, int currentLevel, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (currentLevel > level) {
            level = currentLevel;
            list.add(root.data);
        }

        leftOrder(root.left, currentLevel + 1, list);
        leftOrder(root.right, currentLevel + 1, list);
    }


    // duyet cay theo cai nhin tu tren xuong
    static ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> arrayList = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<PairNode> queue = new LinkedList<>();
        queue.add(new PairNode(root, 0));

        while (!queue.isEmpty()) {
            PairNode current = queue.poll();
            Node currentNode = current.node;
            int score = current.score;

            if (!map.containsKey(score)) {
                map.put(score, currentNode.data);
            }

            if (currentNode.left != null) {
                queue.add(new PairNode(currentNode.left, current.score - 1));
            }

            if (currentNode.right != null) {
                queue.add(new PairNode(currentNode.right, current.score + 1));
            }
        }

        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            arrayList.add(x.getValue());
        }

        return arrayList;
    }

    static class PairNode {
        Node node;
        int score;

        public PairNode(Node node, int score) {
            this.node = node;
            this.score = score;
        }
    }
}
