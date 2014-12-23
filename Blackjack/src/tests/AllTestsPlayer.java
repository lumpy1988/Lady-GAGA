package tests;

import static org.junit.Assert.*;
import main.Blackjack;
import model.PlayerType;

import org.junit.Before;
import org.junit.Test;

import view.BlackJackView;

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
	}
	
	/**
	 * Checks if hitting "Stand" ends the player's turn and starts the dealer's turn
	 */
	@Test
	public void testStandDisabled() {
		
		if (Blackjack.getGame().CheckStatus(PlayerType.USER) == 2){
			Blackjack.getView().clickStand();
			
			assertFalse("Stand button should be disabled at this state of the game", Blackjack.getView().isStandEnabled());
		}
		else
			fail("Game scenario didn't go as expected. Test is invalid, try again.");
	}
	
	/**
	 * Checks if hitting "Hit" ends the player's turn and starts the dealer's turn
	 */
	@Test
	public void testHitDisabled() {
		
		if (Blackjack.getGame().CheckStatus(PlayerType.USER) == 2){
			Blackjack.getView().clickStand();
			
			assertFalse("Hit button should be disabled at this state of the game", Blackjack.getView().isHitEnabled());
		}
		else
			fail("Game scenario didn't go as expected. Test is invalid, try again.");
	}
}
