/**
 * @author Idan , Kosta , Or , Elinor
 */
package main;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import controller.BlackJackController;
import model.BlackJackModel;
import view.BlackJackView;
/**
 * BlackJack Class
 * Main executable class
 */
public class Blackjack
{
	// class variables of the three main MVC components
	protected static BlackJackModel game;
	protected static BlackJackView view;
	protected static BlackJackController controller;
	// testing flag for look and feel disabling during tests
	public static boolean onTest = false;
		
	/**
	* main function starts the App.
	*/
	public static void main(String[] args) 
	{
		if(!onTest){	
			//Create the look and feel of the graphics
			try {
			    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
			    {
			        if ("Nimbus".equals(info.getName())) 
			        {
			            UIManager.setLookAndFeel(info.getClassName());
			            break;
			        }
			    }
			} 
			catch (Exception e) 
			{
				// If Nimbus is not available:
				e.printStackTrace();
			}
		}
		
		try
		{
			//#QA changed local variables to class variables
			//creates the model instance
			game = new BlackJackModel();
			//creates the view instance
			view = new BlackJackView();
			//creates the controller instance
			controller = new BlackJackController(game, view);
			//set the view instance in the view.
			view.setController(controller);	
			//starts the graphics
			view.show();
		}
		catch (Exception e) 
		{
			//in case there was an error with creating the game instances.
			e.printStackTrace();
		}
	}
	
	//========== Getters for testing purposes =================================
	public static BlackJackModel getGame() {
		return game;
	}

	public static BlackJackView getView() {
		return view;
	}

	public static BlackJackController getController() {
		return controller;
	}
	//========== End of Getters block =========================================
}
