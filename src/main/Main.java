package main;

import model.Game;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
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
	}
}
