package hus.dsa.homework3.sort;

public class MergeSort implements Sort {
    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public void sort(int[] array, int left, int right) {
        if (left < right) {
            int p = left + (right - left) / 2;

            sort(array, left, p);
            sort(array, p + 1, right);
            merge(array, left, p, right);
        }
    }

    public void merge(int[] array, int left, int p, int right) {
        int n1 = p - left + 1;
        int n2 = right - p;

        int[] array1 = new int[n1];
        int[] array2 = new int[n2];

        for (int i = 0; i < array1.length; i++) {
            array1[i] = array[left + i];
        }

        for (int i = 0; i < array2.length; i++) {
            array2[i] = array[p + 1 + i];
        }

        int i = 0; int j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (array1[i] >= array2[j]) {
                array[k] = array2[j];
                j++;
            } else {
                array[k] = array1[i];
                i++;
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
}
