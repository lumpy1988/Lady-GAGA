package model;

public abstract class Dealer {
	protected Deck<Card> deck;
	
	public Dealer(Deck<Card> d){
		deck = d;
	}
	
	public Card dealCard(){
		return deck.dealCard();
	}
}
