package hus.dsa.datastructure.finalpractice.backtracking;

public class SudokuVersion2 {
    public static boolean checkRow(int[][] board, int row, int number) {
        for (int i = 0; i < row; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkColumn(int[][] board, int col, int number) {
        for (int i = 0; i < col; i++) {
            if (board[i][col] == number) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkBox(int[][] board, int row, int col, int number) {
        int localRow = row - row % 3;
        int localCol = col - col % 3;

        for (int i = localRow; i < localRow + 3; i++) {
            for (int j = localCol; j < localCol + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean check(int[][] board, int row, int col, int number) {
        return !checkRow(board, row, number)
                && !checkColumn(board, col, number)
                && !checkBox(board, row, col, number);
    }

    public static boolean solve(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        board[i][j] = k;

                        if (check(board, i, j, k)) {
                            return solve(board);
                        } else {
                            board[i][j] = 0;
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }
}
