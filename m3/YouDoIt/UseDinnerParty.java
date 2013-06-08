import javax.swing.*;

public class UseDinnerParty
{
	public static void main(String[] args)
	{
		Party aParty = new Party();
		JOptionPane.showMessageDialog(null, "Creating a party");
		aParty.inputGuests();
		aParty.displayGuests();

		DinnerParty aDinnerParty = new DinnerParty();
		JOptionPane.showMessageDialog(null, "Creating a party with dinner");
		aDinnerParty.inputGuests();
		aDinnerParty.inputDinnerChoice();

		aDinnerParty.displayGuests();
		aDinnerParty.displayDinnerChoice();
	}
}
