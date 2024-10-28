package hus.dsa.homework6.lab1;

public class UnsortedArrayPriorityQueue <K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    protected class ArrEntry<K, E> implements Entry<K, E> {
        private K key;
        private E value;

        public ArrEntry(K key, E value) {
            this.key = key;
            this.value = value;
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
            return "ArrEntry" + '[' +
                    "key=" + key +
                    ", value=" + value +
                    ']';
        }
    }

    ArrEntry<K, E>[] priorityQueue;
    int n;
    private final int defaultSize = 1000;

    public UnsortedArrayPriorityQueue() {
        priorityQueue = new ArrEntry[defaultSize];
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
        if (n >= priorityQueue.length) {
            more();
        }
        priorityQueue[n++] = (ArrEntry<K, E>) entry;
    }

    @Override
    public void insert(K k, E e) {
        if (n >= priorityQueue.length) {
            more();
        }
        priorityQueue[n++] = new ArrEntry<>(k, e);
    }

    private void more() {
        int newLength = priorityQueue.length * 2;
        ArrEntry<K, E>[] arrEntries = new ArrEntry[ newLength];
        System.arraycopy(priorityQueue, 0, arrEntries, 0, priorityQueue.length);
        priorityQueue = arrEntries;
    }
    @Override
    public Entry<K, E> removeMin() {
        int minId = 0;

        for (int i = 1; i < n; i++) {
            if (priorityQueue[i].getKey().compareTo(priorityQueue[minId].getKey()) < 0) {
                minId = i;
            }
        }

        swap(minId, n - 1);

        return priorityQueue[--n];
    }

    private void swap(int left, int right) {
        ArrEntry<K, E> temp = priorityQueue[left];
        priorityQueue[left] = priorityQueue[right];
        priorityQueue[right] = temp;
    }
    @Override
    public Entry<K, E> min() {
        K min = priorityQueue[0].getKey();
        E value = priorityQueue[0].getValue();

        for (int i = 1; i < n; i++) {
            if (priorityQueue[i].getKey().compareTo(min) < 0) {
                min = priorityQueue[i].getKey();
                value = priorityQueue[i].getValue();
            }
        }

        return new ArrEntry<>(min, value);
    }

    public static void main(String[] args) {
        UnsortedArrayPriorityQueue<Integer, String> arrayPriorityQueue = new UnsortedArrayPriorityQueue<>();
        arrayPriorityQueue.insert(5, "is");
        arrayPriorityQueue.insert(6, "Thanh");
        arrayPriorityQueue.insert(1, "hello");
        arrayPriorityQueue.insert(3, "my");
        arrayPriorityQueue.insert(4, "name");
        arrayPriorityQueue.insert(2, "every one");

        while (!arrayPriorityQueue.isEmpty()) {
            System.out.println(arrayPriorityQueue.removeMin());
        }
    }
}
