package hus.dsa.datastructure.sort;

public class Sort {
    void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }

    void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int index = i - 1;

            while (index >= 0 && array[index] > key) {
                array[index + 1] = array[index];
                index--;
            }

            array[index + 1] = key;
        }
    }

    void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < L.length; i++) {
            L[i] = array[i + left];
        }

        for (int i = 0; i < R.length; i++) {
            R[i] = array[mid + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int k = partitionArray(array, left, right);
            quickSort(array, left, k - 1);
            quickSort(array, k + 1, right);
        }

    }

    int partitionArray(int[] array, int left, int right) {
        int index = left - 1;
        int key = array[right];

        for (int i = left; i < right; i++) {
            if (key > array[i]) {
                index++;
                swap(array, index, i);
            }
        }

        swap(array, right, index + 1);

        return index + 1;
    }

    void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 7, 1, 7, 2, 5, 2, -1, 0};

        new Sort().quickSort(array);

        printArray(array);
    }

}
