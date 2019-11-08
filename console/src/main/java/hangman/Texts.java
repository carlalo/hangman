package hangman;

import java.util.ResourceBundle;

public enum Texts
{
 GAME_OVER,
 GAME_BYE,
 GAME_SPEECHLESS,
 GAME_TRIED,
 GAME_WANTED,
 GAME_WON,

 PLAY_AGAIN,
 PLAY_CHEAT,
 PLAY_GUESS,
 PLAY_TRIED,
 PLAY_WRONG;

  private ResourceBundle bundle;

  private ResourceBundle bundle() {
    if (bundle == null) {
      bundle = ResourceBundle.getBundle("hangman.text");
    }
    return bundle;
  }

  private String key() {
    return this.name().toLowerCase().replaceAll("_", ".");
  }

  public String text() {
    final String text = bundle().getString(key());
    return (text == null || text.isBlank()) ? key() : text;
  }
}
