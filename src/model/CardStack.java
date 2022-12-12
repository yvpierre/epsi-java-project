package model;

import java.util.ArrayList;

public class CardStack {
    private ArrayList<Card> cards;

    public CardStack() {
        super();
        cards = new ArrayList<Card>();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public Card getCard(){
        return cards.remove(0);
    }
}
