package player;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
	
	@Test
	void testGetDeck() {
		ArrayList<Integer> testDeck = new ArrayList<Integer>();
		testDeck.add(1);
		testDeck.add(2);
		testDeck.add(3);
		
		Player player = new Player("test");
		player.deck.add(1);
		player.deck.add(2);
		player.deck.add(3);
		
		ArrayList<Integer> playerDeck = player.getDeck();
		
		assertEquals(testDeck, playerDeck);
	}
	
	@Test
	void testGetName() {
		Player player = new Player("test");
	
		String playerName = player.name;
		
		assertEquals("test", playerName);
	}
	
	@Test
	void testGetZeroPoints() {
		Player player = new Player("test");
		
		int points = player.getPoints();
		
		assertEquals(0, points);
	}
	
	@Test
	void testAddFivePoints() {
		Player player = new Player("test");
		
		player.addPoints(5);
		int points = player.getPoints();
		
		assertEquals(5, points);
	}
	
	@Test
	void testAddZeroPoints() {
		Player player = new Player("test");
		
		player.addPoints(0);
		int points = player.getPoints();
		
		assertEquals(0, points);
	}
	
	@Test
	void testResetPoints() {
		Player player = new Player("test");
		
		player.resetPoints();
		int points = player.getPoints();
		
		assertEquals(0, points);
	}
}
