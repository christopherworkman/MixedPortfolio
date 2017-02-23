//Maria Bocanegra
//CIS 163AA
//MEID: MAR2180691
//Final Project

import java.util.*;
public class FiveDice
{
	
	public static void main(String[] args)
	{
		
	    int[] computerDieList = new int[5];
		int[] humanDieList = new int[5];
		
		int rollNumber, userEntry;
		int pairs = 0;
		int prevItem = computerDieList[0];
		int mostFreqCountC = 0, mostFreqCountH = 0;
		String winner;
		
	
			for(rollNumber = 0; rollNumber < 5; ++rollNumber)
			{
			
				Scanner input = new Scanner(System.in);
				System.out.print("\nEnter [1] to roll a die or [0] to forfeit the game. >> ");
				userEntry = input.nextInt();
		
				if(userEntry == 1)
				{
					Die computerDieRoll = new Die();
					System.out.print("Computer ");
					computerDieList[rollNumber] = computerDieRoll.getDiceRoll();
					computerDieRoll.display(rollNumber + 1);
				
					Die humanDieRoll = new Die();
					humanDieList[rollNumber] =  humanDieRoll.getDiceRoll();
					System.out.print("Your ");
					humanDieRoll.display(rollNumber + 1);
				}//closes if [1]
				
				if(userEntry == 0)
				{
					System.out.println("\nYou have chosen to forfeit. \nThe computer wins!");
					System.exit(0);
				}			
			
			}//closes for loop
	
		
	  	System.out.print("\nComputer rolls: ");
	  	for(int j = 0; j < computerDieList.length; ++j)
	  		System.out.print(computerDieList[j] + " ");

		mostFreqCountC = mostOccuring(computerDieList);
		System.out.println("\nThe computer rolled " + mostFreqCountC + " of a kind.");
		
		System.out.print("\nYour rolls: ");
		for(int k = 0; k < humanDieList.length; ++k)
			System.out.print(humanDieList[k] + " ");
		
		mostFreqCountH = mostOccuring(humanDieList);
		System.out.println("\nYou rolled " + mostFreqCountH + " of a kind.");
		
		if(mostFreqCountC == mostFreqCountH)
			winner = "\nThere is no winner. You tied with the computer.";
		else
			winner = mostFreqCountC > mostFreqCountH ? "\nThe Computer wins!" : "\nCongratulations! You won!";
				
		System.out.println(winner);


	}//closes main
	
	public static int mostOccuring(int[] theDieList) {

	    Arrays.sort(theDieList);

	    int previous = theDieList[0];
	    int mostFreq = theDieList[0];
	    int count = 1;
	    int mostFreqCount = 1;

	    for (int i = 1; i < 5; i++) {
	        if (theDieList[i] == previous)
	            count++;
	        else {
	            if (count > mostFreqCount) {
	                mostFreq = theDieList[i-1];
	                mostFreqCount = count;
	            }
	            previous = theDieList[i];
	            count = 1;
	        }
	    }
		
		return mostFreqCount > count ? mostFreqCount : count;
		//fixes issue of most occuring int not being counted if it is the last number
		
	}//closes mostOccuring
	
}//closes class