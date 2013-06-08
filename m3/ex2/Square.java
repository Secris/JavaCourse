/**
	Programmer:			Sean Thames
	Date:				2013-06-06
	Filename:			Square.java
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

public class Square
{
	private double height;
	private double width;
	private double surfaceArea;
	
	public Square(double h, double w)
	{
		height = h;
		width = w;
	}
	
	public void setHeight(double h)
	{
		height = h;
	}
	public double getHeight()
	{
		return height;
	}
	
	public void setWidth(double w)
	{
		width = w;
	}
	public double getWidth()
	{
		return width;
	}
	
	public double computeSurfaceArea()
	{
		surfaceArea = height * width;
		
		return surfaceArea;
	}
}
