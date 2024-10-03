package hus.dsa.homeworks.lab.labs.lab1;

import java.util.Scanner;

public class Lab1 {

    public static int[] inputArrayByKeyboard(Scanner sc) {
        System.out.println("Enter length of Array");
        int lengthOfArray = sc.nextInt();

        int[] array = new int[lengthOfArray];
        for (int i = 0; i < lengthOfArray; i++) {
            System.out.print("A[" + i + "] = ");
            array[i] = sc.nextInt();
        }

        return array;
    }

    public static int[] inputByRandomNumber(Scanner sc) {
        System.out.println("Enter length of Array");
        int lengthOfArray = sc.nextInt();

        int min = 1;
        int max = (int) Math.pow(10, 5);
        int range = max - min + 1;
        int[] array = new int[lengthOfArray];

        for (int i = 0; i < lengthOfArray; i++) {
            array[i] = (int) (Math.random() * range) + min;
        }

        return array;
    }

    public static void printArray(int[] array) {
        System.out.print("Array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t" + array[i]);
        }
        System.out.println();
    }

    public static int[] cloneArray(int[] array) {
        int[] arrayClone = new int[array.length];

        for (int i = 0; i < arrayClone.length; i++) {
            arrayClone[i] = array[i];
        }

        return arrayClone;
    }

    public static void main(String[] args) {
        int[] array = inputByRandomNumber(new Scanner(System.in));
        int[] arrayClone = cloneArray(array);
        printArray(array);
        System.out.println();

        // bubble sort
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
        printArray(array);
        System.out.println("Count compare: " + bubbleSort.getCountCompare());
        System.out.println("Count swap: " + bubbleSort.getCountSwap());

        System.out.println();
        array = cloneArray(arrayClone);

        //insertion sort
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(array);
        printArray(array);
        System.out.println("Count compare: " + insertionSort.getCountCompare());
        System.out.println("Count swap: " + insertionSort.getCountSwap());

        System.out.println();
        array = cloneArray(arrayClone);
        
        //selection sort
        SelectionSort selcSelectionSort = new SelectionSort();
        selcSelectionSort.sort(array);
        printArray(array);
        System.out.println("Count compare: " + selcSelectionSort.getCountCompare());
        System.out.println("Count swap: " + selcSelectionSort.getCountSwap());

        System.out.println();
        array = cloneArray(arrayClone);

        //merge sort
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array);
        printArray(array);
        System.out.println("Count compare: " + mergeSort.getCountCompare());
        System.out.println("Count swap: " + mergeSort.getCountSwap());
    }
}
