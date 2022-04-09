package player;

import java.util.ArrayList;

import deckshuffler.ShuffledDeck;

public class Player {
	
	public ArrayList<Integer> deck;
	public ShuffledDeck shuffledDeck;
	public String name;
	public int points;
	
	public Player(String name) {
		this.deck = new ArrayList<Integer>();
		this.shuffledDeck = new ShuffledDeck();
//		this.deck = this.shuffledDeck.
		this.name = name;
		this.points = 0;
	}
	
	public ArrayList<Integer> getDeck() {
		return this.deck;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public void addPoints(int points) {
		this.points += points;
	}
	
	public void resetPoints() {
		this.points = 0;
	}
	
}
