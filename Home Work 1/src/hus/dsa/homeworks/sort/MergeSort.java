package hus.dsa.homeworks.sort;

public class MergeSort {
    public static void mergeArray(int[] array, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] arrayLeft = new int[n1];
        int[] arrayRight = new int[n2];

        // copy data to two current array
        for (int i = 0; i < arrayLeft.length; i++) {
            arrayLeft[i] = array[l + i];
        }   

        for (int j = 0; j < arrayRight.length; j++) {
            arrayRight[j] = array[m + 1 + j];
        }

        int i = 0, j = 0;

        // variable k is first element of array
        int k = l;
        while (i < n1 && j < n2) {
            if (arrayLeft[i] <= arrayRight[j]) {
                array[k] = arrayLeft[i];
                i++;
            } else {
                array[k] = arrayRight[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            array[k] = arrayLeft[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = arrayRight[j];
            j++;
            k++;
        }
    }

    public static void sort(int[] array, int l, int r) {
        if (l < r) {
            // divided array by index
            int m = l + (r - l) / 2;

            sort(array, l, m);
            sort(array, m + 1, r);

            mergeArray(array, l, m, r);
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 6, 1, 3, 9, 0, 2, 3, 4};

        sort(array, 0, array.length - 1);
        printArray(array);
    }
}
