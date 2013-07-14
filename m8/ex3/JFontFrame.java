/**
 * Programmer:			Sean Thames
 * Date:				2013-07-11
 * Filename:			JFontFrame.java
 * Assignment:			Ch 15 Ex 3
 *
 * Description:         Create a JFrame that holds four buttons with the
 * names of four different fonts. Display a demonstration JLabel using the font 
 * that the user selects. Save the file as JFontFrame.java
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.HashSet;

public class JFontFrame extends JFrame implements ActionListener
{
	private final String demoText = "The font you selected looks like this.";
	private JLabel demonstration = new JLabel("Please select choose a font", JLabel.CENTER);

	private JButton[] fontButtons = new JButton[4];

	GridLayout mainLayout = new GridLayout(2, 0);
	Container buttonArea = new Container();

	public JFontFrame()
	{
		super("JFontFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 300); // Had to make the window larger due to occasionally not having room
		// setResizable(false); // Commented out just incase the window is not big enough it can be resized
		setLocationRelativeTo(null);

		setLayout(mainLayout);
		buttonArea.setLayout(new FlowLayout());

		addWindowComponents();

		add(demonstration);
		add(buttonArea);
	}

	private void addWindowComponents() 
	{
		/*
			Due to the way fonts work it may not be able to display all the fonts listed
			but I felt like it would be a neat addition to make it show different fonts
			each time it is launched.
		*/
		String[] fonts = chooseFonts();

		for(int i = 0; i < fontButtons.length; i++)
		{
			fontButtons[i] = new JButton(fonts[i]);
			buttonArea.add(fontButtons[i]);
			fontButtons[i].addActionListener(this);
		}
	}

	private String[] chooseFonts() 
	{
		Random random = new Random();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] fonts = ge.getAllFonts();

		HashSet<Integer> set = new HashSet<Integer>(); // Thanks to google
		
		int i = 0;
		String[] fontList = new String[4];
		
		while(i < 4)
		{
			int rand = random.nextInt(fonts.length);
			
			if(!(set.contains(rand)))
			{
				set.add(rand);
				fontList[i] = fonts[rand].getFontName();
			}
			
			i++; // Never fails I always forget this on first run
		}
		
		return fontList;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JButton source = (JButton)e.getSource();
		String choice = source.getText();
		changeDemonstration(choice);
	}

	private void changeDemonstration(String f)
	{
		try
		{
			demonstration.setText(demoText);
			Font newFont = new Font(f, Font.PLAIN, 12);
			demonstration.setFont(newFont);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Error setting font!\n" + e);
			System.exit(1);
		}
	}

	public static void main(String[] args)
	{
		JFontFrame fontWindow = new JFontFrame();
		fontWindow.setVisible(true);
	}
}   

