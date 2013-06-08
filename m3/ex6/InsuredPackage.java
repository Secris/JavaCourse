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

public class InsuredPackage extends Package
{
	private final double[] INSURANCE = {2.45, 3.95, 5.55};
	
	private double shippingBefore;
	private double shippingCost;
	private double insuranceCost;
	
	public InsuredPackage(int w, char m)
	{
		super(w, m);
		
		this.calculateShipping();
	}
	
	public void calculateShipping()
	{
		shippingBefore = super.getShippingCost();
		if(shippingBefore <= 1.00)
			insuranceCost = INSURANCE[0];
		else if(shippingBefore >= 1.01 && shippingBefore <= 3.00)
			insuranceCost = INSURANCE[1];
		else if(shippingBefore >= 3.01)
			insuranceCost = INSURANCE[2];
		
		shippingCost = shippingBefore + insuranceCost;
	}
	
	public void display()
	{
		// Make pretty money format
		DecimalFormat f = new DecimalFormat("##.00");
		String formattedShippingCost = f.format(shippingCost);
		String formattedInsuranceCost = f.format(insuranceCost);
		
		String displayString = "";
		displayString += "Weight: " + super.getWeight();
		displayString += "\nShipping Method: " + super.getShippingMethod();
		displayString += "\nInsurance: $" + formattedInsuranceCost;
		displayString += "\nShipping Cost with insurance: $" + formattedShippingCost;
		
		JOptionPane.showMessageDialog(null, displayString);
	}
}
