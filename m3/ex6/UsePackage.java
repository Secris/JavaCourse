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

public class UsePackage
{
	public static void main(String[] args)
	{
		Package[] packageArray = new Package[3];
		packageArray[0] = new Package(3, 'A');
		packageArray[1] = new Package(10, 'T');
		packageArray[2] = new Package(15, 'M');
		
		InsuredPackage[] insuredPackageArray = new InsuredPackage[3];
		insuredPackageArray[0] = new InsuredPackage(14, 'M');
		insuredPackageArray[1] = new InsuredPackage(4, 'T');
		insuredPackageArray[2] = new InsuredPackage(20, 'A');
		
		System.out.println("Displaying Packages");
		for(Package p : packageArray)
			p.display();
		
		System.out.println("\nDisplaying Insured Packages");
		for(InsuredPackage ip : insuredPackageArray)
			ip.display();
	}
}
