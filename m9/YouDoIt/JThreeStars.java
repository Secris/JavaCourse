import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class JThreeStars extends JFrame
{
	int xPoints[] = {42, 52, 72, 52, 60, 40, 15, 28, 9, 32, 42};
	int yPoints[] = {38, 62, 68, 80, 105, 85, 102, 75, 58, 60, 38};
	Polygon aStar = new Polygon(xPoints, yPoints, xPoints.length);

	public JThreeStars()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void paint(Graphics star)
	{
		super.paint(star);
		star.setColor(Color.BLUE);
		star.drawPolygon(aStar);
		star.copyArea(0, 0, 75, 105, 80, 40);
		star.copyArea(0, 0, 75, 105, 40, 150);
	}

	public static void main(String[] args)
	{
		JThreeStars frame = new JThreeStars();
		frame.setSize(200, 300);
		frame.setVisible(true);
	}
}
