package hus.dsa.homeworks.lab.labs.lab1;

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

    public void sort(int[] array) {
        int n = array.length;

        for (int k = 1; k < n; k++) {
            int temp = array[k];
            int i = k;

            while (i > 0) {
                countCompare++;
                if (array[i] < array[i - 1]) {
                    countSwap++;
                    int current = array[i];
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

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 4, 1, 9, 2, -1, -4, 10};

        new InsertionSort().sort(array);

        Lab1.printArray(array);
    }
}
