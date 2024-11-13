package hus.dsa.datastructure.finalpractice.backtracking;

import java.util.LinkedList;
import java.util.List;

public class GenerateNumberOfCharacter {
    public static void generator(List<String> list, String[] alphabet, String[] arr, int index, int number) {
        for (int i = 0; i < alphabet.length; i++) {
            arr[index] = alphabet[i];

            if (index == number) {
                if (!list.contains(convert(arr.clone()))) {
                    list.add(convert(arr.clone()));
                }
            } else {
                generator(list, alphabet, arr, index + 1, number);
            }
        }
    }

    public static String convert(String[] arr) {
        StringBuilder sb = new StringBuilder();

        for (String a : arr) {
            sb.append(a);
        }

        return sb.toString();
    }

    public static void print(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        String[] alphabet = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "k", "l", "m"};
        List<String> list = new LinkedList<>();
        String[] arr = new String[2];
        int index = 0, number = arr.length - 1;

        generator(list, alphabet, arr, index, number);

        print(list);
        System.out.println(check(list));
    }

    public static boolean check(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                return false;
            }
        }

        return true;
    }
}
