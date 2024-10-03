package hus.dsa.homework2.lab16;

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }

}
class GFG{
    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){

            int n = sc.nextInt();

            Node head = new Node(sc.nextInt());
            Node tail = head;

            for(int i=0; i<n-1; i++)
            {
                Node newNode = new Node(sc.nextInt());
                newNode.next=head;
                head=newNode;
            }
            tail.next=head;

            Solution ob = new Solution();
            ob.printList(head);
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java


/* Node of a linked list
 class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }

}
*/

class Solution
{
    /* Function to print nodes in a given Circular linked list */
    void printList(Node head)
    {
        // Your code here

        Node currentNode = head;
        System.out.print(currentNode.data + " ");
        currentNode = currentNode.next;

        while (currentNode != head ) {

            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    public Node sortedInsert(Node head, int data) {
        // code here
        Node temp = new Node(data);

        if (head == null) {
            temp = temp.next;

            return temp;
        }

        Node currNode = head;

        // trường hợp data > data của head
        if (currNode.data > data) {
            while (currNode.next != head) {
                currNode = currNode.next;
            }

            currNode.next = temp;
            temp.next = head;

            return temp;
        }

        while (currNode.next != head && currNode.next.data > data) {
            currNode = currNode.next;
        }

        temp.next = currNode.next;
        currNode.next = temp;

        return head;
    }

    Node reverse(Node head) {
        Node temp = head;

        Stack<Node> stack = new Stack<>();

        while (temp.next != head) {
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

            temp.next = head;
        }

        return head;
    }

    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        if (head.data == key) {
            head = null;

            return head;
        }

        Node temp = head;

        if (head.data == key) {
            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = head.next;
            temp = temp.next;

            return temp;
        }

        while (temp.next != head && temp.next.data != key) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }
}
