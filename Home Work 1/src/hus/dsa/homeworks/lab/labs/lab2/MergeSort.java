package hus.dsa.homeworks.lab.labs.lab2;

import java.lang.reflect.Array;

public class MergeSort {
    private int countSwap;
    private int countCompare;

    public MergeSort() {
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
        sort(array, 0, array.length - 1);
    }

    public <T extends Comparable<T>> void mergeArray(T[] array, int l, int m ,int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        @SuppressWarnings("unchecked")
        T[] array1 = (T[]) Array.newInstance(array.getClass().getComponentType(), n1);

        @SuppressWarnings("unchecked")
        T[] array2 = (T[]) Array.newInstance(array.getClass().getComponentType(), n2);

        for (int i = 0; i < array1.length; i++) {
            array1[i] = array[i + l];
        }

        for (int i = 0; i < array2.length; i++) {
            array2[i] = array[i + m + 1];
        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            countCompare++;
            countSwap++;
            if (array2[j].compareTo(array1[i]) > 0) {
                array[k] = array1[i];
                i++;
            } else {
                array[k] = array2[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            array[k] = array1[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = array2[j];
            j++;
            k++;
        }
    }

    public <T extends Comparable<T>> void sort(T[] array, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            sort(array, l, m);
            sort(array, m + 1, r);

            mergeArray(array, l, m, r);
        }
    }
}
