package hus.dsa.datastructure.finalpractice.collections.tree;

import hus.dsa.datastructure.finalpractice.expr.ChangInfixToSuffix;

import java.util.Stack;


public class ExpressionTree {
    class Node {
        String data;
        Node left, right;

        public Node(String data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(String data) {
            this.data = data;
        }

        public Node() {
        }
    }

    public Node changeArrayToTreeUsingVer1(String[] tokens) {
        String[] arr = new ChangInfixToSuffix().changInfixToSuffix(tokens);

        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            if (isOperand(arr[i])) {
                stack.push(node);
            } else if (isOperator(arr[i])) {
                node.left = stack.pop();
                node.right = stack.pop();
                stack.push(node);
            }
        }

        return stack.pop();
    }

    boolean isOperator(String s) {
        return "+-*/".contains(s);
    }

    boolean isOperand(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



    public static void main(String[] args) {
        Node node = new ExpressionTree().changeArrayToTreeUsingVer1(new String[] {"(","6", "/", "3","+","2",")", "*", "(", "7", "-", "4",")"});

        print(node, 4);
    }

    static void print(Node root, int space) {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += 10;

        // Process right child first
        print(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");

        // Process left child
        print(root.left, space);
    }
}
