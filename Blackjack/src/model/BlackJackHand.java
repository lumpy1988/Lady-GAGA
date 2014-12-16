/**
 * @author Idan , Kosta , Or , Elinor
 */
package model;

import java.util.ArrayList;
/**
 * BlackJackHand Class
 * implements Hand
 */
public class BlackJackHand implements Hand
{
	protected ArrayList<BlackJackCard> cards;	
	/**
	 * BlackJackHand Constructor.
	 * sets arraylist of cards
	 */
	public BlackJackHand()
	{
		cards = new ArrayList<BlackJackCard>();
	}
	
	/**
	 * calculate the hand score
	 * @param gets the player type in order to know how to calculate the aces.
	 */
	@Override
	public int score(PlayerType pt) 
	{
		ArrayList<Integer> scores = possibleScores(pt);
		int maxUnder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;
		
		for (int score : scores){
			if (score > 21 && score < minOver){
				minOver = score;
			}
			else if (score <= 21 && score > maxUnder) {
				maxUnder = score;
			}
		}
		return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
	}
	
	/**
	 * calculate all the possible hand scores.
	 * @param gets the player type in order to know how to calculate the aces.
	 * @return ArrayList<Integer>
	 */
	@Override
	public ArrayList<Integer> possibleScores(PlayerType pt)
	{		
		int numAces = 0;
		int score = 0;
		ArrayList<Integer> possibleScores = new ArrayList<Integer>();
		
		for(BlackJackCard c : cards)
		{
			// in case this is the first ace in the user's hand.
			if (pt.equals(PlayerType.USER) && c.isAce() && numAces==0)
			{
				score += 10;
				numAces++;
			}
			// in case this isn't the first ace in the user's hand.
			else if (pt.equals(PlayerType.DEALER) && c.isAce())
			{
				numAces++;
			}
			// in case this isn't the first ace in the user's hand or it is ace in the dealer's hand or it is other regular card.
				score += c.value();
		}
		possibleScores.add(score);
		if (pt.equals(PlayerType.DEALER))
		{
			for (int i = 0; i < numAces; i++)
			{
				score += 10;
				possibleScores.add(score);
			}
		}
		return possibleScores;	
	}
	
	/**
	 * check if the player busted
	 * @param gets the player type in order to know how to calculate the aces.
	 * @return boolean
	 */
	@Override
	public boolean busted(PlayerType pt) 
	{
		return score(pt) > 21;
	}
	
	/**
	 * check if the score equals to 21
	 * @param gets the player type in order to know how to calculate the aces.
	 * @return boolean
	 */
	@Override
	public boolean is21(PlayerType pt)
	{
		return score(pt) == 21;
	}
	
	/**
	 * check for aces in the hand
	 * @return boolean true or false
	 */
	@Override
	public boolean acesInHand()
	{
		for(BlackJackCard c : cards)
		{
			if (c.isAce())
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * return the cards
	 * @return ArrayList<BlackJackCard>
	 */
	@Override
	public ArrayList<BlackJackCard> getCards()
	{
		return cards;
	}
	
	/**
	 * add card to the arraylist.
	 * @param BlackJackCard
	 */
	@Override
	public void addCard(BlackJackCard card)
	{
		cards.add(card);
	}
	
}
