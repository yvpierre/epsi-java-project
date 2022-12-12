package model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Game {
	// This Queue is used as the starting Queue to draw and as the pot in the center
	private ArrayDeque<Card> cards = new ArrayDeque<Card>();
	private Player player1;
	private Player player2;
	private BattleState state;
	private static String _PLAYER1_DEFAULT_NAME = "Player 1";
	private static String _PLAYER2_DEFAULT_NAME = "Player 2";

	// Getters & Setters
	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	// Constructor
	public Game() {
		this.player1 = new Player(_PLAYER1_DEFAULT_NAME);
		this.player2 = new Player(_PLAYER2_DEFAULT_NAME);
	}

	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	// Functions & Methods
	public void start() {
		initQueue();
		draw();
		play();
	}

	private void initQueue() {
		Face[] faceArray = Face.values();
		Color[] colorArray = Color.values();
		for (int i = 0; i < colorArray.length; i++) {
			for (int y = 0; y < faceArray.length; y++) {
				cards.offer(new Card(faceArray[y], colorArray[i]));
			}
		}
	}

	private void draw() {
		// The cards are shuffled
		shuffle();
		
		int index = (int) cards.size() / 2;

		// 32 cards for both players
		for (int i = 0; i < 26; i++) {
			player1.getStack().offer(cards.poll());
			player2.getStack().offer(cards.poll());
		}
	}

	private void shuffle() {
		Card[] cardsAsArray = new Card[52];
		//put the cards of the queue in a list
		cards.toArray(cardsAsArray);
		ArrayList<Card> arrayListCards = new ArrayList<Card>(Arrays.asList(cardsAsArray));
		//Shuffle the list
		Collections.shuffle(arrayListCards);
		//clear the queue
		cards.clear();
		//put the list elements in the queue
		cards.addAll(arrayListCards);
		
	}

	public void play() {
		// The players take a card in their Queue
		player1.play();
		player2.play();
		System.out.println(player1.name + " : " + player1.getFrontCard());
		System.out.println(player2.name + " : " + player2.getFrontCard());

		// Player cards are put in the pot
		cards.offer(player1.getFrontCard());
		cards.offer(player2.getFrontCard());

		// If the last round was a draw we show a reveal countdown
		if (state == BattleState.DRAW) {
			try {
				System.out.println("Cards revealed in : ");
				Thread.sleep(1000);
				System.out.println("3");
				Thread.sleep(1000);
				System.out.println("2");
				Thread.sleep(1000);
				System.out.println("1");
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Countdown interrupted");
			}
		}

		// If the cards value are equal
		if (player1.getFrontCard().getFace().value == player2.getFrontCard().getFace().value) {
			this.state = BattleState.DRAW;
			System.out.println(state.toString() + " : Battle !");
			System.out.println(this.player1.getFrontCard() + " and " + this.player2.getFrontCard()
					+ " will be won in the next round");
			this.play();
		}

		// If the cards aren't equal
		else {
			// The player 1 has a better card
			if (player1.getFrontCard().getFace().value > player2.getFrontCard().getFace().value) {
				System.out.println("\n" + this.player1.getName() + " WON !");

				int max = cards.size();

				// For each card in the pot we write a message
				for (int i = 0; i < max; i++) {
					Card cardWon = cards.poll();
					System.out.println(this.player1.getName() + " gets : " + cardWon.toString());
					player1.receive(cardWon);
				}

				this.state = BattleState.DONE;
			}
			// he player 2 has a better card
			else {
				System.out.println("\n" + this.player2.getName() + " WON !");

				int max = cards.size();

				// For each card in the pot we write a message
				for (int i = 0; i < max; i++) {
					Card cardWon = cards.poll();;
					System.out.println(this.player2.getName() + " gets : " + cardWon.toString());
					player2.receive(cardWon);
				}

				this.state = BattleState.DONE;
			}
			System.out.println("\n =============================== \n");
		}
	}

	public void showScore() {
		System.out.println(player1.name + " : " + player1.getStack().size() + " points");
		System.out.println(player2.name + " : " + player2.getStack().size() + " points");
	}
}
