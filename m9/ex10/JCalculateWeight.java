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

public class JCalculateWeight extends JFrame implements ActionListener
{
	public JCalculateWeight()
	{
		super("Calculate weight");
	}

	public void actionPerformed(ActionEvent action)
	{
	}

	public void paint(Graphics gr)
	{
		super.paint(gr);
	}

	private double convertToOunces(double w)
	{
		return (w * 16);
	}
	private double convertToKilo(double w)
	{
		return (w / 2.204623);
	}
	private double convertToMetricTon(double w)
	{
		return (w / 2204.623);
	}

	public static void main(String[] args)
	{
		JCalculateWeight frame = new JCalculateWeight();
		setSize(300, 250);
		setVisible(true);
	}
}