/**
 * @author Idan , Kosta , Or , Elinor
 */
package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * CardImageLoader Class
 */
public class CardImageLoader 
{
	private static final String resourcePath = "../Blackjack/src/resources/"; // path
	private static final String imgExtention = ".png"; // file type
	
	/**
	 * return the card image according to the suit and value
	 * @param  Suit, int
	 * @return BufferedImage
	 */
	public static BufferedImage loadImage(Suit s, int value)
	{
		BufferedImage img = null;
		String imageFile = getImageLocation(s, value);
		try 
		{
			img = ImageIO.read(new File(imageFile));
		}
		catch (IOException e)
		{
			System.out.println("Could not Find image... " + imageFile);
		}
		return img;
	}
	
	/**
	 * gets the image string according to the suit and value
	 * @param  Suit, int
	 * @return String
	 */
	public static String getImageLocation(Suit s, int value)
	{
		StringBuilder result = new StringBuilder(resourcePath);
		char suitChar;
		char valueChar;
		
		switch(s.getValue())
		{
		case 0:	suitChar = 'h';
				break;
		case 1: suitChar = 'c';
				break;
		case 2: suitChar = 'd';
				break;
		case 3: suitChar = 's';
				break;
		default: throw new IllegalArgumentException();
		}
		
		switch(value)
		{
		case 10:
					valueChar = 't';
					break;
		case 11:	valueChar = 'j';
					break;
		case 12: 	valueChar = 'q';
					break;
		case 13: 	valueChar = 'k';
					break;
		default:	valueChar = (char) (value + 48);
		}
		
		result.append(suitChar);
		result.append(valueChar);
		result.append(imgExtention);
		
		return result.toString();	
	}
}
