package cs5004.marblesolitaire.model;

/**
 * This class represent marble piece.
 */
public class MarblePiece extends AbstractPiece {

  @Override
  public boolean isMarble() {
    return true;
  }

  @Override
  public String toString() {
    return "O";
  }

}
