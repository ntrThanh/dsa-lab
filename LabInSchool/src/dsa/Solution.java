package dsa;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    // NPuzzle
    public Iterable<int[][]> neighbors(int[][] m) {
        List<int[][]> list = new LinkedList<>();

        int zeroCol = -1, zeroRow = -1;

        // find position of zero
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] == 0) {
                    zeroCol = j;
                    zeroRow = i;
                    break;
                }
            }

            if (zeroCol != -1 || zeroRow != -1) {
                break;
            }
        }

        int[][] move = new int[][] {
                {-1, 0} // up
                , {1, 0} // down
                , {0, 1} // right
                , {0, -1} // left
        };

        for (int i = 0; i < move.length; i++) {
            int newRow = zeroRow + move[i][0];
            int newCol = zeroCol + move[i][1];

            if (check(newRow, newCol, m.length, m.length)) {
                int[][] array = new int[m.length][m.length];

                for (int j = 0; j < array.length; j++) {
                    for (int k = 0; k < array.length; k++) {
                        array[j][k] = m[j][k];
                    }
                }

                array[zeroRow][zeroCol] = array[newRow][newCol];
                array[newRow][newCol] = 0;

                list.add(array);
            }
        }


        return list;
    }

    boolean check(int currRow, int currClo, int row, int col) {
        return currRow >= 0
                && currRow < row
                && currClo >= 0
                && currClo < col;
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {8, 1, 3, 35, 34, 33},
                {4, 0, 2, 32, 31, 30},
                {7, 6, 5, 29, 28, 27},
                {26, 25, 24, 23, 22, 21},
                {20, 19, 18, 17, 16, 15},
                {14, 13, 12, 11, 10, 9}
        };

        new Solution().neighbors(arr);
    }
}
