package hus.dsa.homework4.lab3;

import hus.dsa.homework4.lab2.LinkedListStack;

public class SolveExpr {
    public static int solveExpr(String s) {
        LinkedListStack<String> operand = new LinkedListStack<>();
        LinkedListStack<String> operator = new LinkedListStack<>();

        for (int i = 0; i < s.length(); i++) {
            if (isInteger(s.charAt(i) + "")) {
                operand.push(s.charAt(i) + "");
            } else if (s.charAt(i) == '+' ||
                    s.charAt(i) == '-' ||
                    s.charAt(i) == '*' ||
                    s.charAt(i) == '/') {
                operator.push(s.charAt(i) + "");
            } else if (s.charAt(i) == ')') {
                int result = 0;
                int value1 = Integer.parseInt(operand.pop());
                int value2 = Integer.parseInt(operand.pop());

                String currOperator = operator.pop();

                if (currOperator.equals("+")) {
                    result = value2 + value1;
                } else if (currOperator.equals("-")) {
                    result = value2 - value1;
                } else if (currOperator.equals("*")) {
                    result = value2 * value1;
                } else if (currOperator.equals("/")) {
                    result = value2 / value1;
                }

                operand.push(result + "");
            } else {
                continue;
            }
        }

        return Integer.parseInt(operand.pop());
    }

    public static void main(String[] args) {
        System.out.println(solveExpr("(1 + ((2 + 3) * (8 * 5)))"));
    }
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
