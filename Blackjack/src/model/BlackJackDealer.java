package model;


public class BlackJackDealer implements Player {
	
	private Deck deck;
	private BlackJackHand hand;
	private PlayerType playerType = PlayerType.COMPUTER;
	
	public BlackJackDealer(Deck d) 
	{
		deck = d;
		hand = new BlackJackHand();
	}
	
	public Card dealCard()
	{
		return deck.dealCard();
	}
	
	@Override
	public void hit(BlackJackDealer d) {
		// TODO Auto-generated method stub
		takeCard(deck.dealCard());
	}

	@Override
	public void stand() 
	{
		
	}

	@Override
	public void takeCard(Card c) {
		hand.addCard((BlackJackCard) c);
	}

	@Override
	public boolean canHit() {
		boolean canHit = false;
		if(hand.score() < 17 && !hand.busted() && !hand.is21()){
			canHit = true;
		}
		return canHit;	
	}

	public BlackJackHand getHand() {
		return hand;
	}
	
	public PlayerType getPlayerType(){
		return playerType;
	}

}
