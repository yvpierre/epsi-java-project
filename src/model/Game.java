package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Game {
    private ArrayList<Player> players;
    private ArrayList<Card> cards;

    public Game() {
        this.players = new ArrayList<Player>();
        this.cards = new ArrayList<Card>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void start() {
        draw();
        play();
    }

    public void draw() {
        Collections.shuffle(cards);
        int index = 0;
        int index2 = (int) cards.size() / players.size();
        for(Player player : players) {
            player.receive((ArrayList<Card>) cards.subList(index,index2 - 1));
            index += (int) cards.size() / players.size();
            index2 += (int) cards.size() / players.size();
        }
    }

    public void play(){
        //The players take a card in their stack
        for(Player player : players) {
            player.play();
        }
        //The game compare the cards (parcours des cartes des joueur => max => battlestate)
        //TODO : suppress that
        int max = 0;
        for(int i = 0; i < players.length(); i++){
            if(player.frontCard != player.front)
        }


    }
}
