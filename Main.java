import java.util.Scanner;

// All programs need a class, main runs by default
public class Main {
    //  how accessible? | void if procedure, something else if function | name of funtion (main runs by default) | parameters | everything else
    public void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the dice game!\n");
        pressKey(scanner, "Press enter to continue...");

        // Declare variables
        int playerScore = 0;
        int opponentScore = 0;

        for (int i = 1; i < 6; i++) {
            clearScreen();
            System.out.println("Round " + i + "\n");
            displayScores(playerScore, opponentScore);

            pressKey(scanner, "Press enter to roll the die...");

            // Players turn
            int roll = rollDice();
            message("You", roll);
            playerScore += roll;
            pressKey(scanner, "Press enter to continue...");

            // Opponents turn
            int roll2 = rollDice();
            message("Opponent", roll2);
            opponentScore += roll2;
            pressKey(scanner, "Press enter to continue...");
        }
        
        clearScreen();
        displayScores(playerScore, opponentScore);

        // Win/loss logic
        if (playerScore > opponentScore) {
            System.out.println("You won!");
        } else if (opponentScore > playerScore) {
            System.out.println("You lost...");
        } else {
            System.out.println("It was a draw.");
        }

        scanner.close();

    }

    public int rollDice() {
        // Simulate rolling a die
        clearScreen();
        return (int) (Math.random() * 6) + 1;
    }

    public void message(String word, int roll) {
        // Output messages called from one line
        System.out.println(word + " rolled a " + roll + "\n");
    }

    public void clearScreen() {
        // Best i can do...
        for (int a = 0; a < 50; a++) {
                System.out.println();
            }
    }

    public void displayScores(int playerScore, int opponentScore) {
        // Displays both scores
        System.out.println("Player score:   " + playerScore + "\n");
        System.out.println("Opponent score:   " + opponentScore + "\n");
    }

    public void pressKey(Scanner scanner, String message) {
        // Player input continuing all on one line now
        System.out.println(message);
        scanner.nextLine();
    }
}
