/**
 * Programmer:			Sean Thames
 * Date:				2013-06-20
 * Filename:			DisplaySavedPhoneList.java
 * Assignment:			Ch 13 Ex 5
 *
 * Description:			A) Create a program that accepts any number of
 * first names, last names, and associated phone numbers from the keyboard
 * and saves the data to a file. Save the program as WritePhoneList.java.
 * When you execute the program, enter multiple records that have the
 * same first name because you will search for repeated first names in
 * part c of this exercise.
 *
 * B) Write an application that reads the file created by the
 * WritePhoneList application and displays the records. Save the file as
 * DisplaySavedPhoneList.java
 *
 * C) Write an application that allows you to enter any first name and
 * displays all of the last names and phone numbers for records with the
 * given first name. Display an appropriate message if the first name
 * cannot be found in the input file. Save the file as
 * DisplaySelectedNumbers.java
*/

import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;
import java.util.ArrayList;

public class DisplaySelectedNumbers
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String userInput = "";

		ArrayList<String> matches = new ArrayList<String>();

		Path fileName = Paths.get("PhoneBook.txt");
		Path file = fileName.toAbsolutePath();

		final String delimiter = ",";

		int matchFound = 0;

		System.out.print("Search for >> ");
		userInput = input.nextLine();

		try
		{
			InputStream inputFile = new BufferedInputStream(Files.newInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputFile));

			String s = reader.readLine();

			while(s != null)
			{
				String[] contact = s.split(delimiter);

				userInput = userInput.trim(); // making sure there are no errant spaces
				String lowerSearch = userInput.toLowerCase();

				String lowerFirstName = contact[0].toLowerCase();
				if(lowerFirstName.equals(lowerSearch))
				{
					prettyPrint(contact);
					matchFound++;
				}

				/*
				 * This allows for seaching ANY keyword including
				 * partial names or sections of the phone number.
				 */
				/*
				for(String cs : contact)
				{
					cs = cs.toLowerCase();
					if(cs.indexOf(lowerSearch) > -1)
					{
						prettyPrint(contact);
						matchFound++;
					}
				}
				*/

				s = reader.readLine();
			}

			if(matchFound > 0)
				System.out.println("Found " + matchFound + ".");
			else
				System.out.println("No matches found.");

			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("Error message: " + e);
		}
	}

	public static void prettyPrint(String[] c)
	{
		StringBuilder sb = new StringBuilder();

		for(String s : c)
			sb.append(s + " ");

		System.out.println(sb.toString());
	}
}
