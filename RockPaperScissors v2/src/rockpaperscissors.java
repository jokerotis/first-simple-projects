import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class rockpaperscissors {

	public static void main(String[] args) {
		System.out.println("Welcome to rock paper scissors, first to 3 points.");
		
		Scanner scanner = new Scanner(System.in);
		int computerPoints = 0;
		int userPoints =0;
		
		for(int i = 0; true; i++) {
			
			//userInput then assigns input a value
			System.out.println("Rock, paper scissors?");
			String userInput = scanner.nextLine();
			int userValue = ValueSetter.setValue(userInput.toLowerCase());
			
			if(userValue == -1) {
				System.out.println("Invalid input, try again.");
				
			}	 else {
			// assigns computer a value, then gives it a corresponding name
			int computerValue = ThreadLocalRandom.current().nextInt(1, 3 + 1);
			String computerName = ValueSetter.getValue(computerValue);
			System.out.println("Computer went "+computerName + ".");
			
			// is draw
			if(computerValue == userValue) System.out.println("Draw, new round");
			
			// has computer won?
			else if ((computerValue == 1 && userValue == 3)
					|| computerValue == 2 && userValue == 1
					|| computerValue == 3 && userValue == 2) {
				computerPoints++;
				
				if(computerPoints == 3) {
					System.out.println("Computer wins game.");
					return;
					
				} else {
				System.out.println("Computer wins, new round.");
				}
			}
			// assume user won
			else {
				userPoints++;
				if(userPoints == 3) {
					System.out.println("Player wins game.");
					return;
					
				}
				System.out.println("Player wins, new round.");
			}
			System.out.println("Player: " + userPoints + " Computer: " + computerPoints);
			}
		}
	}
}
