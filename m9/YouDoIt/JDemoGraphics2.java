import javax.swing.*;
import java.awt.*;
import java.awt.Color.*;

public class JDemoGraphics2 extends JFrame
{
	String movieQuote = new String("Why so serious?");
	Font bigFont = new Font("Boopee", Font.ITALIC, 30);
	
	public JDemoGraphics2()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics gr)
	{
		super.paint(gr);
		gr.setFont(bigFont);
		gr.setColor(Color.MAGENTA);
		gr.drawString(movieQuote, 30, 100);
		gr.setColor(Color.BLUE);
		gr.drawString(movieQuote, 60, 140);
	}
	
	public static void main(String[] args)
	{
		JDemoGraphics2 frame = new JDemoGraphics2();
		frame.setSize(280, 200);
		frame.setVisible(true);
	}
}
