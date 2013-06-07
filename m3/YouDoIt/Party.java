import javax.swing.*;

public class Party
{
	private int guests;

	public void displayGuests()
	{
		JOptionPane.showMessageDialog(null, "Guests: " + guests);
	}
	public void inputGuests()
	{
		String guestsString = new String(" ");
		guestsString = JOptionPane.showInputDialog(null, "Enter the number of guests at your party");
		guests = Integer.parseInt(guestsString);
	}
}
