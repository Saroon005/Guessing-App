/**
 * GuessingApp - Use Case 4: Error Handling & Validation
 * 
 * MAIN ClASS
 * 
 * This class coordinates the game execution while ensuring 
 * all user inputs are safely validated before processing.
 * 
 * Responsibilities:
 * - Initialize game configuration
 * - Accept user input
 * - Validate input using ValidationService
 * - Handle game flow without crashing on invalid input
 * 
 * @author Developer
 * @version 4.0
 */
import java.util.*;
public class GuessingApp
{
    public static void main(String[] args) throws InvalidInputException {
        System.out.println("Welcome to the Guessing App");
        GameConfig config = new GameConfig();
        config.showRules();
        
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int hintCount = 0;
        int target = config.getTargetNumber();

        /**
         * Game loop runs until the player
         * exhausts the maximum attempts.
         */
        while (attempts < config.getMaxAttempts()) {
              System.out.print("Enter your guess: ");
              /**
               * User input is validated before
               * being used in the game logic.
               */
              int guess = ValidationService.validateInput(scanner.nextLine());
              attempts++;

              String result = GuessValidator.validateGuess(guess, config.getTargetNumber());

              /**
               * A hint is generated only after
               * an incorrect guess and within
               * the allowed hint limit.
               */
              if (!"CORRECT".equals(result) && hintCount < config.getMaxHints()) {
                hintCount++;
                System.out.println(HintService.generateHint(config.getTargetNumber(), hintCount));
              }

              System.out.println(result);

              /**
               * Stop the loop immediately
               * if the correct number is guessed.
               */
              if ("CORRECT".equals(result)) {
                break;
              }
        }
    }
}

