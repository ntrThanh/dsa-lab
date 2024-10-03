package hus.dsa.homework2.lab4;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        String words = "abc a a abc a e e g j k b d e c c b e c as a as as t t t ";
        String[] arrayWords = words.split(" ");
        SimpleArrayList<WordCount> listWordsCount = new SimpleArrayList<>();

        int k = 0;
        for (int i = 0; i < arrayWords.length; i++) {
            if (!listWordsCount.isContain(new WordCount(arrayWords[i]))) {
                listWordsCount.add(new WordCount(arrayWords[i]));
            } else {
                // neu trong danh sach da co phan tu do thi ta bo qua
                continue;
            }

            // duyet nhung truong hop sau khi duoc them moi
            for (int j = i + 1; j < arrayWords.length; j++) {
                if (listWordsCount.isContain(new WordCount(arrayWords[j]))
                        && new WordCount(arrayWords[j]).equals(listWordsCount.get(k))) {
                    listWordsCount.get(k).count();
                }
            }

            // moi vong voi i thi tang bien k len 1 de update nhung phan tu trong listwordcount
            k++;
        }

        for (int i = 0; i < listWordsCount.size(); i++) {
            System.out.println(listWordsCount.get(i));
        }
    }

    public static String input(Scanner sc) {
        String result = sc.nextLine();

        return result;
    }
}
