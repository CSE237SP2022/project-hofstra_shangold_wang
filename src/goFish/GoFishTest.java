package goFish;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GoFishTest {
	
	ArrayList<Integer> playerToDeck = new ArrayList<Integer>();	
	ArrayList<Integer> playerFromDeck = new ArrayList<Integer>();
	ArrayList<Integer> mainDeck = new ArrayList<Integer>();
	GoFish goFish = new GoFish();

	@BeforeEach
	public void setup() {
		playerToDeck.add(1);
		playerFromDeck.add(1);
	}
	
	@Test
	void testCardNotFound() {
		
		int card = 2;
		boolean present = goFish.cardFound(card, playerFromDeck);
		assertEquals(false, present);
	}
	
	@Test
	void testCardFound() {
		int card = 1;
		boolean present = goFish.cardFound(card, playerFromDeck);
		assertEquals(true, present);
	}
	
	@Test
	void moveSingleCardPresent() {
		int card = 1;
		goFish.moveCardPresent(card, playerToDeck, playerFromDeck);
		int updatedSize = playerToDeck.size();
		assertEquals(2, updatedSize);
	}
	
	@Test
	void moveMultipleCardsPresent() {
		int card = 1;
		playerFromDeck.add(1);
		goFish.moveCardPresent(card, playerToDeck, playerFromDeck);
		int updatedSize = playerToDeck.size();
		assertEquals(3, updatedSize);
	}
	
	@Test
	void moveMainDeckAbsent() {
		boolean mainDeckPresent = goFish.moveCardAbsent(playerToDeck, mainDeck);
		assertEquals(false, mainDeckPresent);
	}
	
	@Test
	void moveMainDeckPresent() {
		mainDeck.add(2);
		boolean mainDeckPresent = goFish.moveCardAbsent(playerToDeck, mainDeck);
		assertEquals(true, mainDeckPresent);
	}
	
	@Test
	void fullSetFalse() {
		boolean isFull = goFish.fullSet(1, playerFromDeck);
		assertEquals(false, isFull);
	}
	
	@Test
	void fullSetTrue() {
		playerFromDeck.add(1);
		playerFromDeck.add(1);
		playerFromDeck.add(1);
		boolean isFull = goFish.fullSet(1, playerFromDeck);
		assertEquals(true, isFull);
	}

	@Test
	void emptySetFalse() {
		boolean isEmpty = goFish.emptyDeck(playerFromDeck);
		assertEquals(false, isEmpty);
	}
	
	@Test
	void emptySetTrue() {
		boolean isEmpty = goFish.emptyDeck(mainDeck);
		assertEquals(true, isEmpty);
	}
	
}
