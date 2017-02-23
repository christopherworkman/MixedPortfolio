// Filename JLottery2.java
// Written by Maria Bocanegra
// Written on April 5, 2016
// Final - CH 14, Game Zone
// Exercise Number 2, pg. 799
// CIS 263AA
// Class # 22892

//generates 6 numbers between 0-30
//user chooses up to 6 boxes (not more) -- each is one number
//each number = 1 box
//winnings criteria:
//3 matches $100
//4 matches $10,000
//5 matches $50k
//6 matches $1,000,000
//0,1,2 matches $0


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class JLottery2 extends JFrame implements ActionListener, ItemListener, MenuListener
{
	private JMenuBar mainBar = new JMenuBar();
	private JMenu m1 = new JMenu("File");
	private JMenu m2 = new JMenu("Game Rules");
	
	private JMenuItem exit = new JMenuItem("Exit");
	
	private JMenuItem about = new JMenuItem("About");

	private JPanel lotteryBoxes = new JPanel();
	
	private int[] numArray = new int [30];
	
	private String[] stringNumArray = new String [30];
	
	private JCheckBox[] cb = new JCheckBox[30];
	
	private JLabel inst = new JLabel("<html>Select six numbers.<br>Click the button below to reveal your prize!</html>");
	
	private JButton go = new JButton("Did I win?!");
	
	private int[] winners = new int[6]; //to be filled with 6 randomly selected winning numbers
	
	ArrayList<Integer> winnersList = new ArrayList<Integer>();
	
	ArrayList<Integer> selected= new ArrayList<Integer>();
	
	private JLabel winningNumbers = new JLabel("");

	ArrayList<Integer> matchedList = new ArrayList<Integer>(); 
	
	private JLabel matchedLabel = new JLabel("Number of matches: ");
	
	private JTextField matchedTF = new JTextField(1);
	
	private JLabel winningsLabel = new JLabel("");
	
	private JLabel congratsLabel = new JLabel("<html><b>Congratulations!!!!!</b><html>");
	
	int i, n, checkCount = 0, matchCount =0;
	boolean tooMany;
	
	final int MAX = 6;
	
	public JLottery2()
	{
		setTitle("Lottery Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		composeMenus();
		addActionListener();
		layoutComponents();
		makeArrays();
		winningNumbers();
		add(inst);
		add(lotteryBoxes);
		add(go);
		
		add(winningNumbers);
		winningNumbers.setVisible(false);
		
		
		add(matchedLabel);
		matchedLabel.setVisible(false);
		add(matchedTF);
		matchedTF.setVisible(false);
		add(congratsLabel);
		congratsLabel.setVisible(false);
		add(winningsLabel);
		winningsLabel.setVisible(false);
		go.setEnabled(false);
		go.setToolTipText("Click when you're feeling lucky!");

	}
	
	public void composeMenus()
	{
		setJMenuBar(mainBar);
		mainBar.add(m1);
		mainBar.add(m2);
		m1.add(exit);
		m1.add(about);
		m2.addMenuListener(this);
	}
	
	public void addActionListener()
	{
		exit.addActionListener(this);
		about.addActionListener(this);
		go.addActionListener(this);
		
	}
	
	public void layoutComponents()
	{
		lotteryBoxes.setLayout(new GridLayout(5,7));
		
	}	

	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		Container con = getContentPane();
		
		if(source == exit)
			System.exit(0);
		
		if(source== about)
			JOptionPane.showMessageDialog(null, "<html>Written By: Maria Bocanegra<br>Course: CIS 263<br>Section #22892<br>MEID: 34967029</html>");
		
		if(source == go)
		{
			// System.out.println("selected: "+ selected);
			//testing for acceptance of selected # input
			go.setVisible(false);
			for(int p =0; p <cb.length; p++)
			{
				cb[p].setEnabled(false);
				
			}
			
			matches();
		}
				

	}
	
	public void matches()
	{
		for(n = 0; n < selected.size(); n++)
		{

			// if(matching && !matchedList.contains(selected.get(n)))
			if(winnersList.contains(selected.get(n)))	
			{
				matchedList.add(selected.get(n));
				matchCount++;
			}
		}
		//testing matches:
		// System.out.println("Matches: " + matchCount);
		// System.out.println("Matched List: " + Arrays.toString(matchedList.toArray()));
		winningNumbers.setVisible(true);
		winningNumbers.setText("Winning Numbers: " + Arrays.toString(winnersList.toArray()));
		
		
		matchedLabel.setVisible(true);
		matchedTF.setText(Integer.toString(matchCount));
		matchedTF.setVisible(true);
		winningsLabel.setVisible(true);
		
		switch(matchCount)
		{
			case(0):
			case(1):
			case(2):
			{
				winningsLabel.setText("Sorry. You are not a winner.");
				break;
			}
			
			case(3):
			{
				congratsLabel.setVisible(true);
				winningsLabel.setText("You win $100");
				break;
			}
			
			case(4):
			{
				congratsLabel.setVisible(true);
				winningsLabel.setText("You win $10,000");
				break;
			}
			
			case(5):
			{
				congratsLabel.setVisible(true);
				winningsLabel.setText("You win $50,000");
				break;
			}
			
			case(6):
			{
				congratsLabel.setVisible(true);
				winningsLabel.setText("You win $1,000,000");
				break;
			}	
			
			default:
			break;
			
		}//closes switch case
			
	}//closes matches method
	
	public void menuSelected(MenuEvent e)
	{
		Object source = e.getSource();
		Container con = getContentPane();
		if(source== m2)
			JOptionPane.showMessageDialog(null, "<html>You may ONLY select 6 numbers.<br><b>Winnings Criteria:</b><br>3 matches: $100<br>4 matches: $10,000<br>5 matches: $50,000<br>6 matches: $1,000,000<br><b>0,1,2 matches: You lose!</b></html>");			
	}
	
	public void menuCanceled(MenuEvent e) 
	{
	        
	}
		
	public void menuDeselected(MenuEvent e) 
	{
	        
	}
	
	public void itemStateChanged(ItemEvent e)
	{ 
		JCheckBox box = (JCheckBox) e.getSource();
		
		int parsedNum = Integer.parseInt(box.getText()); //number value instead of string
		
		if(box.isSelected())
		{
			
			++checkCount;
			if(selected.contains(parsedNum) == false)
				selected.add(parsedNum);
		}
		
		if(!box.isSelected())
		{
			--checkCount;
			for(int k = 0; k < selected.size(); k++)
			{
				if(selected.get(k) == parsedNum)
					selected.remove(k);
				
			}
		}
	
			if(checkCount != MAX)
				{
					if(checkCount > MAX)
						JOptionPane.showMessageDialog(null, "You may only select six numbers.");					
					go.setEnabled(false);

				}
			

		while(checkCount == MAX)
		{
			go.setEnabled(true);
			if(checkCount > MAX || checkCount < MAX)
				go.setEnabled(false);
			break;
		}	
		// System.out.print(checkCount); 
		///use for checkCount reading verification	
	} 
	
	
	public void winningNumbers()
	{
		Random rand = new Random();
		
		for(int x=0; x < 6; x++)
		{
			int winningNum = rand.nextInt(30-1) + 1;
			
			if(!winnersList.contains(winningNum))
				winnersList.add(winningNum);
			else
				x--;
		}
		
		// System.out.println("Winning Numbers: " + Arrays.toString(winnersList.toArray())); 
		//to make sure winning numbers are working	
	}
	
	public void makeArrays()
	{
		//making array of ints from 1-30
		for(i=0; i<30; i++)
		{
			numArray[i] = i + 1;
			stringNumArray[i] = Integer.toString(numArray[i]);
		}	
		
		for(int j=0; j<30; j++)
		{
			cb[j] = new JCheckBox(stringNumArray[j]);
			lotteryBoxes.add(cb[j]);
			cb[j].addItemListener(this);

		}
		
	}

	public static void main(String[] args)
	{
		JLottery2 frame = new JLottery2();
		final int WIDTH = 340;
		final int HEIGHT = 300;
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
	}

}