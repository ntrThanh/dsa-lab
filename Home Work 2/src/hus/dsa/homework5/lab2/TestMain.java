package hus.dsa.homework5.lab2;

public class TestMain {
    public static void main(String[] args) {
        Node<String> root = new Node<>(); root.value = "-";

        root.left = new Node<>(); root.left.value = "*";
        root.left.left = new Node<>(); root.left.left.value = "2";
        root.left.right = new Node<>(); root.left.right.value = "+";
        root.left.right.left = new Node<>(); root.left.right.left.value = "4";
        root.left.right.right = new Node<>(); root.left.right.right.value = "1";

        root.right = new Node<>(); root.right.value = "*";
        root.right.left = new Node<>(); root.right.left.value = "3";
        root.right.right = new Node<>(); root.right.right.value = "-";
        root.right.right.left = new Node<>(); root.right.right.left.value = "1";
        root.right.right.right = new Node<>(); root.right.right.right.value = "2";

        ExpressionTree<String> expressionTree = new ExpressionTree<>();
        expressionTree.preorderPrint(root);
    }
}
