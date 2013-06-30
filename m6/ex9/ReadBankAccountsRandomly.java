/**
 * Programmer:			Sean Thames
 * Date:				2013-06-20
 * Filename:			ReadBankAccountsRandomly.java
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
import static java.nio.file.StandardOpenOption.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class ReadBankAccountsRandomly
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String userInput;

		Path filename = Paths.get("AccountRecords.txt");
		Path file = filename.toAbsolutePath();

		final String QUIT = "QUIT";

		final String ACCOUNT_NUMBER_FORMAT = "0000";
		final String NAME_FORMAT = "        ";
		final int NAME_LENGTH = NAME_FORMAT.length();
		final String BALANCE_FORMAT = "00000.00";
		final String delimiter = ",";

		String defaultRecord = ACCOUNT_NUMBER_FORMAT + delimiter + NAME_FORMAT + delimiter + BALANCE_FORMAT + System.getProperty("line.separator");
		final int RECORD_SIZE = defaultRecord.length();

		String acctString;
		int acct;
		byte[] data = defaultRecord.getBytes();
		String s;

		System.out.print("Enter the number of the account to view >> ");
		userInput = input.nextLine();

		try
		{
			FileChannel fc = (FileChannel)Files.newByteChannel(file, READ);

			while(!(userInput.equals(QUIT)))
			{
				ByteBuffer buffer = ByteBuffer.wrap(data);
				acct = Integer.parseInt(userInput);

				fc.position(acct * RECORD_SIZE);
				fc.read(buffer);
				s = new String(data);

				prettyPrint(s.split(delimiter));

				System.out.print("Enter the number of the account to view or " + QUIT + " >> ");
				userInput = input.nextLine();
			}

			fc.close();
		}
		catch(Exception e)
		{
			System.out.println("Error message: " + e);
		}

		input.close();
	}

	public static void prettyPrint(String[] c)
	{
		StringBuilder sb = new StringBuilder();

		for(String s : c)
			sb.append(s + " ");

		System.out.println(sb.toString());
	}
}
