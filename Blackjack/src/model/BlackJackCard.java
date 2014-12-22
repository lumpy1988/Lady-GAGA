/**
 * @author Idan , Kosta , Or , Elinor
 */
package model;

/**
 * BlackJackCard Class
 */
public class BlackJackCard extends Card implements Facing 
{
	//indicate the card image name
	private String cardImageLocation;
	//indicate if the card is face up or down
	private Face facing;
	
	/**
	 * BlackJackCard Constructor.
	 * gets suit type and value.
	 * @param  Suit, int
	 */
	public BlackJackCard(Suit s, int value) 
	{
		super(s, value);
		cardImageLocation = CardImageLoader.getImageLocation(s, value);
		facing = null;
	}
	
	/**
	 * value() function indicates what is the value of the card in blackjack game.
	 * gets suit type and value.
	 * @return int 
	 */
	protected int value()
	{
		//if the card is ace
		if(isAce())
		{
			return 1;
		}
		//if the card is prince,queen or king
		else if (this.getValue() >= 11 && this.getValue() <= 13) 
		{
			return 10;
		}
		//if the card is ten or under
		else 
		{
			return this.getValue();
		}
	}
	
	
	/**
	 * value() function indicates what is the value of the card in blackjack game.
	 * gets suit type and value.
	 * @return int 
	 */
	public int minValue()
	{
		if (isAce())
		{
			return 1;
		}
		else 
		{
			return value();
		}
	}
	
	public int maxValue() 
	{
		if (isAce())
		{
			return 11;
		}
		else 
		{
			return value();
		}
	}
	
	/**
	 * isAce()  function indicates if the card is ace or not.
	 * checks the value.
	 * @return boolean 
	 */
	public boolean isAce() 
	{
		return this.getValue() == 1;
	}
	
	/**
	 * isFaceCard()  function indicates if the card has face (prince/queen/king)
	 * checks the value.
	 * @return boolean 
	 */
	public boolean isFaceCard() {
		return this.getValue() >= 11 && this.getValue() <= 13;
	}
	
	/**
	 * #QA created new method:
	 * isFacedUp() function indicates if card is faced up or not
	 * @return boolean
	 */
	public boolean isFacedUp()
	{
		return this.facing == Face.UP;
	}

	/**
	 * faceUp() function set the card face up.
	 * checks the value.
	 */
	@Override
	public void faceUp() 
	{
		facing = Face.UP;
	}

	/**
	 * faceDown() function set the card face down.
	 * checks the value.
	 */
	@Override
	public void faceDown() 
	{
		facing = Face.DOWN;
	}

	/**
	 * getCardImageLocation() function return the image location string.
	 * @return String 
	 */
	public String getCardImageLocation() 
	{
		return cardImageLocation;
	}


	/**
	 * getFacing() function return the face position of the card (up/down).
	 * checks the face parameter.
	 * @return Face  
	 */
	public Face getFacing() 
	{
		return facing;
	}

	/**
	 * toString() function return string representation of the card.
	 * @return String  
	 */
	public String toString()
	{
		return this.value() +" "+ this.getSuit();
	}	

	
}
