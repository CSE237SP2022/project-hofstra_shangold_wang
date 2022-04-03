package deckshuffler;
import java.util.ArrayList; 
public class ShuffledDeck {
	
	private int numberOfSuit; 
	private ArrayList<Integer> notShuffledDeck;
	private ArrayList<Integer> shuffledDeck;
	
	public ShuffledDeck() {
		this.numberOfSuit = 13;
		this.notShuffledDeck = new ArrayList<Integer>();
		this.shuffledDeck= new ArrayList<Integer>();
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
	
	public ArrayList<Integer> addShuffledCardsIntoArray(){
		 while (this.notShuffledDeck.size() > 0) {
	            int indexOfCardRemoved = (int) (Math.random() * this.notShuffledDeck.size());
	            int removedCard = notShuffledDeck.remove(indexOfCardRemoved);
	            shuffledDeck.add(removedCard);
	        }
		return this.shuffledDeck;
	}
	
	public static void main(String[] args) {
		ShuffledDeck deck = new ShuffledDeck();
		ArrayList<Integer> unshuffledDeck = deck.addCardsIntoArray();
		ArrayList<Integer> shuffledDeck = deck.addShuffledCardsIntoArray();
	
		System.out.println(shuffledDeck);

	}
	

}
