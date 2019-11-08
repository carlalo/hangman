package hangman;

import static hangman.Texts.GAME_OVER;
import static hangman.Texts.GAME_OVER_GOOD_BYE;
import static hangman.Texts.GAME_OVER_OUT_OF_WORDS;
import static hangman.Texts.GAME_OVER_TRIED;
import static hangman.Texts.GAME_OVER_WANTED;
import static hangman.Texts.GAME_OVER_WON;
import static hangman.Texts.PLAY_AGAIN;
import static hangman.Texts.PLAY_CHEAT;
import static hangman.Texts.PLAY_GUESS;
import static hangman.Texts.PLAY_TRIED;
import static hangman.Texts.PLAY_WRONG;

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
