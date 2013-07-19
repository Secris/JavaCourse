import javax.swing.*;
import java.awt.*;

public class JDemoFontMetrics extends JFrame
{
	String movieQuote = new String("Go ahead, make my day");
	Font courierItalic = new Font("Courier New", Font.ITALIC, 16), timesPlain = new Font("Times New Roman", Font.PLAIN, 16), scriptBold = new Font("Freestyle Script", Font.BOLD, 16);
	
	int ascent, descent, height, leading;
	int x = 20, y = 50;
	
	final int INCREASE_SMALL = 15;
	final int INCREASE_LARGE = 40;
	
	public JDemoFontMetrics()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics pen)
	{
		super.paint(pen);
		pen.setFont(courierItalic);
		pen.drawString(movieQuote, x, y);
		displayMetrics(pen);
		pen.setFont(timesPlain);
		pen.drawString(movieQuote, x, y += INCREASE_LARGE);
		displayMetrics(pen);
		pen.setFont(scriptBold);
		pen.drawString(movieQuote, x, y += INCREASE_LARGE);
		displayMetrics(pen);
	}

	public void displayMetrics(Graphics metrics)
	{
		leading = metrics.getFontMetrics().getLeading();
		ascent = metrics.getFontMetrics().getAscent();
		descent = metrics.getFontMetrics().getDescent();
		height = metrics.getFontMetrics().getHeight();
		
		metrics.drawString("Leading is " + leading, x, y += INCREASE_SMALL);
		metrics.drawString("Ascent is " + ascent, x, y += INCREASE_SMALL);
		metrics.drawString("Descent is " + descent, x, y += INCREASE_SMALL);
		metrics.drawString("Height is " + height, x, y += INCREASE_SMALL);
	}
	
	public static void main(String[] args)
	{
		JDemoFontMetrics frame = new JDemoFontMetrics();
		frame.setSize(250, 350);
		frame.setVisible(true);
	}
}
