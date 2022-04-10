package playGame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameTest {
	
	@Test
	public void gameIsStillGoingTest() {
		Game newGame = new Game(20);
		newGame.player1.points = 10;
		newGame.player2.points = 10;
		
		boolean stillPlaying = newGame.gameIsStillGoing();
		
		assertTrue(stillPlaying);
	}
	
	@Test
	public void gameIsNotStillGoingTest() {
		Game newGame = new Game(20);
		newGame.player1.points = 10;
		newGame.player2.points = 30;
		
		boolean stillPlaying = newGame.gameIsStillGoing();
		
		assertFalse(stillPlaying);
	}
	
	@Test
	public void checkIfPlayerHasCardTest() {
		Game newGame = new Game(20);
		newGame.player1.deck.add(2);
		
		boolean hasCard = newGame.checkIfPlayerHasCard(newGame.player1, 2);
		
		assertTrue(hasCard);
	}
	
	@Test
	public void removeCardFromAnotherPlayerTest() {
		Game newGame = new Game(20);
		int initialDeckSize = newGame.player2.getDeck().size();
		int card = newGame.player2.deck.get(0);
		
		newGame.takeCardFromAnotherPlayer(newGame.player1, newGame.player2, card);
		int newDeckSize = newGame.player2.getDeck().size();
				
		assertEquals(newDeckSize, initialDeckSize - 1);
	}
	
	@Test
	public void takeCardFromDeckSizeTest() {
		Game newGame = new Game(20);
		int initialDeckSize = newGame.player1.deck.size();
		
		newGame.takeCardFromDeck(newGame.player1);
		int newDeckSize = newGame.player1.getDeck().size();
		
		assertEquals(initialDeckSize + 1, newDeckSize);
	}
	
	@Test
	public void determineWhoWonTest() {
		Game newGame = new Game(20);
		newGame.player1.addPoints(10);
		newGame.player2.addPoints(20);
		newGame.player2.name = "test";
		
		String winner = newGame.determineWhoWon();
		
		assertEquals(newGame.player2.name, winner);
	}
	
	@Test
	public void checkIfSetOfThreeExistsTrueTest() {
		Game newGame = new Game(20);
		newGame.player1.deck.add(1);
		newGame.player1.deck.add(1);
		newGame.player1.deck.add(1);
		
		int setExists = newGame.checkIfSetOfThreeExists(newGame.player1);
		
		assertNotEquals(-1, setExists);
	}
	
	@Test
	public void takeAwaySetOfThreeSizeTest() {
		Game newGame = new Game(20);
		newGame.player1.deck.add(1);
		newGame.player1.deck.add(1);
		newGame.player1.deck.add(1);
		int initialDeckSize = newGame.player1.deck.size();
		
		newGame.takeAwaySetOfThree(newGame.player1);
		int newDeckSize = newGame.player1.deck.size();
		
		assertEquals(initialDeckSize - 3, newDeckSize);
		
	}
	
	@Test
	public void updatePointsFromSetOfThreeTest() {
		Game newGame = new Game(20);
		int initialPoints = newGame.player1.points;
		newGame.player1.deck.add(1);
		newGame.player1.deck.add(1);
		newGame.player1.deck.add(1);
		
		newGame.updatePointsFromSetOfThree(newGame.player1);
		int updatedPoints = newGame.player1.points;
		
		assertEquals(initialPoints + 5, updatedPoints);
	}
	
}