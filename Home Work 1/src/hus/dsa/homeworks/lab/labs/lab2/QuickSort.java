package hus.dsa.homeworks.lab.labs.lab2;

public class QuickSort {
    public static <T extends Comparable<T>> void quickSort(T[] array, int l, int r) {
        if (l < r) {
            int pivot = findPivot(array, l, r);

            quickSort(array, l, pivot - 1);
            quickSort(array, pivot + 1, r);
        }
    }

    public static <T> void printArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t" + array[i]);
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> int findPivot(T[] array, int l, int r) {
        int pivotValue = l - 1;
        T key = array[r];

        for (int i = l; i <= r - 1; i++) {
            if (key.compareTo(array[i]) > 0) {
                pivotValue += 1;
                swap(array, pivotValue, i);
            }
        }

        swap(array, pivotValue + 1, r);

        return pivotValue + 1;
    }

    public static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
