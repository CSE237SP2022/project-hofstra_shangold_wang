package player;

import java.util.ArrayList;

public class Player {
	
	private ArrayList<Integer> deck;
	private String name;
	
	public Player(String name) {
		this.deck = new ArrayList<Integer>();
		this.name = name;
	}
	
	public ArrayList<Integer> getDeck() {
		return this.deck;
	}
	
	
}
