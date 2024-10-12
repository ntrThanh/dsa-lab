package hus.dsa.homework4.lab3;

import hus.dsa.homework4.lab2.LinkedListStack;

public class CheckExpr {
    public static boolean check(String s) {
        LinkedListStack<Character> listStack = new LinkedListStack<>();

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                listStack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (listStack.isEmpty()) {
                    return false;
                } else {
                    listStack.pop();
                }
            } else {
                continue;
            }
        }

        return listStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(check("(10 − 8/((2 + 5) ∗ 17)"));
    }
}
