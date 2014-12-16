/**
 * @author Idan , Kosta , Or , Elinor
 */
package controller;

import java.util.ArrayList;

import model.BlackJackCard;
import model.BlackJackDealer;
import model.BlackJackModel;
import model.BlackJackPlayer;
import model.Face;
import model.PlayerType;
import view.BlackJackView;

/**
 * BlackJackController Class
 * MVS - Controller
 */
public class BlackJackController
{
	private BlackJackModel game; // the model instance
	@SuppressWarnings("unused")
	private BlackJackView view; //unused for this iteration --> view instance
	private ArrayList<String> userStrings; // hold all the image strings for the user cards
	private ArrayList<String> dealerStrings; // hold all the image strings for the dealer cards
	
	
	/**
	 * BlackJackController Constructor.
	 * gets the model and view instance.
	 * @param  BlackJackModel, BlackJackView
	 */
	public BlackJackController(BlackJackModel game, BlackJackView view)
	{
		this.game = game;
		this.view = view;
	}
	
	/**
	 * initialize() function indicates the start of a game in the controler point of view.
	 * starts the game in the model and sets the image strings.
	 */
	public void initialize()
	{
		game.startGame(); // starts the game in the model point of view
		setHandImageStringsDealer(game.getDealer()); // sets the image strings of the dealer 		
		setHandImageStringsUser(game.getCurrentPlayer());// sets the image strings of the user
	}
	
	
	/**
	 * setHandImageStringsDealer function sets the image strings for the current hand of the dealer. 
	 * @param  BlackJackDealer
	 */
	private void setHandImageStringsDealer(BlackJackDealer dealer) 
	{
		ArrayList<String> imageList = new ArrayList<String>(); // Initialize the arraylist
		for(BlackJackCard c : dealer.getHand().getCards())
		{
			System.out.println("Dealer - "+c);
			if (c.getFacing().equals(Face.UP))
			{
				imageList.add(c.getCardImageLocation()); //search for the relevant card
			}
			else
			{
				imageList.add("../Blackjack/src/resources/b1fv.png"); // sets the card upside down
			}
				
		}
		dealerStrings = imageList; // sets the dealer hand card images.
	}

	/**
	 * setHandImageStringsUser function sets the image strings for the current hand of the user. 
	 * @param  BlackJackPlayer
	 */
	private void setHandImageStringsUser(BlackJackPlayer p)
	{
		ArrayList<String> imageList = new ArrayList<String>(); // Initialize the arraylist
		for(BlackJackCard c : p.getHand().getCards())
		{
			System.out.println("Player - "+c);
			if (c.getFacing().equals(Face.UP))
			{
				imageList.add(c.getCardImageLocation()); //search for the relevant card
			}
			else
			{
				imageList.add("../resources/b1fv.png"); // sets the card upside down
			}
		}
		userStrings = imageList; // sets the user hand card images.
	}
	
	
	/**
	 * getDealerStrings() function return the dealerStrings.
	 * @return ArrayList<String> 
	 */
	public ArrayList<String> getDealerStrings()
	{
		return dealerStrings;
	}
	
	/**
	 * getUserStrings() function return the userStrings.
	 * @return ArrayList<String> 
	 */
	public ArrayList<String> getUserStrings()
	{
		return userStrings;
	}
	
	/**
	 * ClickedHit() function indicates that the player pushed the HIT button.
	 * @return int.
	 * 0 = player status is busted.
	 * 1 = player got 21.
	 * 2 = player can continue press hit.
	 */
	public int ClickedHit()
	{
		BlackJackCard bc = game.dealCard(PlayerType.USER);
		userStrings.add(bc.getCardImageLocation());
		return checkGameStatus(PlayerType.USER);
	}
	
	/**
	 * getPlayerScore() function to get the player current score according to the player type.
	 * @param PlayerType
	 * @return int score.
	 */
	public int getPlayerScore(PlayerType pt)
	{
		if (pt.equals(PlayerType.USER))
		{
			return game.getCurrentPlayer().getHand().score(pt);
		}
		else
		{
			return game.getDealer().getHand().score(pt);
		}	
	}
	
	
	/**
	 * checkGameStatus() function check the current player game status
	 * @return int.
	 * 0 = player status is busted.
	 * 1 = player got 21.
	 * 2 = player can continue press hit.
	 */
	public int checkGameStatus(PlayerType pt)
	{
		return game.CheckStatus(pt);
	}
	
	/**
	 * DealerHit() function indicates that the dealer hits.
	 * @return int.
	 * 0 = dealer status is busted.
	 * 1 = dealer can stop hit.
	 * 2 = dealer needs to hit again.
	 * 3 = dealer don't need to hit at all.
	 */
	public int DealerHit()
	{
		BlackJackCard bc = null;
		int currentStatus = checkGameStatus(PlayerType.DEALER); // checks if the dealer do not need to hit at all
		if (currentStatus == 2)
		{
			bc = game.dealCard(PlayerType.DEALER);
			dealerStrings.add(bc.getCardImageLocation());
			return checkGameStatus(PlayerType.DEALER);
		}
		else 
		{
			return 3;
		}
	}
	
	/**
	 * checkIfPlayerWon() function check the current player game status
	 * @return int.
	 * -1 = dealer won.
	 * 0 = tie.
	 * 1 = user won
	 */
	public int checkIfPlayerWon()
	{
		int userScore = game.getCurrentPlayer().getHand().score(PlayerType.USER);
		int dealerScore = game.getDealer().getHand().score(PlayerType.DEALER);
		if (userScore>dealerScore)
			return 1;
		if (userScore<dealerScore)
			return -1;
		else
			return 0;
	}
	
	
	/**
	 * checkIfPlayerWon() function check the current player game status
	 * @return boolean. true if the user won and false if not.
	 */
	public void flipDealerCard()
	{
		for(BlackJackCard c : game.getDealer().getHand().getCards())
		{
			c.faceUp();
		}
		setHandImageStringsDealer(game.getDealer());
	}

}
