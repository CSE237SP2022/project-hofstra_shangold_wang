package goFish;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import playGame.Game;
import player.Player;


class GoFishTest {
	
	ArrayList<Integer> playerToDeck = new ArrayList<Integer>();	
	ArrayList<Integer> playerFromDeck = new ArrayList<Integer>();
	ArrayList<Integer> mainDeck = new ArrayList<Integer>();
	Player player1 = new Player("player1");
	Player player2 = new Player("player2");
	GoFish goFish = new GoFish();

	@BeforeEach
	public void setup() {
		playerToDeck.add(1);
		playerFromDeck.add(1);
	}
	
	@Test
	void selectCardFromOne() {
		int testedCardSelect = goFish.computerSelectCardToTarget(playerToDeck);
		assertEquals(1, testedCardSelect);
	}
	
	@Test
	void selectCardFromThree() {
		playerToDeck.add(1);
		playerToDeck.add(1);
		int testedCardSelect = goFish.computerSelectCardToTarget(playerToDeck);
		assertEquals(1, testedCardSelect);
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
		goFish.takeCardFromAnotherPlayer(card, playerToDeck, playerFromDeck);
		int updatedSize = playerToDeck.size();
		assertEquals(2, updatedSize);
	}
	
	@Test
	void moveMultipleCardsPresent() {
		int card = 1;
		playerFromDeck.add(1);
		goFish.takeCardFromAnotherPlayer(card, playerToDeck, playerFromDeck);
		int updatedSize = playerToDeck.size();
		assertEquals(3, updatedSize);
	}
	
	@Test
	void moveMainDeckAbsent() {
		boolean mainDeckPresent = goFish.takeCardFromDeck(playerToDeck, mainDeck);
		assertEquals(false, mainDeckPresent);
	}
	
	@Test
	void moveMainDeckPresent() {
		mainDeck.add(2);
		boolean mainDeckPresent = goFish.takeCardFromDeck(playerToDeck, mainDeck);
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
	
	@Test
	public void checkIfPlayerHasCardTest() {
		player1.deck.add(2);
		
		boolean hasCard = goFish.checkIfPlayerHasCard(player1, 2);
		
		assertTrue(hasCard);
	}
	
	@Test
	public void removeCardFromAnotherPlayerTest() {
		player2.deck.add(1);
		player2.deck.add(2);
		int initialDeckSize = player2.getDeck().size();
		int card = player2.deck.get(0);
		
		goFish.takeCardFromAnotherPlayer(card, player1.deck, player2.deck);
		int newDeckSize = player2.getDeck().size();
				
		assertEquals(newDeckSize, initialDeckSize - 1);
	}
	
	@Test
	public void takeCardFromDeckSizeTest() {
		int initialDeckSize = player1.deck.size();
		ArrayList<Integer> mainDeck = new ArrayList<Integer>();
		mainDeck.add(3);
		
		goFish.takeCardFromDeck(player1.deck, mainDeck);
		int newDeckSize = player1.getDeck().size();
		
		assertEquals(initialDeckSize + 1, newDeckSize);
	}
	
	@Test
	public void checkIfSetOfThreeExistsTrueTest() {
		player1.deck.add(1);
		player1.deck.add(1);
		player1.deck.add(1);
		
		int setExists = goFish.checkIfSetOfThreeExists(player1);
		
		assertNotEquals(-1, setExists);
	}
	
	@Test
	public void takeAwaySetOfThreeSizeTest() {
		player1.deck.add(1);
		player1.deck.add(1);
		player1.deck.add(1);
		int initialDeckSize = player1.deck.size();
		
		goFish.takeAwaySetOfThree(player1);
		int newDeckSize = player1.deck.size();
		
		assertEquals(initialDeckSize - 3, newDeckSize);
		
	}
	
	@Test
	public void updatePointsFromSetOfThreeTest() {
		int initialPoints = player1.points;
		player1.deck.add(1);
		player1.deck.add(1);
		player1.deck.add(1);
		
		goFish.updatePointsFromSetOfThree(player1);
		int updatedPoints = player1.points;
		
		assertEquals(initialPoints + 5, updatedPoints);
	}
	
}
