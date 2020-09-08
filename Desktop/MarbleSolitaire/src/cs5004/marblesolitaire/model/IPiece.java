package cs5004.marblesolitaire.model;

/**
 * This interface represents different pieces on the game board.
 */
public interface IPiece {

  /**
   * Evaluate if the current piece is empty.
   *
   * @return true if this piece is empty, false otherwise.
   */
  boolean isEmpty();

  /**
   * Evaluate if the current piece is a marble.
   *
   * @return true if this piece is a marble, false otherwise.
   */
  boolean isMarble();

  /**
   * Evaluate if the current piece is invalid (out of the boundary of game board).
   *
   * @return true if this piece is invalid, false otherwise.
   */
  boolean isInValid();


}

