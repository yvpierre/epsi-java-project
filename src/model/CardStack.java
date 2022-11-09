package model;

import java.util.ArrayList;

public class CardStack {
    private ArrayList<Card> cards;

    public CardStack() {
        super();
        cards = new ArrayList<Card>();
    }

    public void give(ArrayList<Card> cards, CardStack receiver) {
        receiver.receive(cards);
    }

    public void receive(ArrayList<Card> cards) {
        for(Card card : cards) {
            this.cards.add(card);
        }
    }
}
