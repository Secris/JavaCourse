import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JCardLayout2 extends JFrame implements ActionListener
{
	CardLayout cardLayout = new CardLayout();
	private JButton nb = new JButton("North");
	private JButton sb = new JButton("South");
	private JButton eb = new JButton("East");
	private JButton wb = new JButton("West");
	private JButton cb = new JButton("Center");
	
	public JCardLayout2()
	{
		setLayout(cardLayout);
		add("north", nb);
		add("south", sb);
		add("east", eb);
		add("west", wb);
		add("center", cb);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		nb.addActionListener(this);
		sb.addActionListener(this);
		eb.addActionListener(this);
		wb.addActionListener(this);
		cb.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		cardLayout.next(getContentPane());
	}
	
	public static void main(String[] args)
	{
		JCardLayout2 jbl = new JCardLayout2();
		jbl.setSize(250, 250);
		jbl.setVisible(true);
	}
}
