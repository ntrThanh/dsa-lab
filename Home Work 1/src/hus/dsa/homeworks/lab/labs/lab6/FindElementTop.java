package hus.dsa.homeworks.lab.labs.lab6;

public class FindElementTop {
    public static int findElementTopMin(int k, int array[]) {
        sortIncrease(array);

        return array[k - 1];
    }

    public static void sortIncrease(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static int findElementTopMax(int k, int array[]) {
        sortDecrease(array);

        return array[k - 1];
    }

    public static void sortDecrease(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int array[] = {1, 2, 7, 1, -1, -5, 10, 12};
        System.out.println(findElementTopMax(8, array));
    }
}
