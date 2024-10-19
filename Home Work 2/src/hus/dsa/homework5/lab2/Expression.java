package hus.dsa.homework5.lab2;


import java.util.Stack;

public class Expression {
    public String[] changeInfixToSuffix(String[] token) {
        Stack<String> operand = new Stack<>();
        Stack<String> operator = new Stack<>();

        for (int i = 0; i < token.length; i++) {
            if (checkInteger(token[i])) {
                operand.push(token[i]);
            } else if (checkOperator(token[i]) < 6) {
                if (operator.isEmpty()
                        || checkOperator(operator.peek()) < checkOperator(token[i])
                        || operator.peek().equals("(")) {
                    if (!token[i].equals(")")) {
                        operator.push(token[i]);
                    }
                } else {
                    while (!operator.isEmpty() && checkOperator(operator.peek()) >= checkOperator(token[i]) && !operator.peek().equals("(")) {
                        if (!operator.peek().equals("(")) {
                            String currOperator = operator.pop();
                            operand.push(currOperator);
                        } else {
                            operator.pop();
                        }
                    }

                    if (!token[i].equals(")")) {
                        operator.push(token[i]);
                    }
                }
            } else if (checkOperator(token[i]) == 6 || token[i].equals("(")) {
                if (!token[i].equals(")")) {
                    operator.push(token[i]);
                }
            } else if (token[i].equals(")")) {
                while (!operator.isEmpty() && !operator.peek().equals("(")) {
                    operand.push(operator.pop());
                }

                operator.pop();
            }
        }

        while (!operator.isEmpty()) {
            operand.push(operator.pop());
        }

        return changeStackToArrayString(operand);
    }

    public String[] changeStackToArrayString(Stack<String> stack) {
        String[] result = new String[stack.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
    public boolean checkInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] s = {"-", "3", "+", "4", "^", "5", "^", "a", "/", "2", "-", "7"};
        printArray(s);
        System.out.println();
        printArray(new Expression().changeInfixToSuffix(s));
    }

    public static void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int checkOperator(String s) {
        if (s.equals("^") || s.equals("!")
                || s.equals("~") || s.equals("abs")
                || s.equals("sin") || s.equals("cos")
                || s.equals("tan") || s.equals("ln")
                || s.equals("exp") || s.equals("lg")
                || s.equals("round") || s.equals("sqrt")) {
            return 6;
        } else if (s.equals("*") || s.equals("/")) {
            return 5;
        } else if (s.equals("+") || s.equals("-")) {
            return 4;
        } else {
            return 100;
        }

    }
}
