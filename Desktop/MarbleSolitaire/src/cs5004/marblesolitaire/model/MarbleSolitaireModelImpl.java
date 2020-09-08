package cs5004.marblesolitaire.model;

/**
 * This class implements the MarbleSolitaireModel Interface and represent a model of the Marble
 * Solitaire game. It has a certain pattern of game board and holds marble on its board. Marbles can
 * jump over another marble adjacent to it in four direction (left, right, down, up) to the empty
 * slot two slots away. And the game is over when no more movement is possible.
 */
public class MarbleSolitaireModelImpl extends AbstractMarbleSolitaire {

  /**
   * This is a constructor that takes no parameter and the game board will be initialized to be arm
   * thickness 3 with an empty slot at the center.
   */
  public MarbleSolitaireModelImpl() {
    board = new EnglishBoard();

  }

  /**
   * This is a constructor that takes in 2 parameters as the coordinate of the empty slot and the
   * arm thickness is initialized to 3 by default.
   *
   * @param sRow the row coordinate of the empty slot.
   * @param sCol the column coordinate of the empty slot.
   * @throws IllegalArgumentException if an invalid position is put in.
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) throws IllegalArgumentException {
    board = new EnglishBoard(sRow, sCol);

  }

  /**
   * This is a constructor that takes in 1 parameter. It will initialize the game board with an
   * empty slot at the center.
   *
   * @param armLength the arm thickness of the game board.
   * @throws IllegalArgumentException if a non-positive number is put in.
   */
  public MarbleSolitaireModelImpl(int armLength) throws IllegalArgumentException {

    board = new EnglishBoard(armLength);
  }

  /**
   * This is a constructor that takes in 3 parameter.
   *
   * @param armLength the arm thickness of the game board.
   * @param sRow      the row coordinate of the empty slot.
   * @param sCol      the column coordinate of the empty slot.
   * @throws IllegalArgumentException if a non-positive armLength or an invalid coordinate is passed
   *                                  in.
   */
  public MarbleSolitaireModelImpl(int armLength, int sRow, int sCol)
          throws IllegalArgumentException {
    board = new EnglishBoard(armLength, sRow, sCol);

  }


}
