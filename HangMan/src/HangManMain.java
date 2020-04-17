import java.util.ArrayList;
import java.util.Scanner;

public class HangManMain {

	public static void main(String[] args) {
		
		
		System.out.println("Welcome to hangman");
		System.out.println("For two players");
		
		
		// Gets word  from player 1
		System.out.println("Player 1 input your word");
		Scanner scanner = new Scanner(System.in);
		String wordinput = scanner.nextLine();
		String word = wordinput.toLowerCase();
		
		// divides word into individual letters
		ArrayList<String> letters = new ArrayList<String>();
		int i;
		i = 0;
		do {
			 
			//sets letter at value i to char x
			char x = word.charAt(i);
			// turns char to string
			String letter = Character.toString(x);
			// adds the new letter to list as a new 
			 letters.add(letter);
			 
			// while i is smaller then the word length
			 i++;
		} while (i < word.length());
		
		/*
		 *  this here puts console 10 lines down, so player 2 can't see
		 *  any inputs 
		 */
		for(int k= 0;k < 10;k++){
			System.out.println("");
		}
		int numofguess = word.length() + 4 ;
		// this here makes a  list filled with -- to the length of the word
		ArrayList<String> correctletters = new ArrayList<String>();
		int y = 0;
		do {
			correctletters.add("-");
			y++;
		} while ( y < word.length());
		System.out.println(correctletters);
		// gets guess 
		
		do {
		System.out.println("Player 2, guess you have " + numofguess + " goes");
		String guessinput = scanner.nextLine();
		String guess = guessinput.toLowerCase();
		// sees if guess matches word when guess is not a char
		if ( guess.length() > 1 ) {
			if (guess.equals(word)) {
				System.out.println("Player 2 won");
				return;
			}
			// if doesn't match takes a guess away 
			else {
				numofguess--;
				System.out.println("incorrect guess again you have " + numofguess + " goes remaining");
			}
			
			
		}
		else {
			int j = 0;
			// sees if guess matches any of the letters
			do {
				if (letters.get(j).equals(guess)) {
					
					//if it does add the correct letter to the corresponding
					// position 
					correctletters.set(j, guess);
					numofguess++;
					
				}
		
				j++;
	
			} while(j < word.length());
			System.out.println(correctletters);
			// when there is no - left you must have won
			if(correctletters.contains("-")) {
				numofguess--;
			} else {
				System.out.println("Player 2 wins");
				return;
			}
		}
		} while( numofguess != 0);
		// if you're out of guesses you lose
		System.out.println("Player 2 loses!");
		return;
		
		}
	}


