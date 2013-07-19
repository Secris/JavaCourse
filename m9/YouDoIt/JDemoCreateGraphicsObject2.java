import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class JDemoCreateGraphicsObject2 extends JFrame implements ActionListener
{
	String movieQuote = new String("Here's Looking at you, kid");
	JButton moveButton = new JButton("Move It");
	Font broadwayFont = new Font("Broadway", Font.ITALIC, 12);
	int x = 10, y = 50;
	final int GAP = 20;
	final int SIZE = 400;
	final int LIMIT = SIZE - 50;
	
	public JDemoCreateGraphicsObject2()
	{
		Container con = getContentPane();
		con.setBackground(Color.YELLOW);
		con.setLayout(new FlowLayout());
		con.add(moveButton);
		moveButton.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(SIZE, SIZE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Graphics pen = getGraphics();
		pen.setFont(broadwayFont);
		pen.setColor(Color.MAGENTA);
		
		if(y < LIMIT)
			pen.drawString(movieQuote, x += GAP, y += GAP);
		else
			moveButton.setEnabled(false);
	}
	
	public static void main(String[] args)
	{
		JDemoCreateGraphicsObject2 frame = new JDemoCreateGraphicsObject2();
		frame.setVisible(true);
	}
}
