package hus.dsa.homeworks.sort;

public class SelectionSort {
    public static void sortNumber(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tempData = array[i];
                    array[i] = array[j];
                    array[j] = tempData;
                }
            }
        }
    }

    public static void printDataArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " , ");
        }

        System.out.println();
    }

    public static void main(String[] agrs) {
        int[] array = {4, 3, 1, 6, 7, 4 , 3, 9, 10, 11, 0};
        System.out.println("before sort");
        printDataArray(array);

        System.out.println("after sort");
        sortNumber(array);
        printDataArray(array);
    }
}
