
/**
 * Created by Diana Li on 4/19/2017.
 */
import java.util.Random;

public class Card 
{
	private int suit;
	//1-spade 2-heart 3-diamond 4-club
	private int number;
	//A-1, J-11, Q-12, K-13
	
	public Card()
	{
		Random generator = new Random();
		suit = generator.nextInt(4)+1;
		number = generator.nextInt(13)+1;
	}
	
	public boolean sameSuit (Card c)
	{
		return this.suit == c.suit;
	}
	
	public boolean sameNumber (Card c)
	{
		return this.number == c.number;
	}
	
	public void changeCard()
	{
		int newSuit, newNumber;
		Random generator = new Random();
		newSuit = generator.nextInt(4)+1;
		newNumber = generator.nextInt(13)+1;
		
		this.suit = newSuit;
		this.number = newNumber;
	}
	
	public String toString()
	{
		if(suit == 1)
		{return "(S " + number + ")";}
		if (suit == 2)
		{return "(H " + number + ")";}
		if (suit == 3)
		{return "(D " + number + ")";}
		if (suit == 4)
		{return "(C " + number + ")";}
		else
		{return "Error";}
	}
}
