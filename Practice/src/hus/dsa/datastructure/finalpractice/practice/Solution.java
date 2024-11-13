package hus.dsa.datastructure.finalpractice.practice;

import java.io.File;
import java.util.*;

public class Solution {
    // question 1
    public static int findMax(int[] a, int n) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0 || mid == n - 1) {
                return mid;
            }

            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
                return mid;
            }

            if (a[mid] >= a[mid - 1] && a[mid] <= a[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static int findMaxVersion2(int[] a, int n) {
        return -1;
    }


    public static void main(String[] args) {
//        File file = new File("C:\\Users\\Trong Thanh\\Documents\\TestData");
//
//        System.out.println("The size of the files is: " + size(file));
//
//        System.out.println();
//
//        print(ls(file));

        System.out.println(getMinValueVer2(new int[] {6, 5, 2, 1, 2, 1, 1, 2, 2}));
    }


    // question 2
    public static long size(File file) {
        if (file.isFile()) {
            return file.length();
        } else {
            File[] files = file.listFiles();

            long size = -1;
            for (int i = 0; i < files.length; i++) {
                size = size + size(files[i]);
            }

            return size;
        }
    }

    public static List<String> ls(File file) {
        List<String> result = new LinkedList<>();
        List<File> filesList = new LinkedList<>();

        ls(filesList, file);

        Collections.sort(filesList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return (int) ((int) o1.length() - o2.length());
            }
        });

        for (int i = 0; i < filesList.size(); i++) {
            result.add(filesList.get(i).getName());
        }

        return result;
    }

    static void print(List<String> list) {
        for (String a : list) {
            System.out.println(a);
        }
    }

    public static void ls(List<File> list, File file) {
        if (file.isFile()) {
            list.add(file);
        } else {
            File[] files = file.listFiles();

            for (int i = 0; i < files.length; i++) {
                if (file.isFile()) {
                    ls(list, files[i]);
                } else {
                    ls(list, files[i]);
                }
            }
        } 
    }

    // question 3

    public static long getMinValue(int[] v) {
        Arrays.sort(v);

        long sum = 0;
        long min = Integer.MAX_VALUE;

        for (int i = 0; i < v.length; i++) {
            sum += v[i];
        }

        for (int i = 0; i < v.length; i++) {
            long curr = v[i];
            int j = i + 1;
            int count = 1;

            while (j < v.length && curr == v[j]) {
                j++;
                count++;
            }

            i = j - 1;

            long currentSum = sum - count * curr;
            min = Math.min(min, currentSum);
        }

        return min;
    }

    public static long getMinValueVer2(int[] v) {
        long sum = 0;
        long min = Integer.MAX_VALUE;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < v.length; i++) {
            sum += v[i];

            if (!map.containsKey(v[i])) {
                map.put(v[i], 1);
            } else {
                map.put(v[i], map.get(v[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> element : map.entrySet()) {
            long currSum = sum - (long) element.getValue() * element.getKey();
            min = Math.min(min, currSum);
        }

        return min;
    }
}
