package model;

import java.util.Stack;

public class Player {
    String name;
    Stack<Card> stack;
    Card frontCard;


    public Player(){
        super();
        this.name = "UnNamed Player";
    }

    public Player(String name){
        super();
        this.name = name;
        stack = new Stack<Card>();
        }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stack<Card> getStack() {
        return stack;
    }

    public void setStack(Stack<Card> stack) {
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
        this.frontCard = this.stack.pop();
    }

    public void receive(Stack<Card> cards){
        for(Card card : cards) {
            this.stack.push(cards.pop());
        }
    }
}
