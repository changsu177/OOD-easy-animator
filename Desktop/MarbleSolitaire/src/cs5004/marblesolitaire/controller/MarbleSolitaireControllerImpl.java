package cs5004.marblesolitaire.controller;

import java.io.IOException;
import java.util.Scanner;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;

/**
 * A controller for the Marble Solitaire Game. The controller receives all its inputs from a
 * Readable object and transmits all outputs to an Appendable object.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private final Readable rd;
  private final Appendable ap;

  /**
   * This is a constructor that takes in a readable object and an appendable object.
   *
   * @param rd a readable object that stores the coordinates information which would be retrieved by
   *           the scanner can direct the movement of marbles in this game.
   * @param ap a appendable object that record every state of the game and useful information while
   *           playing the game.
   * @throws IllegalArgumentException if either parameter is null
   */
  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Inputs cannot be null.");
    }
    this.rd = rd;
    this.ap = ap;
  }

  @Override
  public void playGame(MarbleSolitaireModel model) throws IllegalArgumentException,
          IllegalStateException {
    if (model == null) {
      throw new IllegalArgumentException("The input model cannot be null.");
    }

    // Transmit game state， Transmit "Score: x"，  asked one input at a time:
    Scanner scan = new Scanner(this.rd);

    int idx = 0;
    // store coordinates
    int[] num = new int[4];
    int n = -1;
    boolean exited = false;

    while (scan.hasNext()) {
      String sign = scan.next();
      // quite
      if (sign.equals("q") || sign.equals("Q")) {
        exited = !exited;
        helper("Game quit!" + "\n" + "State of game when quit:" + "\n" + model.getGameState() + "\n"
                + "Score: " + model.getScore());
        break;
      } else {
        // non-numeric string
        try {
          n = Integer.valueOf(sign);
        } catch (Exception e) {
          continue;
        }
        // negative input
        if (n <= 0) {
          continue;
        }

        num[idx] = n;
        // 2 valid coordinates are ready
        if (idx == 3) {
          // capture an invalid move
          try {
            model.move(num[0] - 1, num[1] - 1, num[2] - 1, num[3] - 1);
          } catch (IllegalArgumentException e) {
            helper("Invalid move. Play again. Error message:" + e.getMessage());
            idx = 0;
            continue;
          }
          // game over
          if (model.isGameOver()) {
            helper("Game over!" + "\n" + model.getGameState() + "\n" +
                    "Score: " + model.getScore());
            break;
          }
          helper(model.getGameState());
          idx = 0;
        } else {
          idx++;
        }
      }
    }
    if (!exited && !model.isGameOver()) {
      throw new IllegalStateException("Invalid input: run out of the input.");
    }
  }

  /**
   * This helper function helps handle reading and writing. If the appendable object is unable to
   * transmit output or it is unable to read from the Readable object, this function would catch the
   * IOException and throws IllegalStateException instead.
   *
   * @param message the message to be appended to the appendable object.
   * @throws IllegalStateException if the appendable object is unable to append the input String
   */

  private void helper(String message) throws IllegalStateException {
    try {
      this.ap.append(message + '\n');
    } catch (IOException e) {
      throw new IllegalStateException("Unable to transmit the output");

    }
  }

}
