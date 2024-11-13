package hus.dsa.datastructure.finalpractice.expr;

import java.util.Stack;

public class Solve {
    int solve(String[] strings) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];

            if (isInteger(s)) {
                stack.push(s);
            } else if (isUnaryOperator(s)) {
                int curr = Integer.parseInt(stack.pop());
                if (s.equals("expr")) {
                    curr = (int) Math.sqrt(curr);
                }

                stack.push(curr + "");
            } else {
                int after = Integer.parseInt(stack.pop());
                int before = Integer.parseInt(stack.pop());
                int result = Integer.MIN_VALUE;

                if (s.equals("+")) {
                    result = before + after;
                } else if (s.equals("-")) {
                    result = before - after;
                } else if (s.equals("*")) {
                    result = before * after;
                } else if (s.equals("/")) {
                    result = before / after;
                } else if (s.equals("^")) {
                    result = (int) Math.pow(before, after);
                }

                stack.push(result + "");
            }
        }

        return Integer.parseInt(stack.pop());
    }

    boolean isUnaryOperator(String s) {
        return "expr".contains(s);
    }

    public static void main(String[] args) {
        String[] s = new String[]{"2", "4", "9", "expr", "-", "+", "4", "2", "^", "*"};
        System.out.println(new Solve().solve(s));
    }

    boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}