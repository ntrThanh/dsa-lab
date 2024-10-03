package hus.dsa.homeworks.lab.labs.lab7;

import java.util.Scanner;

public class FindNewAddress {

    public static void sort(Node[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].value > array[j].value) {
                    Node temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void printArray(Node[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    public static int findElement(Node[] array, int index) {

        for (int i = 0; i < array.length; i++) {
            if (array[i].index == index) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node[] elements = new Node[10];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = new Node(sc.nextInt(), i);
        }

        printArray(elements);
        sort(elements);
        printArray(elements);
        System.out.println(findElement(elements, 2));
    }
}

class Node {
    int value;
    int index;

    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Node" + '[' +
                "value=" + value +
                ", index=" + index +
                ']';
    }
}
