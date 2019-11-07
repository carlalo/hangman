package hangman;

public class UserInterface
{
  String[][] images = {
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
      System.out.println(images[index][line]);
    }
    System.out.println();
  }

  public void splash() {
    System.out.println("=".repeat(72));
    System.out.println("HANGMAN | Can you escape the gallows?");
    System.out.println("=".repeat(72));
    System.out.println();
  }

  public void clearScreen() {
    System.out.println("\n".repeat(50));
  }
}
