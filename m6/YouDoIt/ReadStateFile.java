import java.nio.file.*;
import java.io.*;
import java.nio.file.attribute.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class ReadStateFile
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		String fileName;
		System.out.print("Enter name of file to use >> ");
		fileName = kb.nextLine();

		Path name = Paths.get(fileName);
		Path file = name.toAbsolutePath();

		final String ID_FORMAT = "000";
		final String NAME_FORMAT = "          ";
		final int NAME_LENGTH = NAME_FORMAT.length();
		final String HOME_STATE = "GA";
		final String BALANCE_FORMAT = "0000.00";
		String delimiter = ",";
		String s = ID_FORMAT + delimiter + NAME_FORMAT + delimiter + HOME_STATE + delimiter + BALANCE_FORMAT + System.getProperty("line.separator");
		final int RECSIZE = s.length();

		byte data[] = s.getBytes();
		final String EMPTY_ACCT = "000";
		String[] array = new String[4];
		double balance;
		double total;

		try
		{
			BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
			System.out.println("\nAttributes of the file:");
			System.out.println("Creation time " + attr.creationTime());
			System.out.println("Size " + attr.size());
		}
		catch(IOException e)
		{
			System.out.println("IO Exception");
			System.out.println(e.getMessage());
		}
	}
}
