package hus.dsa.homework2.lab14;

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        next = prev = null;
    }
}

class DLinkedList {

    Node newNode(Node head, int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            return head;
        }
        head.next = n;
        n.prev = head;
        head = n;
        return head;
    }

    void printList(Node node) {
        Node temp = node;
        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp.prev != null) {
            temp = temp.prev;
        }

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {

        DLinkedList DLL = new DLinkedList();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t > 0) {
            Node temp;
            Node head = null;
            Node root = null;
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(str[i]);
                head = DLL.newNode(head, x);
                if (root == null) root = head;
            }
            head = root;

            String str2[] = read.readLine().trim().split(" ");
            int pos = Integer.parseInt(str2[0]);
            int data = Integer.parseInt(str2[1]);

            Solution g = new Solution();
            head = g.addNode(head, pos, data);

            DLL.printList(head);
            while (head.next != null) {
                temp = head;
                head = head.next;
            }
            t--;
        }
    }
}
// } Driver Code Ends


/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/

class Solution {
    // Function to insert a new node at given position in doubly linked list.
    Node addNode(Node head, int p, int x) {
        // Your code here
        Node currentNode = head;

        for (int i = 0; i < p; i++) {
            currentNode = currentNode.next;
        }

        Node temp = new Node(x);

        if (currentNode.next != null) {
            temp.prev = currentNode;
            temp.next = currentNode.next;
            currentNode.next.prev = temp;
            currentNode.next = temp;
        } else {
            temp.prev = currentNode;
            currentNode.next = temp;
        }

        return head;
    }

    public Node deleteNode(Node head, int x) {
        // code here
        Node currNode = head;

        if (x == 1) {
            head.next.prev = null;
            head = head.next;

            return head;
        }

        for (int i = 1; i < x - 1; i++) {
            currNode = currNode.next;
        }

        if (currNode.next.next != null) {
            currNode.next.next.prev = currNode;
            currNode.next = currNode.next.next;
        } else {
            currNode.next = null;
        }

        return head;
    }

    public Node sortedInsert(Node head, int x) {
        // add your code here
        Node currentNode = head;
        Node temp = new Node(x);

        while (currentNode.next != null && currentNode.next.data < x) {
            currentNode = currentNode.next;
        }

        if (currentNode.next != null) {
            temp.next = currentNode.next;
            temp.prev = currentNode;
            currentNode.next.prev = temp;
            currentNode.next = temp;
        } else {
            temp.prev = currentNode;
            currentNode.next = temp;
        }

        return head;
    }
}