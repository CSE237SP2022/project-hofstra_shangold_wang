package goFish;

import java.util.ArrayList;

public class GoFish {
	
	
	public GoFish() {
		
	}
	
	public void printDeck(ArrayList<Integer> playerDeck) {
		System.out.println("Cards in Player's deck: ");
		for (int i = 0; i < playerDeck.size(); i++) {
			System.out.print(playerDeck.get(i)+", ");	
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
	
	public void moveCardPresent(int card, ArrayList<Integer> playerToDeck, ArrayList<Integer> playerFromDeck) {
		ArrayList<Integer> moveCards = new ArrayList<Integer>();
		for (int i = 0; i < playerFromDeck.size(); i++) {
			if (card == playerFromDeck.get(i)) {
				moveCards.add(card);
				playerFromDeck.remove(i);
				i = i-1;
			}
		}
		for (int i = 0; i < moveCards.size(); i++) {
			playerToDeck.add(card);
		}
	}
	
	public boolean moveCardAbsent(ArrayList<Integer> playerToDeck, ArrayList<Integer> mainDeck) {
		if (mainDeck.size() > 0) {
			int card = mainDeck.remove(0);
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
	
	
	
}
