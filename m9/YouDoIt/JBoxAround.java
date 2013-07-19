import javax.swing.*;
import java.awt.*;

public class JBoxAround extends JFrame
{
	String movieQuote = new String("An offer he can't refuse");
	Font serifItalic = new Font("Serif", Font.ITALIC, 20);

	int leading, ascent, height, width;
	int x = 40, y = 60;
	
	static final int BORDER = 5;
	
	public JBoxAround()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics gr)
	{
		super.paint(gr);
		gr.setFont(serifItalic);
		gr.drawString(movieQuote, x, y);
		leading = gr.getFontMetrics().getLeading();
		ascent = gr.getFontMetrics().getAscent();
		height = gr.getFontMetrics().getHeight();
		width = gr.getFontMetrics().stringWidth(movieQuote);
		
		gr.drawRect(x - BORDER, y - (ascent + leading + BORDER), width + 2 * BORDER, height + 2 * BORDER);
	}
	
	public static void main(String[] args)
	{
		JBoxAround frame = new JBoxAround();
		frame.setSize(330, 100);
		frame.setVisible(true);
	}
}
