/**
 * @author Idan , Kosta , Or , Elinor
 */
package model;
/**
 * Player interface
 */
public interface Player 
{	
	public BlackJackCard hit(BlackJackDealer d); // Take a card from the dealer
	public void takeCard(BlackJackCard c); // Take a card from the dealer
	public boolean got21(); // check if current player got 21
	public boolean isbusted(); // check if current player got busted
	public PlayerType getPlayerType(); // checks the player type
	public BlackJackHand getHand(); // get the player hand
	public void initializeHand(); // empty the player hand
}
