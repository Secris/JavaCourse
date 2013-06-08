public class UsePartiesWithConstructors
{
	public static void main(String[] args)
	{
		PartyWithConstructor2 aParty = new PartyWithConstructor2(40);
		DinnerPartyWithConstructor2 aDinnerParty = new DinnerPartyWithConstructor2(25);

		aParty.displayGuests();
		aDinnerParty.displayGuests();
	}
}
