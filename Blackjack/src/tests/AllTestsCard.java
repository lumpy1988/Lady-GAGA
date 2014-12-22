package tests;

import static org.junit.Assert.*;
import main.Blackjack;
import model.BlackJackCard;
import model.PlayerType;
import org.junit.Before;
import org.junit.Test;

/**
 * Case of JUnit tests for Cards actions
 * @author Elinor, Or, Idan, Kosta
 *
 */
public class AllTestsCard {
	
	/**
	 * Preparation of the application for the required tests
	 */
	@Before
	public void beforeTests(){
		
		// start the application and press "Deal" for each test
		Blackjack.main(null);
		Blackjack.getView().clickDeal();
	}
	
	/**
	 * Checks if the face of a card is presented as required
	 */
	@Test
	public void testCardFrontDisplay(){
		
		boolean up = false;
		// one of the dealer's cards should be faced up
		for (BlackJackCard c : Blackjack.getGame().getDealer().getHand().getCards()){
			if (c.isFacedUp())
				up = true;
		}
		// all player's cards must be faced up
		for (BlackJackCard c : Blackjack.getGame().getCurrentPlayer().getHand().getCards()){
			if (!c.isFacedUp())
				up = false;
		}
		assertTrue("Some dealer's card must be faced up.\nAll player's cards must be faced up.", up);
	}
	
	/**
	 * Checks if the back of a card is presented as required
	 */
	@Test
	public void testCardBackDisplay(){
		
		boolean up = true;
		// one of the dealer's cards must be faced down
		for (BlackJackCard c : Blackjack.getGame().getDealer().getHand().getCards()){
			if (!c.isFacedUp())
				up = false;
		}
		assertTrue("Some Dealer's card must be faced down.", !up);
	}
	
	/**
	 * Checks if hitting "Hit" adds a card to the player's hand
	 */
	@Test
	public void testHitAction(){
		
		if (Blackjack.getController().checkGameStatus(PlayerType.USER) == 2){// make sure the "Hit" action is relevant for this game
			Blackjack.getView().clickHit();
			int playerHand = Blackjack.getGame().getCurrentPlayer().getHand().getCards().size();// check if an additional card were added to player's hand
			assertEquals("Player should have three cards at this point.", playerHand, 3);
		}
		else
			fail("Game scenario didn't go as expected. Test is invalid, try again.");
	}
}
