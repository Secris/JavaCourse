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
	// Really LONG line... 480+ characters. Should be 103 points.
	final int xPoints[] = {7, 147, 147, 325, 325, 333, 341, 332, 328, 330, 329, 325, 322, 324, 323, 325, 329, 331, 327, 242, 243, 240, 238, 238, 235, 229, 223, 215, 210, 205, 203, 200, 201, 196, 189, 186, 184, 177, 172, 171, 165, 160, 156, 151, 143, 136, 131, 129, 125, 127, 125, 127, 125, 126, 123, 117, 118, 116, 113, 108, 104, 102, 93, 84, 82, 86, 87, 83, 75, 67, 66, 63, 64, 63, 58, 55, 50, 47, 48, 48, 45, 42, 22, 24, 20, 20, 21, 19, 19, 11, 11, 2, 2, 0, 8, 10, 8, 11, 11, 9, 8, 5, 7};
	final int yPoints[] = {1, 1, 120, 280, 286, 301, 309, 317, 324, 332, 338, 344, 345, 351, 356, 359, 360, 365, 371, 379, 375, 372, 373, 362, 354, 347, 341, 336, 331, 330, 332, 330, 328, 319, 319, 321, 319, 317, 314, 310, 306, 303, 304, 304, 302, 302, 303, 299, 298, 292, 289, 287, 284, 277, 273, 271, 266, 262, 262, 255, 253, 249, 236, 229, 216, 215, 206, 202, 202, 192, 182, 179, 173, 167, 164, 164, 159, 161, 157, 150, 148, 142, 123, 120, 109, 102, 94, 92, 87, 79, 77, 70, 66, 63, 47, 42, 36, 28, 19, 14, 11, 9, 6};
	

	public JFavoriteState()
	{
		super("Favorite State");
	}

	public void paint(Graphics gr)
	{
		super.paint(gr);
	}

	public static void main(String[] args)
	{
	}
}