package hus.dsa.homework2.lab3;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;


    public void add(T data) {
        if (top == null) {
            top = new Node();
            top.data = data;

            bot = top;
        } else {
            bot.next = new Node();
            bot.next.data = data;
            bot = bot.next;
        }

        n++;
    }

    public void addBot(T data) {
        if (top == null) {
            top = new Node();
            top.data = data;

            bot = top;
        } else {
            bot.next = new Node();
            bot.next.data = data;
            bot = bot.next;
        }

        n++;
    }

    public static void main(String[] args) {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.add(1);
        simpleLinkedList.add(3);
        simpleLinkedList.add(3);
        simpleLinkedList.add(4);
        simpleLinkedList.add(6);
        simpleLinkedList.add(5);
        //System.out.println(simpleLinkedList.size());

        simpleLinkedList.remove(5);
        java.util.Iterator<Integer> iterator = simpleLinkedList.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    public T get(int i) {
        Node currentNode = top;

        for (int j = 0; j < i; j++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }


    public void set(int i, T data) {
        Node currentNode = top;

        for (int j = 0; j < i; j++) {
            currentNode = currentNode.next;
        }

        currentNode.data = data;
    }


    public void removeTop() {
        if (top != null) {
            top = top.next;

            if (top == null) {
                bot = null;
            }
        }
    }

    public void removeBot() {
        if (n == 0) {
            return;
        }

        if (n == 1) {
            top = null;
            bot = null;
        } else {
            Node currentNode = top;

            for (int i = 0; i < n - 2; i++) {
                currentNode = currentNode.next;
            }

            bot = currentNode;
            bot.next = null;
        }

        n--;
    }

    public void remove(T data) {
        if (n == 0) {
            return;
        }

        if (top.data.equals(data)) {
            removeTop();
            n--;
        }

        if (bot.data.equals(data)) {
            removeBot();
            n--;
        }

        Node currentNode = top;

        while (currentNode.next != null) {
            if (currentNode.next.data == data) {
                currentNode.next = currentNode.next.next;
                n--;
            } else {
                currentNode = currentNode.next;
            }
        }
    }


    public boolean isContain(T data) {
        Node currentNode = top;

        for (int j = 0; j < n; j++) {
            if (currentNode.data.equals(data)) {
                return true;
            }

            currentNode = currentNode.next;
        }
        return false;
    }


    public int size() {
        return n;
    }


    public boolean isEmpty() {
        return n == 0;
    }


    public Iterator<T> iterator() {
        return new Iterator<>();
    }

    class Iterator<T> implements java.util.Iterator<T> {
        private Node currentNode = top;

        public Iterator() {
        }

        @Override
        public boolean hasNext() {
            if (currentNode != null) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            T data = (T) currentNode.data;
            currentNode = currentNode.next;

            return data;
        }
    }


}
