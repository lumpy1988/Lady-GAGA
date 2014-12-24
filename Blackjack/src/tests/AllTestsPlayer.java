package tests;

import static org.junit.Assert.*;
import main.Blackjack;
import model.PlayerType;
import org.junit.Before;
import org.junit.Test;

/**
 * Case of JUnit tests for Player actions
 * @author Elinor, Or, Idan, Kosta
 *
 */
public class AllTestsPlayer {
		
	/**
	 * Set the application for an initial state @Before every test
	 */
	@Before
	public void beforeTests(){
		
		Blackjack.onTest = true;
		Blackjack.main(null);
		Blackjack.getView().clickDeal();
		if (Blackjack.getGame().CheckStatus(PlayerType.USER) == 2)// make sure the game status is relevant for this tests
			Blackjack.getView().clickStand();
		else
			fail("Game scenario made test irrelevant, please try again.");
	}
	
	/**
	 * Checks if hitting "Stand" ends the player's turn and starts the dealer's turn
	 */
	@Test
	public void testStandDisabled() {
		
		assertFalse("Stand button should be disabled at this state of the game", Blackjack.getView().isStandEnabled());
	}
	
	/**
	 * Checks if hitting "Hit" ends the player's turn and starts the dealer's turn
	 */
	@Test
	public void testHitDisabled() {
		
		assertFalse("Hit button should be disabled at this state of the game", Blackjack.getView().isHitEnabled());
	}
}
