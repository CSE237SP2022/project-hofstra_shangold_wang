package goFish;

import java.util.ArrayList;

public class GoFish {
	
	private Player playerTo;
	private Player playerFrom;
	
	public GoFish() {
		this.playerTo = new Player();
		this.playerFrom = new Player();
	}
	
	public boolean cardFound(int card) {
		boolean cardThere = false;
		
		for (int i = 0; i < this.playerFrom.deck.size(); i++) {
			if (card == this.playerFrom.deck.get(i)) {
				cardThere = true;
			}
		}
	
		return cardThere;
	}
	
	public void moveCardPresent(int card) {
		ArrayList<Integer> moveCards = new ArrayList<Integer>();
		for (int i = 0; i < this.playerFrom.deck.size(); i++) {
			if (card == this.playerFrom.deck.get(i)) {
				moveCards.add(card);
				this.playerFrom.deck.remove(i);
			}
		}
		for (int i = 0; i < moveCards.size(); i++) {
			this.playerTo.deck.add(card);
		}
	}
	
	public boolean moveCardAbsent(ArrayList<Integer> mainDeck) {
		if (mainDeck.size() > 0) {
			int card = mainDeck.remove(0);
			this.playerTo.deck.add(card);
			return true;
		}
		else {
			return false;
		}
	}
	
}
