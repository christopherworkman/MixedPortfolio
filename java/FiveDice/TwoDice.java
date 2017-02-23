//Maria Bocanegra
//CIS 163AA
//MEID: MAR2180691
//Final Project

import java.util.*;
public class TwoDice
{
	
	public static void main(String[] args)
	{
		
		Die firstDie = new Die();
		Die secondDie = new Die();
		int userEntry;
		int rollNumber = 1;
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter [1] to roll a die. >> ");
		userEntry = input.nextInt();
		
		
		if(userEntry == 1)
		{
			
			firstDie.display(rollNumber);
			rollNumber++;		

			System.out.print("Enter [1] to roll a second die. >> ");
			
			userEntry = input.nextInt();			
			secondDie.display(rollNumber);	
			
		}//closes if
	
		
	}//closes main
	
}//closes class