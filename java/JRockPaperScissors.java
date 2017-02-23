// Filename JRockPaperScissors.java
// Written by Maria Bocanegra
// Written on April 12, 2016
// Final - CH 17, Game Zone
// Exercise Number 2, pg. 989
// CIS 263AA
// Class # 22892

//Rock Paper, scissors JApplet

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
// import java.util.ArrayList;
// import java.util.Arrays;

public class JRockPaperScissors extends JApplet implements ActionListener
{
	int computerChoice, userWinCount=0, computerWinCount=0, gamesTied=0;
   
   String userChoiceStr="", computerChoiceStr="", winnerStr ="";
   
   private JLabel heading = new JLabel("<html><h1>Rock, Paper Scissors...Shoot!</html>");
	private JLabel directions = new JLabel("Weapon of choice:");
   
   private JButton rockB = new JButton("Rock");
	private JButton paperB = new JButton("Paper");
	private JButton scissorsB = new JButton("Scissors");

   private JPanel resultsPanel = new JPanel();
	private JLabel results = new JLabel("<html><h2><i>Results</html>");
   

   
	private JLabel winnerLabel = new JLabel("Winner: ");   
	
	Container con = getContentPane();	
	
	public void init()
	{
		con.setLayout(new FlowLayout());
		con.add(heading);
      con.add(directions);
      
		
      con.add(rockB);
		rockB.addActionListener(this);
		
		con.add(paperB);
		paperB.addActionListener(this);
		
		con.add(scissorsB);
		scissorsB.addActionListener(this);
		

		
		
	}
	
	public void compRandom()
	{
		Random rand = new Random();
		computerChoice = rand.nextInt(3) + 1;
         //computer choice 1 = rock, 2 = paper, 3 = scissors
         
       switch(computerChoice)
       {
         case 1:
            computerChoiceStr = "Rock";
            break;
         case 2:
            computerChoiceStr = "Paper";
            break;
            
         case 3: 
            computerChoiceStr = "Scissors";
            break;
          } 
          
       repaint();   
	}
	public void actionPerformed(ActionEvent e)
	{
		compRandom();	
      Object source = e.getSource();
		Container con = getContentPane();
      if(source == rockB)
      {
         userChoiceStr = "Rock";
         if(computerChoice == 1)
            {
            gamesTied++;
            winnerStr = "Null";
            }
         else if(computerChoice == 2)
            {
            computerWinCount++;
            winnerStr = "Computer";
            }  
         else
            {
            userWinCount++;
            winnerStr = "You";
            }
      }
      
      else if(source == paperB)
      {
         
         userChoiceStr = "Paper";
         if(computerChoice == 1)
            {
            userWinCount++;
            winnerStr = "You";
            }
         
         else if(computerChoice == 2)
            {
            gamesTied++;
            winnerStr = "Null";
            }
 
         else
            {
            computerWinCount++;
            winnerStr = "Computer";
            }                 
      }
      else
      {
         userChoiceStr = "Scissors";
         if(computerChoice == 1)
            {
            computerWinCount++;
            winnerStr = "Computer";
            }   
         
         else if(computerChoice == 2)
            {
            userWinCount++;
            winnerStr = "You";
            }
 
         else
            gamesTied++;   
      }
      
      repaint();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		Font statsFont = new Font("Arial", Font.PLAIN, 15);
      g.setFont(statsFont);
      
      g.drawString("Computer chose: "+computerChoiceStr, 20, 160);
      g.drawString("You chose: "+userChoiceStr, 20, 180);
      
      Font winFont = new Font("Arial", Font.BOLD, 25);
      g.setFont(winFont);
      g.drawString("Winner:", 250, 160);
      g.drawString(winnerStr, 250, 190);


      g.setFont(statsFont);
      g.drawString("User wins: "+Integer.toString(userWinCount), 20, 240);
      g.drawString("Tied games: "+Integer.toString(gamesTied), 20, 260);
      g.drawString("Computer wins: "+Integer.toString(computerWinCount), 20, 280);
		
		Font extraInfoFont = new Font("Times New Roman", Font.PLAIN,10);
      g.setFont(extraInfoFont);
      g.drawString("Written By: Maria Bocanegra", 5,330);
		g.drawString("Course: CIS 263", 5,340);
      g.drawString("Section #22892", 5,370);
      g.drawString("MEID: 34967029", 5,390);
      
      
      
		validate();
		
	}
	
	
}