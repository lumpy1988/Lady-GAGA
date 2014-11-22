package model;

import java.util.ArrayList;
import java.util.Random;

public class Deck<T extends Card> {
	private ArrayList<T> cards;
	private int dealtIndex = 0;
	
	public void setDeckOfCards(ArrayList<T> deckOfCards){
		cards = deckOfCards;
	}
	
	public void shuffle(){
		//seed random number generator with system time
		Random r = new Random(System.currentTimeMillis());		
		for(int i = cards.size() - 1; i > 0; i--){
			int index = r.nextInt(i + 1);
			T temp = cards.get(index);
			cards.add(index, cards.get(i));
			cards.add(i, temp);
		}
	}
	
	public int remainingCards(){
		return cards.size() - dealtIndex;
	}
	
	public T[] dealHand(int numberOfCards){
		@SuppressWarnings("unchecked")
		T[] hand = (T[]) new Object[numberOfCards];
		for (int i = 0; i < numberOfCards; i++) {
			hand[i] = cards.get(dealtIndex);
			dealtIndex++;
		}
		return hand;
	}
	
	public T dealCard(){
		T c = cards.get(dealtIndex);
		dealtIndex++;		
		return c;
	}
}
