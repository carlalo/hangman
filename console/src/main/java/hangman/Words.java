package hangman;

import java.util.ArrayList;
import java.util.List;

public class Words
{
  private List<String> words = new ArrayList<>();

  public Words() {
    List.of("terminator", "banana", "computer", "cow", "rain", "water").forEach(word -> words.add(word.toUpperCase()));
  }

  public String randomWord() {
    if (words.isEmpty()) return "EMPTY";

    final int index = (int) (Math.random() * words.size());
    return words.get(index);
  }

  public void forget(final String word) {
    words.remove(word.toUpperCase());
  }

  @Override
  public String toString() {
    return String.join(", ", words);
  }

  public boolean isEmpty() {
    return words.isEmpty();
  }
}
