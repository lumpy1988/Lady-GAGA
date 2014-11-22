package model;

public interface CardGame {
	public void addPlayer(Player p);
	public void setDealer(BlackJackDealer d);
	public void initializeGame(int numberOfPlayers);
	public void quitGame();
	public void startGame();
}
