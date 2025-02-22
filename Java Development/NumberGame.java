import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;
        String playAgain = "y";

        System.out.println("🎮 Welcome to the Number Guessing Game! 🎯");

        while (playAgain.equalsIgnoreCase("y")) {
            int secretNumber = 1 + (int) (Math.random() * 100);
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nI have picked a number between 1 and 100. Can you guess it? 🤔");

            while (attempts < maxAttempts) {
                System.out.print("🔢 Attempt " + (attempts + 1) + "/" + maxAttempts + " - Enter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("⚠️ Please enter a valid number!");
                    sc.next();
                    continue;
                }

                int guess = sc.nextInt();
                attempts++;

                if (guess < 1 || guess > 100)
                    System.out.println("⚠️ Out of range! Enter a number between 1 and 100.");
                else if (guess < secretNumber)
                    System.out.println("📉 Too low! Try again.");
                else if (guess > secretNumber)
                    System.out.println("📈 Too high! Try again.");
                else {
                    System.out.println("🎉 Correct! The number was " + secretNumber + "!");
                    guessedCorrectly = true;
                    score++;
                    break;
                }
            }
            if (!guessedCorrectly)
                System.out.println("😢 Out of attempts! The number was " + secretNumber + ".");

            System.out.println("\n📊 Your current score: " + score);
            System.out.print("🔁 Do you want to play again? (y/n): ");
            playAgain = sc.next();
        }

        System.out.println("\n🎮 Thanks for playing! Your final score: " + score + " 🏆");
        sc.close();

    }
}
