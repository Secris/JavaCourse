/**
	Programmer:			Sean Thames
	Date:				2013-06-06
	Filename:			LabCourse.java
	Assignment: 		Ch 10 Ex 8

	Description:		Create a class named "CollegeCourse" that includes data 
	fields that hold the department (for example, ENG), the course number (for
	example, 101), the credits (for example, 3), and the fee for the course (for
	example, $360). All of the fields are required as arguments to the 
	constructor, except for the fee, which is calculated at $120 per credit 
	hour. Include a display() method that displays the course data. Create a 
	subclass named "LabCourse" that adds $50 to the course fee. Override the 
	parent class display() method to indicatie that the course is a lab course 
	and to display all the data. Write an application named "UseCourse" that 
	prompts the user for course information. If the user enters a class in any 
	of the following departments, create a "LabCourse: BIO, CHM, CIS, or PHY." 
	If the user enters any other department, create a "CollegeCourse" that does 
	not	include a lab fee. Then display the course data. Save the files as
	"CollegeCourse.java", "LabCourse.java", and "UseCourse.java."
*/

public class LabCourse extends CollegeCourse
{
	private final double LAB_FEE = 50.00;
	
	private double labCourseFee;
	
	public LabCourse(String d, int cn, int cr)
	{
		super(d, cn, cr);
		
		this.calculateFee();
	}
	
	private void calculateFee()
	{
		labCourseFee = super.getFee() + LAB_FEE;
	}
	
	public void display()
	{
		System.out.println("\n== Lab Course ==");
		System.out.println("Department: " + getDepartment());
		System.out.println("Course Num: " + getCourseNumber());
		System.out.println("Credit Hrs: " + getCredits());
		System.out.println("Course Fee: " + labCourseFee);
		System.out.println("Lab Fee of $" + LAB_FEE + " applied");
	}
}
