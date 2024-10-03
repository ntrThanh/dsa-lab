package hus.dsa.homework2.lab7;

public class MyLinkedList {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        Node head = node;

        node.next = new Node(3);
        node = node.next;
        node.next = new Node(3);
        node = node.next;
        node.next = new Node(7);
        node = node.next;
        node.next = new Node(2);
        node = node.next;
        node.next = new Node(0);
        node = node.next;

        int count = 0;


        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            count++;
            temp = temp.next;
        }

        System.out.println("size " + count);
    }
}
