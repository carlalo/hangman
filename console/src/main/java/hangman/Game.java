package hangman;

public class Game
{
  private static final String GAME_OVER = "GAME OVER!\n";
  private static final String GAME_OVER_GOOD_BYE = "Good-bye.";
  private static final String GAME_OVER_OUT_OF_WORDS = "Sorry, I have no more words for you to gain freedom.";
  private static final String GAME_OVER_TRIED = "You tried '%s' with %s.";
  private static final String GAME_OVER_WANTED = "I wanted  '%s'.";
  private static final String GAME_OVER_WON = "You made it. '%s' was your word to freedom.";
  private static final String PLAY_AGAIN = "Play again? [y]es? [n]o? ";
  private static final String PLAY_CHEAT = "Words left are %s.";
  private static final String PLAY_GUESS = "What is your guess? ";
  private static final String PLAY_TRIED = "You have %d tries left. You tried %s in vain.";
  private static final String PLAY_WRONG = "YOU GUESSED WRONG!";

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
        ui.println(String.format(GAME_OVER_WON, hangman.getSolution()));
        return;
      }

      if (hangman.isLost()) {
        ui.println(GAME_OVER);
        ui.println(String.format(GAME_OVER_TRIED, hangman.getPhrase(), hangman.getMisses()));
        ui.println(String.format(GAME_OVER_WANTED, hangman.getSolution()));
        return;
      }

      if (!goodGuess) {
        ui.println(PLAY_WRONG);
        ui.println();
      }

      if (!(System.getProperty("cheat") == null)) {
        ui.println(String.format(PLAY_CHEAT, words.toString()));
        ui.println();
      }

      ui.println(hangman.getPhrase());
      ui.println();

      ui.println(String.format(PLAY_TRIED, hangman.getMaximumFailures() - hangman.getFailures(), hangman.getMisses()));
      ui.println();

      ui.print(PLAY_GUESS);
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
        ui.println(GAME_OVER_OUT_OF_WORDS);
        playAgain = false;
      } else {
        playAgain = game.playAgain();
      }
    }

    ui.println();
    ui.println(GAME_OVER_GOOD_BYE);
  }

  private boolean playAgain() {
    ui.println();
    String answer = "";

    do {
      ui.print(PLAY_AGAIN);
      answer = ui.input().toLowerCase();
    } while (!(answer.startsWith("y") || answer.startsWith("j") || answer.startsWith("n")));

    return !answer.startsWith("n");
  }
}
