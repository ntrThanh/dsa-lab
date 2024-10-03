package hus.dsa.homeworks.lab.labs.lab4;

import hus.dsa.homeworks.lab.labs.lab2.BubbleSort;

import java.lang.*;
import java.util.*;

public class CardManager {
    private List<Card> listCard;

    public CardManager(List<Card> listCard) {
        this.listCard = listCard;
    }

    public CardManager() {
        listCard = new ArrayList<>();
    }

    public void initialCards() {
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                listCard.add(new Card(i, j));
            }
        }
    }

    public void mixUpCards() {
        Collections.shuffle(listCard);
    }

    public void printCards() {
        Iterator<Card> iterator = listCard.iterator();

        while (iterator.hasNext()) {
            System.out.print("\t" + iterator.next());
        }
        System.out.println();
    }

    public List<Card> getListCard() {
        return listCard;
    }

    public void setListCard(List<Card> listCard) {
        this.listCard = listCard;
    }

    public void sortCards(Card[] array) {
        Arrays.sort(array, new CompareCard());
    }

    public static void main(String[] args) {
        CardManager cardManager = new CardManager();
        cardManager.initialCards();
        cardManager.mixUpCards();
        cardManager.printCards();

        Card[] cards = cardManager.getListCard().toArray(new Card[cardManager.getListCard().size()]);
        cardManager.sortCards(cards);
//        new BubbleSort().sort(cards);
        for (int i = 0; i < cards.length; i++) {
            System.out.print("\t" + cards[i]);
        }


    }
}
