package cs5004.marblesolitaire.model.hw08;

import cs5004.marblesolitaire.model.AbstractMarbleSolitaire;
import cs5004.marblesolitaire.model.EuropeanBoard;

/**
 * This class represent a European Solitaire Model. The game board is in the octagon shape and each
 * marbles can jump over another marble adjacent to it in four direction (left, right, down, up) to
 * the empty slot two slots away. And the game is over when no more movement is possible.
 */
public class EuropeanSolitaireModelImpl extends AbstractMarbleSolitaire {

  /**
   * This is a default constructor with no parameters. It creates an octagonal board whose sides
   * have length 3, with the empty slot in the center of the board.
   */
  public EuropeanSolitaireModelImpl() {
    board = new EuropeanBoard();
  }

  /**
   * This is a constructor that takes in one parameter. It creates a game with the specified side
   * length, and the empty slot in the center of the board.
   *
   * @param lens the side length of the game.
   * @throws IllegalArgumentException if a non-positive number is put in.
   */
  public EuropeanSolitaireModelImpl(int lens) throws IllegalArgumentException {
    board = new EuropeanBoard(lens);
  }

  /**
   * This is a constructor that takes in two parameter. It creates a game with the specified empty
   * slot, and the board size is 3 by default.
   *
   * @param row the row position of the empty slot.
   * @param col the column position of the empty slot.
   * @throws IllegalArgumentException if  invalid coordinates are passed in.
   */
  public EuropeanSolitaireModelImpl(int row, int col) throws IllegalArgumentException {
    board = new EuropeanBoard(row, col);
  }

  /**
   * This is a constructor that takes in 3 parameter. It creates a game with the specified side
   * length and a empty slot in the specified position.
   *
   * @param lens the side length of the game.
   * @param row  the row position of the empty slot.
   * @param col  the column position of the empty slot.
   * @throws IllegalArgumentException if a non-positive side length or an invalid coordinate is
   *                                  passed in.
   */
  public EuropeanSolitaireModelImpl(int lens, int row, int col)
          throws IllegalArgumentException {
    board = new EuropeanBoard(lens, row, col);

  }
}
