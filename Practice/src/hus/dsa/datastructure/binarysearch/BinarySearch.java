package hus.dsa.datastructure.binarysearch;

import java.util.Arrays;

public class BinarySearch {
    static int binarySearch(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int m = left + (right - left) / 2;

            if (array[m] == value) {
                return m;
            }

            if (array[m] < value) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 5, -12, 100, 62, 91, -1, 45, 50, 12, 11, 50};
        Arrays.sort(array);

        System.out.println("value = " + -12 + " after sort at index = " + binarySearch(array, -12));
    }
}
