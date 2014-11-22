package model;

public interface CardGame {
	public void addPlayer(Player p);
	public void setDealer(Dealer d);
	public void initializeGame(int numberOfPlayers);
	public void quitGame();
	public void startGame();
}
