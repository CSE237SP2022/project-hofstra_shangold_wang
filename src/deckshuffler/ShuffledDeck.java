package deckshuffler;
import java.util.ArrayList; 
public class ShuffledDeck {
	
	private int numberOfSuit; 
	private ArrayList<Integer> notShuffledDeck;
	private ArrayList<Integer> shuffledDeck;
	private ArrayList<Integer> playerDeck;
	private ArrayList<ArrayList<Integer>> fullDeck;
	
	public ShuffledDeck() {
		this.numberOfSuit = 13;
		this.notShuffledDeck = new ArrayList<Integer>();
		this.shuffledDeck= new ArrayList<Integer>();
		this.playerDeck= new ArrayList<Integer>();
		this.fullDeck= new ArrayList<ArrayList<Integer>>();
	}
	
	
//ArrayList<Integer> notShuffledDeck = new ArrayList<Integer>();

	public ArrayList<Integer> addCardsIntoArray() {
		for (int i = 0; i < this.numberOfSuit; i++) {
			this.notShuffledDeck.add(i);
			this.notShuffledDeck.add(i);
			this.notShuffledDeck.add(i);
			this.notShuffledDeck.add(i);
		}
		
		return this.notShuffledDeck;
	}
	
	public ArrayList<Integer> addShuffledCardsIntoArray() {
		addCardsIntoArray();
		while (this.notShuffledDeck.size() > 0) {
			int indexOfCardRemoved = (int) (Math.random() * this.notShuffledDeck.size());
			int removedCard = notShuffledDeck.remove(indexOfCardRemoved);
	        shuffledDeck.add(removedCard);
	    }
		return this.shuffledDeck;
	} 
	public ArrayList<Integer> addShuffledCardsIntoPlayerArray(){
		addShuffledCardsIntoArray();
		ArrayList<Integer> playerDeck = new ArrayList<Integer>();
		
		for(int j=0; j<7; j++) {
				playerDeck.add(this.shuffledDeck.get(0));
				this.shuffledDeck.remove(0);
		}
			
		return playerDeck;
	}
	
	public ArrayList<ArrayList<Integer>> initializeDecks(int numberPlayers) {
	
		for (int i = 0; i< numberPlayers; i++) {
			
				this.fullDeck.add(addShuffledCardsIntoPlayerArray());
				
			}
		
			this.fullDeck.add(this.shuffledDeck);
		return this.fullDeck;
	}
	
	public static void main(String[] args) {
		ShuffledDeck deck = new ShuffledDeck();
		ArrayList<Integer> unshuffledDeck = deck.addCardsIntoArray();
		ArrayList<Integer> shuffledDeck = deck.addShuffledCardsIntoArray();
		//System.out.println(shuffledDeck);
		ArrayList<Integer> playerDeck = deck.addShuffledCardsIntoPlayerArray();
		
		//initializeDecks initial = new initializeDecks(4);
		ArrayList<ArrayList<Integer>> fullDeck = deck.initializeDecks(2);
	

		//System.out.println(playerDeck);
		System.out.println(fullDeck);
	}
	

}
