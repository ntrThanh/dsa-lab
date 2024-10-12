package hus.dsa.homework4.practice.lab5;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<String> chars = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (checkIsOpenBracket(s.charAt(i))) {
                chars.push(s.charAt(i) + "");
            } else {
                if (chars.isEmpty()) {
                    return false;
                }

                if ((chars.peek().equals("[") && s.charAt(i) == ']')) {
                    chars.pop();
                } else if ((chars.peek().equals("{") && s.charAt(i) == '}')) {
                    chars.pop();
                } else if ((chars.peek().equals("(") && s.charAt(i) == ')')) {
                    chars.pop();
                } else {
                    return false;
                }
            }
        }

        return chars.isEmpty();
    }

    public boolean checkIsOpenBracket(char s) {
        if (s == '(' || s == '[' || s == '{') {
            return true;
        }

        return false;
    }
}