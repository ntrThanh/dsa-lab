package hus.dsa.homework3.sort;

public class InsertionSort implements Sort {
    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int index = i - 1;
            int temp = array[i];

            while (index >= 0 && temp < array[index]) {
                array[index + 1] = array[index];
                index--;
            }

            array[index + 1] = temp;
        }
    }
}
