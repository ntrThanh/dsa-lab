package hus.dsa.homework4.practice.lab3;

public class MyStack {
     class StackNode {
         int data;
         StackNode next;
         StackNode(int a) {
             data = a;
             next = null;
         }
     }
    StackNode top;

    // Function to push an integer into the stack.
    void push(int a) {
        // Add your code here
        if(top == null) {
            top = new StackNode(a);
        } else {
            StackNode currentNode = new StackNode(a);
            currentNode.next = top;
            top = currentNode;
        }
    }

    // Function to remove an item from top of the stack.
    int pop() {
        if(top == null) {
            return -1;
        }

        int temp = top.data;

        top = top.next;

        return temp;
        // Add your code here
    }
}