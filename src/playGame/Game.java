package playGame;

import java.util.ArrayList;
import java.util.Scanner;

import deckshuffler.ShuffledDeck;
import goFish.GoFish;
import player.Player;

public class Game {
	
	private int goalPoints;
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
		mainDeck = fullDeck.get(2);
		
		input = new Scanner(System.in);
	}
	
	
	
	public boolean gameIsStillGoing() {
		if (player1.points < this.goalPoints && player2.points < this.goalPoints
				&& player1.deck.size() > 0 && player2.deck.size() > 0 && !goFish.emptyDeck(mainDeck)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void clearConsole() throws InterruptedException {
		System.out.println("CLEARING CONSOLE IN 3 SECONDS");
		Thread.sleep(3000);
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		
	}
	
	public int cardNotFoundOnPlayerInput(Player player, int nextCard) {
		while (!goFish.checkIfPlayerHasCard(player, nextCard)) {
			System.out.println("Card not found");
			System.out.println("What card does " + player.name + " want to ask for? ");
			nextCard = input.nextInt();
		}
		return nextCard;
	}
	
	public void cardFoundOnPlayerInput(Player player, Player otherPlayer, int nextCard) {
		if (goFish.checkIfPlayerHasCard(otherPlayer, nextCard)) {
			goFish.takeCardFromAnotherPlayer(nextCard, player, otherPlayer);
		} else {
			goFish.takeCardFromDeck(player, this.mainDeck);
		}
	}
	
	public void player2ComputerTurn() {
		System.out.print("Computer's Turn! ");
		int nextCard = goFish.computerSelectCardToTarget(this.player2.deck);
		if (goFish.checkIfPlayerHasCard(this.player1, nextCard)) {
			goFish.takeCardFromAnotherPlayer(nextCard, this.player2, this.player1);
		} else {
			goFish.takeCardFromDeck(this.player2, this.mainDeck);
		}
		System.out.println();
		goFish.takeAwaySetOfThree(this.player2);
	}
	
	public void player2UserTurn() throws InterruptedException {
		System.out.print("*" + this.player2.name + "* ");
		goFish.printDeck(this.player2.deck);
		System.out.print("What card does " + player2.name + " want to ask for? ");
		int nextCard = input.nextInt();
		nextCard = cardNotFoundOnPlayerInput(this.player2, nextCard);
		cardFoundOnPlayerInput(this.player2, this.player1, nextCard);
		System.out.println();
		goFish.takeAwaySetOfThree(this.player2);
		clearConsole();
	}
	
	
	public void player1Turn() throws InterruptedException {
		System.out.print("*" + this.player1.name + "* ");
		goFish.printDeck(this.player1.deck);
		System.out.print("What card does " + player1.name + " want to ask for? ");
		int nextCard = input.nextInt();
		nextCard = cardNotFoundOnPlayerInput(this.player1, nextCard);
		cardFoundOnPlayerInput(this.player1, this.player2, nextCard);
		System.out.println();
		goFish.takeAwaySetOfThree(this.player1);
		clearConsole();
	}
	
	public void player2Turn() throws InterruptedException {
		if (this.isComputer) {
			player2ComputerTurn();
		} else {
			player2UserTurn();
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
		System.out.println("Here are the rules:");
		System.out.println("GoFish is a one or two player game. Each player starts with 7 cards.");
		System.out.println("At the start of the turn, a player will look at their hand and ask the other player if that player has the card in their hand.");
		System.out.println("If the other player has the asked for card, all copies of that card must be given to the asking player.");
		System.out.println("If the asked player does not have the card, they have to Go Fish and draw one card from the main deck.");
		System.out.println("Points are awarded for obtaining a set of three cards.");
		System.out.println("The game ends when there are no more cards left or a player completes 5 sets.");
		System.out.println("Whoever has the most points at the end wins!");
		System.out.println("To play against a computer user, type 'computer' as Player 2's name.");
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
	
	public void playGame() throws InterruptedException {
		startGameInputs();
		
		while(gameIsStillGoing()) {
			player1Turn();
			player2Turn();
			updatedPoints();
		}
		System.out.println("The Game is over! " + determineWhoWon() + " won the game!");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Game newGame = new Game(5);
		newGame.playGame();
	}
}
