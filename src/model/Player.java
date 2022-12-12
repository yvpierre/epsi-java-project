package model;

import java.util.Stack;

public class Player {
    String name;
    Stack<Card> stack;
    Card frontCard;

    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stack<Card> getStack() {
        return stack;
    }

    public Card getFrontCard() {
        return frontCard;
    }

    //Constructors
    public Player(){
        super();
        this.name = "UnNamed Player";
    }

    public Player(String name){
        super();
        this.name = name;
        stack = new Stack<Card>();
        }

    //Methods & Functions
    public void play(){
        this.frontCard = this.stack.pop();
    }

    public void receive(Card card){
        this.stack.push(card);
    }
}
