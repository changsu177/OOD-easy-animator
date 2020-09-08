package cs5004.marblesolitaire.model;

/**
 * This class extends AbstractBoard and represents an English Marble Solitaire game board.
 */
public class EnglishBoard extends AbstractBoard {

  private int armLength;
  private int sRow;
  private int sCol;

  /**
   * This constructor takes no parameter and initialize the game board as default (armLenght 3 with
   * empty slot in the center).
   */
  public EnglishBoard() {
    this.armLength = 3;
    this.sRow = 3;
    this.sCol = 3;
    this.makeBoard( 3 * armLength - 2, sRow, sCol);
  }

  /**
   * This constructor takes in two parameters: sRow and sCol which determine the position of the
   * empty slot. And it will initializes the game board with the arm thickness 3
   *
   * @param sRow the row position of the empty slot.
   * @param sCol the column position of the empty slot.
   * @throws IllegalArgumentException if an invalid empty position is put in.
   */
  public EnglishBoard(int sRow, int sCol) throws IllegalArgumentException {
    this.armLength = 3;
    if (!inArea(sRow, sCol)) {
      throw new IllegalArgumentException("Invalid position for the empty slot.");
    }
    this.sRow = sRow;
    this.sCol = sCol;
    this.makeBoard( 3 * armLength - 2, sRow, sCol);
  }

  /**
   * This constructor takes in the arm thickness as its only parameter and initialize a game board
   * with a empty slot at the center.
   *
   * @param armLength the armLength of the game board.
   * @throws IllegalArgumentException if a non positive odd arm length is put in.
   */
  public EnglishBoard(int armLength) throws IllegalArgumentException {
    if (armLength <= 0 || armLength % 2 == 0) {
      throw new IllegalArgumentException("The armLength should be a positive odd number.");
    }
    this.armLength = armLength;
    this.sRow = (3 * armLength) / 2 - 3 / 2;
    this.sCol = (3 * armLength) / 2 - 3 / 2;
    this.makeBoard( 3 * armLength - 2, sRow, sCol);

  }

  /**
   * This constructor takes in the arm thickness, row and column of the empty slot as parameters.
   *
   * @param armLength the armLength of the game board.
   * @param sRow      the row position of the empty slot.
   * @param sCol      the column position of the empty slot.
   * @throws IllegalArgumentException if the armLength is not a positive odd number or the position
   *                                  of the empty slot is invalid.
   */
  public EnglishBoard(int armLength, int sRow, int sCol) throws IllegalArgumentException {
    if (armLength <= 0 || armLength % 2 == 0) {
      throw new IllegalArgumentException("The armLength should be a positive odd number.");
    }
    this.armLength = armLength;
    if (!inArea(sRow, sCol)) {
      throw new IllegalArgumentException("Invalid position for the empty slot.");
    }
    this.sRow = sRow;
    this.sCol = sCol;
    this.makeBoard( 3 * armLength - 2, sRow, sCol);
  }

  @Override
  public boolean inArea(int i, int j) {
    boolean row = i >= armLength - 1 && i <= 2 * armLength - 2;
    boolean col = j >= armLength - 1 && j <= 2 * armLength - 2;
    boolean inRect = i >= 0 && i <= 3 * armLength - 3 && j >= 0 && j <= 3 * armLength - 3;
    return (row || col) && inRect;
  }
}
