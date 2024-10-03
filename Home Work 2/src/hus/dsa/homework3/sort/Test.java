package hus.dsa.homework3.sort;

import java.util.Scanner;

public class Test {
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 7, 1, 7, 6, 8, 0, -1, 4, -2, 23, 10, 11};

        QuickSort bubbleSort = new QuickSort();
        bubbleSort.sort(array);

        printArray(array);
    }
}
