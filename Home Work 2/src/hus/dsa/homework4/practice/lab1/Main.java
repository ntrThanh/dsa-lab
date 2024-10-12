package hus.dsa.homework4.practice.lab1;

import java.util.Stack;

public class Main {
    public static String encodeString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            int j = i;

            sb.append(s.charAt(i));

            while (j + 1 < s.length() && (s.charAt(j) == s.charAt(j + 1))) {
                count++;
                j++;
            }
            if (count != 1) {
                i = j;
            }

            sb.append(count);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(encodeString("a"));
    }
}
