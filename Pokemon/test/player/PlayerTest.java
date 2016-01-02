package player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pokemon.Pokemon;

/**
 * Test player class
 * @author Blake Hooks
 *
 */
public class PlayerTest {
	/** Player to be tested */
	Player player;
	
	/**
	 * Setup player to be tested
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		player = Player.getPlayer();
	}

	/**
	 * Test getX method
	 */
	@Test
	public void testGetX() {
		assertEquals(1000, player.getX(), 0);
	}

	/**
	 * Test getY method
	 */
	@Test
	public void testGetY() {
		assertEquals(650, player.getY(), 0);
	}
	
	/**
	 * Test move method
	 */
	@Test
	public void testMove() {
		player.move(100, 0);
		assertEquals(1100, player.getX(), 0);
		assertEquals(650, player.getY(), 0);
		
		player.move(0, 100);
		assertEquals(1100, player.getX(), 0);
		assertEquals(750, player.getY(), 0);
		
		player.move(100, 100);
		assertEquals(1200, player.getX(), 0);
		assertEquals(850, player.getY(), 0);
	}

}
