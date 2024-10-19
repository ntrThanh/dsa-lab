package hus.dsa.homework5.lab1;

public class TestMain2 {
    public static void main(String[] args) {
        ArrayBinaryTree<Integer, Integer> arrayBinaryTree = new ArrayBinaryTree<>();

        arrayBinaryTree.setRoot(10);
        arrayBinaryTree.setLeft(1, 2);
        arrayBinaryTree.setRight(1, 3);
        arrayBinaryTree.setLeft(2, 5);
        arrayBinaryTree.setRight(2, 7);
        arrayBinaryTree.setLeft(3, 0);
        arrayBinaryTree.setRight(3, 9);


        arrayBinaryTree.print(1, 4);

    }



}
