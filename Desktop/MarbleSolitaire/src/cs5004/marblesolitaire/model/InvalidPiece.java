package cs5004.marblesolitaire.model;

/**
 * This class represent an invalid piece which is out of the boundary of the game board.
 */

public class InvalidPiece extends AbstractPiece {

  @Override
  public boolean isInValid() {
    return true;
  }

  @Override
  public String toString() {
    return " ";
  }

}
