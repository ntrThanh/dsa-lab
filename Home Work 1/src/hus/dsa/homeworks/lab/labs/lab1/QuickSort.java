package hus.dsa.homeworks.lab.labs.lab1;

public class QuickSort {
    public static void quickSort(int[] array, int l, int r) {
        if (l < r) {
            int pivot = findPivot(array, l, r);

            quickSort(array, l, pivot - 1);
            quickSort(array, pivot + 1, r);
        }
    }

    public static void main(String[] args) {
        int array[] = {1, 7, 4, 8, 2, 0, -1, -10, 100, 12, 12, 3, 3, 5, 4};
        printArray(array);

        quickSort(array, 0, array.length - 1);

        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t" + array[i]);
        }
        System.out.println();
    }

    public static int findPivot(int[] array, int l, int r) {
        int pivotValue = l - 1;
        int key = array[r];

        for (int i = l; i <= r - 1; i++) {
            if (key >= array[i]) {
                pivotValue += 1;
                swap(array, pivotValue, i);
            }
        }

        swap(array, pivotValue + 1, r);

        return pivotValue + 1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
