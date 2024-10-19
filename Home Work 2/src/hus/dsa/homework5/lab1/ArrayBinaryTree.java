package hus.dsa.homework5.lab1;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T> {
    private E[] array;
    private int n;
    private final int defaultSize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultSize];
        n = 0;
    }

    public void setRoot(E element) {
        array[1] = element;

        n++;
    }

    public E[] getArray() {
        return array;
    }

    public void setLeft(int p, E element) {
        array[2 * p] = element;

        n++;
    }

    public void setRight(int p, E element) {
        array[2 * p + 1] = element;

        n++;
    }


    @Override
    public T root() {
        if (isEmpty()) {
            return null;
        }
        Integer result = 1;

        return (T) result;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(T p) {
        Integer position = (Integer) p;
        if (position > n) {
            return 0;
        }

        if (2 * position + 1 > n || 2 * position + 1 > n) {
            return 0;
        }

        if (array[2 * position] == null && array[2 * position + 1] == null) {
            return 0;
        } else if (array[2 * position] == null || array[2 * position + 1] == null) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public T parent(T p) {
        Integer result = (Integer) p;

        if (result > n) {
            return null;
        }

        result = result / 2;
        return (T) result;
    }

    @Override
    public T right(T p) {
        Integer result = (Integer) p;

        if (result > n) {
            return null;
        }

        result = 2 * result + 1;
        return (T) result;
    }

    @Override
    public T sibling(T p) {
        Integer result = (Integer) p;

        if (result > n) {
            return null;
        }

        result = 2 * result;
        return (T) result;
    }

    public void print(int k, int space) {
        // Base case
        if (k > n || array[k] == null)
            return;

        // Increase distance between levels
        space += 10;

        // Process right child first
        print(2 * k + 1, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.print(array[k] + "\n");

        // Process left child
        print(2 * k, space);
    }
}
