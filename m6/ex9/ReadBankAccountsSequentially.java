/**
 * Programmer:			Sean Thames
 * Date:				2013-06-20
 * Filename:			ReadBankAccountsSequentially.java
 * Assignment:			Ch 13 Ex 9
 *
 * Description:			A) The Rochester Bank maintains customer records
 * in a random access file. Write an application that creates 10,000 blank
 * records and then allows the user to enter customer account information,
 * include an account number that is 9999 or less, a last name, and a
 * balance. Insert each new record into a data file at a location that is
 * equal to the account number. Assume that the user will not enter invalid
 * account numbers. Force each name to eight characters, padding it with
 * spaces or truncating it if necessary. Also assume that the user will not
 * enter a bank balance greater than 99,000.00. Save the file as
 * CreateBankFile.java.
 *
 * B) Create an application that uses the file created by the user in
 * Exercise 9a and displays all existing accounts in account-number order.
 * Save the file as ReadBankAccountsSequentially.java
 *
 * C) Create an application that uses the file created by the user in
 * Exercise 9a and allows the user to enter an account number to view the
 * account balance. Allow the user to view additional account balances
 * until entering an application-terminating value. Save the file as
 * ReadBankAccountsRandomly.java
*/

import java.nio.file.*;
import java.io.*;
import java.nio.file.attribute.*;
import static java.nio.file.StandardOpenOption.*;

public class ReadBankAccountsSequentially
{
	public static void main(String[] args)
	{
		Path filename = Paths.get("AccountRecords.txt");
		Path file = filename.toAbsolutePath();

		final String delimiter = ",";

		try
		{
			InputStream inputFile = new BufferedInputStream(Files.newInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputFile));

			String s = reader.readLine();

			while(s != null)
			{
				String[] array = s.split(delimiter);
				if(!((array[1].trim()).isEmpty()))
					System.out.println("Acct #" + array[0] + "\tAcct Holder: " + array[1]+ "\tBalance: $" + array[2]);

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
