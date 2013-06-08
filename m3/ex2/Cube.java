/**
	Programmer:			Sean Thames
	Date:				2013-06-06
	Filename:			Cube.java
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

public class Cube extends Square
{
	private double height;
	private double width;
	private double depth;
	private double surfaceArea;
	
	public Cube(double h, double w, double d)
	{
		super(h, w);
		depth = d;
	}
	
	public void setDepth(double d)
	{
		depth = d;
	}
	public double getDepth()
	{
		return depth;
	}
	
	public double computeSurfaceArea()
	{
		height = super.getHeight();
		width = super.getWidth();
		
		// equation for surfaceArea: 2hw + 2wd + 2hd
		surfaceArea = (2 * height * width) + (2 * width * depth) + (2 * height * depth);
		
		return surfaceArea;
	}
}
