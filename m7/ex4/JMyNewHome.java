/**
 * Programmer:			Sean Thames
 * Date:				2013-06-30
 * Filename:			JMyNewHome.java
 * Assignment:			Ch 14 Ex 4
 *
 * Description:			Write an application for a construction company to 
 * handle a customer's order to build a new home. Use separate ButtonGroups to
 * allow the customer to select one of four models, the number of bedrooms, and
 * a garage type. Assume that the models are the Aspen, $100,000; the Brittany,
 * $120,000; the Colonial, $180,000; or the Dartmoor, $250,000. Assume that any
 * model can have two, three, or four bedrooms and that each bedroom adds 
 * $10,500 to the base price. Assume that the garage type can be zero-, one-, 
 * two-, or three-car, and that each car adds $7,775 to the price. Save the
 * file as JMyNewHome.java
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JMyNewHome extends JFrame implements ItemListener
{
	final int WIDTH = 325;
	final int HEIGHT = 400;
	
	final int ASPEN_PRICE = 100000;
	final int BRITTANY_PRICE = 120000;
	final int COLONIAL_PRICE = 180000;
	final int DARTMOOR_PRICE = 250000;
	
	final int PRICE_PER_BEDROOM = 10500;
	
	final int PRICE_PER_CAR = 7775;
	
	JLabel appTitle = new JLabel("My New Home order calculator");
	JLabel priceLabel = new JLabel("Total Price:");
	JLabel[] separator = new JLabel[4];
	
	JTextField price = new JTextField(8);
	
	ButtonGroup models = new ButtonGroup();
	JRadioButton aspen = new JRadioButton("Aspen $" + ASPEN_PRICE);
	JRadioButton brittany = new JRadioButton("Brittany $" + BRITTANY_PRICE);
	JRadioButton colonial = new JRadioButton("Colonial $" + COLONIAL_PRICE);
	JRadioButton dartmoor = new JRadioButton("Dartmoor $" + DARTMOOR_PRICE);
	
	ButtonGroup bedrooms = new ButtonGroup();
	JRadioButton twoRooms = new JRadioButton("Two Bedrooms $" + (2 * PRICE_PER_BEDROOM));
	JRadioButton threeRooms = new JRadioButton("Three Bedrooms $" + (3 * PRICE_PER_BEDROOM));
	JRadioButton fourRooms = new JRadioButton("Four Bedrooms $" + (4 * PRICE_PER_BEDROOM));
	
	ButtonGroup garage = new ButtonGroup();
	JRadioButton zeroCars = new JRadioButton("No Garage $" + (0 * PRICE_PER_CAR));
	JRadioButton oneCars = new JRadioButton("One Car Garage $" + (1 * PRICE_PER_CAR));
	JRadioButton twoCars = new JRadioButton("Two Car Garage $" + (2 * PRICE_PER_CAR));
	JRadioButton threeCars = new JRadioButton("Three Car Garage $" + (3 * PRICE_PER_CAR));
	
	int totalPrice = 0;
	
	public JMyNewHome()
	{
		super("My New Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLayout(new FlowLayout());
		
		for(int i = 0; i < separator.length; i++)
			separator[i] = new JLabel("---------------------------------------------------");
		
		add(appTitle);
		
		add(separator[0]);
		
		add(aspen);
		add(brittany);
		add(colonial);
		add(dartmoor);
		aspen.addItemListener(this);
		brittany.addItemListener(this);
		colonial.addItemListener(this);
		dartmoor.addItemListener(this);
		
		add(separator[1]);
		
		add(twoRooms);
		add(threeRooms);
		add(fourRooms);
		twoRooms.addItemListener(this);
		threeRooms.addItemListener(this);
		fourRooms.addItemListener(this);
		
		add(separator[2]); 
		
		add(zeroCars);
		add(oneCars);
		add(twoCars);
		add(threeCars);
		zeroCars.addItemListener(this);
		oneCars.addItemListener(this);
		twoCars.addItemListener(this);
		threeCars.addItemListener(this);
		
		add(separator[3]);
		
		add(priceLabel);
		add(price);
		price.setEditable(false);
		
		groupButtons();
		setLocationRelativeTo(null); // Starting in the corner bugs me
		
		setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent event)
	{
		totalPrice = 0;
		
		Object source = event.getSource();
		
		if(aspen.isSelected())
			totalPrice += ASPEN_PRICE;
		if(brittany.isSelected())
			totalPrice += BRITTANY_PRICE;
		if(colonial.isSelected())
			totalPrice += COLONIAL_PRICE;
		if(dartmoor.isSelected())
			totalPrice += DARTMOOR_PRICE;
		
		if(twoRooms.isSelected())
			totalPrice += (2 * PRICE_PER_BEDROOM);
		if(threeRooms.isSelected())
			totalPrice += (3 * PRICE_PER_BEDROOM);
		if(fourRooms.isSelected())
			totalPrice += (4 * PRICE_PER_BEDROOM);
		
		if(oneCars.isSelected())
			totalPrice += PRICE_PER_CAR;
		if(twoCars.isSelected())
			totalPrice += (2 * PRICE_PER_CAR);
		if(threeCars.isSelected())
			totalPrice += (3 * PRICE_PER_CAR);
			
		price.setText("$" + totalPrice);
	}
	
	public void groupButtons()
	{
		models.add(aspen);
		models.add(brittany);
		models.add(colonial);
		models.add(dartmoor);
		
		bedrooms.add(twoRooms);
		bedrooms.add(threeRooms);
		bedrooms.add(fourRooms);
		
		garage.add(zeroCars);
		garage.add(oneCars);
		garage.add(twoCars);
		garage.add(threeCars);
	}
	public static void main(String[] args)
	{
		JMyNewHome aHome = new JMyNewHome();
	}
}
