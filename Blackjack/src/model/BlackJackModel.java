package model;

import java.util.ArrayList;

public class BlackJackModel implements CardGame {
	
	private ArrayList<Player> players;
	private BlackJackDealer dealer;
	private Player currentPlayer;
	private int currentPlayerIndex;
	
	public BlackJackModel(){
		players = new ArrayList<Player>();
		initializeGame(1);
	}
	
	@Override
	public void addPlayer(Player p) {
		players.add(p);		
	}

	@Override
	public void setDealer(BlackJackDealer d) {
		dealer = d;
	}

	@Override
	public void initializeGame(int numberOfPlayers) {
		Deck gameDeck = generateDeck();
		//add user player
		addPlayer(new BlackJackPlayer(PlayerType.USER));
		for(int i = 0; i < numberOfPlayers - 1; i++){
			addPlayer(new BlackJackPlayer(PlayerType.COMPUTER));
		}
		dealer = new BlackJackDealer(gameDeck);
		//addPlayer(dealer);
		currentPlayerIndex = 0;
	}

	@Override
	public void quitGame() {
		// TODO Auto-generated method stub
		players.clear();
		dealer = null;
		currentPlayer = null;
	}

	@Override
	public void startGame() {
		BlackJackCard c;
		for(Player p : players){
			c = (BlackJackCard) dealer.dealCard();
			c.faceUp();
			p.takeCard(c);			
		}
		c = (BlackJackCard) dealer.dealCard();
		c.faceUp();
		dealer.takeCard(c);
		for(Player p : players){
			c = (BlackJackCard) dealer.dealCard();
			c.faceUp();
			p.takeCard(c);			
		}
		c = (BlackJackCard) dealer.dealCard();
		c.faceDown();
		dealer.takeCard(c);
		
		currentPlayer = players.get(0);
	}
	
	public Deck generateDeck()
	{
		Deck d = new Deck();
		ArrayList<BlackJackCard> cards = new ArrayList<BlackJackCard>();
		for(int value = 1; value <= 13; value++){
			cards.add(new BlackJackCard(Suit.CLUB, value));
			cards.add(new BlackJackCard(Suit.HEART, value));
			cards.add(new BlackJackCard(Suit.SPADE, value));
			cards.add(new BlackJackCard(Suit.DIAMOND, value));
		}
		d.setDeckOfCards(cards);
		d.shuffle();
		return d;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(BlackJackPlayer currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public BlackJackDealer getDealer() {
		return dealer;
	}
	
	public void update(String command){
		if (command.equals("exit")) {
			System.exit(0);
		}		
		if(currentPlayer.equals(dealer)){
			if (dealer.canHit()){
				dealer.hit(dealer);
			}
		}
		else if (currentPlayer.getPlayerType() != PlayerType.USER){
			// TODO Implement multiplyaer  
		}
		else {
			if (command.equals("hit") && currentPlayer.canHit()){
				currentPlayer.hit(dealer);
			}
			else if (command.equals("stand")){
				currentPlayer.stand();
			}
		}
		currentPlayer = getNextPlayer();
	}
	
	private Player getNextPlayer(){
		int nextPlayerIndex = (currentPlayerIndex + 1) % players.size();
		return players.get(nextPlayerIndex);
	}

}
