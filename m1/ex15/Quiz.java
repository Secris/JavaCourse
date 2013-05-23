/**
 * 	Author:			Sean Thames
 * 	Class:			CIST-2372
 * 	Date:			2013-05-22
 * 	Filename:		Quiz.java
 * 	Assignment:		Chapter 8 Ex 15
 * 
 * 	Description:
 * 	Write an application that contains an array of 10 multiple-choice quiz
 * 	questions related to your favorite hobby. Each question contains three
 * 	answer choices. Also create an array that holds the correct answer to 
 * 	each question -- A, B, or C. Display each question and verify that the 
 * 	user enters only A, B, or C as the answer -- if not, keep prompting the
 * 	user until a valid response is entered. If the user responds to a 
 * 	question correctly, display "Correct!"; otherwise, display "The 
 * 	correct answer is" and the letter of the correct answer. After the user
 * 	answers all the questions, display the number of correct and incorrect 
 * 	answers. Save the file as Quiz.java
 */

import javax.swing.JOptionPane;

public class Quiz
{
	/**
	 * isValid accapts a string and checks to see if it is A, B, or C
	 * and returns a boolean value of true or false if it matches
	 */
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
	/**
	 * askQuestion recieves an array containing the question and all the
	 * answers. Returning the user input as a String
	 */
	private static String askQuestion(String[] q) 
	{
		String fmtQuestion = ""; // String to hold the formatted question
		String answer = "";
		
		for(int i = 0; i < q.length; i++)
			fmtQuestion += q[i] + "\n";
			
		do 
		{
			answer = JOptionPane.showInputDialog(null, fmtQuestion);
			if(answer == null)
			{
				int quit = JOptionPane.showConfirmDialog(null, "Would you like to quit?", "Quit", JOptionPane.YES_NO_OPTION);
				if(quit == 0)
					return "ABORT";
				else
					continue;
			}
		} while (answer == null || !(isValid(answer)));
		
		return answer;
	}
	/**
	 * isCorrect recieves two values a (correct answer) and r (incorrect
	 * answer). Returning a boolean value if the answer is correct or not
	 */
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
	/**
	 * showGrade accepts two values c (total correct answers) and i (total
	 * incorrect answers). A message dialog is displayed stating the total
	 * coreect, incorrect, and the grade for the test
	 */
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
		String response = ""; // holds the answer the user supplied temporarily
		
		/*
		 * I know multi-dimensional arrays are not till next chapter but
		 * I already knew about them and felt that it really was the best 
		 * option for this assignment
		 */
		
		String[][] question = new String[10][4]; // Array to store questions
		String[] correctAnswer = new String[10]; // Array to store correct answers
		
		question[0][0] = "Which one of these is not a primitive data type?";
		question[0][1] = "A) integer";
		question[0][2] = "B) char";
		question[0][3] = "C) String";
		correctAnswer[0] = "C";
		
		question[1][0] = "Java source code is stored in files with what extension?";
		question[1][1] = "A) .class";
		question[1][2] = "B) .java";
		question[1][3] = "C) .jav";
		correctAnswer[1] = "B";
		
		question[2][0] = "The best environment for developing Java applications is?";
		question[2][1] = "A) A UNIX server hosted by a corporate entity";
		question[2][2] = "B) Eclipse IDE";
		question[2][3] = "C) Whatever you are most comfortable in";
		correctAnswer[2] = "C";
		
		question[3][0] = "Java can be used to write?";
		question[3][1] = "A) Web Applications";
		question[3][2] = "B) Desktop programs";
		question[3][3] = "C) All of the above";
		correctAnswer[3] = "C";
		
		question[4][0] = "Which GUI toolkit comes included with Java?";
		question[4][1] = "A) Swing";
		question[4][2] = "B) Gtk";
		question[4][3] = "C) JavaFX";
		correctAnswer[4] = "A";
		
		question[5][0] = "The current version of Java is?";
		question[5][1] = "A) 7";
		question[5][2] = "B) 1.7";
		question[5][3] = "C) This is a trick question (aka both)";
		correctAnswer[5] = "C";
		
		question[6][0] = "Java is a?";
		question[6][1] = "A) Byte-Code compiled language";
		question[6][2] = "B) Interpreted language";
		question[6][3] = "C) Compiled language";
		correctAnswer[6] = "A";
		
		question[7][0] = "The file extension for MyApp.java after running \"javac MyApp.java\" is?";
		question[7][1] = "A) .exe";
		question[7][2] = "B) .class";
		question[7][3] = "C) .java";
		correctAnswer[7] = "B";
		
		question[8][0] = "In Java console output is achieved by using?";
		question[8][1] = "A) std::cout";
		question[8][2] = "B) printf";
		question[8][3] = "C) System.out.println";
		correctAnswer[8] = "C";
		
		question[9][0] = "Java applications are executed in?";
		question[9][1] = "A) an interpreter";
		question[9][2] = "B) a virtual machine";
		question[9][3] = "C) on your computer";
		correctAnswer[9] = "B";

		// loop through the question array asking each one
		do 
		{
			response = askQuestion(question[i]);
			if(response.equals("ABORT"))
				return;
			if(isCorrect(correctAnswer[i], response))
				correct += 1;
			else
				incorrect += 1;
			
			i++;
		} while(i < question.length);
		
		showGrade(correct, incorrect);
	}
}
