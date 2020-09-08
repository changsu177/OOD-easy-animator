package cs5004.marblesolitaire.model;

/**
 * This class extends AbstractBoard and represents an Triangle Marble Solitaire game board.
 */
public class TriangleBoard extends AbstractBoard {

  private int dimensions;
  private int emptyRow;
  private int emptyCol;

  /**
   * This is a default constructor with no parameters. It creates a 5-row game with the empty slot
   * at (0,0).
   */
  public TriangleBoard() {
    this.dimensions = 5;
    this.emptyRow = 0;
    this.emptyCol = 0;
    this.makeBoard(dimensions, 0, 0);

  }

  /**
   * This is a constructor that takes in two parameter. It creates a 5-row game with the empty slot
   * at the specified position.
   *
   * @param dimensions the number of slots in the bottom-most row.
   * @throws IllegalArgumentException if the a negative dimension is put in.
   */
  public TriangleBoard(int dimensions) throws IllegalArgumentException {
    if (dimensions <= 0) {
      throw new IllegalArgumentException("The dimensions must be a positive number.");
    }
    this.dimensions = dimensions;
    this.emptyRow = 0;
    this.emptyCol = 0;
    this.makeBoard(dimensions, 0, 0);
  }

  /**
   * This is a default constructor that takes in three parameter. It creates a game with the
   * specified dimension and an empty slot at the specified row and column. and the board size is 3
   * by default.
   *
   * @param row the row position of the empty slot.
   * @param col the column position of the empty slot.
   * @throws IllegalArgumentException if the an invalid empty position is put in.
   */
  public TriangleBoard(int row, int col) throws IllegalArgumentException {
    this.dimensions = 5;
    if (!inArea(row, col)) {
      throw new IllegalArgumentException("Invalid position for the empty slot.");
    }
    this.emptyRow = row;
    this.emptyCol = col;

    this.makeBoard(dimensions, row, col);

  }

  /**
   * This is a default constructor that takes in three parameter. It creates a game with the
   * specified dimension and an empty slot at the specified row and column.
   *
   * @param dimensions the number of slots in the bottom-most row.
   * @param row        the row position of the empty slot.
   * @param col        the column position of the empty slot.
   * @throws IllegalArgumentException if the a negative dimension or an invalid empty position is
   *                                  put in.
   */
  public TriangleBoard(int dimensions, int row, int col) throws IllegalArgumentException {
    if (dimensions <= 0) {
      throw new IllegalArgumentException("The dimensions must be a positive number.");
    }
    this.dimensions = dimensions;
    if (!inArea(row, col)) {
      throw new IllegalArgumentException("Invalid position for the empty slot.");
    }
    this.emptyRow = row;
    this.emptyCol = col;

    this.makeBoard(dimensions, row, col);
  }

  @Override
  public boolean inArea(int i, int j) {
    boolean inRect = i >= 0 && i < dimensions && j >= 0 && j < dimensions;
    return inRect && j <= i;

  }
}
