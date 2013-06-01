/**
 * 	Author:			Sean Thames
 * 	Class:			CIST-2372
 * 	Date:			2013-06-01
 * 	Filename:		DayOfWeek.java
 * 	Assignment:		Chapter 9 Ex 6
 *
 *  Description:	Create an application that contains an enumeration that
 *	represents the days of the week. Display a list of the days, then prompt
 *	the user for a day. Display business hours for the chosen day. Assume 
 *	that the business is open from 11 to 5 on Sunday, 9 to 9 on weekdays, 
 *	and 9 to 6 on Saturday. Save the file as DayOfWeek.java
 *
 */
 
 import java.util.Scanner;
 
 public class DayOfWeek
 {
 	// Thanks to my docs.oracle.com research enum is way more advanced
 	public enum Days {
 		SUN("11 - 5"), MON("9 - 9"), TUE("9 - 9"), WED("9 - 9"), THU("9 - 9"), FRI("9 - 9"), SAT("9 - 6");
 	
 		private String hours;
 		
 		private Days(String h)
 		{
 			hours = h;
 		}
 	}
 	public static void main(String[] args)
 	{
 		Scanner in = new Scanner(System.in);
 		
 		Days aDay;
 		String input = "";
 		
 		for (Days day : Days.values())
 			System.out.print(day + " ");
 		
 		System.out.print("\nPlease pick a day: ");
 		input = in.nextLine().toUpperCase();
 		
 		if (input.length() > 3)
 			input = input.substring(0, 3); // trimming in case user inputs full day name
 		
 		try // I have a peeve about seeing errors even from unexpected input
 		{
 			aDay = Days.valueOf(input);
 			
 			System.out.println("The hours for " + aDay + " are " + aDay.hours);
 		}
 		catch(Exception e)
 		{
 			if (input.isEmpty())
 				System.out.println("Nothing entered exiting.");
 			else
 				System.out.println("Error: Invalid entry!\n\t" + e);
 		}
 	}
 }
