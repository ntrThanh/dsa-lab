package hus.dsa.datastructure.finalpractice.expr;

import java.util.Stack;

public class ChangInfixToSuffix {

    public String[] changInfixToSuffix(String[] array) {
        Stack<String> operator = new Stack<>();
        Stack<String> operand = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            String s = array[i];
            if (isInteger(s)) {
                operand.push(s);
            } else if (priorityOfOperator(s) < 6) {
                if (operator.isEmpty()
                        || operator.peek().equals("(")
                        || priorityOfOperator(operator.peek()) < priorityOfOperator(array[i])) {
                    operator.push(s);
                } else {
                    while (!operator.isEmpty() && priorityOfOperator(operator.peek()) >= priorityOfOperator(s) && !operator.peek().equals("(")) {
                        String curr = operator.pop();
                        operand.push(curr);
                    }

                    operator.push(s);
                }
            } else if (priorityOfOperator(s) == 6 || s.equals("(")) {
                operator.push(s);
            } else if (s.equals(")")) {
                while (!operator.isEmpty() && !operator.peek().equals("(")) {
                    operand.push(operator.pop());
                }

                operator.pop();
            }
        }

        while (!operator.isEmpty()) {
            operand.push(operator.pop());
        }


        return changStackToString(operand);
    }

    public static void main(String[] args) {
        String[] expr = new String[]{"(", "6", "/", "3", "+", "2", ")", "*", "(", "7", "-", "4", ")"};
        print(expr);
        print(new ChangInfixToSuffix().changInfixToSuffix(expr));
    }

    static void print(String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }

    String[] changStackToString(Stack<String> s) {
        String[] result = new String[s.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = s.pop();
        }

        return result;
    }

    boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    int priorityOfOperator(String s) {
        if ("^!~".contains(s)) {
            return 6;
        } else if ("*/%".contains(s)) {
            return 5;
        } else if ("+-".contains(s)) {
            return 4;
        } else {
            return 1000;
        }
    }
}
