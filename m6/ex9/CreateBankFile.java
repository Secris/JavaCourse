/**
 * Programmer:			Sean Thames
 * Date:				2013-06-20
 * Filename:			CreateBankFile.java
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
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;
import java.text.*;

public class CreateBankFile
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Path filename = Paths.get("AccountRecords.txt");
		Path file = filename.toAbsolutePath();

		final int NUMBER_OF_RECORDS = 10000;

		final String ACCOUNT_NUMBER_FORMAT = "0000";
		final String NAME_FORMAT = "        ";
		final int NAME_LENGTH = NAME_FORMAT.length();
		final String BALANCE_FORMAT = "00000.00";
		final String delimiter = ",";

		String defaultRecord = ACCOUNT_NUMBER_FORMAT + delimiter + NAME_FORMAT + delimiter + BALANCE_FORMAT + System.getProperty("line.separator");
		final int RECORD_SIZE = defaultRecord.length();

		FileChannel fc = null;
		String acctString;
		int acct;
		String name;
		double balance;
		byte[] data;
		ByteBuffer buffer;
		final String QUIT = "QUIT";


		createEmptyFile(file, defaultRecord, NUMBER_OF_RECORDS);

		try
		{
			fc = (FileChannel)Files.newByteChannel(file, CREATE, WRITE);

			System.out.print("Enter account number or " + QUIT + " >> ");
			acctString = input.nextLine();

			while(!(acctString.equals(QUIT)))
			{
				acct = Integer.parseInt(acctString);

				System.out.print("Account holder name for account #" + acctString + " >> ");
				name = input.nextLine();
				StringBuilder sb = new StringBuilder(name);
				sb.setLength(NAME_LENGTH);
				name = sb.toString();

				System.out.print("Balance of account #" + acctString + " >> ");
				balance = input.nextDouble();
				input.nextLine();
				DecimalFormat df = new DecimalFormat(BALANCE_FORMAT);

				String s = acctString + delimiter + name + delimiter + df.format(balance) + System.getProperty("line.separator");
				data = s.getBytes();
				buffer = ByteBuffer.wrap(data);

				fc.position(acct * RECORD_SIZE);
				fc.write(buffer);

				System.out.print("\nEnter account number or " + QUIT + " >> ");
				acctString = input.nextLine();
			}

			fc.close();
		}
		catch(Exception e)
		{
			System.out.println("Error message: " + e);
		}

		input.close();
	}

	public static void createEmptyFile(Path file, String s, int lines)
	{
		try
		{
			OutputStream outputStr = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStr));

			for(int count = 0; count < lines; ++count)
				writer.write(s, 0, s.length());

			writer.close();
		}
		catch(Exception e)
		{
			System.out.println("Error message: " + e);
		}
	}
}
