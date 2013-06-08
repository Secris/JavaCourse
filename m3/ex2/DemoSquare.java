/**
	Programmer:			Sean Thames
	Date:				2013-06-06
	Filename:			DemoSquare.java
	Assignment: 		Ch 10 Ex 2
	Description:		Create a class named "Square" that contains data fields 
	for "height", "width", and "surfaceArea", and a method named 
	"computeSurfaceArea()". Create a child class named "Cube." "Cube" contains 
	an additional data field named "depth", and a "computeSurfaceArea()" method 
	that overrides the parent method. Write an application that instantiates a
	"Square" object and a "Cube" object and displays the surface areas of the 
	objects. Save the files as "Cube.java", "Square.java", and 
	"DemoSquare.java."
	
	Formulas:
	Surface Area of a Rectangle = hw
	Surface Area of a Rectangular Prism = 2hw + 2wd + 2hd
*/

public class DemoSquare
{
	public static void main(String[] args)
	{
		/*
			Technically a square and a cube have sides that are all the same 
			value. However since it specifies otherwise I am assuming it wants 
			your values to look something like this.
		*/
		double height = 10.0;
		double width = 8.0;
		double depth = 13.0;
		
		Square aSquare = new Square(10.0, 8.0);
		Cube aCube = new Cube(12.0, 10.0, 13.0);
		
		System.out.println("The square has the following values: ");
		System.out.println("Height: " + aSquare.getHeight());
		System.out.println("Width: " + aSquare.getWidth());
		System.out.println("Surface Area: " + aSquare.computeSurfaceArea());
		
		System.out.println("\nThe cube has the following values: ");
		System.out.println("Height: " + aCube.getHeight());
		System.out.println("Width: " + aCube.getWidth());
		System.out.println("Depth: " + aCube.getDepth());
		System.out.println("Surface Area: " + aCube.computeSurfaceArea());
	}
}
