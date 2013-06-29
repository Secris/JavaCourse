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

public class DisplaySavedPhoneList
{
	public static void main(String[] args)
	{
		Path fileName = Paths.get("PhoneBook.txt");
		Path file = fileName.toAbsolutePath();

		final String delimiter = ",";

		String s = "";

		try
		{
			InputStream inputFile = new BufferedInputStream(Files.newInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputFile));

			s = reader.readLine();

			while(s != null)
			{
				String[] contact = s.split(delimiter);
				for(String temp : contact)
					System.out.print(temp + " ");

				System.out.println(); // blank line between records

				s = reader.readLine();
			}

			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("Error message: " + e);
		}
	}
}
