/**
	Programmer:			Sean Thames
	Date:				2013-06-06
	Filename:			CollegeCourse.java
	Assignment: 		Ch 10 Ex 8

	Description:		Create a class named "CollegeCourse" that includes data 
	fields that hold the department (for example, ENG), the course number (for
	example, 101), the credits (for example, 3), and the fee for the course (for
	example, $360). All of the fields are required as arguments to the 
	constructor, except for the fee, which is calculated at $120 per credit 
	hour. Include a display() method that displays the course data. Create a 
	subclass named "LabCourse" that adds $50 to the course fee. Override the 
	parent class display() method to indicate that the course is a lab course 
	and to display all the data. Write an application named "UseCourse" that 
	prompts the user for course information. If the user enters a class in any 
	of the following departments, create a "LabCourse: BIO, CHM, CIS, or PHY." 
	If the user enters any other department, create a "CollegeCourse" that does 
	not	include a lab fee. Then display the course data. Save the files as
	"CollegeCourse.java", "LabCourse.java", and "UseCourse.java."
*/

public class CollegeCourse
{
	private String department;
	private int courseNumber;
	private int credits;
	private double fee;
	
	// Some extras
	private final double COST_PER_CREDIT_HOUR = 120.00;

	public CollegeCourse(String d, int cn, int cr)
	{
		department = d.toUpperCase();
		courseNumber = cn;
		credits = cr;
		
		calculateFee();
	}
	
	public String getDepartment()
	{
		return department;
	}
	
	public int getCourseNumber()
	{
		return courseNumber;
	}
	
	public int getCredits()
	{
		return credits;
	}
	
	public double getFee()
	{
		return fee;
	}
	
	private void calculateFee()
	{
		fee = COST_PER_CREDIT_HOUR * credits;
	}
	
	public void display()
	{
		System.out.println("\n==== Course ====");
		System.out.println("Department: " + department);
		System.out.println("Course Num: " + courseNumber);
		System.out.println("Credit Hrs: " + credits);
		System.out.println("Course Fee: " + fee);
	}
}
