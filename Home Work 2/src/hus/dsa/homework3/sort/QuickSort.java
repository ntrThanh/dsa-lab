package hus.dsa.homework3.sort;

public class QuickSort implements Sort {
    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public void sort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);

            sort(array, left, pivot - 1);
            sort(array, pivot + 1, right);
        }
    }


    public int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int k = left - 1;

        for (int i = left; i <= right - 1; i++) {
            if (array[i] < pivot) {
                k++;
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
        }

        int temp = array[right];
        array[right] = array[k + 1];
        array[k + 1] = temp;

        return k + 1;
    }



}
