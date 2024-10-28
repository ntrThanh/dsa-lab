package hus.dsa.homework6.lab4;

import hus.dsa.homework6.lab1.SortedArrayPriorityQueue;
import hus.dsa.homework6.lab1.SortedLinkedPriorityQueue;
import hus.dsa.homework6.lab1.UnsortedArrayPriorityQueue;
import hus.dsa.homework6.lab1.UnsortedLinkedPriorityQueue;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        SortedArrayPriorityQueue<Integer, Integer> sortedArrayPriorityQueue = new SortedArrayPriorityQueue<>();
        SortedLinkedPriorityQueue<Integer, Integer> sortedLinkedPriorityQueue = new SortedLinkedPriorityQueue<>();
        UnsortedArrayPriorityQueue<Integer, Integer> unsortedArrayPriorityQueue = new UnsortedArrayPriorityQueue<>();
        UnsortedLinkedPriorityQueue<Integer, Integer> unsortedLinkedPriorityQueue = new UnsortedLinkedPriorityQueue<>();

//        System.out.println("insert ");
//        long sortArrayStart = System.currentTimeMillis();
//        for (int i = 0; i < n; i++) {
//            sortedArrayPriorityQueue.insert(i, i);
//        }
//        long sortArrayEnd = System.currentTimeMillis();
//        System.out.println("sortedArrayPriorityQueue: " + (sortArrayEnd - sortArrayStart));
//
//        long sortLinkedStart = System.currentTimeMillis();
//        for (int i = 0; i < n; i++) {
//            sortedLinkedPriorityQueue.insert(i, i);
//        }
//        long sortLinkedEnd = System.currentTimeMillis();
//        System.out.println("sortedLinkedPriorityQueue: " + (sortLinkedEnd - sortLinkedStart));

        long unSortArrayStart = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            unsortedArrayPriorityQueue.insert(i, i);
        }
        long unSortArrayEnd = System.currentTimeMillis();
        System.out.println("unsortedArrayPriorityQueue: " + (unSortArrayEnd - unSortArrayStart));

//        long unSortLinkedStart = System.currentTimeMillis();
//        for (int i = 0; i < n; i++) {
//            unsortedLinkedPriorityQueue.insert(i, i);
//        }
//        long unSortLinkedEnd = System.currentTimeMillis();
//        System.out.println("unsortedLinkedPriorityQueue: " + (unSortLinkedEnd - unSortLinkedStart));

        // remove
        System.out.println();
        System.out.println("remove");
        System.out.println();
        long sortArrayStart2 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            sortedArrayPriorityQueue.removeMin();
        }
        long sortArrayEnd2 = System.currentTimeMillis();
        System.out.println("sortedArrayPriorityQueue: " + (sortArrayEnd2 - sortArrayStart2));

        long sortLinkedStart2 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            sortedLinkedPriorityQueue.removeMin();
        }
        long sortLinkedEnd2 = System.currentTimeMillis();
        System.out.println("sortedLinkedPriorityQueue: " + (sortLinkedEnd2 - sortLinkedStart2));

//        long unSortArrayStart2 = System.currentTimeMillis();
//        for (int i = 0; i < n; i++) {
//            unsortedArrayPriorityQueue.removeMin();
//        }
//        long unSortArrayEnd2 = System.currentTimeMillis();
//        System.out.println("unsortedArrayPriorityQueue: " + (unSortArrayEnd2 - unSortArrayStart2));
//
//        long unSortLinkedStart2 = System.currentTimeMillis();
//        for (int i = 0; i < n; i++) {
//            unsortedLinkedPriorityQueue.removeMin();
//        }
//        long unSortLinkedEnd2 = System.currentTimeMillis();
//        System.out.println("unsortedLinkedPriorityQueue: " + (unSortLinkedEnd2 - unSortLinkedStart2));
    }
}
