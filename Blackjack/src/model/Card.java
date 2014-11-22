package model;

public abstract class Card {
	protected Suit suit;
	private boolean available = true;
	protected int faceValue;
	
	public Card(Suit s, int value){
		faceValue = value;
		suit = s;
	}
	
	public abstract int value();
	
	public boolean isAvailable(){
		return available;
	}
	
	public void markUnavailable(){
		available = false;
	}
	
	public void markAvailable(){
		available = true;
	}
}
