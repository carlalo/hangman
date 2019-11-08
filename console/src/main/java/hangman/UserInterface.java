package hangman;

import java.util.Arrays;
import java.util.Scanner;

public class UserInterface
{
  private static final Scanner SCAN = new Scanner(System.in);

  private static String[][] images = {
    {
      "       ",
      "       ",
      "       ",
      "       ",
      "       ",
      "       ",
      "       ",
      "       ",
      "       "
    },
    {
      "       ",
      "       ",
      "       ",
      "       ",
      "       ",
      "       ",
      "       ",
      "       ",
      "___|___"
    },
    {
      "       ",
      "   |   ",
      "   |   ",
      "   |   ",
      "   |   ",
      "   |   ",
      "   |   ",
      "   |   ",
      "___|___"
    },
    {
      "   ____________",
      "   |           |",
      "   |   ",
      "   |   ",
      "   |   ",
      "   |   ",
      "   |   ",
      "   |   ",
      "___|___"
    },
    {
      "   ____________",
      "   |          _|_",
      "   |         /   \\",
      "   |        |     |",
      "   |         \\_ _/",
      "   |   ",
      "   |   ",
      "   |   ",
      "___|___"
    },
    {
      "   ____________",
      "   |          _|_",
      "   |         /   \\",
      "   |        |     |",
      "   |         \\_ _/",
      "   |           | ",
      "   |           |",
      "   |   ",
      "___|___"
    },
    {
      "   ____________",
      "   |          _|_",
      "   |         /   \\",
      "   |        |     |",
      "   |         \\_ _/",
      "   |           | ",
      "   |           |",
      "   |          / \\ ",
      "___|___      /   \\"
    },
    {
      "   ____________",
      "   |          _|_",
      "   |         /   \\",
      "   |        |     |",
      "   |         \\_ _/",
      "   |          _|_",
      "   |         / | \\",
      "   |          / \\ ",
      "___|___      /   \\"
    }
  };

  public void drawGallows(final int fails) {
    final int index = Math.min(fails, images.length - 1);
    for (int line = 0; line < images[index].length; ++line) {
      println(images[index][line]);
    }
    println();
  }

  public void splash() {
    println("=".repeat(72));
    println("HANGMAN | Can you escape the gallows?");
    println("=".repeat(72));
    println();
  }

  public void clearScreen() {
    println("\n".repeat(50));
  }

  public void print(final String... text) {
    Arrays.stream(text).forEach(System.out::print);
  }

  public void println(final String... text) {
    print(text);
    System.out.println();
  }

  public String input() {
    return SCAN.next();
  }
}
