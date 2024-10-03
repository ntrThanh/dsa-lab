package hus.dsa.homework2.lab6;

public class MyLinkedList<T> {
    private Node head;
    private Node bot;
    int n = 0;

    class Node<T> {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }

        public Node() {
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public MyLinkedList() {

    }

    public int get(int index) {
        if (index >= n) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return (int) currentNode.value;
    }

    public void addAtHead(int val) {
        if (n == 0) {
            head = new Node(val);
            bot = head;
        } else {
            head = new Node(val, head);
        }

        n++;
    }

    public void addAtTail(int val) {
        if (n == 0) {
            addAtHead(val);
        } else {
            bot.next = new Node(val);
            bot = bot.next;

            n++;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index >= n) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == n - 1) {
            addAtTail(val);
            return;
        }

        Node currentNode = head;

        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }

        currentNode.next = new Node(val, currentNode.next);

        n++;
    }

    public void deleteAtIndex(int index) {
        if (index >= n) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node currentNode = head;

            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }

            currentNode.next = currentNode.next.next;


        }
        n--;
    }


    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addAtTail(1);
        list.addAtTail(12);
        list.addAtTail(123);
        list.addAtTail(1234);
        list.addAtTail(12345);
        list.addAtTail(123456);
        list.addAtTail(1234567);


        list.deleteAtIndex(1);

        for (int i = 0; i < list.n; i++) {
            System.out.println(list.get(i));
        }
    }
}
