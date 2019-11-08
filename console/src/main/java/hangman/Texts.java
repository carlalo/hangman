package hangman;

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

  private String key() {
    return this.name().toLowerCase().replaceAll("_", ".");
  }

  public String text() {
    return key();
  }
}
