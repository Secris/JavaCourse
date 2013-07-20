/**
 * Programmer:			Sean Thames
 * Date:				2013-07-19
 * Filename:			JCalculateWeight.java
 * Assignment:			Ch 16 Ex 10
 *
 * Description:         Write an application that extends JFrame and that
 * prompts the user to enter his or her name and weight in pounds. After the
 * name and weight are entered, use Graphics2D methods to display the user's
 * name and weight, with the weight displayed in pounds, ounces, kilograms, and
 * metric tons on separate lines. Use the following conversion factors:
 * 	>> 1 pound = 16 ounces
 * 	>> 1 kilogram = 1 pound / 2.204623
 * 	>> 1 metric ton = 1 pound / 2204.623
 * Save the file as JCalculateWeight.java
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class JCalculateWeight extends JFrame implements ActionListener
{
	final String title = new String("Please enter your weight in pounds: ");
	JTextField weightField = new JTextField(10);
	JButton calcButton = new JButton("Calculate!");
	
	final int x = 20;
	int y = 100;
	
	final int offset = 25;
	
	public JCalculateWeight()
	{
		super("Calculate weight");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setResizable(false);
		
		add(new JLabel(title));
		add(weightField);
		add(calcButton);
		calcButton.addActionListener(this);
		
		Container con = getContentPane();
		con.setBackground(Color.WHITE);
	}

	private static double convertToOunces(double w)
	{
		return (w * 16);
	}
	private static double convertToKilo(double w)
	{
		return (w / 2.204623);
	}
	private static double convertToMetricTon(double w)
	{
		return (w / 2204.623);
	}

	public void actionPerformed(ActionEvent ae)
	{
		Graphics gr = getGraphics();
		String weightString = weightField.getText();
		double weight = Double.parseDouble(weightString);
		
		gr.setColor(Color.WHITE);
		gr.fillRect(x - 30, y - 30, 300, 250);
		
		gr.setColor(Color.BLACK);
		gr.drawString("Ounces: " + convertToOunces(weight), x, y);
		gr.drawString("Kilograms: " + convertToKilo(weight), x, y + offset);
		gr.drawString("Metric tons: " + convertToMetricTon(weight), x, y + (offset *2));
	}

	public static void main(String[] args)
	{
		JCalculateWeight frame = new JCalculateWeight();
		frame.setSize(300, 250);
		frame.setVisible(true);
	}
}