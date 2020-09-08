package cs5004.marblesolitaire;

import java.io.InputStreamReader;

import cs5004.marblesolitaire.controller.MarbleSolitaireController;
import cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs5004.marblesolitaire.model.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;
import cs5004.marblesolitaire.model.hw08.EuropeanSolitaireModelImpl;
import cs5004.marblesolitaire.model.hw08.TriangleSolitaireModelImpl;

/**
 * Demonstrates a simple command-line-based Marble Solitaire Game.
 */
public class MarbleSolitaire {
  public static void main(String[] args) {
    builder(args);
  }

  /**
   * This is a builder function that helps to parse the input of the main function and play a marble
   * solitaire game.
   *
   * @param args the input string to be parsed.
   */
  public static void builder(String[] args) {

    int size = -1;
    int eRow = -1;
    int eCol = -1;

    for (int i = 1; i < args.length; ) {
      if (args[i].equals("-size")) {
        size = Integer.valueOf(args[i + 1]);
        i = i + 2;
      } else if (args[i].equals("-hole")) {
        eRow = Integer.valueOf(args[i + 1]);
        eCol = Integer.valueOf(args[i + 2]);
        i = i + 3;
      }
    }
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();

    if (size == -1 && eRow == -1 && eCol == -1) {
      switch (args[0]) {
        case "english":
          model = new MarbleSolitaireModelImpl();
          break;
        case "european":
          model = new EuropeanSolitaireModelImpl();
          break;
        case "triangular":
          model = new TriangleSolitaireModelImpl();
          break;
        default:
          break;
      }
    } else if (size != -1 && eRow == -1 && eCol == -1) {
      switch (args[0]) {
        case "english":
          model = new MarbleSolitaireModelImpl(size);
          break;
        case "european":
          model = new EuropeanSolitaireModelImpl(size);
          break;
        case "triangular":
          model = new TriangleSolitaireModelImpl(size);
          break;
        default:
          break;
      }
    } else if (size == -1 && eRow != -1 && eCol != -1) {
      switch (args[0]) {
        case "english":
          model = new MarbleSolitaireModelImpl(eRow, eCol);
          break;
        case "european":
          model = new EuropeanSolitaireModelImpl(eRow, eCol);
          break;
        case "triangular":
          model = new TriangleSolitaireModelImpl(eRow, eCol);
          break;
        default:
          break;
      }
    } else if (size != -1 && eRow != -1 && eCol != -1) {
      switch (args[0]) {
        case "english":
          model = new MarbleSolitaireModelImpl(size, eRow, eCol);
          break;
        case "european":
          model = new EuropeanSolitaireModelImpl(size, eRow, eCol);
          break;
        case "triangular":
          model = new TriangleSolitaireModelImpl(size, eRow, eCol);
          break;
        default:
          break;
      }
    }
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(new
            InputStreamReader(System.in), System.out);
    controller.playGame(model);

  }

}
