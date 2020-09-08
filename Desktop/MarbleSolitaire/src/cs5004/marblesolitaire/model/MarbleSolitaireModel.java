package cs5004.marblesolitaire.model;

/**
 * This interface represents the operations offered by the marble solitaire model. One object of the
 * model represents one game of marble solitaire.
 */
public interface MarbleSolitaireModel {
  /**
   * Move a single marble from a given position to another empty slot.
   *
   * @param fromRow the row position of the marble to be moved (starts at 0)
   * @param fromCol the column position of the marble to be moved (starts at 0)
   * @param toRow   the row position to move marble to (starts at 0)
   * @param toCol   the column position to move marble to(starts at 0)
   * @throws IllegalArgumentException if the move is  impractical.
   */
  void move(int fromRow, int fromCol, int toRow, int toCol) throws
          IllegalArgumentException;

  /**
   * Determine and return if the game is over. A game is over when no more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  boolean isGameOver();

  /**
   * Return a string that represents the current state of the board.
   *
   * @return the game state as a string
   */
  String getGameState();

  /**
   * Return the number of marbles on the game board.
   *
   * @return the number of marbles on the game board
   */
  int getScore();

  /**
   * Evaluate if the piece can further move.
   *
   * @return true if this piece can move, false otherwise.
   */
  boolean canMove(int row, int col);
}
