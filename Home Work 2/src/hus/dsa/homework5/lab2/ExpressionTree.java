package hus.dsa.homework5.lab2;


import hus.dsa.homework5.tree.LinkedBinaryTree;

public class ExpressionTree<T> extends LinkedBinaryTree<T> {
    public void preorderPrint(Node<T> p) {
        if (p == null) {
            return;
        }

        System.out.print(p.value + " ");
        preorderPrint(p.left);
        preorderPrint(p.right);
    }

    public void postorderPrint(Node<T> p) {
        if (p == null) {
            return;
        }


        postorderPrint(p.left);
        postorderPrint(p.right);
        System.out.print(p.value + " ");
    }

    public void inorderPrint(Node<T> p) {
        if (p == null) {
            return;
        }

        System.out.print("(");

        inorderPrint(p.left);
        System.out.print(p.value);
        inorderPrint(p.right);

        System.out.print(")");
    }

    public boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

}
class Node<T> {
    T value;
    Node<T> left;
    Node<T> right;
    Node<T> parent;
}

