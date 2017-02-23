//Maria Bocanegra
//CIS 163AA
//MEID: MAR2180691
//Final Project

import java.lang.*;

public class Die
{
	
		
		
		private static final int HIGHEST_DIE_VALUE = 6;
		private static final int LOWEST_DIE_VALUE = 1;
		int roll = ((int)(Math.random() * 100) % HIGHEST_DIE_VALUE + LOWEST_DIE_VALUE);
		
		//private int diceRoll = 0;
		

		
		
		public int getDiceRoll()
		{
			
			return roll;
			
		}
		
		public void display(int rollNumber)
		{
			
			
			
			System.out.println("Roll #" + rollNumber + ": You rolled a(n) " + roll);
			
		
		}
	
		
	
	
	
	
}