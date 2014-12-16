/**
 * @author Idan , Kosta , Or , Elinor
 */
package model;

/**
 * BlackJackDealer Class
 * implements the Player interface.
 */
public class BlackJackDealer implements Player {
	
	private Deck deck; //deck of cards
	private BlackJackHand hand; //dealer's hand
	private PlayerType playerType = PlayerType.DEALER; // player type = DEALER
	
	
	/**
	 * BlackJackDealer Constructor.
	 * gets the deck. create new empty hand.
	 * @param  Deck
	 */
	public BlackJackDealer(Deck d) 
	{
		deck = d;
		hand = new BlackJackHand();
	}
	
	/**
	 * get one card from the deck
	 */
	public BlackJackCard dealCard()
	{
		return deck.dealCard();
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
		BlackJackCard bc = deck.dealCard();
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
	 * check if the dealer got the score 21
	 */
	@Override
	public boolean got21()
	{
		return hand.is21(playerType);
	}
	/**
	 * check if the dealer got busted. his score exceeded 21
	 */
	@Override
	public boolean isbusted()
	{
		return hand.busted(playerType);
	}

	/**
	 * return the dealer's hand
	 */
	@Override
	public BlackJackHand getHand() 
	{
		return hand;
	}
	
	/**
	 * return the dealer's player type
	 */
	@Override
	public PlayerType getPlayerType()
	{
		return playerType;
	}
	/**
	 * return the deck of the game.
	 */
	public Deck getDeck()
	{
		return deck;
	}
	
	/**
	 * checks if the dealer faces the soft 17 status.
	 * @return boolean true if it is soft 17 status and false if it is not.
	 */
	public boolean checkSoft17()
	{
		return (hand.score(playerType) == 17 && hand.acesInHand());
	}

}
