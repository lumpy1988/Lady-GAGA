package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.util.ArrayList;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;

public class BlackJackView {

	private JFrame frmBlackjack;
	private ArrayList<JLabel> dealerLabels;
	private ArrayList<JLabel> userLabels;
	private int nextUserCardX;
	private JLayeredPane userPane;
	private JLayeredPane dealerPane;
	private static final int CARDHEIGHT = 96;
	private static final int CARDWIDTH = 71;
	private static final int DEALER_Y = 37;
	private static final int USER_Y = 30;
	private int userX;
	private int dealerX;

	/**
	 * Launch the application.
	 */
	public void show() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					frmBlackjack.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BlackJackView() {
		dealerLabels = new ArrayList<>();
		userLabels = new ArrayList<>();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBlackjack = new JFrame();
		frmBlackjack.setTitle("Blackjack");
		
		frmBlackjack.setBounds(100, 100, 500, 500);
		frmBlackjack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBlackjack.setResizable(false);						
		
		nextUserCardX = 7;
		
		JButton btnHit = new JButton("Hit");
		btnHit.setBounds(170, 410, 60, 30);
		
		JButton btnStand = new JButton("Stand");
		btnStand.setBounds(270, 410, 60, 30);
		frmBlackjack.getContentPane().setLayout(null);
		frmBlackjack.getContentPane().add(btnHit);
		frmBlackjack.getContentPane().add(btnStand);
		
		
		userPane = new JLayeredPane();
		userPane.setBorder(new TitledBorder(null, "Your Cards", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		userPane.setBounds(170, 250, 160, 152);
		frmBlackjack.getContentPane().add(userPane);
		
		JLabel lblU = new JLabel("u1");
		lblU.setBounds(10, 30, 71, 96);
		userPane.add(lblU, 0);
		
		userLabels.add(lblU);
		
		JLabel lblU_1 = new JLabel("u2");
		lblU_1.setBounds(23, 30, 71, 96);
		userPane.add(lblU_1, 0);
		userLabels.add(lblU_1);
		
		userX = 36;
		
		
		dealerPane = new JLayeredPane();
		dealerPane.setBorder(new TitledBorder(null, "Dealer's Cards", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dealerPane.setBounds(170, 40, 160, 160);
		frmBlackjack.getContentPane().add(dealerPane);
		
		
		
		JLabel lblD = new JLabel("d1");
		lblD.setBounds(10, 37, 71, 96);
		dealerPane.add(lblD, 0);		
		dealerLabels.add(lblD);
		
		JLabel lblD_1 = new JLabel("d2");
		lblD_1.setBounds(23, 37, 71, 96);
		dealerPane.add(lblD_1, 0);
		dealerLabels.add(lblD_1);
		
		dealerX = 36;
		
		JMenuBar menuBar = new JMenuBar();
		frmBlackjack.setJMenuBar(menuBar);
		
		JMenu mnGame = new JMenu("Game");
		menuBar.add(mnGame);
		
		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mnGame.add(mntmNewGame);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnGame.add(mntmQuit);		
	}
	
	public void setDealerCards(ArrayList<String> cardImages){
		assert(cardImages.size() == dealerLabels.size());
		
		for(int i = 0; i < cardImages.size(); i++){
			JLabel label = dealerLabels.get(i);
			label.setIcon(new ImageIcon(
					BlackJackView.class.getResource(cardImages.get(i))));
			label.setText("");
			label.revalidate();
			label.repaint();
		}
		frmBlackjack.revalidate();
		frmBlackjack.repaint();
	}
	
	public void setUserCards(ArrayList<String> cardImages){
		assert(cardImages.size() == userLabels.size());
		
		for(int i = 0; i < cardImages.size(); i++){
			JLabel label = userLabels.get(i);
			label.setIcon(new ImageIcon(
					BlackJackView.class.getResource(cardImages.get(i))));
			label.setText("");
			label.revalidate();
			label.repaint();
		}
		frmBlackjack.revalidate();
		frmBlackjack.repaint();
	}
	
	public void addUserCard(String cardImage){
		JLabel label = new JLabel("");
		label.setBounds(userX, USER_Y, CARDWIDTH, CARDHEIGHT);
		label.setIcon(new ImageIcon(
				BlackJackView.class.getResource(cardImage)));
		userPane.add(label, 0);
		userX += 13;		
	}
	
	public void addDealerCard(String cardImage)
	{
		
	}
}
