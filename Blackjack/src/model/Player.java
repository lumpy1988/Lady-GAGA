package model;

public interface Player {	
	public void hit(Dealer d); // Take a card from the dealer
	public void stand(); // Don't take a card from the dealer
	public void takeCard(Card c);
	public boolean canHit();
	public PlayerType getPlayerType();
	public BlackJackHand getHand();
}
