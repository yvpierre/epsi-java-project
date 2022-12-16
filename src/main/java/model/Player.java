package main.java.model;

import java.util.ArrayDeque;

public class Player {
    String name;
    ArrayDeque<Card> queue = new ArrayDeque<Card>();
    Card frontCard;

    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayDeque<Card> getStack() {
        return queue;
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
        }

    //Methods & Functions
    public void play(){
        this.frontCard = this.queue.poll();
    }

    public void receive(Card card){
        this.queue.offer(card);
    }
}
