package hus.dsa.homework6.lab1;

public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends SortedArrayPriorityQueue<K, E> {

    public MinHeapPriorityQueue() {
        super();
    }


    private void upHeap(int n) {
        while (n > 1 && priorityQueue[n/2].getKey().compareTo(priorityQueue[n].getKey()) > 0) {
            swap(n, n / 2);
            n = n / 2;
        }
    }

    private void downHeap(int n) {
        while (2 * n < size()) {
            int k = 2 * n;

            if (k > 0 && priorityQueue[k].getKey().compareTo(priorityQueue[k + 1].getKey()) > 0) {
                k++;
            }

            if (priorityQueue[n].getKey().compareTo(priorityQueue[k].getKey()) < 0) {
                break;
            }

            swap(n, k);
            n = k;
        }
    }

    @Override
    public void insert(Entry<K, E> entry) {
        priorityQueue[++n] = (ArrEntry<K, E>) entry;
        upHeap(n);
    }

    @Override
    public void insert(K k, E e) {
        Entry<K, E> entry = new ArrEntry<>(k, e);
        priorityQueue[++n] = (ArrEntry<K, E>) entry;
        upHeap(n);
    }

    @Override
    public Entry<K, E> removeMin() {
        Entry<K, E> entry = priorityQueue[1];
        swap(1, n--);
        downHeap(1);
        priorityQueue[n + 1] = null;
        return entry;
    }

    @Override
    public Entry<K, E> min() {
        return priorityQueue[1];
    }



    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> minHeapPriorityQueue = new MinHeapPriorityQueue<>();
        minHeapPriorityQueue.insert(5, "nguoi");
        minHeapPriorityQueue.insert(1, "Xin");
        minHeapPriorityQueue.insert(2, "chao");
        minHeapPriorityQueue.insert(6, "toi");
        minHeapPriorityQueue.insert(8, "Thanh");
        minHeapPriorityQueue.insert(4, "moi");
        minHeapPriorityQueue.insert(7, "la");

        while (!minHeapPriorityQueue.isEmpty()) {
            System.out.println(minHeapPriorityQueue.removeMin());
        }
    }
}
