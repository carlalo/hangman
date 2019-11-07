package hangman;

import java.util.Scanner;

public class Game
{
  public static void main(final String[] args) {
    final UserInterface ui = new UserInterface();
    final Hangman hangman = new Hangman();

    boolean goodGuess = true;
    String guess = "";

    try (final Scanner sc = new Scanner(System.in)) {
      do {
        ui.clearScreen();
        ui.splash();
        ui.drawGallows(hangman.getFailures());

        if (hangman.isWon()) {
          System.out.println(String.format("You made it. '%s' was your word to freedom.", hangman.getSolution()));
          System.exit(0);
        }

        if (hangman.isLost()) {
          System.out.println("GAME OVER!\n");
          System.out.println(String.format("You tried '%s' with %s.", hangman.getPhrase(), hangman.getMisses()));
          System.out.println(String.format("I wanted  '%s'.", hangman.getSolution()));
          System.exit(2);
        }

        if (!goodGuess) {
          System.out.println("YOU GUESSED WRONG!");
          System.out.println();
        }

        System.out.println(hangman.getPhrase());
        System.out.println();

        System.out.println(String.format("You have %d tries left. You tried %s in vain.",
                                         hangman.getMaximumFailures() - hangman.getFailures(), hangman.getMisses()));
        System.out.println();

        System.out.print("What is your guess? ");
        guess = sc.next();
        goodGuess = hangman.guess(guess);
      } while (true);
    }
  }
}
