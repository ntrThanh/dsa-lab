package hus.dsa.homework4.practice.lab8;

public class MyCircularQueue {

    class Node {
        int value;
        Node next;

        public Node (int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private int size;
    private int number;
    private Node front;
    private Node rear;

    public int getNumber() {
        return number;
    }

    public MyCircularQueue(int k) {
        this.size = k;
        number = 0;
    }

    public boolean enQueue(int value) {
        if (size == 0) {
            return false;
        }

        if (number == size) {
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

    public boolean deQueue() {
        if (number == 0) {
            return false;
        }

        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            rear.next = front;
        }

        number--;
        return true;
    }

        public int Front() {
            if(number == 0) {
                return -1;
            }
            return front.value;
        }

        public int Rear() {
        if(number == 0) {
            return -1;
        }
        return rear.value;
    }

    public boolean isEmpty() {
        return number == 0;
    }

    public boolean isFull() {
        return number == size;
    }

    public static void display(MyCircularQueue myCircularQueue) {
        for (int i = 0; i < myCircularQueue.getNumber(); i++) {

        }
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(5);
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(12));
        System.out.println(myCircularQueue.enQueue(123));
        System.out.println(myCircularQueue.enQueue(1234));
        System.out.println(myCircularQueue.enQueue(12345));
        System.out.println(myCircularQueue.enQueue(123456));
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.Rear());

    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */