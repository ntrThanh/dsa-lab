package hus.dsa.homework6.lab1;

public class UnsortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
    protected class NodeEntry<K, E> implements Entry<K, E> {

        private K key;
        private E value;
        private NodeEntry<K, E> next;

        public void setNext(NodeEntry<K, E> next) {
            this.next = next;
        }

        public NodeEntry<K, E> getNext() {
            return next;
        }

        public NodeEntry(K key, E value) {
            this.key = key;
            this.value = value;
        }

        public NodeEntry(K key, E value, NodeEntry<K, E> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "NodeEntry" + '[' +
                    "key=" + key +
                    ", value=" + value +
                    ']';
        }
    }

    private NodeEntry<K, E> head;
    private int n;

    public UnsortedLinkedPriorityQueue() {
        n = 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (head == null) {
            head = (NodeEntry<K, E>) entry;
        } else {
            NodeEntry<K, E> node = getNodeByIndex(n - 1);
            node.setNext((NodeEntry<K, E>) entry);
        }

        n++;
    }

    @Override
    public void insert(K k, E e) {
        NodeEntry<K, E> entry = new NodeEntry<>(k, e);

        if (head == null) {
            head = entry;
        } else {
            NodeEntry<K, E> node = getNodeByIndex(n - 1);
            node.setNext(entry);
        }

        n++;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (n == 0) {
            return null;
        }

        if (n == 1) {
            NodeEntry<K, E> node = head;
            head = null;
            n--;
            return node;
        }

        int index = 0;
        NodeEntry<K, E> temp = head;
        K key = temp.getKey();

        for (int i = 1; i < n; i++) {
            temp = temp.next;
            if (temp.getKey().compareTo(key) < 0) {
                key = temp.getKey();
                index = i;
            }
        }

        NodeEntry<K, E> result;

        if (index == 0) {
            result = head;
            head = head.next;
        } else {
            NodeEntry<K, E> node = getNodeByIndex(index - 1);
            result = node.getNext();
            node.setNext(node.getNext().getNext());
        }

        n--;
        return result;
    }

    public NodeEntry<K, E> getNodeByIndex(int index) {
        if (index >= n || index < 0) {
            return null;
        }
        NodeEntry<K, E> node = head;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node;
    }

    @Override
    public Entry<K, E> min() {
        NodeEntry<K, E> temp = head;
        K key = temp.getKey();
        E value = temp.getValue();

        for (int i = 0; i < n; i++) {
            if (temp.getKey().compareTo(key) < 0) {
                key = temp.getKey();
                value = temp.getValue();
            }

            temp = temp.next;
        }

        return new NodeEntry<>(key, value);
    }

    public static void main(String[] args) {
        UnsortedLinkedPriorityQueue<Integer, String> arrayPriorityQueue = new UnsortedLinkedPriorityQueue<>();
        arrayPriorityQueue.insert(5, "is");
        arrayPriorityQueue.insert(6, "Thanh");
        arrayPriorityQueue.insert(1, "hello");
        arrayPriorityQueue.insert(3, "my");
        arrayPriorityQueue.removeMin();
        arrayPriorityQueue.insert(4, "name");
        arrayPriorityQueue.insert(2, "every one");

        while (!arrayPriorityQueue.isEmpty()) {
            System.out.println(arrayPriorityQueue.removeMin());
        }
    }
}
