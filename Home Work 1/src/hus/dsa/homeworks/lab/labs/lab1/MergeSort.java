package hus.dsa.homeworks.lab.labs.lab1;

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

    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public void mergeArray(int[] array, int l, int m ,int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] array1 = new int[n1];
        int[] array2 = new int[n2];

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
            if (array1[i] <= array2[j]) {
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

    public void sort(int[] array, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            sort(array, l, m);
            sort(array, m + 1, r);

            mergeArray(array, l, m, r);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 4, 1, 9, 2, -1, -4, 10};

        new MergeSort().sort(array);

        Lab1.printArray(array);
    }
}
