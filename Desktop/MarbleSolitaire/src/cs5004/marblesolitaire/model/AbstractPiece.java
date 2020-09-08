package cs5004.marblesolitaire.model;

/**
 * This function represents a abstract class that implements the Ipiece interface.
 */
public class AbstractPiece implements IPiece {

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public boolean isMarble() {
    return false;
  }

  @Override
  public boolean isInValid() {
    return false;
  }

}
