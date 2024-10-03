package hus.dsa.homework2.lab10;

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;

            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }

            Solution ob = new Solution();
            head = ob.reverseList(head);
            printList(head);
            t--;
        }
    }
}

// } Driver Code Ends


// function Template for Java

/* linked list node class:

class Node {
    int data;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

class Solution {
    // Function to reverse a linked list.
    Node reverseList(Node head) {
        // code here
        Stack<Node> stack = new Stack<>();

        Node temp = head;

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        if (!stack.isEmpty()) {
            head = stack.pop();
            temp = head;

            while (!stack.isEmpty()) {
                temp.next = stack.pop();
                temp = temp.next;
            }
        }

        temp.next = null;


        return head;
    }
}

