
/*
 * 1. Generate a random number within a specified range, such as 1 to 100.
 * 2. Prompt the user to enter their guess for the generated number.
 * 3. Compare the user's guess with the generated number and provide feedback on whether the guess is correct, too high, or too low.
 * 4. Repeat steps 2 and 3 until the user guesses the correct number.
 * 5. Limit the number of attempts the user has to guess the number.
 * 6. Add the option for multiple rounds, allowing the user to play again.
 * 7. Display the user's score, which can be based on the number of attempts taken or rounds won.
 */
import java.util.Random;
import java.util.Scanner;

public class Random_Number {
	public static void main(String[] args) {
		System.out.println("********************************************************************");
		System.out.println("             Pick a number, any number...);                ");
		System.out.println("********************************************************************");
		System.out.println();

		Random random = new Random(); // Generate a random number between 0 and 100
		int lowerNumber = 1;
		int upperNumber = 100;
		int maxAttempts = 5;
		int rounds = 0;
		int wins = 0;
		boolean playAgain = true;

		while (playAgain) {
			Scanner sc = new Scanner(System.in);
			System.out.println("========== Round " + (rounds + 1) + " ==========\n");
			int numberToGuess = random.nextInt(upperNumber - lowerNumber + 1) + lowerNumber;
			int attempts = 0;
			boolean roundWon = false;

			while (attempts < maxAttempts) {
				System.out.print("Guess the number between " + lowerNumber + " and " + upperNumber + " : ");
				int userGuess = sc.nextInt();
				attempts++;

				if (userGuess < numberToGuess) {
					System.out.println(" Too low! Try again.");
				} else if (userGuess > numberToGuess) {
					System.out.println("Too high! Try again.");
				} else {
					System.out.println("Congratulations..!! You guessed the number " + numberToGuess + " in " + attempts
							+ " attempts.");
					roundWon = true;
					wins++;
					break;
				}
			}
			if (!roundWon) {
				System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was "
						+ numberToGuess + ".");
			}
			rounds++;

			System.out.println("Do you want to play again? (y/n):");
			String playAgainInput = sc.next();
			playAgain = playAgainInput.equalsIgnoreCase("Y");

		}
		System.out.println("Game Over!! you played " + rounds + " round(s) and won " + wins + " time(s).");
	}
}
