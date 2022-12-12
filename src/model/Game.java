package model;

import java.util.Collections;
import java.util.Stack;

public class Game {
	//This stack is used as the starting stack to draw and as the pot in the center of the game
    private Stack<Card> cards;
	private Player player1;
    private Player player2;
    private BattleState state;
    private static String _PLAYER1_DEFAULT_NAME = "Player 1";
    private static String _PLAYER2_DEFAULT_NAME = "Player 2";
    
    //Getters & Setters
    public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}
	
	//Constructor
    public Game() {
    	this.player1 = new Player(_PLAYER1_DEFAULT_NAME);
    	this.player2 = new Player(_PLAYER2_DEFAULT_NAME);
    }
    
    public Game(Player player1, Player player2) {
    	this.player1 = player1;
    	this.player2 = player2;
    }
    
    //Functions & Methods
    public void start() {
        draw();
        play();
    }

    public void draw() {
    	//The cards are shuffled
        Collections.shuffle(cards);
        int index = (int) cards.size() / 2;
        
        //32 cards for both players
        for(int i = 0; i < 26; i++) {
        	player1.getStack().push(cards.pop());
        	player1.getStack().push(cards.pop());
        }
    }

    public void play(){
        //The players take a card in their stack
    	player1.play();
    	player2.play();
    	System.out.println(player1.name + " : " + player1.getFrontCard());
    	System.out.println(player2.name + " : " + player2.getFrontCard());
    	
    	//If the cards value are equal
    	if(player1.getFrontCard().getFace().value == player2.getFrontCard().getFace().value) {
    		this.state = BattleState.DRAW;
    		System.out.println(state.toString() + " : Battle !");
    		//the cards of the players goes in the pot
    		cards.push(this.player1.getFrontCard());
    		cards.push(this.player2.getFrontCard());
    		System.out.println(this.player1.getFrontCard() + " and " + this.player2.getFrontCard() + " will be won in the next round");
    		this.play();
    	}
    	
    	//If the cards aren't equal
    	else {
    		//The player 1 has a better card
    		if(player1.getFrontCard().getFace().value > player2.getFrontCard().getFace().value) {
    			System.out.println("Player 1 wins");
    			System.out.println("Player 1 gets : " + player1.getFrontCard());
    			System.out.println("Player 1 gets : " + player2.getFrontCard());
    			player1.getStack().push(player1.getFrontCard());
    			player1.getStack().push(player2.getFrontCard());
    		}
    		//he player 2 has a better card
    		else {
    			System.out.println("Player 2 wins");
    			System.out.println("Player 2 gets : " + player1.getFrontCard());
    			System.out.println("Player 2 gets : " + player2.getFrontCard());
    			player2.getStack().push(player1.getFrontCard());
    			player2.getStack().push(player2.getFrontCard());
    		}
    	}
    	
    	
        


    }
}
