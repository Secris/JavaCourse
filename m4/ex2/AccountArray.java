/**
 * Programmer:			Sean Thames
 * Date:				2013-06-14
 * Filename:			AccountArray.java
 * Assignment: 			Ch 11 Ex 2
 * 
 * Description:		A) Create an abstract class named "Account" for a bank.
 * Include an integer field for the account number and a double field 
 * for the account balance. Also include a constructor that requires an 
 * account number and that sets the balance to 0.0. Include a set method
 * for the balance. Also include two abstract get methods -- one for 
 * each field. Create two child classes of Account: Checking and Savings.
 * Within the Checking class, the get method displays the String 
 * "Checking Account Information", the account number, and the balance. 
 * Within the Savings class, add a field to hold the interest rate, and 
 * require the Savings constructor to accept an argument for the value 
 * of the interest rate. The Savings get method displays the String 
 * "Savings Account Information", the account number, the balance, and 
 * the interest rate. Write an application that demonstrates you can 
 * instantiate and display both Checking and Savings objects. Save the 
 * files as Account.java, Checking.java, Savings.java, and 
 * DemoAccounts.java
 * 
 * B) Write an application named AccountArray in which you enter data for
 * a mix of 10 Checking and Savings accounts. Use a for loop to display 
 * the data. Save the file as AccountArray.java
*/

public class AccountArray
{
	public static void main(String[] args)
	{
		Account[] accountArray = new Account[10];
		
		accountArray[0] = new Checking(11);
		accountArray[1] = new Checking(12);
		accountArray[2] = new Checking(13);
		accountArray[3] = new Checking(14);
		accountArray[4] = new Checking(15);
		accountArray[5] = new Savings(21, 1.0);
		accountArray[6] = new Savings(22, 1.1);
		accountArray[7] = new Savings(23, 1.2);
		accountArray[8] = new Savings(24, 1.3);
		accountArray[9] = new Savings(25, 1.4);
		
		// Outputing this much info is less intrusive at the console
		for(int i = 0; i < accountArray.length; ++i)
			System.out.println(accountArray[i].getAccountInfo() + "\n");
	}
}
