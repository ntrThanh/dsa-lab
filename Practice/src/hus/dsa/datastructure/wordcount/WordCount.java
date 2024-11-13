package hus.dsa.datastructure.wordcount;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class WordCount {
    static List<Word> count(String s) {
        List<Word> list = new LinkedList<>();

        for (int i = 0; i < s.length() - 1; i++) {
            Word word = new Word(s.charAt(i) + "");
            if (contain(list, word.data)) {
                continue;
            }

            for (int j = i + 1; j < s.length(); j++) {
                if (word.data.equals(s.charAt(j) + "")) {
                    word.count++;
                }
            }

            list.add(word);
        }

        return list;
    }

    public static void main(String[] args) {
        String s = "aaabbanwnacccaccubo";

        List<Word> list = count(s);
        list.stream().forEach(x -> {
            System.out.println(x + "");
        });
    }

    static boolean contain(List<Word> list, String data) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).data.equals(data)) {
                return true;
            }
        }

        return false;
    }
}

class Word  {

    String data;
    int count;

    public Word(String data) {
        this.data = data;
        this.count = 1;
    }
    @Override
    public String toString() {
        return "Word" + '[' +
                "data='" + data + '\'' +
                ", count=" + count +
                ']';
    }
}


