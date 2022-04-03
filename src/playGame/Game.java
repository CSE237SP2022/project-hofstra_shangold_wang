package playGame;

import java.util.Scanner;

public class Game {
	
	void Game() {
		
	}
	
	public boolean gameIsStillGoing() {
		return true;
	}
	
	public boolean checkIfPlayerHasCard(String player) {
		return true;
	}
	
	public void takeCardFromAnotherPlayer(String player1, String player2) {
		
	}
	
	public void takeCardFromDeck(String player) {
		
	}
	
	public String playerTurn() {
		return "";
	}
	
	public boolean otherPlayerHasCard(String otherPlayer, int card) {
		return true;
	}
	
	
	public static void main(String[] args) {
		Game newGame = new Game();
		Scanner input = new Scanner(System.in);
		while (newGame.gameIsStillGoing()) {
			
			if (newGame.playerTurn() == "user-1") {
				
				System.out.println("What card does Player 1 want to ask for?");
				int nextCard = input.nextInt();
				if (newGame.otherPlayerHasCard("user-2", nextCard)) {
					// take card from other player
				} else {
					// take card from deck
				}
				
			} else if (newGame.playerTurn() == "user-2") {
				
				System.out.println("What card does Player 2 want to ask for?");
				int nextCard = input.nextInt();
				if (newGame.otherPlayerHasCard("user-1", nextCard)) {
					// take card from other player
				} else {
					// take card from deck
				}
			}
		}
		
	}

}
