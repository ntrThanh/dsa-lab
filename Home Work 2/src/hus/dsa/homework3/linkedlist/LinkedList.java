package hus.dsa.homework3.linkedlist;

public class LinkedList {
    Node head;
    int size;

    public LinkedList() {
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        return getNodeByIndex(index).val;
    }

    public Node getNodeByIndex(int index) {
        Node temp = head;

        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public int getLength() {
        return size;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        Node node = getNodeByIndex(size - 1);
        node.next = new Node(val);
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0 ) {
            head = new Node(val, head);
        } else {
            Node temp = getNodeByIndex(index - 1);
            temp.next = new Node(val, temp.next);
        }

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        Node node = getNodeByIndex(index - 1);
        node.next = node.next.next;
        size--;
    }

    class Node {
        int val;
        Node next;

        public Node() {

        }

        public Node (int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node (int val) {
            this.val = val;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addAtIndex(0, 1);
        list.addAtIndex(0, 2);
        list.addAtIndex(0, 1);
        list.addAtIndex(1, 2);

        for (int i = 0; i < list.getLength(); i++) {
            System.out.println(list.get(i));
        }
    }
}
