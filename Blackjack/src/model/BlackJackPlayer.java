/**
 * @author Idan , Kosta , Or , Elinor
 */
package model;
/**
 * BlackJackPlayer Class
 * implements Player 
 */
public class BlackJackPlayer implements Player 
{	
	private BlackJackHand hand; 
	private PlayerType playerType;
	
	/**
	 * BlackJackPlayer Constructor.
	 */
	public BlackJackPlayer(PlayerType pt)
	{
		hand = new BlackJackHand();
		playerType = pt;
	}
	
	/**
	 * #QA created new constructor
	 * BlackJackPlayer Constructor
	 * @param PlayerType, BlackJackHand
	 */
	public BlackJackPlayer(PlayerType pt, BlackJackHand bh)
	{
		hand = bh;
		playerType = pt;
	}
	
	/**
	 * clean the hand
	 */
	@Override
	public void initializeHand()
	{
		hand = new BlackJackHand();
	}
	
	/**
	 * commit hit in the game.
	 * @return the blackjack card.
	 */
	@Override
	public BlackJackCard hit(BlackJackDealer d) 
	{
		BlackJackCard bc = d.dealCard();
		takeCard(bc);
		return bc;
	}

	/**
	 * add card to the dealer's hand.
	 */
	@Override
	public void takeCard(BlackJackCard c) 
	{
		hand.addCard(c);
	}

	/**
	 * check if the player got the score 21
	 */
	@Override
	public boolean got21()
	{
		return hand.is21(playerType);
	}
	/**
	 * check if the player got busted. his score exceeded 21
	 */
	@Override
	public boolean isbusted()
	{
		return hand.busted(playerType);
	}

	/**
	 * return the user's player type
	 */
	@Override
	public PlayerType getPlayerType() 
	{
		return playerType;
	}
	/**
	 * return the user's hand
	 */
	@Override
	public BlackJackHand getHand()
	{
		return hand;
	}

}
