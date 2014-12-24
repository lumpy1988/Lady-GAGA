package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import model.BlackJackCard;
import model.BlackJackDealer;
import model.BlackJackHand;
import model.BlackJackModel;
import model.BlackJackPlayer;
import model.Deck;
import model.PlayerType;
import model.Suit;
import org.junit.Test;

public class AllTestsModel {
	
	/**
	 * checks method dealCard(PlayerType pt)
	 */
	@Test
	public void testDealCard() {
		// initialize game objects
		Deck d = new Deck();
		BlackJackDealer bd = new BlackJackDealer(d);
		BlackJackPlayer bp = new BlackJackPlayer(PlayerType.USER);
		BlackJackModel bm = new BlackJackModel(bd, bp);
		// deal 3 cards to player
		bm.dealCard(PlayerType.USER);
		bm.dealCard(PlayerType.USER);
		bm.dealCard(PlayerType.USER);
		
		assertEquals("Player should have 3 cards by now", 3, bp.getHand().getCards().size());
	}
	
	/**
	 * checks method CheckStatus(PlayerType pt)
	 */
	@Test
	public void testCheckStatus(){
		// initialize game objects
		Deck d = new Deck();
		BlackJackDealer bd = new BlackJackDealer(d);
		BlackJackPlayer bp = new BlackJackPlayer(PlayerType.USER);
		BlackJackModel bm = new BlackJackModel(bd, bp);

		assertEquals("Status didn't match the player's hand", 2, bm.CheckStatus(PlayerType.USER));
	}
	
	/**
	 * checks method getPlayer()
	 */
	@Test
	public void tetsGetPlayer(){
		// initialize game with customized player hand
		Deck d = new Deck();
		BlackJackDealer bd = new BlackJackDealer(d);
		ArrayList<BlackJackCard> cards = new ArrayList<BlackJackCard>();
		cards.add(new BlackJackCard(Suit.HEART, 4));
		cards.add(new BlackJackCard(Suit.DIAMOND, 9));
		cards.add(new BlackJackCard(Suit.DIAMOND, 3));
		BlackJackPlayer bp = new BlackJackPlayer(PlayerType.USER, new BlackJackHand(cards));
		BlackJackModel bm = new BlackJackModel(bd, bp);
		// set and get BlackJackPlayer object
		bm.setCurrentPlayer(bp);
		BlackJackPlayer newbp = bm.getCurrentPlayer();
		assertSame(bp, newbp);
	}
	
	/**
	 * checks method initializeGame()
	 */
	@Test
	public void testInitializeGame(){
		// initialize game object
		Deck d = new Deck();
		BlackJackDealer bd = new BlackJackDealer(d);
		BlackJackPlayer bp = new BlackJackPlayer(PlayerType.USER);
		BlackJackModel bm = new BlackJackModel(bd, bp);
		// reset player's hand
		bp.initializeHand();
		// store player hand's size
		int initializedHand = bp.getHand().getCards().size();
		
		bm.initializeGame();
		
		assertNotEquals("Player should have 2 cards by now.", initializedHand, bp.getHand().getCards().size());
	}
	
	/**
	 * checks method initializeHand()
	 */
	@Test
	public void testInitializeHand(){
		// initialize game with customized player hand
		Deck d = new Deck();
		BlackJackDealer bd = new BlackJackDealer(d);
		ArrayList<BlackJackCard> cards = new ArrayList<BlackJackCard>();
		cards.add(new BlackJackCard(Suit.HEART, 4));
		cards.add(new BlackJackCard(Suit.DIAMOND, 9));
		cards.add(new BlackJackCard(Suit.DIAMOND, 3));
		BlackJackPlayer bp = new BlackJackPlayer(PlayerType.USER, new BlackJackHand(cards));
		BlackJackModel bm = new BlackJackModel(bd, bp);
		// store player hand's size 
		int beforeInit = bp.getHand().getCards().size();
		
		bm.startGame();
		
		assertNotEquals("Player should have an empty hand by now.", beforeInit, bp.getHand().getCards().size());
	}
}