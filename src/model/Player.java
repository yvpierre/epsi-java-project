package model;

import java.util.ArrayList;

public class Player {
    String name;
    CardStack stack;
    Card frontCard;
    BattleState state;


    public Player(){
        super();
        this.name = "UnNamed Player";
    }

    public Player(String name){
        super();
        this.name = name;
        stack = new CardStack();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardStack getStack() {
        return stack;
    }

    public void setStack(CardStack stack) {
        this.stack = stack;
    }

    public Card getFrontCard() {
        return frontCard;
    }

    public void setFrontCard(Card frontCard) {
        this.frontCard = frontCard;
    }

    public BattleState getState() {
        return state;
    }

    public void setState(BattleState state) {
        this.state = state;
    }


    public void play(){
        this.frontCard = this.stack.getCard();
    }

    public void receive(ArrayList<Card> cards){
        for(Card card : cards) {
            this.stack.add(card);
        }
    }
}
