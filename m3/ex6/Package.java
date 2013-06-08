/**
	Programmer:			Sean Thames
	Date:				2013-06-06
	Filename:			.java
	Assignment: 		Ch 10 Ex 6
	Description:		Create a class named "Package" with data fields for 
	weight in ounces, shipping method, and shipping cost. The shipping method is
	a character: 'A' for air, 'T' for truck, or 'M' for mail. The "Package" 
	class contains a constructor that requires arguments for weight and shipping
	method. The constructor calls a calculateCost() method that determines the 
	shipping cost, based on the following table:
	
	Weight(oz.)		Air($)		Truck($)		Mail($)
	1 to 8			2.00		1.50			.50
	9 to 16			3.00		2.35			1.50
	17 and over		4.50		3.25			2.15
	
	The "Package" class also contains a "display()" method that displays the 
	values in all four fields. Create a subclass named "InsuredPackage" that 
	adds an insurance cost to the shipping cost, based on the following table:
	
	Shipping Cost Before Insurance($)	Additional Cost($)
	0 to 1.00							2.45
	1.01 to 3.00						3.95
	3.01 and over						5.55
	
	Write an application named "UsePackage" that instantiates at least three 
	objects of each type (Package and InsuredPackage) using a variety of weights
	and shipping method codes. Display the results for each "Package" and 
	"InsuredPackage." Save the files as "Package.java", "InsuredPackage.java", 
	and "UsePackage.java."

*/

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Package
{
	private int weight;
	private char shippingMethod;
	private double shippingCost;
	
	// Some extras
	private final char defaultShipping = 'M';
	
	private final double[] COST_AIR = {2.00, 3.00, 4.50};
	private final double[] COST_TRUCK = {1.50, 2.35, 3.25};
	private final double[] COST_MAIL = {0.50, 1.50, 2.15};
	
	
	public Package(int w, char m)
	{
		setWeight(w);
		setShippingMethod(m); 
		
		calculateCost();
	}
	
	public void setWeight(int w)
	{
		weight = w;
	}
	public int getWeight()
	{
		return weight;
	}
	
	public void setShippingMethod(char m)
	{
		char convertedChar;
		String tempString;
		
		tempString = String.valueOf(m);
		tempString = tempString.toUpperCase();
		convertedChar = tempString.charAt(0);
			
		switch(convertedChar)
		{
			case 'A':
			case 'T':
			case 'M':
				shippingMethod = convertedChar;
				break;
			default:
				System.out.println("Invalid value: " + convertedChar);
				System.out.println("Defaulting to " + defaultShipping);
				shippingMethod = defaultShipping;
				break;
		}
	}
	public char getShippingMethod()
	{
		return shippingMethod;
	}
	
	public void calculateCost()
	{
		switch(getShippingMethod())
		{
			case 'A':
				if(getWeight() <= 8)
					shippingCost = COST_AIR[0];
				else if (getWeight() >= 9 && getWeight() <= 16)
					shippingCost = COST_AIR[1];
				else if (getWeight() >= 17)
					shippingCost = COST_AIR[2];
				break;
			case 'T':
				if(getWeight() <= 8)
					shippingCost = COST_TRUCK[0];
				else if (getWeight() >= 9 && getWeight() <= 16)
					shippingCost = COST_TRUCK[1];
				else if (getWeight() >= 17)
					shippingCost = COST_TRUCK[2];
				break;
			case 'M':
				if(getWeight() <= 8)
					shippingCost = COST_MAIL[0];
				else if (getWeight() >= 9 && getWeight() <= 16)
					shippingCost = COST_MAIL[1];
				else if (getWeight() >= 17)
					shippingCost = COST_MAIL[2];
				break;
		}
	}
	public double getShippingCost()
	{
		return shippingCost;
	}
	
	public void display()
	{
		// Make pretty money format
		DecimalFormat f = new DecimalFormat("##.00");
		String formattedShippingCost = f.format(getShippingCost());
		/*
			The book says display the four data fields for Package but there are
			only three in the Package class.
		*/
		String displayString = "";
		displayString += "Weight: " + getWeight();
		displayString += "\nShipping Method: " + getShippingMethod();
		displayString += "\nShipping Cost: $" + formattedShippingCost;
		
		JOptionPane.showMessageDialog(null, displayString);
	}
}
