package model;

/**
 * Card abstract Class
 */
public abstract class Card 
{
	private Suit suit; // card suit
	private int faceValue; // face value from 1 to 13
	
	/**
	 * Card Constructor.
	 * @param  Suit, int
	 */
	public Card(Suit s, int value)
	{
		faceValue = value;
		suit = s;
	}
	
	/**
	 * abstract function to calculate the card value
	 */
	protected abstract int value();
	
	/**
	 * return the suit of the card
	 */
	protected Suit getSuit()
	{
		return suit;
	}
	
	/**
	 * return the value of the card
	 */
	protected int getValue()
	{
		return faceValue;
	}
	
	/**
	 * return set value  of the card
	 */
	protected void setValue(int value)
	{
		this.faceValue = value;
	}
	
}
