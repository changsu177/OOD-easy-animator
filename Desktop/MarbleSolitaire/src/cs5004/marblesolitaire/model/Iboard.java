package cs5004.marblesolitaire.model;

/**
 * This interface represents a game board.
 */
public interface Iboard {
  /**
   * This function construct a game board.
   *
   * @return a constructed game board.
   */
  IPiece[][] makeBoard(int size, int eRow, int eCol);

  /**
   * Get the current score which is, the number of marbles on the board.
   *
   * @return the number of marbles on the game board.
   */
  int getScore();

  /**
   * Get the size of the game board.
   *
   * @return the size of the game board.
   */
  int getSize();


  /**
   * Get the piece sitting on the given position.
   *
   * @return the piece sitting on the given position.
   */
  IPiece getPiece(int row, int col) throws IllegalArgumentException;

  /**
   * Set a piece on the given position of the game board.
   *
   * @throws IllegalArgumentException if a invalid coordinate is putting in.
   */
  void setPiece(int row, int col, IPiece piece) throws IllegalArgumentException;

  /**
   * This function evaluate if the input position is in the valid game board range.
   *
   * @param i the row of the input position.
   * @param j the column of the input position.
   */
  boolean inArea(int i, int j);
}
