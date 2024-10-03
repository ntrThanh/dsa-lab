package hus.dsa.homeworks.lab.labs.lab4;

import java.util.Comparator;

public class CompareCard implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        if (o1.getRank() - o2.getRank() == 0) {
            return o1.getSuit() - o2.getSuit();
        } else {
            return o1.getRank() - o2.getRank();
        }
    }
}
