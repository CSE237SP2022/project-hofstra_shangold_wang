package deckshuffler;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class DeckTest {

	@Test
	void addCardsIntoArrayContentsTest() {
		ShuffledDeck deck = new ShuffledDeck();
		ArrayList<Integer> unshuffledDeck = deck.addCardsIntoArray();
		
		ArrayList<Integer> testDeck = new ArrayList<Integer>();
		for (int i = 0; i < 13; i++) {
			testDeck.add(i);
			testDeck.add(i);
			testDeck.add(i);
			testDeck.add(i);
		}
		
		assertEquals(testDeck, unshuffledDeck);
	}
	
	@Test
	void addCardsIntoArraySizesTest() {
		ShuffledDeck deck = new ShuffledDeck();
		ArrayList<Integer> unshuffledDeck = deck.addCardsIntoArray();
		
		ArrayList<Integer> testDeck = new ArrayList<Integer>();
		for (int i = 0; i < 13; i++) {
			testDeck.add(i);
			testDeck.add(i);
			testDeck.add(i);
			testDeck.add(i);
		}
		
		assertEquals(52, unshuffledDeck.size());
	}

	@Test
	void addShuffledCardsIntoArrayContentsTest() {
		ShuffledDeck deck = new ShuffledDeck();
		ArrayList<Integer> shuffledDeck = deck.addShuffledCardsIntoArray();
		ArrayList<Integer> testDeck = new ArrayList<Integer>();
		for (int i = 0; i < 13; i++) {
			testDeck.add(i);
			testDeck.add(i);
			testDeck.add(i);
			testDeck.add(i);
		}
		assertNotEquals(testDeck, shuffledDeck);

	}
	
	@Test
	void addShuffledCardsIntoArraySizeTest() {
		ShuffledDeck deck = new ShuffledDeck();
		ArrayList<Integer> shuffledDeck = deck.addShuffledCardsIntoArray();
		ArrayList<Integer> testDeck = new ArrayList<Integer>();
		for (int i = 0; i < 13; i++) {
			testDeck.add(i);
			testDeck.add(i);
			testDeck.add(i);
			testDeck.add(i);
		}
		assertEquals(52, shuffledDeck.size());

	}
	
	@Test
	void addShuffledCardsIntoPlayerArrayTest() {
		ShuffledDeck deck = new ShuffledDeck();
		ArrayList<Integer> playerDeck = deck.addShuffledCardsIntoPlayerArray();
		
		int listLength = playerDeck.size();
		
		assertEquals(7, listLength);
	}
	
	@Test
	void initializeZeroDecksTest() {
		ShuffledDeck deck = new ShuffledDeck();
		ArrayList<ArrayList<Integer>> initializedDeck = deck.initializeDecks(0);
		
		int listLength = initializedDeck.size();
		
		assertEquals(1, listLength);
	}
	
	@Test
	void initializeFourDecksTest() {
		ShuffledDeck deck = new ShuffledDeck();
		ArrayList<ArrayList<Integer>> initializedDeck = deck.initializeDecks(4);
		
		int listLength = initializedDeck.size();
		
		assertEquals(5, listLength);
	}
	
	@Test
	void initializeTenDecksTest() {
		ShuffledDeck deck = new ShuffledDeck();
		ArrayList<ArrayList<Integer>> initializedDeck = deck.initializeDecks(10);
		
		int listLength = initializedDeck.size();
		
		assertEquals(11, listLength);
	}
	
	
}
