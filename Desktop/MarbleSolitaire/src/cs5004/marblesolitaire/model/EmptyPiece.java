package cs5004.marblesolitaire.model;

/**
 * This class represent an empty piece.
 */
public class EmptyPiece extends AbstractPiece {

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public String toString() {
    return "_";
  }

}
