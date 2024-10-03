package hus.dsa.homework3.sort;

public class BubbleSort implements Sort {
    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean checked = false;

            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    checked = true;
                }
            }

            if (!checked) {
                break;
            }
        }
    }
}
