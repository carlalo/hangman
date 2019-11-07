package hangman;

public class Dictionary
{
  private static String[] words = {
    "terminator",
    "banana",
    "computer",
    "cow",
    "rain",
    "water"
  };

  public String randomWord() {
    return words[(int) (Math.random() * words.length)];
  }
}
