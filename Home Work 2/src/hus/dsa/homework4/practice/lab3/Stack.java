package hus.dsa.homework4.practice.lab3;

public class Stack {
    private int[] arr;
    private int top;

    public Stack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        // Your Code
        arr[++top] = x;
    }

    public int pop() {
        // Your Code
        if(top < 0) {
            return -1;
        }
        return arr[top--];
    }
}
