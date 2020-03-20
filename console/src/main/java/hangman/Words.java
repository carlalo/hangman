package hangman;

import java.util.*;

public class Words
{
  private List<String> words = new ArrayList<>();

  public Words() {
    if (Locale.getDefault().getLanguage().equals(Locale.GERMAN.getLanguage())) {
      List.of("Termin", "Kapitän", "Computer", "Kuh", "Regen", "Banane", "Wasser", "Kirchturm", "Tisch", "Teppich",
              "Regenschauer", "Bildschirm", "Fernseher", "Regenschirm", "Apfelkuchen", "Rosine", "Schwein", "Pferd",
              "Katze").forEach(word -> words.add(word.toUpperCase()));
    } else {
      List.of("apple", "banana", "computer", "cow", "rain", "umbrella", "shower", "pineapple", "captain", "table",
              "carpet", "water", "monitor", "television", "raisin", "pig", "horse", "date", "church", "shopping",
              "garden", "cat", "supermarket").forEach(word -> words.add(word.toUpperCase()));
    }
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
