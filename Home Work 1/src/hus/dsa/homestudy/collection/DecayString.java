package hus.dsa.homestudy.collection;

import java.util.LinkedList;
import java.util.List;

public class DecayString {
    public static void printString(String[] character) {
        for (int i = 0; i < character.length; i++) {
            if (character[i].equals(" ")) {
                continue;
            }
            System.out.print("\"" + character[i] + "\"" + "\t");
        }

        System.out.println();
    }

    public static boolean isInteger(String character) {
        try {
            Integer.parseInt(character);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String[] decayString(String string) {
        String[] strings = string.split("");
        List<String> listStringResult = new LinkedList<>();

        String currentString;

        for (int i = 0; i < strings.length; i++) {
            currentString = strings[i];

            if (isInteger(strings[i])) {
                StringBuilder tempString = new StringBuilder();
                int j = i;

                while (isInteger(strings[j]) || strings[j].equals(".")) {
                    tempString.append(strings[j]);
                    j++;
                }

                currentString = tempString.toString();
                i = j - 1;
            }

            listStringResult.add(currentString);
        }

        return listStringResult.toArray(new String[listStringResult.size()]);
    }

    public static void main(String[] args) {
        printString(decayString(" - (4.5 * 1.2) + 5.0 + (6.0 * 1.5)"));
    }
}
