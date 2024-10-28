package hus.dsa.homework6.lab1;

public class SortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
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

    protected ArrEntry<K, E>[] priorityQueue;
    protected int n;
    private final int defaultSize = 1000;

    public SortedArrayPriorityQueue() {
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

    private void more() {
        int newLength = priorityQueue.length * 2;
        ArrEntry<K, E>[] arrEntries = new ArrEntry[ newLength];
        System.arraycopy(priorityQueue, 0, arrEntries, 0, priorityQueue.length);
        priorityQueue = arrEntries;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (n >= priorityQueue.length) {
            more();
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (entry.getKey().compareTo(priorityQueue[i].getKey()) > 0) {
                index = i;
                break;
            }
        }

        for (int i = n; i > index; i--) {
            priorityQueue[i] = priorityQueue[i - 1];
        }

        priorityQueue[index] = (ArrEntry<K, E>) entry;
        n++;
    }

    protected void swap(int left, int right) {
        ArrEntry<K, E> temp = priorityQueue[left];
        priorityQueue[left] = priorityQueue[right];
        priorityQueue[right] = temp;
    }


    @Override
    public void insert(K k, E e) {
        if (n >= priorityQueue.length) {
            more();
        }
        if (n == 0) {
            priorityQueue[n++] = new ArrEntry<>(k, e);
            return;
        }
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k.compareTo(priorityQueue[i].getKey()) < 0) {
                index = i + 1;
                break;
            }
        }

        for (int i = n; i > index; i--) {
            priorityQueue[i] = priorityQueue[i - 1];
        }

        priorityQueue[index] = new ArrEntry<>(k, e);
        n++;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (n == 0) {
            return null;
        }
        return priorityQueue[--n];
    }

    @Override
    public Entry<K, E> min() {
        return priorityQueue[n - 1];
    }

    public static void main(String[] args) {
        SortedArrayPriorityQueue<Integer, String> arrayPriorityQueue = new SortedArrayPriorityQueue<>();
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
