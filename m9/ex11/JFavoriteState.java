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