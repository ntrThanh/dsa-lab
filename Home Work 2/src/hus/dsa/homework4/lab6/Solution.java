package hus.dsa.homework4.lab6;

import java.util.Stack;

public class Solution {
    public static int evaluatePostFix(String s)
    {
        // Your code here
        Stack<String> operand = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (isInteger(s.charAt(i) + "")) {
                operand.push(s.charAt(i) + "");
            } else {
                int value1 = Integer.parseInt(operand.pop());
                int value2 = Integer.parseInt(operand.pop());

                String operator = s.charAt(i) + "";

                if (operator.equals("+")) {
                    int result = value2 + value1;
                    operand.push(result + "");
                } else if (operator.equals("-")) {
                    int result = value2 - value1;
                    operand.push(result + "");
                } else if (operator.equals("*")) {
                    int result = value2 * value1;
                    operand.push(result + "");
                } else if (operator.equals("/")) {
                    int result = value2 / value1;
                    operand.push(result + "");
                }
            }
        }

        return Integer.parseInt(operand.pop());
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
