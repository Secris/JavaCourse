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
	private static boolean isValid(String a)
	{
		a = a.toLowerCase();
		if(a.equals("a") || a.equals("b") || a.equals("c"))
		{
			return true;
		} 
		else
		{
			JOptionPane.showMessageDialog(null, "Please pick A, B, or C");
			return false;
		}
	}
	private static String askQuestion(String[] q) 
	{
		String fmtQuestion = ""; // String to hold the formatted question
		String answer = "";
		
		for(int i = 0; i < q.length; i++)
			fmtQuestion += q[i] + "\n";
			
		do 
		{
			answer = JOptionPane.showInputDialog(null, fmtQuestion);
		} while (!(isValid(answer)));
		
		return answer;
	}
	private static boolean isCorrect(String a, String r) // a = correct answer, r = user response
	{
		r = r.toUpperCase();
		if(a.equals(r)) 
		{
			JOptionPane.showMessageDialog(null, "Correct!");
			return true;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "The correct answer is: \n" + a);
			return false;
		}
	}
	public static void showGrade(int c, int i)
	{
		int numberQuestions = c + i;
		String fmtGrade = "";
		int pointsPerQuestion = 100 / numberQuestions;
		int grade = c * pointsPerQuestion;
		
		fmtGrade += "You answered " + c + " correctly and " + i + " incorrectly";
		fmtGrade += "\nYour grade is: " + grade + "%";
		
		JOptionPane.showMessageDialog(null, fmtGrade);
	}

	public static void main(String[] args)
	{
		int i = 0; // iterator to be used later for the askQuestion loop
		int correct = 0; // number of correct answers
		int incorrect = 0; // number of incorrect answers
		String response = ""; // holds the answer the user supplied
		
		
		
		String[][] question = new String[10][4]; // Array to store questions
		String[] correctAnswer = new String[10]; // Array to store correct answers
		
		question[0][0] = "Question 1";
		question[0][1] = "A) First answer";
		question[0][2] = "B) Second answer";
		question[0][3] = "C) Third answer";
		correctAnswer[0] = "A";
		
		question[1][0] = "Question 2";
		question[1][1] = "A) First answer";
		question[1][2] = "B) Second answer";
		question[1][3] = "C) Third answer";
		correctAnswer[1] = "A";
		
		question[2][0] = "Question 3";
		question[2][1] = "A) First answer";
		question[2][2] = "B) Second answer";
		question[2][3] = "C) Third answer";
		correctAnswer[2] = "A";
		
		question[3][0] = "Question 4";
		question[3][1] = "A) First answer";
		question[3][2] = "B) Second answer";
		question[3][3] = "C) Third answer";
		correctAnswer[3] = "A";
		
		question[4][0] = "Question 5";
		question[4][1] = "A) First answer";
		question[4][2] = "B) Second answer";
		question[4][3] = "C) Third answer";
		correctAnswer[4] = "A";
		
		question[5][0] = "Question 6";
		question[5][1] = "A) First answer";
		question[5][2] = "B) Second answer";
		question[5][3] = "C) Third answer";
		correctAnswer[5] = "A";
		
		question[6][0] = "Question 7";
		question[6][1] = "A) First answer";
		question[6][2] = "B) Second answer";
		question[6][3] = "C) Third answer";
		correctAnswer[6] = "A";
		
		question[7][0] = "Question 8";
		question[7][1] = "A) First answer";
		question[7][2] = "B) Second answer";
		question[7][3] = "C) Third answer";
		correctAnswer[7] = "A";
		
		question[8][0] = "Question 9";
		question[8][1] = "A) First answer";
		question[8][2] = "B) Second answer";
		question[8][3] = "C) Third answer";
		correctAnswer[8] = "A";
		
		question[9][0] = "Question 10";
		question[9][1] = "A) First answer";
		question[9][2] = "B) Second answer";
		question[9][3] = "C) Third answer";
		correctAnswer[9] = "A";

		// loop through the question array asking each one
		do 
		{
			response = askQuestion(question[i]);
			if(isCorrect(correctAnswer[i], response))
				correct += 1;
			else
				incorrect += 1;
			
			i++;
		} while(i < question.length);
		
		showGrade(correct, incorrect);
	}
}
