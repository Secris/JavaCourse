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
import java.util.ArrayList;

public class Median2
{
	public static double getMedian(double[] nums)
	{
		double median = 0.0;
		int[] middle = new int[2];
		
		if (nums.length % 2 == 0)
		{
			middle[0] = (nums.length / 2) - 1;	// nums.length counts from "1" instead of "0"
			middle[1] = middle[0] + 1; 			// get the other middle value in an even length array
			median = nums[middle[0]] + nums[middle[1]];
			median = median / 2.0;
		}
		else
		{
			middle[0] = nums.length / 2;
			median = nums[middle[0]];
		}
		
		return median;
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		final byte LIMIT = 9; 		// Maximum number of values to accept. 
									// Is a byte because why not save a few bytes of memory
		
		int i = 0; 					// iterator for the input loop
		
		String userInput = "";
		ArrayList<String> numberList = new ArrayList<String>();
		
		double[] numbers; 
		
		System.out.println("Please enter up to " + LIMIT + " numbers.\nTo stop just press enter.");
		do 
		{
			System.out.print("Number " + (i + 1) + "/" + LIMIT + ": ");
			userInput = input.nextLine().toLowerCase();
			if (!(userInput.isEmpty()))
			{
				try
				{
					Double.parseDouble(userInput);
					numberList.add(userInput);
					i++;
				}
				catch (Exception e)
				{
					System.out.println("Error: " + userInput + " is not a valid number");
					if (userInput.indexOf(' ') > -1)
						System.out.println("Please use a single line for each number.");
				}
			}
		} while (!(userInput.isEmpty()) && i < LIMIT);
		
		if (numberList.size() == 0) 
		{
			System.out.println("\nNothing was entered exiting...");
			return; // Kills program if not even one value was entered
		}
		else
		{
			numbers = new double[numberList.size()]; // Create an array the same size as the List
		}
		
		for(int c = 0; c < numberList.size(); c++) 
			numbers[c] = Double.parseDouble(numberList.get(c).toString());			// Transfer list values to the array
		
		Arrays.sort(numbers);
		
		System.out.print("\n\nYou entered: ");
		for(Double num : numbers)
			System.out.print(num + "   ");
		
		System.out.println("\nThe median value is " + getMedian(numbers));
		
		input.close();
	}
}
