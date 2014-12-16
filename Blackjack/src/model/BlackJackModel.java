/**
 * @author Idan , Kosta , Or , Elinor
 */
package model;
/**
 * BlackJackModel Class
 * MVS - model
 * implements CardGame 
 */
public class BlackJackModel implements CardGame 
{	
	private BlackJackDealer dealer; 
	private BlackJackPlayer player;
	
	/**
	 * BlackJackModel Constructor.
	 */
	public BlackJackModel()
	{
		Deck d = new Deck();
		dealer = new BlackJackDealer(d);
		player = new BlackJackPlayer(PlayerType.USER);
	}
	
	
	/**
	 * starts the game.
	 */
	@Override
	public void startGame() 
	{
		dealer.initializeHand();
		player.initializeHand();
		dealer.getDeck().shuffle();
		initializeGame();
	}

	/**
	 * initialize the game in the model point of view and deal 2 cards to the dealer and the user.
	 */
	@Override
	public void initializeGame() 
	{
		BlackJackCard a;
		//Player first card:
		a = dealer.dealCard();
		a.faceUp();
		player.takeCard(a);
		//Dealer first card:
		BlackJackCard b;
		b = (BlackJackCard) dealer.dealCard();
		b.faceUp();
		dealer.takeCard(b);
		//Player second card:
		BlackJackCard c;
		c = (BlackJackCard) dealer.dealCard();
		c.faceUp();
		player.takeCard(c);
		//dealer second card - Face down:
		BlackJackCard d;
		d = (BlackJackCard) dealer.dealCard();
		d.faceDown();
		dealer.takeCard(d);		
	}

	/**
	 * return the user player
	 */
	public BlackJackPlayer getCurrentPlayer() 
	{
		return player;
	}
	
	/**
	 * sets the user player
	 */
	public void setCurrentPlayer(BlackJackPlayer currentPlayer) 
	{
		this.player = currentPlayer;
	}

	/**
	 * get the dealer player
	 */
	public BlackJackDealer getDealer() 
	{
		return dealer;
	}
	
	/**
	 * check the game status of the current user
	 * @return int. 
	 * if the current player got busted return 0. 
	 * if the current player got 21 return 1. 
	 * if the current player can continue to hit return 2.
	 */
	public int CheckStatus (PlayerType pt)
	{
		BlackJackCard a;
		a = dealer.dealCard();
		a.faceUp();
		if (pt.equals(PlayerType.USER))
		{
			if (player.isbusted())
			{
				return 0;
			}
			if (player.got21())
			{
				return 1;
			}
			else
			{
				return 2;	
			}
		}
		else
		{
			if (dealer.isbusted())
			{
				return 0;
			}
			if (dealer.checkSoft17() || dealer.getHand().score(pt) < 17)
			{
				return 2;	
			}
			else
			{
				return 1;
			}
		}	
	}
	
	
	/**
	 * deal card to the current player.
	 * @return BlackJackCard. 
	 */
	public BlackJackCard dealCard(PlayerType pt)
	{
		BlackJackCard a;	
		a = pt.equals(PlayerType.USER) ? player.hit(dealer) : dealer.hit(dealer);
		a.faceUp();
		return a;
	}
	
}
