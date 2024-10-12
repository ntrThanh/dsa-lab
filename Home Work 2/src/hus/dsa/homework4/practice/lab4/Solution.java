package hus.dsa.homework4.practice.lab4;

import java.util.Stack;

public class Solution {
    // Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s, int sizeOfStack) {
        // code here
        s.remove((sizeOfStack  - 1) / 2);
    }
}

