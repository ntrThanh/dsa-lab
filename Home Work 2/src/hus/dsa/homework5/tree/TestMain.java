package hus.dsa.homework5.tree;

public class TestMain {
    public static void main(String[] args) {
        Node<Integer> root = new Node<Integer>(); root.value = 1;
        Node<Integer> r2 = new Node<Integer>(); r2.value = 9;
        Node<Integer> r3 = new Node<Integer>(); r3.value = 10;
        Node<Integer> r4 = new Node<Integer>(); r4.value = 2;
        Node<Integer> r5 = new Node<Integer>(); r5.value = 7;
        Node<Integer> r6 = new Node<Integer>(); r6.value = 5;
        Node<Integer> r7 = new Node<Integer>(); r7.value = 3;

        LinkedBinaryTree<Integer> linkedBinaryTree = new LinkedBinaryTree<>();
        linkedBinaryTree.addRoot(root);
        linkedBinaryTree.addNodeLeft(linkedBinaryTree.getRoot(), r2);
        linkedBinaryTree.addNodeRight(linkedBinaryTree.getRoot(), r3);

        linkedBinaryTree.addNodeLeft(linkedBinaryTree.getNodeLeft(linkedBinaryTree.getRoot()), r4);
        linkedBinaryTree.addNodeRight(linkedBinaryTree.getNodeLeft(linkedBinaryTree.getRoot()), r5);

        linkedBinaryTree.addNodeLeft(linkedBinaryTree.getNodeRight(linkedBinaryTree.getRoot()), r6);
        linkedBinaryTree.addNodeRight(linkedBinaryTree.getNodeRight(linkedBinaryTree.getRoot()), r7);

        linkedBinaryTree.printTree();
    }
}
