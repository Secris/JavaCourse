/*
	Author:			Sean Thames
	Class:			CIST-2372
	Date:			2013-05-22
	Filename:		Quiz.java
	Assignment:		Chapter 8 Ex 15

	Description:
	Write an application that contains an array of 10 multiple-choice quiz
	questions related to your favorite hobby. Each question contains three
	answer choices. Also create an array that holds the correct answer to each
	question -- A, B, or C. Display each question and verify that the user
	enters only A, B, or C as the answer -- if not, keep prompting the user
	until a valid response is entered. If the user responds to a question
	correctly, display "Correct!"; otherwise, display "The correct answer is"
	and the letter of the correct answer. After the user answers all the
	questions, display the number of correct and incorrect answers. Save the
	file as Quiz.java
*/

import javax.swing.JOptionPane;

public class Quiz
{
	// Method to verify input
	private static boolean validAnswer(String a)
	{
		a = a.toLowerCase();
		if(a.equals("a") || a.equals("b") || a.equals("c"))
			return true;
		else
			return false;
	}

	public static void main(String[] args)
	{
		int i = 0; // iterator to be used later for the askQuestion loop
		
		String[] questions = new String[10]; // Array to store questions
		String[] correctAnswers = new String[10]; // Array to store correct answers
		
		
	}
}
