/**
 * Programmer:			Sean Thames
 * Date:				2013-06-20
 * Filename:			temp.java
 * Assignment:			Ch 12 Ex 1
 *
 * Description:			Write an application named GoTooFar in which you 
 * declare an array of five integers and store five values in the array. 
 * Write a try block in which you loop to display each successive element of 
 * the array, increasing a subscript by 1 on each pass through the loop. Create
 * a catch block that catches the eventual ArrayIndexOutOfBoundsException and 
 * displays the message, "Now you've gone too far." Save the file as GoTooFar.java
*/

public class GoTooFar
{
	public static void main(String[] args)
	{
		final int[] smallArray = {2, 3, 5, 7, 11};
		int i = 0;

		try
		{
			while(true)
			{
				System.out.println(i + ": " + smallArray[i]);
				i++;
			}
		}
		catch(ArrayIndexOutOfBoundsException tooFar)
		{
			System.out.println("Now you've gone too far");
		}
	}
}