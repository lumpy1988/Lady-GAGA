/**
 * @author Idan , Kosta , Or , Elinor
 */
package model;

/**
 * Suit enum
 */
public enum Suit 
{
	HEART(0), CLUB(1), DIAMOND(2), SPADE(3);
	
	/**
	 * suit value 0-3
	 */
	private int value;
	
	/**
	 * Suit Constructor
	 */
	private Suit(int v)
	{
		value = v;
	}

	/**
	 * return the value of the suit 
	 * @return int
	 */
	public int getValue() 
	{
		return value;
	}
	
	/**
	 * static method to translate suit from value
	 * @param int
	 * @return Suit
	 */
	public static Suit getSuitFromValue(int value)
	{
		switch(value) 
		{
			case 0:	return HEART;
			case 1: return CLUB;
			case 2: return DIAMOND;
			case 3: return SPADE;
			default: return null;
		}
	}
}
