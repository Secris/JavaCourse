/**
 * Programmer:			Sean Thames
 * Date:				2013-07-11
 * Filename:			MineField2.java
 * Assignment:			Ch 15 Ex 12
 *
 * Description:         A) Create a Mine Field game in which the user attempts
 * to click [2]0 panels of a grid before hitting the "bomb." Set up a JFrame 
 * using BorderLayout, use the NORTH region for a congratulatory message, and
 * use the CENTER region for the game. In the CENTER region, create a 
 * four-by-five grid using GridLayout and populate the grid with JPanels. Set 
 * the background color for all the JPanels to Color.BLUE. Randomly choose one 
 * of the panels to be the bomb; the other 19 panels are "safe." Allow the 
 * player to click on grids. If the player chooses a safe-panel, turn the panel 
 * to Color.WHITE. If the player chooses the bomb panel, turn the panel to 
 * Color.RED and turn all remaining panels white. If the user successfully 
 * chooses 10 safe panels before choosing the bomb, display a congratulatory
 * message in the NORTH JFrame region. Save the game as MineField.java.
 * 
 * B) Improve the Mine Field game by allowing the user to choose a difficulty
 * level before beginning. Place three buttons labeled "Easy", "Intermediate", 
 * and "Difficult" in one region of the JFrame, and place the game grid and 
 * congratulatory message in the other regions. Require the user to select a 
 * difficulty level before starting the game, then disable the buttons. If the 
 * user chooses "Easy", the user must select only five safe panels to win the 
 * game. If the user selects "Intermediate", require 10 safe panels, as in the 
 * original game. If the user selects "Difficult", require 15 safe panels. Save
 * the game as MineField2.java
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.Random;

public class MineField2 extends JFrame implements ActionListener
{
	private Random random = new Random();
	private final int NUMBER_OF_TILES = 20;
	
	private int numberOfTurns = 99;
	
	private int timesSafe = 0;
	private int bombLocation = 0;
	
	private final int WIDTH = 650;
	private final int HEIGHT = 450;
	
	private BorderLayout mainLayout = new BorderLayout();
	private GridLayout gameLayout = new GridLayout(4, 5, 3, 3);
	private CardLayout cards = new CardLayout();
	
	private Container difficultyContainer = new Container();
	private Container gameContainer = new Container();
	
	private JLabel title = new JLabel("Please select a difficulty", JLabel.CENTER);
	private JPanel[] bombPanels = new JPanel[NUMBER_OF_TILES];
	private JButton[] bombButtons = new JButton[NUMBER_OF_TILES];
	
	private final String BOMB = "<html><font face=\"monospace\">&nbsp&nbsp;,-*<br>&nbsp;(_) BOOM!</font></html>";
	private JLabel bomb = new JLabel(BOMB);
	
	private JButton easy = new JButton("Easy");
	private JButton medium = new JButton("Intermediate");
	private JButton hard = new JButton("Difficult");
	
	private boolean gameState = true;
	
	public MineField2()
	{
		super("MineField");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameContainer.setLayout(gameLayout);
		
		bombLocation = random.nextInt(NUMBER_OF_TILES);
		
		add(title, BorderLayout.NORTH);
		
		add(difficultyContainer, BorderLayout.WEST);
		difficultyContainer.setLayout(new BoxLayout(difficultyContainer, BoxLayout.PAGE_AXIS));
		difficultyContainer.add(easy);
		difficultyContainer.add(medium);
		difficultyContainer.add(hard);
		easy.addActionListener(this);
		medium.addActionListener(this);
		hard.addActionListener(this);
		
		add(gameContainer, BorderLayout.CENTER);
		drawGameGrid();
		// placeBomb(bombLocation); // Uncomment this if you want to know where it is
		
		toggleGame();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JButton source = (JButton)e.getSource();
		
		if(source == easy || source == medium || source == hard)
		{
			if(source == easy)
				setDifficulty(1);
			else if(source == medium)
				setDifficulty(2);
			else if(source == hard)
				setDifficulty(3);
		}
		else
		{
			timesSafe += 1;
			if(source == bombButtons[bombLocation])
				goBoom(source);
			else
				fizzle(source);
		
			if(timesSafe >= numberOfTurns)
				victory();
		}
	}
	
	private void drawGameGrid()
	{
		for(int i = 0; i < NUMBER_OF_TILES; i++)
		{
			bombPanels[i] = new JPanel(cards);
			bombButtons[i] = new JButton("Click me!");
			bombButtons[i].setBackground(null);
			bombPanels[i].add("card" + i, bombButtons[i]);
			bombPanels[i].setBackground(Color.BLUE);
			gameContainer.add(bombPanels[i]);
			bombButtons[i].addActionListener(this);
		}
	}
	
	private void placeBomb(int bl)
	{
		System.out.println("Location: " + bl);
	}
	private void goBoom(JButton b)
	{
		Container con = b.getParent();
		for(JButton a : bombButtons)
			fizzle(a);
		
		title.setText("Uh oh!");
		con.removeAll();
		con.add(bomb);
		con.setBackground(Color.RED);
		revalidate();
	}
	private void fizzle(JButton b)
	{
		Container con = b.getParent();
		con.setBackground(Color.WHITE);
		b.removeActionListener(this);
		b.setText("");
		b.setEnabled(false);
		
		revalidate();
	}
	private void victory()
	{
		for(JButton a : bombButtons)
			fizzle(a);
			
		title.setText("Congratulations!");
		
		revalidate();
	}
	private void toggleGame()
	{
		if(gameState)
			gameState = false;
		else
			gameState = true;
			
		for(JButton a : bombButtons)
			a.setEnabled(gameState);
	}
	private void disableDifficulty()
	{
		easy.setEnabled(false);
		medium.setEnabled(false);
		hard.setEnabled(false);
	}
	private void setDifficulty(int d)
	{
		switch(d)
		{
			case 1:
				numberOfTurns = 5;
				toggleGame();
				disableDifficulty();
				break;
			case 2:
				numberOfTurns = 10;
				toggleGame();
				disableDifficulty();
				break;
			case 3:
				numberOfTurns = 15;
				toggleGame();
				disableDifficulty();
				break;
			default:
				break;
		}
	}
	public static void main(String[] args)
	{
		MineField2 game = new MineField2();
		game.setVisible(true);
	}
}
