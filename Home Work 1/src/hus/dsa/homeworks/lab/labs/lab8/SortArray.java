package hus.dsa.homeworks.lab.labs.lab8;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SortArray {
    public static void sort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

    }

    public static List<Node> countValue(int[] array) {
        List<Node> list = new LinkedList<>();
        int temp;
        int count;

        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            count = 1;

            for (int j = i + 1; j <= array.length; j++) {
                if (j == array.length) {
                    i = j - 1;
                    list.add(new Node(temp, count));
                    break;
                }
                if (temp != array[j]) {
                    i = j - 1;
                    list.add(new Node(temp, count));
                    break;
                } else {
                    count++;
                }
            }
        }

        return list;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 22, 3, 24, 15, 30, 30, 30, 40};

        printArray(array);
        sort(array);
        printArray(array);

        List<Node> listNode = countValue(array);

        for (int i = 0; i < listNode.size(); i++) {
            System.out.println(listNode.get(i));
        }
    }
}

class Node {
    int value;
    int count;

    public Node(int element, int count) {
        this.value = element;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Node" + '[' +
                "value=" + value +
                ", count=" + count +
                ']';
    }
}