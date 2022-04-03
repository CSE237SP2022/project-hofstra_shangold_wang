package deckshuffler;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class DeckTest {

	@Test
	void addCardsIntoArrayTest() {
		ShuffledDeck deck = new ShuffledDeck();
		ArrayList<Integer> unshuffledDeck = deck.addCardsIntoArray();
		
		ArrayList<Integer> testDeck = new ArrayList<Integer>();
		for (int i = 0; i < 13; i++) {
			testDeck.add(i);
			testDeck.add(i);
			testDeck.add(i);
			testDeck.add(i);
		}
		
		assertEquals(unshuffledDeck, testDeck);
		assertEquals(unshuffledDeck.size(),52);
	}

	@Test
	void addShuffledCardsIntoArray() {
		ShuffledDeck deck = new ShuffledDeck();
		ArrayList<Integer> shuffledDeck = deck.addShuffledCardsIntoArray();
		ArrayList<Integer> testDeck = new ArrayList<Integer>();
		for (int i = 0; i < 13; i++) {
			testDeck.add(i);
			testDeck.add(i);
			testDeck.add(i);
			testDeck.add(i);
		}
		assertNotEquals(shuffledDeck,testDeck);
		assertEquals(shuffledDeck.size(),52);

	}
}
