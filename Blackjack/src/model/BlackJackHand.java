package model;

import java.util.ArrayList;

public class BlackJackHand extends Hand<BlackJackCard> {
	
	public int score() {
		ArrayList<Integer> scores = possibleScores();
		int maxUnder = Integer.MAX_VALUE;
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
	
	public ArrayList<BlackJackCard> getCards(){
		return cards;
	}
	
}
