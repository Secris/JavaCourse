import javax.swing.*;
import java.awt.*;

public class JDemoGraphics extends JFrame
{
	String movieQuote = new String("Why so serious?");
	
	public JDemoGraphics()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics gr)
	{
		super.paint(gr);
		gr.drawString(movieQuote, 30, 100);
	}
	
	public static void main(String[] args)
	{
		JDemoGraphics frame = new JDemoGraphics();
		frame.setSize(280, 200);
		frame.setVisible(true);
	}
}
