package hangman;

public class Game
{
  private static final UserInterface ui = new UserInterface();
  private static final Words words = new Words();
  private Hangman hangman;

  public Game() {
    hangman = new Hangman(words);
  }

  public void reset() {
    words.forget(hangman.getSolution());
    hangman = new Hangman(words);
  }

  public void play() {
    boolean goodGuess = true;

    do {
      ui.clearScreen();
      ui.splash();
      ui.drawGallows(hangman.getFailures());

      if (hangman.isWon()) {
        ui.println(String.format("You made it. '%s' was your word to freedom.", hangman.getSolution()));
        return;
      }

      if (hangman.isLost()) {
        ui.println("GAME OVER!\n");
        ui.println(String.format("You tried '%s' with %s.", hangman.getPhrase(), hangman.getMisses()));
        ui.println(String.format("I wanted  '%s'.", hangman.getSolution()));
        return;
      }

      if (!goodGuess) {
        ui.println("YOU GUESSED WRONG!");
        ui.println();
      }

      if (!(System.getProperty("cheat") == null)) {
        ui.println(String.format("Words left are %s.", words.toString()));
        ui.println();
      }

      ui.println(hangman.getPhrase());
      ui.println();

      ui.println(String.format("You have %d tries left. You tried %s in vain.",
                               hangman.getMaximumFailures() - hangman.getFailures(), hangman.getMisses()));
      ui.println();

      ui.print("What is your guess? ");
      goodGuess = hangman.guess(ui.input());
    } while (true);
  }

  public static void main(final String[] args) {
    boolean playAgain = true;
    final Game game = new Game();

    while (playAgain) {
      game.play();
      game.reset();

      if (words.isEmpty()) {
        ui.println();
        ui.println("Sorry, I have no more words for you to gain freedom.");
        playAgain = false;
      } else {
        playAgain = game.playAgain();
      }
    }

    ui.println();
    ui.println("Good-bye.");
  }

  private boolean playAgain() {
    ui.println();
    String answer = "";

    do {
      ui.print("Play again? [y]es? [n]o? ");
      answer = ui.input().toLowerCase();
    } while (!(answer.startsWith("y") || answer.startsWith("n")));

    return !answer.startsWith("n");
  }
}
