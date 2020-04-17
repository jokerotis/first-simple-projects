import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class rockpaperscissors {

	public static void main(String[] args) {
		// user input
		System.out.println("Rock, paper scissors?");
		
		Scanner userinput = new Scanner(System.in);
		String userin = userinput.nextLine();
		

		
		// assigns a value to the user input
		int uservalue;
		
		switch (userin.toLowerCase()) {
			case "rock":
				 uservalue = 1;
				 
				break;
			case "paper":
				uservalue = 0;
				
				break;
			case "scissors":
				uservalue = -1;
				
				break;
			default:
				System.out.println("try using rock paper or scissors");
				return;
		} 
		
		// assigns a value for the computer
		int randomNum = ThreadLocalRandom.current().nextInt(-1, 1 + 1);
		
		int computervalue = randomNum; 
		switch(computervalue) {
			case 1:
				System.out.println("Computer went rock");
				break;
			case 0:
				System.out.println("Computer went paper");
				break;
			case -1:
				System.out.println("Computer went scissors");
				break;
			default:
				System.out.println("your code is bad try again");
				return;
		}
		
			// checks against the computers guess to see if draw.
			if (uservalue == computervalue) {
				System.out.println("draw");
			
				return;	
				}
			// if its not a draw it see if you lost
			
			if ((uservalue == 1 && computervalue == 0) 
					|| uservalue == 0 && computervalue == -1 
					|| uservalue == -1 && computervalue == 1) {
				System.out.println("You lose!");
			}
			
			// if you didnt lose you won!
			else {
				System.out.println("You win");
				return;
			}
				
		
		
		
	}

}
