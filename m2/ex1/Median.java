/**
 * 	Author:			Sean Thames
 * 	Class:			CIST-2372
 * 	Date:			2013-06-01
 * 	Filename:		Median.java
 * 	Assignment:		Chapter 9 Ex 1a
 *
 *  Description:	The median of a list is its middle value when the values are
 *	placed in order. For example, if a list contains 1, 4, 7, 8, and 9, then the
 *	median is 7. Write an application that allows you to enter nine double values
 *	and display them and their median. Save the file as Median.java.
 *
 */

import java.util.Scanner;
import java.util.Arrays;

public class Median
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int i = 0; // iterator for the input loop
		String userInput = "";
		double[] numbers = new double[9];
		System.out.println("Please enter nine numbers.");
		do 
		{
			System.out.print("Number " + (i + 1) + "/9: ");
			userInput = input.nextLine();
			try
			{
				numbers[i] = Double.parseDouble(userInput);
				i++;
			}
			catch (Exception e)
			{
				System.out.println("Error: " + userInput + " is not a valid number");
			}
		} while (i < 9);
		
		Arrays.sort(numbers);
		
		System.out.print("\n\nYou entered: ");
		for(Double num : numbers)
			System.out.print(num + "   ");
		
		System.out.println("\nThe median value is " + numbers[4]);
	}
}
