import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;
import java.text.*;

public class CreateFilesBasedOnState
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		Path inStateFile = Paths.get("/home/sean/dev/JavaCourse/m6/YouDoIt/InStateCusts.txt");
		Path outOfStateFile = Paths.get("/home/sean/dev/JavaCourse/m6/YouDoIt/OutOfStateCusts.txt");

		final String ID_FORMAT = "000";
		final String NAME_FORMAT = "          ";
		final int NAME_LENGTH = NAME_FORMAT.length();
		final String HOME_STATE = "WI";
		final String BALANCE_FORMAT = "0000.00";
		String delimiter = ",";
		String s = ID_FORMAT + delimiter + NAME_FORMAT + delimiter + HOME_STATE + delimiter + BALANCE_FORMAT + System.getProperty("line.separator");
		final int RECSIZE = s.length();

		FileChannel fcIn = null;
		FileChannel fcOut = null;
		String idString;
		int id;
		String name;
		String state;
		double balance;
		final String QUIT = "999";

		createEmptyFile(inStateFile, s);
		createEmptyFile(outOfStateFile, s);
	}

	public static void createEmptyFile(Path file, String s)
	{
		final int NUMRECS = 1000;

		try
		{
			OutputStream outputStr = new BufferedOutputStream(file.newOutputStream(CREATE));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStr));

			for(int count = 0; count < NUMRECS; ++count)
				writer.write(s, 0, s.length());

			writer.close();
		}
		catch(Exception e)
		{
			System.out.println("Error message: " + e);
		}
	}
}
