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
		
		assertEquals(playerDeck, testDeck);
	}
	
	@Test
	void testGetName() {
		Player player = new Player("test");
	
		String playerName = player.name;
		
		assertEquals(playerName, "test");
	}
}
