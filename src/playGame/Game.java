package playGame;

import java.util.ArrayList;
import java.util.Scanner;

import deckshuffler.ShuffledDeck;
import goFish.GoFish;
import player.Player;

public class Game {
	
	public int goalPoints;
	private Scanner input;
	public Player player1;
	public Player player2;
	public ArrayList<Integer> mainDeck;
	public ArrayList<ArrayList<Integer>> fullDeck;
	public ShuffledDeck allDecks;
	public GoFish goFish;
	
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
	
	public void player1Turn() {
		System.out.print("What card does " + player1.name + " want to ask for? ");
		int nextCard = input.nextInt();
		if (checkIfPlayerHasCard(this.player2, nextCard)) {
			// take card from other player
			takeCardFromAnotherPlayer(this.player1, this.player2, nextCard);
		} else {
			takeCardFromDeck(this.player1);
			// take card from deck
		}
		System.out.println();
	}
	
	public void player2Turn() {
		System.out.print("What card does " + player2.name + " want to ask for? ");
		int nextCard = input.nextInt();
		if (checkIfPlayerHasCard(this.player1, nextCard)) {
			// take card from other player
			takeCardFromAnotherPlayer(this.player2, this.player1, nextCard);
		} else {
			takeCardFromDeck(this.player2);
			// take card from deck
		}
		System.out.println();
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
	
	
//	public static void main(String[] args) {
//		Game newGame = new Game(20);
//		Player p1 = newGame.player1;
//		Player p2 = newGame.player2;
//		Scanner input = new Scanner(System.in);
//		while (newGame.gameIsStillGoing()) {
//			
//			if (newGame.playerTurn() == "user-1") {
//				
//				System.out.println("What card does Player 1 want to ask for?");
//				int nextCard = input.nextInt();
//				if (newGame.otherPlayerHasCard(p1, nextCard)) {
//					// take card from other player
//				} else {
//					// take card from deck
//				}
//				
//			} else if (newGame.playerTurn() == "user-2") {
//				
//				System.out.println("What card does Player 2 want to ask for?");
//				int nextCard = input.nextInt();
//				if (newGame.otherPlayerHasCard(p2, nextCard)) {
//					// take card from other player
//				} else {
//					// take card from deck
//				}
//			}
//		}
//		
//	}
	
	public static void main(String[] args) {
		Game newGame = new Game(5);
		newGame.playGame();
	}

}
