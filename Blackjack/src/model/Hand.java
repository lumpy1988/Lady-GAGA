/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Idan
 *
 */
public interface Hand 
{
	public int score(); 
	public ArrayList<Integer> possibleScores();	
	public boolean busted();
	public boolean is21();
	public ArrayList<BlackJackCard> getCards();
	public void addCard(BlackJackCard card);
}
