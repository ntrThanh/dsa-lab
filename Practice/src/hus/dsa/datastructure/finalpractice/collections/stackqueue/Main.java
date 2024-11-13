package hus.dsa.datastructure.finalpractice.collections.stackqueue;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyLinkedStack<>();

        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(6);
        stack.push(9);
        stack.push(12);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
