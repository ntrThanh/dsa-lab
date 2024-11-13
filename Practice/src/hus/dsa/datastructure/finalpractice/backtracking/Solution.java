package hus.dsa.datastructure.finalpractice.backtracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static int factory(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }

        return factory(number - 1) * number;
    }

    public static int fibonaci(int n) {
        if (n < 2) {
            return n;
        }

        return fibonaci(n - 1) + fibonaci(n - 2);
    }

    public static void towerOfHanoi(int number, char a, char b, char c) {
        if (number == 1) {
            System.out.println(a + " -> " + c);
        } else {
            towerOfHanoi(number - 1, a, c, b);
            towerOfHanoi(1, a, b, c);
            towerOfHanoi(number - 1, b, a, c);
        }
    }

    public static List<int[]> generateNumberOfBinary(int number) {
        List<int[]> result = new LinkedList<>();
        int[] arr = new int[number];

        generateVerTwo(result, arr, 0, number);

        return result;
    }

    public static void generate(List<int[]> list, int[] arr, int index, int number) {
        if (index == number) {
            list.add(arr.clone());
            return;
        }

        for (int i = 0; i <= 1; i++) {
            arr[index] = i;

            generate(list, arr, index + 1, number);

            arr[index] = i;
        }
    }

    public static void generateVerTwo(List<int[]> list, int[] arr, int index, int number) {
        for (int i = 0; i <= 1; i++) {
            arr[index] = i;

            if (index == number - 1) {
                list.add(arr.clone());
            } else {
                generateVerTwo(list, arr, index + 1, number);
            }
        }
    }


    public static boolean contain(List<int[]> list, int[] arr) {
        for (int[] a : list) {
            for (int i = 0; i < arr.length; i++) {
                if (a[i] != arr[i]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void print(List<int[]> list) {
        for (int[] a : list) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }

    public static int numberOfPathRobot(int n, int m) {
        if (n == 0 && m == 0) {
            return 0;
        }

        if (n == 0 || m == 0) {
            return 1;
        }

        return numberOfPathRobot(n - 1, m) + numberOfPathRobot(n, m - 1);
    }

    public static int numberOfPathRobotVer2(int[][] map, int n, int m) {
        if (map[m][n] == 1) {
            return 0;
        }

        if (n == 0 && m == 0) {
            return 0;
        }

        if (n == 0 || m == 0) {
            return 1;
        }

        return numberOfPathRobotVer2(map, n - 1, m) + numberOfPathRobotVer2(map, n, m - 1);
    }

    public String addBinary(String a, String b) {
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        boolean isDoubleOne = false;
        Stack<String> stack = new Stack<>();

        while (indexA >= 0 || indexB >= 0) {
            String tempA = (indexA >= 0) ? a.charAt(indexA) + "" : "0";
            String tempB = (indexB >= 0) ? b.charAt(indexB) + "" : "0";

            String result = add(tempA, tempB);

            if (isDoubleOne) {
                result = add(result, "1");
                isDoubleOne = result.equals("0");
            }

            if ("1".equals(tempA) && "1".equals(tempB)) {
                isDoubleOne = true;
            }

            stack.push(result);

            indexA--;
            indexB--;
        }

        // Xử lý bit nhớ cuối cùng nếu cần
        if (isDoubleOne) {
            stack.push("1");
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public String add(String left, String right) {
        if ((left.equals("0") && right.equals("0"))
                || (left.equals("1") && right.equals("1"))) {
            return "0";
        } else {
            return "1";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11", "1"));
    }
}
