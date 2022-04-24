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
	
	public boolean checkIfPlayerHasCard(Player player, int card) {
		ArrayList<Integer> playerDeck = player.deck;
		return goFish.cardFound(card, playerDeck);
	}
	
	public void takeCardFromAnotherPlayer(Player taker, Player giver, int card) {
		if (goFish.cardFound(card, giver.deck)) {
			card = giver.deck.remove(giver.deck.indexOf(card));
			taker.deck.add(card);
			System.out.println("Card found! " + taker.name + 
					" took " + card + " from " + giver.name + ".");
			taker.points += 1;
			System.out.println();
		}
	}
	
	public void takeCardFromDeck(Player taker) {
		int cardFromDeck = mainDeck.remove(mainDeck.size() - 1);
		taker.deck.add(cardFromDeck);
		System.out.println("Go Fish! " + taker.name + 
				" took a card from the deck.");
		System.out.println();
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
		while (!checkIfPlayerHasCard(this.player1, nextCard)) {
			System.out.println("Card not found");
			System.out.println("What card does " + player1.name + " want to ask for? ");
			nextCard = input.nextInt();
		}
		if (checkIfPlayerHasCard(this.player2, nextCard)) {
			takeCardFromAnotherPlayer(this.player1, this.player2, nextCard);
		} else {
			takeCardFromDeck(this.player1);
		}
		System.out.println();
		takeAwaySetOfThree(this.player1);
		clearConsole();
	}
	
	public void player2Turn() {
		if (this.isComputer) {
			System.out.print("Computer's Turn! ");
			int nextCard = goFish.computerSelectCardToTarget(this.player2.deck);
			if (checkIfPlayerHasCard(this.player1, nextCard)) {
				takeCardFromAnotherPlayer(this.player2, this.player1, nextCard);
			} else {
				takeCardFromDeck(this.player2);
			}
			System.out.println();
			takeAwaySetOfThree(this.player2);
		} else {
			System.out.print("*" + this.player2.name + "* ");
			goFish.printDeck(this.player2.deck);
			System.out.print("What card does " + player2.name + " want to ask for? ");
			int nextCard = input.nextInt();
			while (!checkIfPlayerHasCard(this.player2, nextCard)) {
				System.out.println("Card not found");
				System.out.println("What card does " + player2.name + " want to ask for? ");
				nextCard = input.nextInt();
			}
			if (checkIfPlayerHasCard(this.player1, nextCard)) {
				takeCardFromAnotherPlayer(this.player2, this.player1, nextCard);
			} else {
				takeCardFromDeck(this.player2);
			}
			System.out.println();
			takeAwaySetOfThree(this.player2);
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
	
	public int checkIfSetOfThreeExists(Player player) {
		for (int i = 0; i < player.deck.size(); i++) {
			int cardCount = 0;
			for (int j = 0; j < player.deck.size(); j++) {
				int currentCard = player.deck.get(i);
				if (player.deck.get(j) == currentCard) {
					cardCount += 1;
				}
				if (cardCount >= 3) return currentCard;
			}
			cardCount = 0;
		}
		return -1;
	}
	
	public void updatePointsFromSetOfThree(Player player) {
		player.points += 5;
	}
	
	public int takeAwaySetOfThree(Player player) {
		int setCard = checkIfSetOfThreeExists(player);
		if (setCard != -1) {	
			System.out.println(player.name + " has a set of three " + setCard + "'s to put down!");
			player.deck.remove(player.deck.indexOf(setCard));
			player.deck.remove(player.deck.indexOf(setCard));
			player.deck.remove(player.deck.indexOf(setCard));
			updatePointsFromSetOfThree(player);
			System.out.println();
		}
		return setCard;
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
