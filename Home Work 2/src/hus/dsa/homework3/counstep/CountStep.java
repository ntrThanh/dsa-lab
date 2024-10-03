package hus.dsa.homework3.counstep;

public class CountStep {

    public static void main(String[] args) {
        int[][] array = new int[3][7];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = 1;
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(countStep(array));
    }

    public static int countStep(int[][] array) {
        return count(array, 0, 0);
    }

    public static int count(int array[][], int i, int j) {
        int down = i;
        int right = j;

        if (down == array.length - 1 && right == array[0].length - 1) {
            return 1;
        } else if (down >= array.length  || right >= array[0].length) {
            return 0;
        }

        return count(array, down + 1, right) + count(array, down, right + 1);
    }
}
