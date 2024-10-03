package hus.dsa.homeworks.sort;

public class BubbleSort {

    public static void sortNumber(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swapData(array, j, j + 1);
                }
            }
        }
    }

    public static void sortNumberVersionTwo(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            boolean check = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swapData(array, j, j + 1);
                    check = true;
                }
            }

            if (!check) {
                System.out.println("the data is sorted before used method sort");
                break;
            }
        }
    }

    public static void swapData(int[] array, int i, int j) {
        int currentData = array[i];
        array[i] = array[j];
        array[j] = currentData;
    }

    public static void printDataArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " , ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 6, 2, 2, 0, 8, 7, 22};
        System.out.println("before sort");
        printDataArray(array);

        // sort array;
        sortNumberVersionTwo(array);
        System.out.println("after sort");
        printDataArray(array);
    }
}
