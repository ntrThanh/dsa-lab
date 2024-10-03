package hus.dsa.homework3.stack;

import java.util.Stack;

public class CheckExpr {
    public boolean isValidExpr(String expr) {
        boolean check = true;
        Stack<String> charOfString = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') {
                charOfString.push(expr);
            }

            if (expr.charAt(i) == ')') {
                if (charOfString.isEmpty()) {
                    return false;
                } else {
                    charOfString.pop();
                }
            }
        }

        return charOfString.isEmpty();
    }

    public static void main(String[] args) {
        String temp = "a + (b + (c * (a - e))";

        System.out.println(new CheckExpr().isValidExpr(temp));
    }
}
