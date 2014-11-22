package model;


public class BlackJackDealer extends Dealer implements Player {
	
	private BlackJackHand hand;
	private PlayerType playerType = PlayerType.CPU;
	
	public BlackJackDealer(Deck<Card> d) {
		super(d);
		hand = new BlackJackHand();
	}

	@Override
	public void hit(Dealer d) {
		// TODO Auto-generated method stub
		takeCard(deck.dealCard());
	}

	@Override
	public void stand() {
		
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
