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
	public void determineWhoWonTest() {
		Game newGame = new Game(20);
		newGame.player1.addPoints(10);
		newGame.player2.addPoints(20);
		newGame.player2.name = "test";
		
		String winner = newGame.determineWhoWon();
		
		assertEquals(newGame.player2.name, winner);
	}
	
	
}