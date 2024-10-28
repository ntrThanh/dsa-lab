package hus.dsa.homework6.lab2;

import hus.dsa.homework3.sort.MergeSort;
import hus.dsa.homework3.sort.QuickSort;
import hus.dsa.homework6.lab1.MinHeapPriorityQueue;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 4, 1, 8, 5, 0, 1, 10, 33, 22, -12, 24};

        MinHeapPriorityQueue<Integer, Integer> heapPriorityQueue = new MinHeapPriorityQueue<>();
        long curr1 = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            heapPriorityQueue.insert(arr[i], arr[i]);
        }
        long curr2 = System.nanoTime();
        System.out.println("heap sort: " + (curr2 - curr1));

        int[] arr2 = new int[] {1, 3, 4, 1, 8, 5, 0, 1, 10, 33, 22, -12, 24};
        QuickSort quickSort = new QuickSort();
        long curr3 = System.nanoTime();
        quickSort.sort(arr2);
        long curr4 = System.nanoTime();
        System.out.println("quick sort: " + (curr4 - curr3));

        int[] arr3 = new int[] {1, 3, 4, 1, 8, 5, 0, 1, 10, 33, 22, -12, 24};
        MergeSort mergeSort = new MergeSort();
        long curr5 = System.nanoTime();
        mergeSort.sort(arr3);
        long curr6 = System.nanoTime();
        System.out.println("merge sort: " + (curr6 - curr5));

//        heap sort: 57800
//        quick sort: 13700
//        merge sort: 19900
    }
}
