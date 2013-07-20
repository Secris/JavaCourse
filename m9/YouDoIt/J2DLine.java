import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class J2DLine extends JFrame
{
	public J2DLine()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics gr)
	{
		super.paint(gr);
		Graphics2D gr2D = (Graphics2D)gr;
		Point2D.Float pos1 = new Point2D.Float(80, 50);
		Point2D.Float pos2 = new Point2D.Float(20, 100);
		
		BasicStroke aStroke = new BasicStroke(15.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
		
		gr2D.setStroke(aStroke);
		Line2D.Float line = new Line2D.Float(pos1, pos2);
		gr2D.draw(line);
	}
	
	public static void main(String[] args)
	{
		J2DLine frame = new J2DLine();
		frame.setSize(100, 120);
		frame.setVisible(true);
	}
}