package main;

import main.java.model.Game;
import main.java.model.Player;

public class Main {

	public static void main(String[] args) {
		Player pablo = new Player("Pablo");
		Player pierre = new Player("Pierre");
		Game game = new Game(pablo, pierre);
		
		game.start();
		try {
		Thread.sleep(2000);
		game.play();
		Thread.sleep(2000);
		game.play();
		Thread.sleep(2000);
		game.play();
		Thread.sleep(2000);
		game.play();
		Thread.sleep(2000);
		game.play();
		Thread.sleep(2000);
		game.play();
		}
		catch(Exception e){
			System.out.println("thread interrupted");
		}
		
		game.showScore();
	}
}
