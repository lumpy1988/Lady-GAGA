/**
 * @author Idan , Kosta , Or , Elinor
 */
package model;

import java.util.ArrayList;
import java.util.Random;
/**
 * Deck Class
 */
public class Deck 
{
	private ArrayList<BlackJackCard> cards; // array of cards
	private int dealtIndex; // index for the current card in the top of the card
	
	/**
	 * Card Constructor
	 */
	public Deck()
	{
		dealtIndex = 0;
		ArrayList<BlackJackCard> deckOfCards = new ArrayList<BlackJackCard>();
		for(int value = 1; value <= 13; value++)
		{
			deckOfCards.add(new BlackJackCard(Suit.CLUB, value));
			deckOfCards.add(new BlackJackCard(Suit.HEART, value));
			deckOfCards.add(new BlackJackCard(Suit.SPADE, value));
			deckOfCards.add(new BlackJackCard(Suit.DIAMOND, value));
		}
		setDeckOfCards(deckOfCards);
		shuffle();	//shuffle the cards
	}
	
	
	/**
	 * sets the deck of cards.
	 * @param ArrayList<BlackJackCard>
	 */
	protected void setDeckOfCards(ArrayList<BlackJackCard> deckOfCards)
	{
		cards = deckOfCards;
	}
	
	/**
	 * shuffle the cards
	 */
	public void shuffle()
	{
		//seed random number generator with system time
		Random r = new Random(System.currentTimeMillis());		
		for(int i = 0; i < cards.size(); i++)
		{
			int index = r.nextInt(cards.size());
			BlackJackCard temp = cards.get(index);
			cards.set(index, cards.get(i));
			cards.set(i, temp);
		}
		dealtIndex = 0;
	}
	
	/**
	 * return the number of cards remained in the deck according to the dealtIndex
	 * @return int
	 */
	protected int remainingCards()
	{
		return cards.size() - dealtIndex;
	}
	
	/**
	 * return a hand according to the numberOfCards
	 * @return BlackJackCard[]
	 */
	protected BlackJackCard[] dealHand(int numberOfCards)
	{
		BlackJackCard[] hand = (BlackJackCard[]) new Object[numberOfCards];
		for (int i = 0; i < numberOfCards; i++) 
		{
			hand[i] = cards.get(dealtIndex);
			dealtIndex++;
		}
		return hand;
	}
	
	/**
	 * return card from the top of the deck
	 * @return BlackJackCard
	 */
	protected BlackJackCard dealCard()
	{
		BlackJackCard c = cards.get(dealtIndex);
		dealtIndex++;		
		return c;
	}
	
	/**
	 * return the cards of the deck 
	 * @return ArrayList<BlackJackCard>
	 */
	protected ArrayList<BlackJackCard> getCards()
	{
		return cards;
	}
}
