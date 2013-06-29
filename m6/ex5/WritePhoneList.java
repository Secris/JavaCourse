/**
 * Programmer:			Sean Thames
 * Date:				2013-06-20
 * Filename:			WritePhoneList.java
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

public class WritePhoneList
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String userInput;

		// I develop on Linux so this means it will work either way
		Path fileName = Paths.get("PhoneBook.txt");
		Path file = fileName.toAbsolutePath();
		OutputStream outputFile = null;

		final String QUIT = "QUIT";
		final String delimiter = ",";

		System.out.print("Enter contact's first name or " + QUIT + " >> ");
		userInput = input.nextLine();

		try
		{
			outputFile = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputFile));

			while(!(userInput.equals(QUIT)))
			{
				StringBuilder contact = new StringBuilder(userInput);

				System.out.print("Enter contact's last name >> ");
				userInput = input.nextLine();
				contact.append(delimiter + userInput.trim());

				System.out.print("Enter contact's phone number >> ");
				userInput = input.nextLine();
				contact.append(delimiter + userInput.trim());

				contact.append(System.getProperty("line.separator"));
				String s = contact.toString();

				writer.write(s);

				System.out.print("\nEnter contact's first name or " + QUIT + " >> ");
				userInput = input.nextLine();
			}

			writer.close();
		}
		catch(Exception e)
		{
			System.out.println("Error message: " + e);
		}
	}
}
