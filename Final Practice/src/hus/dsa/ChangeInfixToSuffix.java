package hus.dsa;

import java.util.Stack;

public class ChangeInfixToSuffix {
    public static String[] change(String[] tokens) {
        Stack<String> operator = new Stack<>();
        Stack<String> operand = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String currString = tokens[i];

            if (isOperand(currString)) {
                operand.push(currString);
            } else if (priorityOfOperator(currString) < 6) {
                if (operator.isEmpty()
                        || operator.peek().equals("(")
                        || priorityOfOperator(operator.peek()) < priorityOfOperator(currString)) {
                    operator.push(currString);
                } else {
                    while (!operator.isEmpty()
                            && priorityOfOperator(operator.peek()) >= priorityOfOperator(currString) && !operator.peek().equals("(")) {
                        operand.push(operator.pop());
                    }

                    operator.push(currString);
                }
            } else if (priorityOfOperator(currString) == 6 || currString.equals("(")) {
                operator.push(currString);
            } else if (currString.equals(")")) {
                while (!operator.isEmpty() && !operator.peek().equals("(")) {
                    String s = operator.pop();
                    operand.push(s);
                }

                operator.pop();
            }
        }

        while (!operator.isEmpty()) {
            operand.push(operator.pop());
        }

        return convert(operand);
    }

    public static String[] convert(Stack<String> stack) {
        String[] result = new String[stack.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static boolean isOperand(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void print(String[] array) {
        for (String a : array) {
            System.out.print(a);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        print(new String[]{"(","6", "/", "3","+","2",")", "*", "(", "7", "-", "4",")"});
        print(change(new String[]{"(", "6", "/", "3", "+", "2", ")", "*", "(", "7", "-", "4", ")"}));
    }

    public static int priorityOfOperator(String s) {
        if ("^".contains(s)) {
            return 6;
        } else if ("*/".contains(s)) {
            return 5;
        } else if ("-+".contains(s)) {
            return 4;
        } else {
            return 1000;
        }
    }
}
