/**
 * Programmer:			Sean Thames
 * Date:				2013-07-19
 * Filename:			JFavoriteState.java
 * Assignment:			Ch 16 Ex 11
 *
 * Description:			Write an application that extends JFrame and that uses
 * the Graphics2D environment to create a GeneralPath object. Use the
 * GeneralPath object to create the outline of your favorite state. Display the
 * state name at the approximate center of the state boundaries. Save the file
 * as JFavoriteState.java
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class JFavoriteState extends JFrame
{
	/*
		To get the points I scaled an image to the general dimensions I wanted (350 x 400)
		then opened it in paint. Once in paint I was able to get the coordinates by placing
		my mouse at each point and writing down the numbers in the bottom left of the window.
		This method allowed me to be as detailed as I wanted and produced a better result than
		drawing it on graph paper (I tried both).
	*/
	// Really LONG line... 480+ characters. Should be 103 points.
	public static final float xPoints[] = {7, 147, 147, 325, 325, 333, 341, 332, 328, 330, 329, 325, 322, 324, 323, 325, 329, 331, 327, 242, 243, 240, 238, 238, 235, 229, 223, 215, 210, 205, 203, 200, 201, 196, 189, 186, 184, 177, 172, 171, 165, 160, 156, 151, 143, 136, 131, 129, 125, 127, 125, 127, 125, 126, 123, 117, 118, 116, 113, 108, 104, 102, 93, 84, 82, 86, 87, 83, 75, 67, 66, 63, 64, 63, 58, 55, 50, 47, 48, 48, 45, 42, 22, 24, 20, 20, 21, 19, 19, 11, 11, 2, 2, 0, 8, 10, 8, 11, 11, 9, 8, 5, 7};
	public static final float yPoints[] = {1, 1, 120, 280, 286, 301, 309, 317, 324, 332, 338, 344, 345, 351, 356, 359, 360, 365, 371, 379, 375, 372, 373, 362, 354, 347, 341, 336, 331, 330, 332, 330, 328, 319, 319, 321, 319, 317, 314, 310, 306, 303, 304, 304, 302, 302, 303, 299, 298, 292, 289, 287, 284, 277, 273, 271, 266, 262, 262, 255, 253, 249, 236, 229, 216, 215, 206, 202, 202, 192, 182, 179, 173, 167, 164, 164, 159, 161, 157, 150, 148, 142, 123, 120, 109, 102, 94, 92, 87, 79, 77, 70, 66, 63, 47, 42, 36, 28, 19, 14, 11, 9, 6};

	// My stepdad informed me it was not good enough without the bay area lol
	public static final float bayX[] = {64, 67, 67, 71, 77, 75, 74, 69, 70, 66, 68, 71, 77, 82, 81, 80, 78, 75, 71, 70, 68, 64};
	public static final float bayY[] = {168, 170, 175, 178, 182, 178, 174, 168, 165, 163, 160, 158, 159, 159, 157, 153, 155, 158, 158, 154, 154, 156};
	Font label = new Font("Courier New", Font.BOLD, 12);

	public JFavoriteState()
	{
		super("Favorite State");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public void paint(Graphics gr)
	{
		super.paint(gr);
		Graphics2D gr2D = (Graphics2D)gr;
		GeneralPath cal = new GeneralPath();
		GeneralPath bay = new GeneralPath();

		cal.moveTo(xPoints[0] + 10, yPoints[0] + 50);
		for(int i = 1; i < xPoints.length; i++)
			cal.lineTo(xPoints[i] + 10, yPoints[i] + 50);
		cal.closePath();

		bay.moveTo(bayX[0] + 10, bayY[0] + 50);
		for(int i = 1; i < bayX.length; i++)
			bay.lineTo(bayX[i] + 10, bayY[i] + 50);
		bay.closePath();

		gr2D.draw(cal);
		gr2D.draw(bay);

		gr.setFont(label);
		gr.drawString("California", 125, 225);
	}

	public static void main(String[] args)
	{
		JFavoriteState frame = new JFavoriteState();
		frame.setSize(375, 450);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}