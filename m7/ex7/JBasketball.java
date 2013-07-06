/**
 * Programmer:			Sean Thames
 * Date:				2013-06-30
 * Filename:			JBasketball.java
 * Assignment:			Ch 14 Ex 7
 *
 * Description:			Write an application that allows a user to select a 
 * favorite basketball team from a list box. Include at least five teams in the
 * list, and display the chosen team in a text field after the user makes a 
 * selection. Save the file as JBasketball.java
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JBasketball extends JFrame implements ActionListener
{
	final int WIDTH = 250;
	final int HEIGHT = 100;
	
	String[] teams = {"Bulls", "Celtics", "Heat", "Lakers", "Spurs"};
	
	JLabel title = new JLabel("Please choose a team:");
	JComboBox<String> teamBox = new JComboBox<String>(teams);
	JLabel choiceTitle = new JLabel("You chose: ");
	JTextField choice = new JTextField(8);
	
	public JBasketball()
	{
		super("Team Chooser");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, 75);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		add(title);
		add(teamBox);
		add(choiceTitle);
		add(choice);
		
		teamBox.addActionListener(this);
		
		choiceTitle.setVisible(false);
		choice.setVisible(false);
		choice.setEditable(false);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		setSize(WIDTH, HEIGHT);
		choiceTitle.setVisible(true);
		choice.setVisible(true);
		choice.setText(teamBox.getSelectedItem().toString());
	}
	
	public static void main(String[] args)
	{
		new JBasketball();
	}
}
