package model;

import java.util.ArrayList;

public class BlackJackHand implements Hand
{
	protected ArrayList<BlackJackCard> cards = new ArrayList<BlackJackCard>();
	
	public int score() 
	{
		ArrayList<Integer> scores = possibleScores();
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
	
	public ArrayList<Integer> possibleScores(){		
		int numAces = 0;
		int score = 0;
		ArrayList<Integer> possibleScores = new ArrayList<Integer>();
		
		for(BlackJackCard c : cards){
			if (c.isAce()){
				numAces++;
			}
			else {
				score += c.value();
			}
		}
		
		possibleScores.add(score);
		
		for (int i = 0; i < numAces; i++){
			score += 10;
			possibleScores.add(score);
		}
		
		return possibleScores;
		
	}
	
	public boolean busted() {
		return score() > 21;
	}
	
	public boolean is21(){
		return score() == 21;
	}
	
	public ArrayList<BlackJackCard> getCards()
	{
		return cards;
	}
	
	public void addCard(BlackJackCard card){
		cards.add(card);
	}
	
}
