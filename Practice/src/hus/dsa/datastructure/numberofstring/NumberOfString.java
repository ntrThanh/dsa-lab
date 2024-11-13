package hus.dsa.datastructure.numberofstring;

import java.util.ArrayList;
import java.util.List;

public class NumberOfString {
    static List<Double> getNumberOfString(String s) {
        List<Double> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (isInteger(s.charAt(i) + "")) {
                StringBuilder sb = new StringBuilder();
                int j = i;

                while (j < s.length() && (isInteger(s.charAt(j) + "") || s.charAt(j) == '.')) {
                    sb.append(s.charAt(j));
                    j++;
                }

                list.add((double) Double.parseDouble(sb.toString()));
                i = j - 1;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        String s = "(1.2 + (2.3 - 3.66) + (1.345 * 15)) + (1 ^ 3) + 1.2350 + 0.133 + 10292";
        List<Double> list = getNumberOfString(s);

        list.stream().forEach(x -> System.out.println(x));
    }

    static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
