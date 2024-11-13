package hus.dsa.datastructure.labinschool;

import java.util.ArrayList;
import java.util.List;

public class GenerateNumberBinary {
    List<int[]> generateNumberOfBinary(int n) {
        List<int[]> list = new ArrayList<>();

        generate(list, 0, new int[n]);

        return list;
    }

    public static void main(String[] args) {
        new GenerateNumberBinary().print(new GenerateNumberBinary().permutations(new int[] {1, 2, 3}));
    }

    void print(List<int[]> list) {
        for (int[] a : list) {
            printArray(a);
        }
    }

    void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    void generate(List<int[]> list, int index, int[] binary) {
        for (int i = 0; i <= 1; i++) {
            binary[index] = i;

            if (index == binary.length - 1) {
                list.add(binary.clone()); // su dung clone vi neu khong dung clone thi mang se duoc tham chieu den cung mot ket qua
            } else {
                generate(list, index + 1, binary);
            }
        }
    }

    List<int[]> permutations(int[] array) {
        List<int[]> list = new ArrayList<>();

        permutations(list, 0, array);

        return list;
    }

    void permutations(List<int[]> list, int index, int[] array) {
        if (index >= array.length) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            swap(array, index, i);

            if (index == array.length - 1 && !contain(list, array)) {
                list.add(array.clone());
            }

            permutations(list, index + 1, array);

            swap(array, index, i);
        }
    }

    boolean contain(List<int[]> list, int[] array) {
        for (int[] a : list) {
            if (equals(a, array)) {
                return true;
            }
        }

        return false;
    }

    boolean equals(int[] a1, int[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }

        return true;
    }

    void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
