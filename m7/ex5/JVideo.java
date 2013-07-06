/**
 * Programmer:			Sean Thames
 * Date:				2013-06-30
 * Filename:			JVideo.java
 * Assignment:			Ch 14 Ex 5
 *
 * Description:			A) Write an application for a video store. Place the
 * names of 10 of your favorite movies in a combo box. Let the user select a 
 * movie to rent. Display the rental fee, which is $1.00, $2.00, or $3.00 for
 * each movie. Save the file as JVideo.java
 *
 * B) Change the JVideo application to include an editable combo box. Allow the
 * user to type the name of the movie to rent. Display an appropriate error 
 * message if the desired movie is not available. Save the file as JVideo2.java
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class JVideo extends JFrame implements ActionListener
{
	public enum movie {
		EQUILIBRIUM(1.00), I_ROBOT(1.00), THE_MATRIX(1.00), INCEPTION(2.00), V_FOR_VENDETTA(3.00), THE_LAST_SAMURAI(2.00), IRON_MAN(1.00), SHERLOCK_HOLMES(3.00), REPOMEN(2.00), EAGLE_EYE(3.00);
		
		private final double fee;
		
		private movie(double f)
		{
			fee = f;
		}
	}
	
	final int WIDTH = 250;
	final int HEIGHT = 150;
	
	JLabel top = new JLabel("Please select a movie");
	JComboBox movieList = new JComboBox(movie.values());
	JLabel priceLabel = new JLabel("The rental fee is: ");
	JTextField priceBox = new JTextField(5);
	
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	
	public JVideo()
	{
		super("Video Rental System");
		setSize(WIDTH, HEIGHT);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		add(top);
		add(movieList);
		add(priceLabel);
		add(priceBox);
		priceBox.setEditable(false);
		
		movie temp = (movie)movieList.getSelectedItem();
		priceBox.setText(fmt.format(temp.fee));
		
		movieList.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		movie selectedMovie = (movie)movieList.getSelectedItem();
		
		priceBox.setText(fmt.format(selectedMovie.fee));
	}
	
	public static void main(String[] args)
	{
		JVideo videoWindow = new JVideo();
	}
}
