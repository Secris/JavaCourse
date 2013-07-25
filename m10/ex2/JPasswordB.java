/**
 * Programmer:			Sean Thames
 * Date:				2013-07-25
 * Filename:			JPasswordA.java
 * Assignment:			Ch 17 Ex 2
 *
 * Description:         A) Create a JApplet that asks a user to enter a 
 * password into a JTextField and to then press Enter. Compare the 
 * password to "Rosebud"; if it matches exactly, display "Access Granted".
 * If not, display "Access Denied". Save the file as JPasswordA.java.
 * 
 * B) Modify the password applet in Exercise 2a to ignore differences in
 * case between the typed password and "Rosebud". Save the file as 
 * JPasswordB.java.
 * 
 * C) Modify the password applet in Exercise 2b to compare the password 
 * to a list of five valid passwords: Rosebud, Redrum, Jason, Surrender,
 * or Dorothy. Save the file as JPasswordC.java
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JPasswordB extends JApplet implements ActionListener
{
	private final String PASSWORD = "Rosebud";
	
	private Container con = getContentPane();
	private JLabel passwordLabel = new JLabel("Password:");
	private JTextField passwordField = new JTextField(16);
	
	private JLabel accessGranted = new JLabel("<html><font color=\"green\">Access Granted</font></html>");
	private JLabel accessDenied = new JLabel("<html><font color=\"red\">Access Denied</font></html>");
	
	public void init()
	{
		con.setLayout(new FlowLayout());
		
		con.add(passwordLabel);
		con.add(passwordField);
		
		con.add(accessGranted);
		accessGranted.setVisible(false);
		con.add(accessDenied);
		accessDenied.setVisible(false);
		
		passwordField.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String input = passwordField.getText();
		
		if(input.equalsIgnoreCase(PASSWORD))
		{
			accessGranted.setVisible(true);
			accessDenied.setVisible(false);
		}
		else
		{
			accessDenied.setVisible(true);
			accessGranted.setVisible(false);
		}
	}
}
