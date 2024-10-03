package hus.dsa.homework3.exprstring;

import java.util.*;

public class FormulaEval {
    public static void printString(String[] character) {
        for (int i = 0; i < character.length; i++) {
            if (character[i].equals(" ")) {
                continue;
            }
            System.out.print("\"" + character[i] + "\"" + "\t");
        }

        System.out.println();
    }

    public static boolean isInteger(String character) {
        try {
            Integer.parseInt(character);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String[] decayString(String string) {
        String[] strings = string.split("");
        List<String> listStringResult = new LinkedList<>();

        String currentString;

        for (int i = 0; i < strings.length; i++) {
            currentString = strings[i];

            if (isInteger(strings[i])) {
                StringBuilder tempString = new StringBuilder();
                int j = i;

                while (isInteger(strings[j]) || strings[j].equals(".")) {
                    tempString.append(strings[j]);
                    j++;
                }

                currentString = tempString.toString();
                i = j - 1;
            }

            listStringResult.add(currentString);
        }

        return listStringResult.toArray(new String[listStringResult.size()]);
    }

    public static double eval(String formula) {
        String[] arrayOfCharacter = decayString(formula);

        Stack<String> operator = new Stack<>();
        Stack<String> operand = new Stack<>();

        for (int i = 0; i < arrayOfCharacter.length; i++) {
            if (isDouble(arrayOfCharacter[i])) {
                operand.push(arrayOfCharacter[i]);
            } else if (isOperator(arrayOfCharacter[i])) {
                operator.push(arrayOfCharacter[i]);
            } else if (arrayOfCharacter[i].equals(")")) {
                double result = 0;
                double value1 = Double.parseDouble(operand.pop());
                double value2 = Double.parseDouble(operand.pop());

                String currentOperator = operator.pop();
                if (currentOperator.equals("+")) {
                    result = value2 + value1;
                } else if (currentOperator.equals("-")) {
                    result = value2 - value1;
                } else if (currentOperator.equals("*")) {
                    result = value2 * value1;
                } else if (currentOperator.equals("/")) {
                    result = value2 / value1;
                }

                operand.push(result + "");
            }
        }


        return Double.parseDouble(operand.pop());
    }

    public static void main(String[] args) {
        System.out.println(eval("(1 + ((2 + 3) * (4 * 5)))"));
    }

    public static boolean isDouble(String character) {
        try {
            Double.parseDouble(character);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isOperator(String c) {
        if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
            return true;
        }

        return false;
    }
}
