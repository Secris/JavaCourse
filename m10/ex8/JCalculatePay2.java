/**
 * Programmer:			Sean Thames
 * Date:				2013-07-25
 * Filename:			JCalculatePay.java
 * Assignment:			Ch 17 Ex 8
 *
 * Description:         A) Create a payroll JApplet named JCalculatePay 
 * that allows the user to enter two double values: hours worked and an 
 * hourly rate. When the user clicks a JButton, gross pay is calculated.
 * Display the result in a JTextField that appears on screen only after 
 * the user clicks the JButton. Save the file as JCalculatePay.java.
 * 
 * B) Modify the payroll applet created in Exercise 8a so that federal 
 * withholding tax is subtracted from gross pay based on the values in 
 * Table 17-1. Display the gross pay, tax amount, and net pay. Save the 
 * file as JCalculatePay2.java.
 * 
 * Income ($)				Withholding %
 * --------------------------------------
 * 0 to 99.99				10
 * 100.00 to 299.99			15
 * 300.00 to 599.99			21
 * 600.00 and up			28
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class JCalculatePay2 extends JApplet implements ActionListener
{
	private final double[] WITHHOLDING_PERCENT = {0.10, 0.15, 0.21, 0.28};
	private final double[] TAX_LIMITS = {99.99, 299.99, 599.99};
	
	Container con = getContentPane();
	
	private JLabel payLabel = new JLabel("Hourly rate: ");
	private JLabel hoursLabel = new JLabel("Hours worked: ");
	private JLabel grossLabel = new JLabel("Gross pay: ");
	private JLabel withholdingLabel = new JLabel("Withheld: ");
	private JLabel netLabel = new JLabel("Net pay: ");
	
	private JButton calculate = new JButton("Calculate");
	
	private JTextField payField = new JTextField(10);
	private JTextField hoursField = new JTextField(10);
	private JTextField grossField = new JTextField(10);
	private JTextField withholdingField = new JTextField(10);
	private JTextField netField = new JTextField(10);
	
	public void init()
	{
		// Decided it was time to learn the more powerful layout manager
		con.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);
		
		c.gridx = 0;
		c.gridy = 0;
		con.add(payLabel, c);
		
		/*
		 * I understand that typing the c.gridx and c.gridy repeatedly is
		 * a bit much but I felt removing them or doing some other method
		 * made it harder to see what is happening.
		 */
		
		c.gridx = 1;
		c.gridy = 0;
		con.add(payField, c);
		
		c.gridx = 0;
		c.gridy = 1;
		con.add(hoursLabel, c);
		
		c.gridx = 1;
		c.gridy = 1;
		con.add(hoursField, c);
		
		c.gridx = 1;
		c.gridy = 2;
		con.add(calculate, c);
		calculate.addActionListener(this);
		
		c.gridx = 0;
		c.gridy = 3;
		con.add(grossLabel, c);
		
		c.gridx = 1;
		c.gridy = 3;
		con.add(grossField, c);
		grossField.setEditable(false);
		
		c.gridx = 0;
		c.gridy = 4;
		con.add(withholdingLabel, c);
		
		c.gridx = 1;
		c.gridy = 4;
		con.add(withholdingField, c);
		withholdingField.setEditable(false);
		
		c.gridx = 0;
		c.gridy = 5;
		con.add(netLabel, c);
		
		c.gridx = 1;
		c.gridy = 5;
		con.add(netField, c);
		netField.setEditable(false);
		
		grossLabel.setVisible(false);
		grossField.setVisible(false);
		withholdingLabel.setVisible(false);
		withholdingField.setVisible(false);
		netLabel.setVisible(false);
		netField.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		NumberFormat money = NumberFormat.getCurrencyInstance();
		String pay = payField.getText();
		String hours = hoursField.getText();
		
		double payRate = 0.0;
		double hoursWorked = 0.0;
		double grossPay = 0.0;
		double withheld = 0.0;
		double taxes = 0.0;
		double netPay = 0.0;
		
		try
		{
			payRate = Double.parseDouble(pay);
			hoursWorked = Double.parseDouble(hours);
			grossPay = payRate * hoursWorked;
			
			if(grossPay < TAX_LIMITS[0])
				withheld = WITHHOLDING_PERCENT[0];
			else if(grossPay > TAX_LIMITS[0] && grossPay <= TAX_LIMITS[1])
				withheld = WITHHOLDING_PERCENT[1];
			else if(grossPay > TAX_LIMITS[1] && grossPay <= TAX_LIMITS[2])
				withheld = WITHHOLDING_PERCENT[2];
			else if(grossPay > TAX_LIMITS[2])
				withheld = WITHHOLDING_PERCENT[3];
			
			taxes = grossPay * withheld;
			netPay = grossPay - taxes;
			
			grossField.setText(money.format(grossPay));
			grossField.setHorizontalAlignment(JTextField.RIGHT);
			grossLabel.setVisible(true);
			grossField.setVisible(true);
			
			withholdingField.setText(money.format(taxes));
			withholdingField.setHorizontalAlignment(JTextField.RIGHT);
			withholdingLabel.setVisible(true);
			withholdingField.setVisible(true);
			
			netField.setText(money.format(netPay));
			netField.setHorizontalAlignment(JTextField.RIGHT);
			netLabel.setVisible(true);
			netField.setVisible(true);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Invalid values");
		}
	}
}
