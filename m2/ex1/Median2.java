/**
 * 	Author:			Sean Thames
 * 	Class:			CIST-2372
 * 	Date:			2013-06-01
 * 	Filename:		Median2.java
 * 	Assignment:		Chapter 9 Ex 1b
 *
 *  Description:	Revise the Median class so that the user can enter any number
 *	of values up to nine. If the list has an even number of values, the median is
 *	the numeric average of the values in the two middle positions. Save the file
 *	as Median2.java
 *
 */

import java.util.Scanner;
import java.util.Arrays;

public class Median2
{
	public static double getMedian(double[] nums)
	{
		double median = 0.0;
		
		if (nums.length % 2 == 0)
		{
			// TODO code for an even length array
		}
		else
		{
			// TODO code for an odd length array
		}
		
		return median;
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int i = 0; // iterator for the input loop
		String userInput = "";
		double[] numbers = new double[9];
		double median = 0.0; // value to hold the middle location of the array
		
		System.out.println("Please enter up to nine numbers.\nTo stop just press enter.");
		do 
		{
			System.out.print("Number " + (i + 1) + "/9: ");
			userInput = input.nextLine().toLowerCase();
			if (userInput.equals(""))
				break;
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
		
		System.out.println("\nThe median value is " + getMedian(numbers));
	}
}
