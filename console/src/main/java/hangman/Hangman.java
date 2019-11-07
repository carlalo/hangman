package hangman;

import java.util.*;

public class Hangman
{
  private static final int TRIES = 7;

  private Dictionary dictionary = new Dictionary();
  private int fails;

  private String solution;
  private String phrase;
  private TreeSet<Character> misses;

  public Hangman() {
    solution = dictionary.randomWord();
    phrase = "*".repeat(solution.length());
    fails = 0;
    misses = new TreeSet<>();
  }

  public String getPhrase() {
    return phrase;
  }

  public String getSolution() {
    return solution;
  }

  public boolean guess(final String guess) {
    if (isLost()) return false;

    final char guessedCharacter = guess.charAt(0);

    final StringBuilder mask = new StringBuilder();
    for (int i = 0; i < solution.length(); ++i) {
      final char givenCharacter = solution.charAt(i);

      if (givenCharacter == guessedCharacter || phrase.charAt(i) != '*') {
        mask.append(givenCharacter);
      } else {
        mask.append("*");
      }
    }

    if (mask.toString().equalsIgnoreCase(phrase)) {
      ++fails;
      misses.add(guessedCharacter);
      return false;
    }

    phrase = mask.toString();
    return true;
  }

  public SortedSet<Character> getMisses() {
    return Collections.unmodifiableSortedSet(misses);
  }

  public int getFailures() {
    return fails;
  }

  public int getMaximumFailures() {
    return TRIES;
  }

  public boolean isWon() {
    return phrase.equalsIgnoreCase(solution);
  }

  public boolean isLost() {
    return getFailures() >= getMaximumFailures();
  }
}
