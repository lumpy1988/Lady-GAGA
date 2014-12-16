/**
 * @author Idan , Kosta , Or , Elinor
 */
package model;

import java.util.ArrayList;
/**
 * Hand interface
 */
public interface Hand 
{
	public int score(PlayerType pt); // return the hand score
	public ArrayList<Integer> possibleScores(PlayerType pt);// return possible scores
	public boolean busted(PlayerType pt); // check for bust
	public boolean is21(PlayerType pt); // check for 21
	public ArrayList<BlackJackCard> getCards(); //return the cards
	public void addCard(BlackJackCard card); // add card to hand
	boolean acesInHand(); // checks for aces in the player hand. (for soft 17 in the dealer player).
}
