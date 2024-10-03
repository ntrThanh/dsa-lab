package hus.dsa.homework3.patition;

public class QuickSortPartition {
    public static int partition(int[] array) {
        int position = -1;
        double key = getAverage(array);

        for (int i = 0; i < array.length; i++) {
            if (array[i] < key) {
                position++;
            }
        }

        return position;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        System.out.println(getAverage(array));
        System.out.println(partition(array));
    }

    public static double getAverage(int[] array) {
        int avg = 0;

        for (int i = 0; i < array.length; i++) {
            avg += array[i];
        }

        return (double) avg / array.length;
    }
}
