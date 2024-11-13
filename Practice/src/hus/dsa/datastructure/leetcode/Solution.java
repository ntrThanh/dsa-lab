package hus.dsa.datastructure.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    // check ver 1
    public boolean isValidSudoku(char[][] board) {

        // check col
        for (int i = 0; i < board.length; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < board.length; j++) {
                if (isInteger(board[j][i])) {
                    if (!list.contains(board[j][i])) {
                        list.add(board[j][i]);
                    } else {
                        return false;
                    }
                }
            }
        }

        // check row
        for (int i = 0; i < board.length; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < board.length; j++) {
                if (isInteger(board[i][j])) {
                    if (!list.contains(board[i][j])) {
                        list.add(board[i][j]);
                    } else {
                        return false;
                    }
                }
            }
        }

        // check square
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {

                // square 3 x 3
                List<Character> list = new ArrayList<>();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (isInteger(board[k][l])) {
                            if (!list.contains(board[k][l])) {
                                list.add(board[k][l]);
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, k, i, j)) {
                            board[i][j] = k;

                            if (solve(board)) {
                                return true;
                            } else { // backtracking
                                board[i][j] = '.';
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }


    boolean isInteger(char s) {
        try {
            Integer.parseInt(s + "");
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    // check ver 2
    boolean checkRow(char[][] board, char curr, int row) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == curr) {
                return true;
            }
        }

        return false;
    }

    boolean checkCol(char[][] board, char curr, int col) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == curr) {
                return true;
            }
        }

        return false;
    }

    boolean checkSquare(char[][] board, char curr, int row, int col) {
        int localRow = row - row % 3;
        int localCol = col - col % 3;

        for (int i = localRow; i < localRow + 3; i++) {
            for (int j = localCol; j < localCol + 3; j++) {
                if (board[i][j] == curr) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean isValid(char[][] board, char curr, int row, int col) {
        return !checkCol(board, curr, col) && !checkRow(board, curr, row) && !checkSquare(board, curr, row, col);
    }


    public int longestValidParentheses(String s) {

        if (s.length() == 1 || s.equals("")) {
            return 0;
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else  {
                if (stack.isEmpty()) {
                    count = 0;
                } else if (stack.peek() == '(') {
                    stack.pop();
                    count++;
                    list.add(count);
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i)) {
                max = list.get(i);
            }
        }

        return max * 2;
    }


}
