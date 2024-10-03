package hus.dsa.homeworks.lab.labs.lab2;

public class BubbleSort {
    private int countSwap;
    private int countCompare;

    public BubbleSort() {
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

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                countCompare++;
                if (array[j + 1].compareTo(array[j]) > 0) {
                    countSwap++;
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
