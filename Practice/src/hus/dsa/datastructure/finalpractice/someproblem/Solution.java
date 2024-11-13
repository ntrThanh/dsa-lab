package hus.dsa.datastructure.finalpractice.someproblem;

import java.util.*;

public class Solution {

    public static int checkContain(int[] superString, int[] sub) {
        if (superString.length < sub.length) {
            return -1;
        } else if (sub.length == 0) {
            return 0;
        }

        for (int i = 0; i < superString.length; i++) {
            if (sub.length > superString.length - i) {
                return -1;
            }

            int index = i;
            int count = 0;

            while (count < sub.length && sub[count] == superString[index]) {
                index++;
                count++;
            }

            if (count == sub.length) {
                return i;
            }

            if (count == 0) {
                i = index;
            } else {
                i = index - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        new Solution().grayCode(3);
    }


    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        Stack<String> stack = new Stack<>();

        int index = s.length() / 2;

        for (int i = 0; i < index; i++) {
            if (" ,".contains(s.charAt(i) + "")) {
                continue;
            }

            stack.push(s.charAt(i) + "");
        }

        for (int i = index; i < s.length(); i++) {
            if (" ,".contains(s.charAt(i) + "")) {
                continue;
            }

            if (stack.peek().equals(s.charAt(i) + "")) {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static boolean isPalindromeVer2(String s) {
        s = s.toLowerCase();

        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (" ,".contains(s.charAt(i) + "")) {
                continue;
            }

            stack.push(s.charAt(i) + "");
            queue.add(s.charAt(i) + "");
        }

        for (int i = 0; i < stack.size(); i++) {
            String left = stack.pop();
            String right = queue.poll();

            if (!left.equals(right)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isIsomorphic(String left, String right) {
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < left.length(); i++) {
            char key = left.charAt(i);
            char value = right.charAt(i);

            if (map.containsKey(key)) {
                if (value != map.get(key)) {
                    return false;
                }
            } else if (map.containsValue(value)) {
                return false;
            } else {
                map.put(key, value);
            }
        }

        return false;
    }


    public static String findOptimalGroveString(String s) {
        List<String> list = new LinkedList<>();

        String[] result = s.split("");

        permutation(result, 0, list);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int sum1 = 0;
                int sum2 = 0;

                for (int i = 0; i < o1.length(); i++) {
                    if (i % 2 == 0) {
                        sum1 = sum1 + o1.charAt(i);
                        sum2 = sum2 + o2.charAt(i);
                    }
                }

                return sum1 - sum2;
            }
        });

        return list.get(0);
    }

    public static void permutation(String[] strings, int index, List<String> list) {
        if (index == strings.length) {
            if (!list.contains(convert(strings.clone()))) {
                list.add(convert(strings.clone()));
            }
        } else {
            for (int i = index; i < strings.length; i++) {
                swap(strings, index, i);

                permutation(strings, index + 1, list);

                swap(strings, index, i);
            }
        }
    }

    public static String convert(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }

        return sb.toString();
    }

    public static <T> void swap(T[] s, int left, int right) {
        T temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }


    // ======================= đây là bài trong leetcode
    public void swap(int[] s, int left, int right) {
        int temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }

    public String getPermutation(int n, int k) {
        List<String> list = new LinkedList<>();

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        permutation(array, 0, list);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        });

        return list.get(k);
    }

    public void permutation(int[] array, int index, List<String> list) {
        if (index == array.length) {
            if (!list.contains(convert(array.clone()))) {
                list.add(convert(array.clone()));
            }
        } else {
            for (int i = index; i < array.length; i++) {
                swap(array, index, i);

                permutation(array, index + 1, list);

                swap(array, index, i);
            }
        }
    }




    public String getPermutationVer2(int n, int k) {
        List<Integer> list = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        k--;
        for (int i = n; i > 0; i--) {
            int curr = getFactory(i - 1);
            int index = k / curr;
            sb.append(list.get(index));
            list.remove(list.get(index));
            k = k % curr;
        }

        return sb.toString();
    }

    public int getFactory(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * getFactory(n - 1);
        }
    }

    // =================== new solution in leecode
    public List<Integer> grayCode(int n) {
        List<String> list = new LinkedList<>();

        generate(new int[n], 0, list);

        List<Integer> list1 = new LinkedList<>();

        for (int i = 0; i < list.size(); i++) {
            list1.add(binaryToInteger(list.get(i)));
        }

        Collections.sort(list1);

        return list1;
    }

    public int binaryToInteger(String s) {
        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            result += (int) (Math.pow(2, s.length() - 1 - i) * Integer.parseInt(s.charAt(i) + ""));
        }

        return result;
    }

    public void generate(int[] array, int index, List<String> list) {
        if (index == array.length) {
            if (!list.contains(convert(array.clone()))) {
                list.add(convert(array.clone()));
            }
        } else {
            for (int i = 0; i <= 1; i++) {
                array[index] = i;

                generate(array, index + 1, list);
            }
        }
    }

    public String convert(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }

        return sb.toString();
    }
}
