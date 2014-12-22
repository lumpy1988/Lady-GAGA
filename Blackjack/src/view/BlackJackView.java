/**
 * @author Idan , Kosta , Or , Elinor
 */
package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import controller.BlackJackController;
import model.PlayerType;
/**
 * BlackJackView Class
 * MVS - View
 */
public class BlackJackView 
{
	/**
	 * parameters
	 */
	private static JFrame frmBlackjack; // main frame
	private ArrayList<JLabel> dealerLabels = null; // dealer cards
	private ArrayList<JLabel> userLabels = null; // user cards 
	private ArrayList<JLabel> unfoldCards = null; // unfold cards for the deal movement
	private static JLabel background = null; // background of the main frame
	private JLayeredPane userPane; // user pane
	private JLayeredPane dealerPane; // dealer pane
	private BlackJackController myController; // controller instance
	private JButton btnDeal = new JButton("Deal"); // Deal button
	private JButton btnHit = new JButton("Hit"); // Hit button
	private JButton btnStand = new JButton("Stand"); // Stand button
	private JLabel userScoreValue = new JLabel(); // user score graphics
	private JLabel dealerScoreValue = new JLabel(); // dealer score graphics
	private int numberOfUserCards = 0; // indicate the number of cards in the user hand
	private int numberOfDealerCards = 0; // indicate the number of cards in the dealer hand
	
	/**
	 * BlackJackView Constructor
	 */
	public BlackJackView() 
	{
		initialize();
	}
	
	/**
	 * sets the controller instance
	 * @param BlackJackController
	 */
	public void setController(BlackJackController c)
	{
		this.myController = c;
	}
	
	/**
	 * Launch the application.
	 */
	public void show() 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			@Override
			public void run() 
			{
				try 
				{
					frmBlackjack.setVisible(true); //set the frame visible
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});	
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		
		//create the Frame
		createFrame();

		//create the buttons and place them on the frame
		setButtons();
		
		//create the user and dealer panes and place them on the frame 
		setPanes();

