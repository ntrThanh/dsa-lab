package hus.dsa.homework6.lab1;

public class SortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
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

    public SortedLinkedPriorityQueue() {
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
        if (n == 0) {
            head = (NodeEntry<K, E>) entry;
            n++;
            return;
        }
        int index = 0;

        NodeEntry<K, E> node = head;

        for (int i = 0; i < n; i++) {
            if (entry.getKey().compareTo(node.getKey()) < 0) {
                index = i;
                break;
            }

            node = node.getNext();
        }

        if (index == 0) {
            NodeEntry<K, E> temp = (NodeEntry<K, E>) entry;
            temp.setNext(head);
            head = temp;
            n++;
            return;
        }

        NodeEntry<K, E> temp = getNodeByIndex(index - 1);
        temp.setNext((NodeEntry<K, E>) entry);
        n++;
    }

    @Override
    public void insert(K k, E e) {
        NodeEntry<K, E> entry = new NodeEntry<>(k, e);
        if (n == 0) {
            head = (NodeEntry<K, E>) entry;
            n++;
            return;
        }
        int index = 0;

        NodeEntry<K, E> node = head;

        for (int i = 0; i < n; i++) {
            if (entry.getKey().compareTo(node.getKey()) < 0) {
                index = i;
                break;
            }

            node = node.getNext();
        }

        if (index == 0) {
            head = new NodeEntry<>(k, e, head);
            n++;
            return;
        }

        NodeEntry<K, E> temp = getNodeByIndex(index - 1);
        temp.setNext((NodeEntry<K, E>) entry);
        n++;
    }

    @Override
    public Entry<K, E> removeMin() {
        return head;
    }

    public void swap(int left, int right) {
        NodeEntry<K, E> nodeLeft = getNodeByIndex(left);
        NodeEntry<K, E> nodeRight = getNodeByIndex(right);

        NodeEntry<K, E> currentNode = nodeLeft;
        nodeLeft = nodeRight;
        nodeRight = currentNode;
    }

    public NodeEntry<K, E> getNodeByIndex(int index) {
        if (index >= n) {
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
        return head;
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
