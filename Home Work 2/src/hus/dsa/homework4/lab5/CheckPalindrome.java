package hus.dsa.homework4.lab5;

import hus.dsa.homework4.lab2.LinkedListStack;
import hus.dsa.homework4.lab4.ArrayQueue;

public class CheckPalindrome {
    public static boolean checkPalindrome(String string) {
        ArrayQueue<String> str1 = new ArrayQueue<>();
        LinkedListStack<String> str2 = new LinkedListStack<>();

        for (int i = 0; i < string.length(); i++) {
            str1.enqueue(string.charAt(i) + "");
            str2.push(string.charAt(i) + "");
        }

        for (int i = 0; i < string.length(); i++) {
            if (!str1.dequeue().equals(str2.pop())) {
                return false;
            }  
        }

        return true; 
    }

    public static void main(String[] args) {
        System.out.println(checkPalindrome("abbbbbbbbab"));
    }
}
