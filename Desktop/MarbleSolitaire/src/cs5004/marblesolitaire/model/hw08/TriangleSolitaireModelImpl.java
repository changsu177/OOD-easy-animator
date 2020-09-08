package cs5004.marblesolitaire.model.hw08;

import cs5004.marblesolitaire.model.AbstractMarbleSolitaire;
import cs5004.marblesolitaire.model.EmptyPiece;
import cs5004.marblesolitaire.model.MarblePiece;
import cs5004.marblesolitaire.model.TriangleBoard;

/**
 * This class represent a triangle solitaire model.This game board is in the triangle shape and each
 * marble can jump over an adjacent marble to the next empty slot. It can jump to the position in
 * its own row two columns away left or right, or  positions that are two rows above and below,
 * along the four diagonal directions. And the game is over when no more movement is possible.
 */
public class TriangleSolitaireModelImpl extends AbstractMarbleSolitaire {

  private int dimensions;

  /**
   * This is a default constructor with no parameters. It creates a 5-row game with the empty slot
   * at (0,0).
   */
  public TriangleSolitaireModelImpl() {
    this.dimensions = 5;
    board = new TriangleBoard();
  }

  /**
   * This is a constructor that takes in two parameter. It creates a specified-dimension game with
   * the empty slot at (0,0).
   *
   * @param dimensions the number of slots in the bottom-most row.
   * @throws IllegalArgumentException if a non-positive number is put in.
   */
  public TriangleSolitaireModelImpl(int dimensions) throws IllegalArgumentException {
    this.dimensions = dimensions;
    board = new TriangleBoard(dimensions);
  }

  /**
   * This is a constructor that takes in two parameter. It creates a 5-row game with the empty slot
   * at the specified position.
   *
   * @param row the row position of the empty slot.
   * @param col the column position of the empty slot.
   * @throws IllegalArgumentException if  invalid coordinates are passed in.
   */
  public TriangleSolitaireModelImpl(int row, int col) throws IllegalArgumentException {
    this.dimensions = 5;
    board = new TriangleBoard(row, col);
  }

  /**
   * This is a default constructor that takes in three parameter. It creates a game with the
   * specified dimension and an empty slot at the specified row and column.
   *
   * @param dimensions the number of slots in the bottom-most row.
   * @param row        the row position of the empty slot.
   * @param col        the column position of the empty slot.
   * @throws IllegalArgumentException if a non-positive dimensions or an invalid coordinate is
   *                                  passed in.
   */
  public TriangleSolitaireModelImpl(int dimensions, int row, int col) {
    this.dimensions = dimensions;
    board = new TriangleBoard(dimensions, row, col);
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws
          IllegalArgumentException {
    helperMove(fromRow, fromCol, toRow, toCol);
    if ((Math.abs(toRow - fromRow) == 2 && fromCol == toCol)
            || (Math.abs(toCol - fromCol) == 2 && fromRow == toRow) || (toCol - fromCol) == 2 &&
            (toRow - fromRow) == 2 || (toCol - fromCol) == -2 && (toRow - fromRow) == -2) {


      int middleX = (fromRow + toRow) / 2;
      int middleY = (fromCol + toCol) / 2;

      if (!board.getPiece(middleX, middleY).isMarble()) {
        throw new IllegalArgumentException("No marble between the from position and the to " +
                "position.");
      }

      board.setPiece(middleX, middleY, new EmptyPiece());
      board.setPiece(fromRow, fromCol, new EmptyPiece());
      board.setPiece(toRow, toCol, new MarblePiece());

    } else {
      throw new IllegalArgumentException("Cannot move: didn't jump over one adjacent marble.");
    }
  }

  @Override
  public boolean canMove(int row, int col) {

    boolean upperLeft = board.inArea(row - 2, col - 2) &&
            board.getPiece(row - 2, col - 2).isEmpty()
            && board.getPiece(row - 1, col - 1).isMarble();
    boolean lowerRight = board.inArea(row + 2, col + 2)
            && board.getPiece(row + 2, col + 2).isEmpty()
            && board.getPiece(row + 1, col + 1).isMarble();

    boolean upperRight = board.inArea(row - 2, col)
            && board.getPiece(row - 2, col).isEmpty()
            && board.getPiece(row - 1, col).isMarble();

    boolean lowerLeft = board.inArea(row + 2, col)
            && board.getPiece(row + 2, col).isEmpty()
            && board.getPiece(row + 1, col).isMarble();

    boolean leftward = board.inArea(row, col - 2) && board.getPiece(row, col - 1).isMarble()
            && board.getPiece(row, col - 2).isEmpty();
    boolean rightward = board.inArea(row, col + 2) && board.getPiece(row, col + 1).isMarble()
            && board.getPiece(row, col + 2).isEmpty();
    return upperLeft || upperRight || lowerLeft || lowerRight || leftward || rightward;
  }

  @Override
  public String getGameState() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < board.getSize(); i++) {
      StringBuilder line = new StringBuilder();
      for (int j = board.getSize() - 1; j >= 0; j--) {
        line.append(board.getPiece(i, j));
        if (!board.getPiece(i, j).isInValid() && j != 0) {
          line.append(" ");
        }
      }
      while (line.length() < 2 * dimensions - 1) {
        line.append(" ");
      }
      String temp = line.reverse().toString().replaceFirst("\\s++$", "");

      sb.append(temp);


      if (i != board.getSize() - 1) {
        sb.append("\n");
      }
    }
    return sb.toString();
  }
}
