package hus.dsa.homestudy.collection;

public class LinkedList<T> extends MyAbstractList<T> {
    private Node<T> head;

    @Override
    public void add(T element) {
        insert(size, element);
    }

    @Override
    public void set(int index, T element) {
        checkBoundaries(index);

        getNodeByIndex(index).setValue(element);
    }

    @Override
    public void delete(int index) {
        checkBoundaries(index);

        if (index == 0) {
            head = head.getNext();
        } else {
            Node<T> currentNode = getNodeByIndex(index - 1);
            currentNode.setNext(currentNode.getNext().getNext());
        }

        size--;
    }

    @Override
    public void insert(int index, T element) {
        checkBoundaries(index);

        if (index == 0) {
            head = new Node<>(element, head);
        } else {
            Node<T> currentNode = getNodeByIndex(index - 1);
            currentNode.setNext(new Node<>(element, currentNode.getNext()));
        }

        size++;
    }

    @Override
    public T get(int index) {
        checkBoundaries(index);

        return (T) getNodeByIndex(index).getValue();
    }

    public Node getNodeByIndex(int index) {
        checkBoundaries(index);

        Node<T> currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    public static void main(String[] args) {
        MyList<Pointer> listNode = new MyArrayList<>();

        for (int i = 0; i < 10; i++) {
            listNode.add(new Pointer(i));
        }

        listNode.insert(10, new Pointer(11));
        listNode.delete(11);

        System.out.println(listNode);
        System.out.println(listNode.getSize());
    }

    @Override
    public int getSize() {
        return size;
    }

    class Node<T> {
        private T value;
        private Node next;

        public Node() {
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

class Pointer {
    int gpa;

    public Pointer(int gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Pointer" + '[' +
                "gpa=" + gpa +
                ']';
    }
}
