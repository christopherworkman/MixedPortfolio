//Maria Bocanegra
//CIS 163AA


import java.util.*;

public class RandomGuess3
{
	public static void main(String[] args)
	{
		int userNumber = 0;
		int randomNumber = 0;
		int playAgain = 0;
		Scanner input = new Scanner(System.in);
		boolean againBool = true;
		
		
		
		
		game(userNumber, randomNumber);
	
	
		
		
		while(againBool == true)
		{
			System.out.print("Would you like to play again? Enter [1] for yes, or [0] to exit. >> ");
			playAgain = input.nextInt();
			
			if(playAgain == 1)
					game(userNumber, randomNumber);
				
				else
				{
					System.out.println("Thank you for playing the Guessing Game.");
					againBool = false;
				}//closes else
		}//closes while loop
	
	}//closes main



	public static void game(int userNumber, int randomNumber)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please guess a number between 1 - 1000. >> ");
		userNumber = input.nextInt();
		randomNumber = (1 + (int)(Math.random() * 1000));
		
		System.out.println("Your guess: " + userNumber);
		//System.out.println("The computer's chosen number was " + randomNumber);
		
		
		for(int x = 1; x < 1000; ++x)
			{
				if(userNumber == randomNumber)
				{
					System.out.println("Congratulations! You guessed the right number on try # " + x);
					break;
				}
			
				else
					if(userNumber > randomNumber)
						{
							System.out.print("You guessed too high! \nPlease try again. >> ");
							userNumber = input.nextInt();
						}
					else
						if(userNumber < randomNumber)
							{
								System.out.print("You guessed too low! \nPlease try again >> ");
								userNumber = input.nextInt();
							}
			
			}//closes for loop
		
		
	}//closes game



}