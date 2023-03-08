import java.util.Scanner;
/**
* Program asks user to guess
* a random number.
*
* @author Titwech Wal
* @version 1.0
* @since   2023-02-27
*/

public final class DiceGame {

    /**
    * This is a private constructor used to satisfy
    * the style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private DiceGame() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * This is the main method.
    *
    * @param args Unused.
    */

    public static void main(String[] args) {
        // Constants, variables and counter
        final int MAX_NUM = 6;
        final int MIN_NUM = 1;
        String userNum = "";
        int userNumInt = 0;
        // Start counter
        int counter = 0;

        // Generates number in set range.
        final int randomNum = (int) (Math.random() * (MAX_NUM - MIN_NUM + 1)
                                                    + MIN_NUM);

        // Using Scanner for getting input from user
        final Scanner scanner = new Scanner(System.in);

        do {
            // Get user input for number
            System.out.println("Guess a number between 1-6: ");
            userNum = scanner.nextLine();

            // Detects string input.
            try {
                // Convert string to integer
                userNumInt = Integer.parseInt(userNum);

                if (userNumInt < MIN_NUM || userNumInt > MAX_NUM) {
                    // Prints if number is not in range
                    System.out.println("Not in range");

                } else {
                    // User guesses add to counter
                    counter = counter + 1;

                    if (userNumInt > randomNum) {
                        // If number is over 6
                        System.out.println("Too high.");
                        System.out.println();

                    } else if (userNumInt < randomNum) {
                        // If number is under 6
                        System.out.println("Too low.");

                    } else { 
                        // displays if the user got it right
                        System.out.println("Your guess is correct!");
                        System.out.println("You guessed " + counter + " Times");
                    }
                }

            } catch (NumberFormatException error) {
                // Displays error to user.
                System.out.print("Please enter valid input."
                    + error.getMessage());
            }

        // This  executes when the user gets the
        // number correct.
        } while (userNumInt != randomNum);

        // Close scanner
        scanner.close();
    }
}