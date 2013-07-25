import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JLifeCycle extends JApplet implements ActionListener
{
	JLabel messageInit = new JLabel("init");
	JLabel messageStart = new JLabel("start");
	JLabel messageDisplay = new JLabel("display");
	JLabel messageAction = new JLabel("action");
	JLabel messageStop = new JLabel("stop");
	JLabel messageDestroy = new JLabel("destroy");
	
	JButton pressButton = new JButton("Press");
	
	int countInit, countStart, countDisplay, countAction, countStop, countDestroy;
	
	public void init()
	{
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		
		++countInit;
		con.add(messageInit);
		con.add(messageStart);
		con.add(messageDisplay);
		con.add(messageAction);
		con.add(messageStop);
		con.add(messageDestroy);
		con.add(pressButton);
		pressButton.addActionListener(this);
		display();
	}
	
	public void start()
	{
		++countStart;
		display();
	}
	
	public void display()
	{
		++countDisplay;
		messageInit.setText("init " + countInit);
		messageStart.setText("start " + countStart);
		messageDisplay.setText("display " + countDisplay);
		messageAction.setText("action " + countAction);
		messageStop.setText("stop " + countStop);
		messageDestroy.setText("destroy " + countDestroy);
	}
	
	public void stop()
	{
		++countStop;
		display();
	}
	
	public void destroy()
	{
		++countDestroy;
		display();
	};
	
	public void actionPerformed(ActionEvent ae)
	{
		++countAction;
		display();
	}
}