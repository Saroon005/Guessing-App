/**
 * GuessingApp - Use Case 2: User Guess Submission
 * 
 * MAIN ClASS
 * 
 * Coordinates the game flow:
 * 1. Initialize game
 * 2. Accept user guesses
 * 3. Validate guesses
 * 4. Stop when game ends
 * 
 * @author Developer
 * @version 2.0
 */
import java.util.*;
public class GuessingApp
{
    public static void main(String[] args) {
        System.out.println("Welcome to the Guessing App");
        GameConfig config = new GameConfig();
        config.showRules();
        
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int hintCount = config.getMaxHints();
        int target = config.getTargetNumber();

        /**
         * Game loop runs until the player
         * exhausts the maximum attempts.
         */
        while (attempts < config.getMaxAttempts()) {
            System.out.println("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            String result = GuessValidator.validateGuess(guess, target);

            System.out.println(result);

            /**
             * Stop the loop immediately
             * if the correct number is guessed.
             */
            if (result != "CORRECT") {
                String hint = HintService.generateHint(target, --hintCount);
                System.out.println(hint);
            } else {
                break;
            }
        }
    }
}

