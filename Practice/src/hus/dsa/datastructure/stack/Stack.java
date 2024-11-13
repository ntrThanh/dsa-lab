package hus.dsa.datastructure.stack;

public class Stack<T> {
    class Node {
        T data;
        Node next;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    Node head;
    int size;

    public Stack() {
        size = 0;
    }
    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    T peek() {
        return head.data;
    }

    public void push(T data) {
        head = new Node(data, head);
        size++;
    }

    T pop() {
        T data = head.data;
        head = head.next;
        size--;

        return data;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(12);
        stack.pop();
        stack.push(1);
        stack.push(0);
        stack.push(32);
        stack.push(52);
        stack.pop();
        stack.push(10);
        stack.push(-1);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println();
    }
}

