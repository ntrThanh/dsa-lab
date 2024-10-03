package hus.dsa.homeworks.lab.labs.lab2;

import hus.dsa.homeworks.lab.labs.lab1.Lab1;

public class SelectionSort {
    private int countSwap;
    private int countCompare;

    public SelectionSort() {
        countCompare = 0;
        countSwap = 0;
    }

    public int getCountSwap() {
        return countSwap;
    }

    public int getCountCompare() {
        return countCompare;
    }

    public <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                countCompare++;
                if (array[j].compareTo(array[i]) > 0) {
                    countSwap++;
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
