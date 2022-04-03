package player;

import java.util.ArrayList;

public class Player {
	
	public ArrayList<Integer> deck;
	public String name;
	
	public Player(String name) {
		this.deck = new ArrayList<Integer>();
		this.name = name;
	}
	
	public ArrayList<Integer> getDeck() {
		return this.deck;
	}
	
	public String getName() {
		return this.name;
	}
	
	
}
