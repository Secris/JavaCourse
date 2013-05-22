public class EventArrayDemo
{
	public static void main(String[] args)
	{
		Event[] someEvents = new Event[5];
		int x;
		
		for(x = 0; x < someEvents.length; ++x)
			someEvents[x] = new Event(1);
		
		for(x = 0; x< someEvents.length; ++x)
			System.out.println(someEvents[x].getType() + " " + someEvents[x].getRate() + " " + someEvents[x].getManager());
	}
}
