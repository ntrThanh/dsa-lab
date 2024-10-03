package hus.dsa.homeworks.lab.labs.lab1;

public class SelectionSort {
    private int countSwap;
    private int countCompare;

    public SelectionSort() {
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
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                countCompare++;
                if (array[i] > array[j]) {
                    countSwap++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 4, 1, 9, 2, -1, -4, 10};

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(array);

        Lab1.printArray(array);
        System.out.println(selectionSort.getCountSwap());
    }
}
