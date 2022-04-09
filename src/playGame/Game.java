package playGame;

import java.util.ArrayList;
import java.util.Scanner;

import deckshuffler.ShuffledDeck;
import goFish.GoFish;
import player.Player;

public class Game {
	
	public int goalPoints;
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
		
	}
	
	
	
	public boolean gameIsStillGoing() {
		if (player1.points < this.goalPoints && player2.points < this.goalPoints) {
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
			card = giver.deck.remove(card);
			taker.deck.add(card);
		}
		
	}
	
	public void takeCardFromDeck(Player taker) {
		int cardFromDeck = mainDeck.remove(mainDeck.size() - 1);
		taker.deck.add(cardFromDeck);
		
	}
	
	public Player playerTurn() {
		return this.player1;
	}
	
	public boolean otherPlayerHasCard(Player otherPlayer, int card) {
		return true;
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

}
