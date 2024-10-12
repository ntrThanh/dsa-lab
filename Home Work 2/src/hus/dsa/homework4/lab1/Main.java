package hus.dsa.homework4.lab1;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        String name = "Nguyen Trong Thanh";

        for (int i = 0; i < name.length(); i++) {
            if (i % 2 == 0) {
                stack.push(name.charAt(i) + "");
            }

            if (i % 3 == 0) {
                stack.pop();
            }
        }

        System.out.println(stack);
    }
}
