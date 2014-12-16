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
	/**
	* main function starts the App.
	*/
	public static void main(String[] args) 
	{
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
		
		try
		{
			//creates the model instance
			BlackJackModel game = new BlackJackModel();
			//creates the view instance
			BlackJackView view = new BlackJackView();
			//creates the controller instance
			BlackJackController controller = new BlackJackController(game, view);
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

}
