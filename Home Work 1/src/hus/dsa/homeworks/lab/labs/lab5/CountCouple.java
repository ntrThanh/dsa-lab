package hus.dsa.homeworks.lab.labs.lab5;

public class CountCouple {
    public static int countCouple(int[] array, int k) {

        int count = 0;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void sort(int array[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(array, l, m);
            sort(array, m + 1, r);

            merge(array, l, m, r);
        }
    }

    public static void  merge(int[] array, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] arrayLeft = new int[n1];
        int[] arrayRight = new int[n2];

        for (int i = 0; i < arrayLeft.length; i++) {
            arrayLeft[i] = array[l + i];
        }

        for (int i = 0; i < arrayRight.length; i++) {
            arrayRight[i] = array[m + i + 1];
        }

        int i = 0, j = 0;

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

    public static int binarySearch(int array[], int k) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int m =  left + (right - left) / 2;
            if (array[m] < k) {
                left = m + 1;
            } else if (array[m] > k) {
                right = m - 1;
            } else {
                return m;
            }
        }

        return -1;
    }

    public static int countCoupleByBinarySearch(int array[], int k) {
        sort(array, 0, array.length - 1);
        int count = 0;

        for (int i = 1; i < array.length; i++) {
            int current = k - array[i];
            if (binarySearch(array, current) != -1) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 4, 3, 4, 5, 3};
        // System.out.println(binarySearch(array, 4));
        System.out.println(countCouple(array, 3));
    }
}
