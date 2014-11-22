package model;

public class BlackJackPlayer implements Player {
	
	private BlackJackHand hand;
	private PlayerType playerType;
	
	public BlackJackPlayer(PlayerType pt){
		hand = new BlackJackHand();
		playerType = pt;
	}
	
	@Override
	public void hit(BlackJackDealer d) {
		takeCard(d.dealCard());
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
		if(!hand.busted() && !hand.is21()){
			canHit = true;
		}
		return canHit;
	}

	public PlayerType getPlayerType() {
		return playerType;
	}
	
	public BlackJackHand getHand(){
		return hand;
	}

}
