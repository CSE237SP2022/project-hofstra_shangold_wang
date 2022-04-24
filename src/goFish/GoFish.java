package goFish;

import java.util.ArrayList;

import player.Player;

public class GoFish {
	
	
	public GoFish() {
		
	}
	
	public void printDeck(ArrayList<Integer> playerDeck) {
		System.out.println("Cards in Player's deck: ");
		for (int i = 0; i < playerDeck.size(); i++) {
			System.out.print(" |" + playerDeck.get(i)+"| ");	
		}
		System.out.println("");
	}
	
	public int computerSelectCardToTarget(ArrayList<Integer> computerDeck) {
		int selectedIndex = (int) (Math.random()*computerDeck.size());
		int selectedCard = computerDeck.get(selectedIndex);
		return selectedCard;
	}
	
	public boolean cardFound(int card, ArrayList<Integer> playerDeck) {
		boolean cardThere = false;
		
		for (int i = 0; i < playerDeck.size(); i++) {
			if (card == playerDeck.get(i)) {
				cardThere = true;
			}
		}
	
		return cardThere;
	}
	
	public void takeCardFromAnotherPlayer(int card, Player taker, Player giver) {
		ArrayList<Integer> playerToDeck = taker.deck;
		ArrayList<Integer> playerFromDeck = giver.deck;
		ArrayList<Integer> moveCards = new ArrayList<Integer>();
		for (int i = 0; i < playerFromDeck.size(); i++) {
			if (card == playerFromDeck.get(i)) {
				System.out.println("Card found! " + taker.name + 
						" took " + card + " from " + giver.name + ".");
				moveCards.add(card);
				playerFromDeck.remove(i);
				i = i-1;
			}
		}
		for (int i = 0; i < moveCards.size(); i++) {
			playerToDeck.add(card);
		}
	}
	
	public boolean takeCardFromDeck(Player taker, ArrayList<Integer> mainDeck) {
		ArrayList<Integer> playerToDeck = taker.deck;
		if (mainDeck.size() > 0) {
			int card = mainDeck.remove(0);
			System.out.println("Go Fish! " + taker.name + 
					" took a card from the deck.");
			playerToDeck.add(card);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean fullSet(int card, ArrayList<Integer> playerDeck) {
		int numberOfCard = 0;
		for (int i = 0; i < playerDeck.size(); i++) {
			if (card == playerDeck.get(i)) {
				numberOfCard = numberOfCard + 1;
			}
		}
		boolean setFull = false;
		if (numberOfCard == 4) {
			setFull = true;
			for (int i = 0; i < playerDeck.size(); i++) {
				if (card == playerDeck.get(i)) {
					playerDeck.remove(i);
					i = i-1;
				}
			}
		}
		
		return setFull;
	}
	
	public boolean emptyDeck(ArrayList<Integer> Deck) {
		boolean empty = false;
		if (Deck.size() == 0) {
			empty = true;
		}
		return empty;
	}
	
	
	public boolean checkIfPlayerHasCard(Player player, int card) {
		ArrayList<Integer> playerDeck = player.deck;
		return cardFound(card, playerDeck);
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
	
}
