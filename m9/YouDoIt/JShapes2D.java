import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class JShapes2D extends JFrame
{
	public JShapes2D()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics gr)
	{
		super.paint(gr);
		Graphics2D gr2D = (Graphics2D)gr;
		
		Rectangle2D.Float rect = new Rectangle2D.Float(20F, 40F, 40F, 40F);
		Rectangle2D.Float rect2 = new Rectangle2D.Float(20F, 90F, 40F, 40F);
		gr2D.draw(rect);
		gr2D.fill(rect2);
		
		Ellipse2D.Float ellipse = new Ellipse2D.Float(20F, 140F, 40F, 40F);
		Ellipse2D.Float ellipse2 = new Ellipse2D.Float(20F, 190F, 40F, 40F);
		gr2D.draw(ellipse);
		gr2D.fill(ellipse2);
		
		Arc2D.Float ac = new Arc2D.Float(20, 240, 50, 50, 30, 120, Arc2D.PIE);
		Arc2D.Float ac2 = new Arc2D.Float(20, 290, 50, 50, 30, 120, Arc2D.PIE);
		gr2D.draw(ac);
		gr2D.fill(ac2);
		
		GeneralPath pol = new GeneralPath();
		pol.moveTo(20F, 320F);
		pol.lineTo(40F, 380F);
		pol.lineTo(100F, 400F);
		pol.closePath();
		gr2D.draw(pol);
	}
	
	public static void main(String[] args)
	{
		JShapes2D frame = new JShapes2D();
		frame.setSize(100, 240);
		frame.setVisible(true);
	}
}