/**
 * Programmer:			Sean Thames
 * Date:				2013-07-11
 * Filename:			MineField.java
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

public class MineField extends JFrame implements ActionListener
{
	private final int SIZE_OF_PLAY_AREA = 20;
	
	private int timesSafe = 0;
		
	public MineField() {};
	
	public void actionPerformed() {};
	
	private void drawBombGrid() {}; 
	
	public static void main(String[] args) {};
}
