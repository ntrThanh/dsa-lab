package hus.dsa.homeworks.lab.labs.lab2;

public class InsertionSort {
    private int countSwap;
    private int countCompare;

    public InsertionSort() {
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
        int n = array.length;

        for (int k = 1; k < n; k++) {
            T temp = array[k];
            int i = k;

            while (i > 0) {
                countCompare++;
                if (array[i - 1].compareTo(array[i]) > 0) {
                    countSwap++;
                    T current = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = current;
                    i--;
                } else {
                    break;
                }
            }

            array[i] = temp;
        }
    }
}
