package sixthOctober;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
public class RockPaperScissor {
	public static void main(String [] args) {
		
		Scanner input = new Scanner(System.in);
		
		String [] choices = {"rock", "paper", "scissor"};
		
		
		String computerChoice = randomChoice(choices);
		System.out.println(computerChoice);
		
		System.out.println("Choose your weapon(Rock, Paper,Scissor): ");
		String userChoice = input.nextLine().toLowerCase();
		game(computerChoice, userChoice);
	}

	private static void game(String computerChoice, String userChoice) {
		if(computerChoice == "rock") {
			if(userChoice == "scissor") {
				System.out.println("You lose!");
			}
			if(userChoice == "paper") {
				System.out.println("You won!");
			}
		}
		if(computerChoice == "paper") {
			if(userChoice == "rock") {
				System.out.println("You lose!");
			}
			if(userChoice == "scissor") {
				System.out.println("You won!");
			}
		}
		if(computerChoice == "scissor") {
			if(userChoice == "paper") {
				System.out.println("You lose!");
			}
			if(userChoice== "rock") {
				System.out.println("You won!");
			}
		}
		if(computerChoice == userChoice) {
			System.out.println("Its a draw!");
		}
	}
	private static String randomChoice(String[] choices) {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 2 + 1);
		return choices[randomNum].toString();
	}
}
