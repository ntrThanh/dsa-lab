package hus.dsa.homeworks.sort;

public class InsertionSort {
    public static void sortNumber(int[] array) {
        int n = array.length;

        for (int i = 0; i < n; i++) {
            shiftArray(array, i);
        }
    }

    public static void shiftArray(int[] array, int i) {
        int temp = array[i];

        while (i > 0 && array[i] < array[i - 1]) {
            swapData(array, i, i - 1);
            i--;
        }

        array[i] = temp;
    }

    public static void swapData(int[] array, int i, int j) {
        int currentData = array[i];
        array[i] = array[j];
        array[j] = currentData;
    }

    public static void main(String[] args) {
        int[] array = {6, 5, 7, 4, 1, 0};
        System.out.println("before sort");
        BubbleSort.printDataArray(array);

        //sort
        sortNumber(array);
        System.out.println("after sort");
        BubbleSort.printDataArray(array);
    }
}
