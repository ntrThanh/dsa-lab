package hus.dsa.homework4.practice.lab2;

import hus.dsa.homework4.lab4.ArrayQueue;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void revert(Integer[] array, int k) {
        ArrayQueue<Integer> arrayDeque = new ArrayQueue<>();

        for (int i = 0; i < array.length; i++) {
            arrayDeque.enqueue(array[i]);
        }

        for (int i = 0; i < k; i++) {
            int temp = arrayDeque.dequeue();
            arrayDeque.enqueue(temp);
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = arrayDeque.dequeue();
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 6, 3, 5, 2, 3};
        System.out.println(Arrays.deepToString(arr));

        revert(arr, 3);
        System.out.println(Arrays.deepToString(arr));
    }
}
