/**
 * @author Idan , Kosta , Or , Elinor
 */
package view;
/**
 * View_Constants - Constants Class
 */
public final class View_Constants 
{
	//frame pane
	public static final int FRAME_PANE_X_LOCATION = 100;
	public static final int FRAME_PANE_Y_LOCATION = 100;
	public static final int FRAME_PANE_WIDTH = 550;
	public static final int FRAME_PANE_HEIGHT = 500;
	
	//hit button
	public static final int HIT_PANE_X_LOCATION = 195;
	public static final int HIT_PANE_Y_LOCATION = 410;
	public static final int HIT_PANE_WIDTH = 60;
	public static final int HIT_PANE_HEIGHT = 40;
	
	//stand button
	public static final int STAND_PANE_X_LOCATION = 295;
	public static final int STAND_PANE_Y_LOCATION = 410;
	public static final int STAND_PANE_WIDTH = 60;
	public static final int STAND_PANE_HEIGHT = 40;
	
	//deal button
	public static final int DEAL_PANE_X_LOCATION = 110;
	public static final int DEAL_PANE_Y_LOCATION = 110;
	public static final int DEAL_PANE_WIDTH = 60;
	public static final int DEAL_PANE_HEIGHT = 30;
	
	//user pane
	public static final int USER_PANE_X_LOCATION = 170;
	public static final int USER_PANE_Y_LOCATION = 250;
	public static final int USER_PANE_WIDTH = 210;
	public static final int USER_PANE_HEIGHT = 152;
	
	//dealer pane
	public static final int DEALER_PANE_X_LOCATION = 170;
	public static final int DEALER_PANE_Y_LOCATION = 40;
	public static final int DEALER_PANE_WIDTH = 210;
	public static final int DEALER_PANE_HEIGHT = 152;
	
	//dealer card
	public static final int DEALER_CARD_X_LOCATION = 10;
	public static final int DEALER_CARD_Y_LOCATION = 30;
	public static final int DEALER_CARD_WIDTH = 71;
	public static final int DEALER_CARD_HEIGHT = 96;
	
	//user and dealer score value
	public static final int SCORE_X_LOCATION = 10;
	public static final int SCORE_Y_LOCATION = 128;
	public static final int SCORE_WIDTH = 200;
	public static final int SCORE_HEIGHT = 15;
	
	
	//space between cards
	public static final int SPACE_BETWEEN_CARDS = 13;
	
	
	//user card
	public static final int USER_CARD_X_LOCATION = 10;
	public static final int USER_CARD_Y_LOCATION = 30;
	public static final int USER_CARD_WIDTH = 71;
	public static final int USER_CARD_HEIGHT = 96;
	
	//start point of movement
	public static final int START_POINT_X = 390;
	public static final int START_POINT_Y = ((DEALER_PANE_Y_LOCATION + DEALER_CARD_Y_LOCATION) + (USER_PANE_Y_LOCATION + USER_CARD_Y_LOCATION))/2;
	//deck
	public static final int DECK_HEIGHT = 110;
	//diagonal movement
	public static final int DIAG_MOVEMENT = START_POINT_Y - (DEALER_PANE_Y_LOCATION + DEALER_CARD_Y_LOCATION);
	
	//total number of cards
	public static final int NUMBER_OF_CARDS_START = 4;
	//buffer size
	public static final int BUFFER = 2;
}
