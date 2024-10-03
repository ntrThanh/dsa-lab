package hus.dsa.homeworks.lab.labs.lab2;

import java.util.Scanner;

public class Lab2 {
    public static Integer[] inputByRandomNumber(Scanner sc) {
        System.out.println("Enter length of Array");
        int lengthOfArray = sc.nextInt();

        int min = 1;
        int max = (int) Math.pow(10, 5);
        int range = max - min + 1;
        Integer[] array = new Integer[lengthOfArray];

        for (int i = 0; i < lengthOfArray; i++) {
            array[i] = (int) (Math.random() * range) + min;
        }

        return array;
    }

    public static void printArray(Integer[] array) {
        System.out.print("Array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t" + array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] array = inputByRandomNumber(new Scanner(System.in));
        printArray(array);

        //insert sort
        // quick sort
        // bubble sort
        new MergeSort().sort(array);
        printArray(array);
    }
}
