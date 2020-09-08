package cs5004.marblesolitaire.model;

/**
 * This class extends AbstractBoard and represents an European Marble Solitaire game board.
 */
public class EuropeanBoard extends AbstractBoard {

  private int lens;
  private int emptyRow;
  private int emptyCol;

  /**
   * This is a default constructor with no parameters. It creates an octagonal board whose sides
   * have length 3, with the empty slot in the center of the board.
   */
  public EuropeanBoard() {
    this.lens = 3;
    this.emptyRow = 3;
    this.emptyCol = 3;

    this.makeBoard( 3 * lens - 2, emptyRow, emptyCol);
  }

  /**
   * This is a constructor that takes in one parameter. It creates a game with the specified side
   * length, and the empty slot in the center of the board.
   *
   * @param lens the side length of the game.
   * @throws IllegalArgumentException if the a non positive odd side length is put in.
   */
  public EuropeanBoard(int lens) throws IllegalArgumentException {
    if (lens <= 0 || lens % 2 == 0) {
      throw new IllegalArgumentException("The side length should be a positive odd number.");
    }
    this.lens = lens;
    this.emptyRow = (3 * lens) / 2 - 3 / 2;
    this.emptyCol = (3 * lens) / 2 - 3 / 2;

    this.makeBoard( 3 * lens - 2, emptyRow, emptyCol);

  }

  /**
   * This is a constructor that takes in two parameter. It creates a game with the specified empty
   * slot, and the board size is 3 by default.
   *
   * @param row the row position of the empty slot.
   * @param col the column position of the empty slot.
   * @throws IllegalArgumentException if an invalid empty position is put in.
   */
  public EuropeanBoard(int row, int col) throws IllegalArgumentException {
    this.lens = 3;
    if (!inArea(row, col)) {
      throw new IllegalArgumentException("Invalid position for the empty slot.");
    }
    this.emptyRow = row;
    this.emptyCol = col;

    this.makeBoard( 3 * lens - 2, emptyRow, emptyCol);

  }

  /**
   * This is a constructor that takes in 3 parameter. It creates a game with the specified side
   * length and a empty slot in the specified position.
   *
   * @param lens the side length of the game.
   * @param row  the row position of the empty slot.
   * @param col  the column position of the empty slot.
   * @throws IllegalArgumentException if the a non positive odd side length or an invalid empty
   *                                  position is put in.
   */
  public EuropeanBoard(int lens, int row, int col) throws IllegalArgumentException {
    if (lens <= 0 || lens % 2 == 0) {
      throw new IllegalArgumentException("The side length should be a positive odd number.");
    }
    this.lens = lens;
    if (!inArea(row, col)) {
      throw new IllegalArgumentException("Invalid position for the empty slot.");
    }
    this.emptyRow = row;
    this.emptyCol = col;

    this.makeBoard( 3 * lens - 2, emptyRow, emptyCol);

  }

  @Override
  public boolean inArea(int i, int j) {
    boolean a = true;
    boolean b = true;
    if (i >= 0 && i <= lens - 2) {
      a = j >= lens - 1 - i && j <= 2 * lens - 2 + i;
    } else if (i >= 2 * lens - 1 && i <= 3 * lens - 3) {
      b = j >= 0 + (i - (2 * lens - 2)) && j <= 3 * lens - 3 - (i - (2 * lens - 2));
    }

    boolean inRect = i >= 0 && i <= 3 * lens - 3 && j >= 0 && j <= 3 * lens - 3;
    return inRect && a && b;
  }
}
