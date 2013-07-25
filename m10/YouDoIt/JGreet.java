import javax.swing.*;
import java.awt.*;

public class JGreet extends JApplet
{
	Container con = getContentPane();
	JLabel greeting = new JLabel("Greetings!");
	
	public void init()
	{
		con.add(greeting);
	}
}