		//create the deck and place it on the frame
		locateDeck();
		
	}
		
	/**
	 * sets the dealer cards graphics.
	 * @param ArrayList<String>
	 */
	private void setDealerCards(ArrayList<String> cardImages)
	{
		assert(cardImages.size() == dealerLabels.size());		
		for(int i = 0; i < cardImages.size(); i++)
		{
			JLabel label = dealerLabels.get(i);
			File sourceimage = new File(cardImages.get(i));
			BufferedImage imageOfCard = null;
			try 
			{
				imageOfCard = ImageIO.read(sourceimage);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			label.setIcon(new ImageIcon(imageOfCard));
			label.revalidate();
			label.repaint();
		}
		frmBlackjack.revalidate();
		frmBlackjack.repaint();
	}
	
	/**
	 * #QA created new method
	 * returns the dealer's cards as JLabels
	 * @return ArrayList<JLabel>
	 */
	public ArrayList<JLabel> getDealerCards()
	{
		return dealerLabels;
	}
	
	/**
	 * #QA created new method
	 * Checks if button is enabled
	 * @return boolean
	 */
	public boolean isHitEnabled()
	{
		return btnHit.isEnabled();
	}
	
	/**
	 * sets the user cards graphics.
	 * @param ArrayList<String>
	 */
	private void setUserCards(ArrayList<String> cardImages)
	{
		assert(cardImages.size() == userLabels.size());
		for(int i = 0; i < cardImages.size(); i++)
		{
			JLabel label = userLabels.get(i);
			File sourceimage = new File(cardImages.get(i));
			BufferedImage imageOfCard = null;
			try 
			{
				imageOfCard = ImageIO.read(sourceimage);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			label.setIcon(new ImageIcon(imageOfCard));
			label.revalidate();
			label.repaint();
		}
		frmBlackjack.revalidate();
		frmBlackjack.repaint();
	}
	
	/**
	 * place the deck on the main frame
	 */
	private void locateDeck()
	{
		File sourceimage = new File("../Blackjack/src/resources/deck.png");
		try 
		{
			BufferedImage imageToMove = ImageIO.read(sourceimage);		
			JLabel deck_pic = new JLabel();
			deck_pic.setIcon(new ImageIcon(imageToMove));
			deck_pic.setBounds(View_Constants.START_POINT_X, View_Constants.START_POINT_Y, View_Constants.USER_CARD_WIDTH, View_Constants.DECK_HEIGHT);			
			frmBlackjack.getContentPane().add(deck_pic);
		}
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
			
	}
	
	/**
	 * create the main frame graphics
	 */
	private void createFrame()
	{
		frmBlackjack = new JFrame();
		try 
		{
			background = new JLabel(new ImageIcon(ImageIO.read(new File("../Blackjack/src/resources/GreenBackground.jpg"))));
			frmBlackjack.setContentPane(background);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		frmBlackjack.setTitle("BlackJack Game");
				
		//set the boundaries of the desktop.
		frmBlackjack.setBounds(View_Constants.FRAME_PANE_X_LOCATION, View_Constants.FRAME_PANE_Y_LOCATION, View_Constants.FRAME_PANE_WIDTH, View_Constants.FRAME_PANE_HEIGHT);
		frmBlackjack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBlackjack.setResizable(false);	
		frmBlackjack.getContentPane().setLayout(null);
		
	}
	
	/**
	 * place the buttons on the main frame
	 */
	private void setButtons()
	{
		//sets button location
		btnDeal.setBounds(View_Constants.START_POINT_X+5, View_Constants.START_POINT_Y+View_Constants.DECK_HEIGHT+5, View_Constants.DEAL_PANE_WIDTH, View_Constants.DEAL_PANE_HEIGHT);
		btnHit.setBounds(View_Constants.HIT_PANE_X_LOCATION, View_Constants.HIT_PANE_Y_LOCATION, View_Constants.HIT_PANE_WIDTH, View_Constants.HIT_PANE_HEIGHT);	
		btnStand.setBounds(View_Constants.STAND_PANE_X_LOCATION, View_Constants.STAND_PANE_Y_LOCATION, View_Constants.STAND_PANE_WIDTH, View_Constants.STAND_PANE_HEIGHT);	
		//sets the initial state of the buttons
		btnDeal.setEnabled(true);
		btnHit.setEnabled(false);
		btnStand.setEnabled(false);
		//adds the buttons to the desktop frame		
		frmBlackjack.getContentPane().add(btnDeal);
		frmBlackjack.getContentPane().add(btnHit);
		frmBlackjack.getContentPane().add(btnStand);
		setDealFunc(); // sets the Deal functionality
		setHitFunc(); // sets the Hit functionality
		setStandFunc(); // sets the Stand functionality
	}
	
	/**
	 * set both the user and the dealer panes
	 */
	private void setPanes()
	{
		//set the user pane and place it on the frame
		userPane = new JLayeredPane();
		userPane.setBorder(new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white), "Your Cards", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tiresias PCFont Z", Font.BOLD+Font.ITALIC, 15 ), Color.white));
		userPane.setBounds(View_Constants.USER_PANE_X_LOCATION, View_Constants.USER_PANE_Y_LOCATION, View_Constants.USER_PANE_WIDTH, View_Constants.USER_PANE_HEIGHT);
		frmBlackjack.getContentPane().add(userPane);
		
		//set the dealer pane and place it on the frame
		dealerPane = new JLayeredPane();
		dealerPane.setBorder(new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white), "Dealer's Cards", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tiresias PCFont Z", Font.BOLD+Font.ITALIC, 15 ), Color.white));
		dealerPane.setBounds(View_Constants.DEALER_PANE_X_LOCATION, View_Constants.DEALER_PANE_Y_LOCATION, View_Constants.DEALER_PANE_WIDTH, View_Constants.DEALER_PANE_HEIGHT);
		frmBlackjack.getContentPane().add(dealerPane);
	}
	
	/**
	 * Flip the cards after dealing
	 */
	private void flipTheIntialCards()
	{	
		//sets the user cards:
		flipCard(PlayerType.USER, 1);
		flipCard(PlayerType.USER, 2);
		//sets the DEALER card:
		flipCard(PlayerType.DEALER, 1);
		flipCard(PlayerType.DEALER, 2);

		setDealerCards(myController.getDealerStrings());
		setUserCards(myController.getUserStrings());
	}
	
	/**
	 * Flip a card according to the player type and number of card
	 * @param PlayerType p, int numberOfCard
	 */
	private void flipCard(PlayerType p, int numberOfCard)
	{
		JLabel lbl = new JLabel("");
		//sets a user card:
		if (p.equals(PlayerType.USER))
		{
			lbl.setBounds(View_Constants.USER_CARD_X_LOCATION + (numberOfCard-1)*View_Constants.SPACE_BETWEEN_CARDS, View_Constants.USER_CARD_Y_LOCATION, View_Constants.USER_CARD_WIDTH, View_Constants.USER_CARD_HEIGHT);
			userPane.add(lbl,0);
			userLabels.add(lbl);
		}
		else
		{
			lbl.setBounds(View_Constants.DEALER_CARD_X_LOCATION + (numberOfCard-1)*View_Constants.SPACE_BETWEEN_CARDS, View_Constants.DEALER_CARD_Y_LOCATION, View_Constants.DEALER_CARD_WIDTH, View_Constants.DEALER_CARD_HEIGHT);
			dealerPane.add(lbl,0);		
			dealerLabels.add(lbl);
		}
	}

	
	/**
	 * Deal the cards from the deck 
	 */
	private void placeCardFromDeck(PlayerType pt,int numberOfCard)
	{

		File sourceimage = new File("../Blackjack/src/resources/b1fv.png");	//unfold card 
		JLabel cardToMove = new JLabel(); // the moving card
		unfoldCards.add(cardToMove);	
		frmBlackjack.add(cardToMove);
		BufferedImage imageToMove = null;
		try 
		{
			imageToMove = ImageIO.read(sourceimage);	
			cardToMove.setIcon(new ImageIcon(imageToMove));
			cardToMove.setBounds(View_Constants.START_POINT_X, View_Constants.START_POINT_Y, View_Constants.USER_CARD_WIDTH, View_Constants.USER_CARD_HEIGHT);					
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		int x =  View_Constants.START_POINT_X;
		int y = View_Constants.START_POINT_Y;
		frmBlackjack.createBufferStrategy(View_Constants.BUFFER);
		Graphics g = frmBlackjack.getBufferStrategy().getDrawGraphics();
		frmBlackjack.update(g);
		cardToMove.setLocation(x, y);
	    frmBlackjack.getBufferStrategy().show();
	    g.dispose();
		if (pt.equals(PlayerType.USER))
		{
			for (int i=0; i<View_Constants.DIAG_MOVEMENT; i++)
			{
				x--;
				y++;	
				
				//use buffered strategy for the graphic movement
				bufferedMovement (frmBlackjack, cardToMove,g, x, y)	;	
			}
		}
		else
		{
			for (int i=0; i<View_Constants.DIAG_MOVEMENT; i++)
			{
				x--;
				y--;
				
				//use buffered strategy for the graphic movement
				bufferedMovement (frmBlackjack, cardToMove,g, x, y)	;	
			}
		}
		int xToMove = View_Constants.DEALER_PANE_X_LOCATION + View_Constants.DEALER_CARD_X_LOCATION + View_Constants.SPACE_BETWEEN_CARDS*(numberOfCard-1);
		int xMovement = x - xToMove;
		for (int i=0; i<xMovement; i++)
		{
			x--;
			
			//use buffered strategy for the graphic movement
			bufferedMovement (frmBlackjack, cardToMove,g, x, y)	;	
		}
	}

	/**
	 * starts the card dealing in the start of the game.
	 * deals the cards to the dealer and the user alternately
	 */
	private void startNewGameGraphic()
	{
		PlayerType pt = PlayerType.USER;
		numberOfUserCards = 0;
		numberOfDealerCards = 0;
		for (int i=1; i<=View_Constants.NUMBER_OF_CARDS_START; i++)
		{
			if (pt.equals(PlayerType.USER))
			{
				numberOfUserCards++;
				pt = PlayerType.DEALER;
				placeCardFromDeck(pt,numberOfUserCards);
			}
			else
			{
				numberOfDealerCards++;
				pt = PlayerType.USER;
				placeCardFromDeck(pt,numberOfDealerCards);
			}
		}
	}
	
	/**
	 * create the buffered strategy in the frame.
	 * in order to avoid flickering while moving.
	 * @param JFrame,JLabel,Graphics,int,int
	 */
	private void bufferedMovement (JFrame bf, JLabel mc,Graphics g, int x, int y)
	{	
		g = bf.getBufferStrategy().getDrawGraphics();	
		bf.update(g);
		mc.setLocation(x, y);
		bf.getBufferStrategy().show();
	    g.dispose();
	}
	
	
	/**
	 * Sets the Deal button functionality and listeners
	 */
	private void setDealFunc()
	{
		btnDeal.addActionListener(new ActionListener() //sets the listener for the "DEAL" button.
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if (userLabels!= null)
				{
					for (JLabel card : userLabels)
					{
						userPane.remove(card);
					}
				}
				if (dealerLabels!= null)
				{
					for (JLabel card : dealerLabels)
					{
						dealerPane.remove(card);
					}
				}
				dealerLabels = new ArrayList<JLabel>();
				userLabels = new ArrayList<JLabel>();
				unfoldCards = new ArrayList<JLabel>();	
				userPane.remove(userScoreValue);
				dealerPane.remove(dealerScoreValue);
				myController.initialize();
				//disable the buttons while dealing
				btnDeal.setEnabled(false);
				btnHit.setEnabled(false);
				btnStand.setEnabled(false);
				//show the movement graphics
				startNewGameGraphic();
				flipTheIntialCards();	//flip the cards
				setUserScoreValue();
				updateUserScore();
				for (JLabel card : unfoldCards)
				{
					frmBlackjack.remove(card);
				}
				//enable the buttons
				if (myController.checkGameStatus(PlayerType.USER)==1)
				{
					JOptionPane.showMessageDialog(null, "You've got 21 on the first 2 cards!\n lets see what the delaer will get...", "BlackJack", JOptionPane.INFORMATION_MESSAGE);
					flipSecondDealerCard();
					setDealerScoreValue();
					updateDealerScore();
					if (myController.getPlayerScore(PlayerType.DEALER) != 21)
					{
						JOptionPane.showMessageDialog(null, "You've won with blackjack score!", "Winner", JOptionPane.INFORMATION_MESSAGE);	
					}
					else
					{
						JOptionPane.showMessageDialog(null, "The dealer got also 21!\n You've lost", "Looser", JOptionPane.INFORMATION_MESSAGE);	
					}
					btnDeal.setEnabled(true);
				}
				else
				{
					btnHit.setEnabled(true);
					btnStand.setEnabled(true);	
				}
										
			}
		});
	}
	
	/**
	 * #QA created new method
	 * Perform doClick() on the Deal button
	 */
	public void clickDeal()
	{
		btnDeal.doClick();
	}
	
	/**
	 * #QA created new method
	 * Checks if button is enabled
	 * @return boolean
	 */
	public boolean isDealEnabled()
	{
		return btnDeal.isEnabled();
	}
	
	/**
	 * Sets the score value graphics of the user hand.
	 */
	private void setUserScoreValue()
	{
		userScoreValue.setForeground(Color.white);
		userScoreValue.setFont(new Font("Tiresias PCFont Z", Font.BOLD, 12));
		userScoreValue.setBounds(View_Constants.SCORE_X_LOCATION, View_Constants.SCORE_Y_LOCATION, View_Constants.SCORE_WIDTH, View_Constants.SCORE_HEIGHT);
		userPane.add(userScoreValue);
	}
	
	/**
	 * update the score of the user after hit.
	 */
	private void updateUserScore()
	{
		userScoreValue.setText("your current score is: " + myController.getPlayerScore(PlayerType.USER));
	}
	
	/**
	 * Sets the score value graphics of the dealer hand.
	 */
	private void setDealerScoreValue()
	{
		dealerScoreValue.setForeground(Color.white);
		dealerScoreValue.setFont(new Font("Tiresias PCFont Z", Font.BOLD, 12));
		dealerScoreValue.setBounds(View_Constants.SCORE_X_LOCATION, View_Constants.SCORE_Y_LOCATION, View_Constants.SCORE_WIDTH, View_Constants.SCORE_HEIGHT);
		dealerPane.add(dealerScoreValue);
	}
	
	/**
	 * update the score of the dealer after hit.
	 */
	private void updateDealerScore()
	{
		dealerScoreValue.setText("Dealer current score is: " + myController.getPlayerScore(PlayerType.DEALER));
	}
	
	/**
	 * Sets the Hit button functionality and listeners
	 */
	private void setHitFunc()
	{
		btnHit.addActionListener(new ActionListener() //sets the listener for the "Hit" button.
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				btnStand.setEnabled(false);
				btnHit.setEnabled(false);
				int userGameStatus = myController.ClickedHit();
				numberOfUserCards++;
				placeCardFromDeck(PlayerType.USER,numberOfUserCards);
				flipCard(PlayerType.USER,numberOfUserCards);
				setUserCards(myController.getUserStrings());
				updateUserScore();
				for (JLabel card : unfoldCards)
				{
					frmBlackjack.remove(card);
				}
				if(userGameStatus==0) // in case the user busted
				{
					JOptionPane.showMessageDialog(null, "You are Busted!\n Dealer has won!", "Looser", JOptionPane.INFORMATION_MESSAGE);
					btnDeal.setEnabled(true);
				}
				if(userGameStatus==1) // in case the user reached 21.
				{
					JOptionPane.showMessageDialog(null, "You've got 21!\n lets see what the delaer will get...", "Reached 21", JOptionPane.INFORMATION_MESSAGE);
					setDealerMoves();
				}
				if (userGameStatus==2) // in case the user can continue hitting
				{
					btnStand.setEnabled(true);
					btnHit.setEnabled(true);
				}
			}
		});
	}
	
	/**
	 * #QA created new method
	 * Perform doClick() on the Hit button
	 */
	public void clickHit()
	{
		btnHit.doClick();
	}
	
	/**
	 * Sets the Stand button functionality and listeners
	 */
	private void setStandFunc()
	{
		btnStand.addActionListener(new ActionListener() //sets the listener for the "Hit" button.
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				btnStand.setEnabled(false);
				btnHit.setEnabled(false);
				JOptionPane.showMessageDialog(null, "You've reached "+myController.getPlayerScore(PlayerType.USER)+".\n lets see what the delaer will get...", "Stand", JOptionPane.INFORMATION_MESSAGE);
				setDealerMoves();
			}
		});
	}
	
	/**
	 * #QA created new method
	 * Perform doClick() on the Stand button
	 */
	public void clickStand()
	{
		btnStand.doClick();
	}
	
	/**
	 * #QA created new method
	 * Checks if button is enabled
	 * @return boolean
	 */
	public boolean isStandEnabled()
	{
		return btnStand.isEnabled();
	}
		
	/**
	 * sets the graphic moves of the dealer
	 */
	private void setDealerMoves()
	{
		int dealerGameStatus;
		flipSecondDealerCard();
		setDealerScoreValue();
		updateDealerScore();
		do 
		{
			dealerGameStatus = myController.DealerHit();
			if (dealerGameStatus != 3)
			{
				numberOfDealerCards++;
				placeCardFromDeck(PlayerType.DEALER,numberOfDealerCards);
				flipCard(PlayerType.DEALER,numberOfDealerCards);
				setDealerCards(myController.getDealerStrings());
				for (JLabel card : unfoldCards)
				{
					frmBlackjack.remove(card);
				}
			}
			updateDealerScore();
		}
		while (dealerGameStatus == 2);
		updateDealerScore();
		endGameStatus(dealerGameStatus);
	}
	
	/**
	 * checks the game status in the end of a round
	 */
	private void endGameStatus(int dealerGameStatus)
	{
		if (dealerGameStatus == 0)
		{
			JOptionPane.showMessageDialog(null, "The dealer got busted!\n you've won!", "Winner", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			if (myController.checkIfPlayerWon() == 1)
			{
				JOptionPane.showMessageDialog(null, "You got the larger score!\n you've won!", "Winner", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (myController.checkIfPlayerWon() == 0)
			{
				JOptionPane.showMessageDialog(null, "Tie!\n you've lost!", "Looser", JOptionPane.INFORMATION_MESSAGE);			
			}
			else
			{
				JOptionPane.showMessageDialog(null, "The dealer got a larger score!\n you've lost!", "Looser", JOptionPane.INFORMATION_MESSAGE);			
			}
		}
		btnHit.setEnabled(false);
		btnStand.setEnabled(false);
		btnDeal.setEnabled(true);
	}
	
	
	/**
	 * flip the second card of the dealer
	 */
	private void flipSecondDealerCard()
	{
		myController.flipDealerCard();
		setDealerCards(myController.getDealerStrings());
	}
	
	
}
