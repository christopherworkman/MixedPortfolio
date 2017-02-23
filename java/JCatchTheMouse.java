// Filename JCatchTheMouse.java
// Written by Maria Bocanegra
// Written on April 12, 2016
// Final - CH 15, Game Zone
// Exercise Number 2, pg. 872
// CIS 263AA
// Class # 22892

//use 48 buttons
//Grid layout - 8 rows, 6 columns

//one of the buttons randomly displays an "x"
//user must click on x
//after clicking 10 x's--display name, course, sect #, MEID w/ JOptionMessage
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;


public class JCatchTheMouse extends JFrame implements ActionListener
{
	
	private JButton[] buttons = new JButton[48];
	private JLabel instruct = new JLabel("<html>Click the X!<br> Click 10 X's to win the game!!<br></html>");
	private JPanel buttonHolder = new JPanel();
	private JLabel wrong = new JLabel("You missed the X. The count will re-start!");
	ArrayList<Integer> xButtonList = new ArrayList<Integer>();
	
	

	int x, y, p, count, boxWithX;

	
	public JCatchTheMouse()
	{
		
		setTitle("Catch the Mouse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		add(instruct);
		add(buttonHolder);
		add(wrong);
		wrong.setVisible(false);

		
		layoutComponents();
		makeButtons();
		randomX();
		
	}
	

	
	public void layoutComponents()
	{
		buttonHolder.setLayout(new GridLayout(8,6));
		
	}	//closes layoutComponents
	
	public void makeButtons()
	{
		
		for(x=0; x <48; x++)
		{
			
			buttons[x] = new JButton("");
			buttonHolder.add(buttons[x]);
			buttons[x].addActionListener(this);
		}
	}//coses makeButtons
	
	public void randomX()
	{
		Random rand = new Random();
		
			boxWithX = rand.nextInt(48-1) + 1;
			
			if(!xButtonList.contains(boxWithX))
			{
				buttons[boxWithX].setText("X");	
				xButtonList.add(boxWithX);
			}
			else
			{
				boxWithX = boxWithX + 1;
				buttons[boxWithX].setText("X");	
				xButtonList.add(boxWithX);
			} 		

	} //closes randomX
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		Container con = getContentPane();
		
		if(source==buttons[boxWithX])
		{
			count++;
			wrong.setVisible(false);
				
			if(count % 10 == 0)
				{
				JOptionPane.showMessageDialog(null, "<html>Written By: Maria Bocanegra<br>Course: CIS 263<br>Section #22892<br>MEID: 34967029<br><br> <i>Thanks for playing!</i></html>");
				System.exit(0);
				}		
			// System.out.println("Click total: " + count); //will only count to 9--will shut down before printing #10.
			buttons[boxWithX].setText("");
			randomX();
			repaint();	
			
		}
		
		else //if source is blank button (no X)
		{
			wrong.setVisible(true);
			count = 0;
			buttons[boxWithX].setText("");
			randomX();
			repaint();
			
		}
		
		// if(count == 48)
// 		{
// 			JOptionPane.showMessageDialog(null, "Thank you for playing! Come back again soon!");
// 			System.exit(0);
// 		}
			
	}
	
	public static void main(String[] args)
	{
		JCatchTheMouse frame = new JCatchTheMouse();
		final int WIDTH = 500;
		final int HEIGHT = 400;
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
	}
	
}