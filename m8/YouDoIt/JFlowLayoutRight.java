import javax.swing.*;
import java.awt.*;

public class JFlowLayoutRight extends JFrame
{
	private JButton nb = new JButton("North");
	private JButton sb = new JButton("South");
	private JButton eb = new JButton("East");
	private JButton wb = new JButton("West");
	private JButton cb = new JButton("Center");
	
	public JFlowLayoutRight()
	{
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(nb);
		add(sb);
		add(eb);
		add(wb);
		add(cb);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		JFlowLayoutRight jbl = new JFlowLayoutRight();
		jbl.setSize(250, 250);
		jbl.setVisible(true);
	}
}
