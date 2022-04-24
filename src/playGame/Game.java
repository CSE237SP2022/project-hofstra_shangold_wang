package playGame;

import java.util.ArrayList;
import java.util.Scanner;

import deckshuffler.ShuffledDeck;
import goFish.GoFish;
import player.Player;

public class Game {
	
	public int goalPoints;
	private Scanner input;
	Player player1;
	Player player2;
	private ArrayList<Integer> mainDeck;
	private ArrayList<ArrayList<Integer>> fullDeck;
	private ShuffledDeck allDecks;
	private GoFish goFish;
	private boolean isComputer = false;
	
	public Game(int goalPoints) {
		this.goalPoints = goalPoints;
		player1 = new Player("p1");
		player2 = new Player("p2");
		allDecks = new ShuffledDeck();
		goFish = new GoFish();
		
		fullDeck = allDecks.initializeDecks(2);
		player1.deck = fullDeck.get(0);
		player2.deck = fullDeck.get(1);
		mainDeck = fullDeck.get(1);
		
		input = new Scanner(System.in);
	}
	
	
	
	public boolean gameIsStillGoing() {
		if (player1.points < this.goalPoints && player2.points < this.goalPoints
				&& player1.deck.size() > 0 && player2.deck.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void clearConsole() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	
	
	
	
	public void player1Turn() {
		System.out.print("*" + this.player1.name + "* ");
		goFish.printDeck(this.player1.deck);
		System.out.print("What card does " + player1.name + " want to ask for? ");
		int nextCard = input.nextInt();
		while (!goFish.checkIfPlayerHasCard(this.player1, nextCard)) {
			System.out.println("Card not found");
			System.out.println("What card does " + player1.name + " want to ask for? ");
			nextCard = input.nextInt();
		}
		if (goFish.checkIfPlayerHasCard(this.player2, nextCard)) {
			goFish.takeCardFromAnotherPlayer(nextCard, this.player1.deck, this.player2.deck);
		} else {
			goFish.takeCardFromDeck(this.player1.deck, this.mainDeck);
		}
		System.out.println();
		goFish.takeAwaySetOfThree(this.player1);
		clearConsole();
	}
	
	public void player2Turn() {
		if (this.isComputer) {
			System.out.print("Computer's Turn! ");
			int nextCard = goFish.computerSelectCardToTarget(this.player2.deck);
			if (goFish.checkIfPlayerHasCard(this.player1, nextCard)) {
				goFish.takeCardFromAnotherPlayer(nextCard, this.player2.deck, this.player1.deck);
			} else {
				goFish.takeCardFromDeck(this.player2.deck, this.mainDeck);
			}
			System.out.println();
			goFish.takeAwaySetOfThree(this.player2);
		} else {
			System.out.print("*" + this.player2.name + "* ");
			goFish.printDeck(this.player2.deck);
			System.out.print("What card does " + player2.name + " want to ask for? ");
			int nextCard = input.nextInt();
			while (!goFish.checkIfPlayerHasCard(this.player2, nextCard)) {
				System.out.println("Card not found");
				System.out.println("What card does " + player2.name + " want to ask for? ");
				nextCard = input.nextInt();
			}
			if (goFish.checkIfPlayerHasCard(this.player1, nextCard)) {
				goFish.takeCardFromAnotherPlayer(nextCard, this.player2.deck, this.player1.deck);
			} else {
				goFish.takeCardFromDeck(this.player2.deck, this.mainDeck);
			}
			System.out.println();
			goFish.takeAwaySetOfThree(this.player2);
			clearConsole();
		}
	}
	
	public String determineWhoWon() {
		if (player1.points > player2.points) {
			return player1.name;
		} else if (player1.points == player2.points) {
			return "No one";
		} else {
			return player2.name;
		}
	}

	
	public void startGameInputs() {
		System.out.println("Welcome to Go Fish!");
		System.out.print("What is Player 1's name? ");
		this.player1.name = input.next();
		System.out.println("Welcome " + this.player1.name + "!");
		
		
		System.out.print("What is Player 2's name? ");
		this.player2.name = input.next();
		if (this.player2.name.toLowerCase().equals("computer")) {
			this.isComputer = true;
		}
		
		System.out.println("Welcome " + this.player2.name + "!");
		System.out.println("Alright, let's start the game, good luck!!");
		System.out.println();
	}
	
	public void updatedPoints() {
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("Here is the updated scoreboard!");
		System.out.println(player1.name + ": " + player1.points + " points");
		System.out.println(player2.name + ": " + player2.points + " points");
		System.out.print("-----------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	public void playGame() {
		startGameInputs();
		
		while(gameIsStillGoing()) {
			player1Turn();
			player2Turn();
			updatedPoints();
		}
		System.out.println("The Game is over! " + determineWhoWon() + " won the game!");
	}
	
	public static void main(String[] args) {
		Game newGame = new Game(5);
		newGame.playGame();
	}
}
