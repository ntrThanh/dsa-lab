package hus.dsa.homework5.lab3;

import java.util.Stack;

public class ArrayToTree {

    public static Node<String> arrayToTree(String[] array) {
        String[] tokens = new Expression().changeInfixToSuffix(array);

        Stack<Node<String>> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            Node<String> node = new Node<>(tokens[i]);
            if (isInteger(tokens[i])) {
                stack.push(node);
            } else if (isOperator(tokens[i])) {
                node.left = stack.pop();
                node.right = stack.pop();
                stack.push(node);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Node<String> root = arrayToTree(new String[] {"(", "6", "/", "3","+","2",")", "*", "(", "7", "-", "4",")"});
        print(root, 2);
    }

    static void print(Node<String> root, int space) {
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
        System.out.print(root.value + "\n");

        // Process left child
        print(root.left, space);
    }

    static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static boolean isOperator(String s) {
        return "+-*/".contains(s);
    }


}
