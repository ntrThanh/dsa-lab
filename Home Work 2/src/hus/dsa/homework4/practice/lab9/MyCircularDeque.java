package hus.dsa.homework4.practice.lab9;

public class MyCircularDeque {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node front;
    private Node rear;
    private int size;
    private int number;

    public MyCircularDeque(int k) {
        this.size = k;
        this.number = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        if (front == null) {
            front = new Node(value);
            front.next = front;
            rear = front;

        } else {
            front = new Node(value, front);
            rear.next = front;
        }

        number++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        if (front == null) {
            front = new Node(value);
            front.next = front;
            rear = front;
        } else {
            Node temp = new Node(value);
            rear.next = temp;
            temp.next = front;
            rear = rear.next;
        }

        number++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        if (number == 1) {
            front = null;
            rear = null;

            number--;
            return true;
        } else {
            rear.next = front.next;
            front = front.next;

            number--;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        if (number == 1) {
            front = null;
            rear = null;

            number--;
            return true;
        } else {
            Node temp = front;

            while (temp.next != rear) {
                temp = temp.next;
            }

            temp.next = front;
            rear = temp;

            number--;
            return true;
        }
    }

    public int getFront() {
        if (number == 0) {
            return -1;
        }

        return front.val;
    }

    public int getRear() {
        if (number == 0) {
            return -1;
        }

        return rear.val;
    }

    public boolean isEmpty() {
        return number == 0;
    }

    public boolean isFull() {
        return number == size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */