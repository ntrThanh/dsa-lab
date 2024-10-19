package hus.dsa.homework5.lab1;

public class TestMain {
    public static void main(String[] args) {
        LinkedBinaryTree<Integer, Node<Integer>> linkedBinaryTree = new LinkedBinaryTree<>();

        linkedBinaryTree.addRoot(1);
        linkedBinaryTree.addLeft(linkedBinaryTree.root(), 3);
        linkedBinaryTree.addRight(linkedBinaryTree.root(), 7);
        linkedBinaryTree.addRight(linkedBinaryTree.right(linkedBinaryTree.root()), 9);
        linkedBinaryTree.addLeft(linkedBinaryTree.right(linkedBinaryTree.root()), 6);
        linkedBinaryTree.addRight(linkedBinaryTree.right(linkedBinaryTree.right(linkedBinaryTree.root())), 10);
        linkedBinaryTree.addLeft(linkedBinaryTree.sibling(linkedBinaryTree.right(linkedBinaryTree.root())), 20);

        print(linkedBinaryTree.root(), 4);
    }

    public static <T> void print(Node<T> root, int space) {
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
        System.out.print(root.element + "\n");

        // Process left child
        print(root.left, space);
    }
}
