package cs5004.marblesolitaire.model;

/**
 * This class represent an abstract marble solitaire model. It has a certain pattern of game board
 * and holds marble on its board. Marbles can move by following certain moving rules and the game is
 * over when no more movement can be made.
 */
public class AbstractMarbleSolitaire implements MarbleSolitaireModel {
  protected Iboard board;

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    helperMove(fromRow, fromCol, toRow, toCol);
    if ((Math.abs(toRow - fromRow) == 2 && fromCol == toCol)
            || (Math.abs(toCol - fromCol) == 2 && fromRow == toRow)) {
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

  /**
   * This function helps test whether the input parameters for the move function are valid.
   *
   * @param fromRow the row position of the marble to be moved (starts at 0)
   * @param fromCol the column position of the marble to be moved (starts at 0)
   * @param toRow   the row position to move marble to (starts at 0)
   * @param toCol   the column position to move marble to(starts at 0)
   * @throws IllegalArgumentException if any one of the four coordinates is invalid(out of the game
   *                                  board boundary) or against the rule of the game move.
   */
  public void helperMove(int fromRow, int fromCol, int toRow, int toCol) throws
          IllegalArgumentException {
    if (board.getPiece(fromRow, fromCol).isInValid() || board.getPiece(toRow, toCol).isInValid()) {
      throw new IllegalArgumentException("Invalid input position.");
    }

    if (!board.getPiece(fromRow, fromCol).isMarble()) {
      throw new IllegalArgumentException("No marble in the position that marble is moving from.");
    }

    if (!board.getPiece(toRow, toCol).isEmpty()) {
      throw new IllegalArgumentException("The position that the marble is moving to is not empty.");
    }
  }

  @Override
  public boolean isGameOver() {
    if (board.getScore() <= 1) {
      return true;
    }
    // no more potential movement.
    for (int i = 0; i < board.getSize(); i++) {
      for (int j = 0; j < board.getSize(); j++) {
        if (board.getPiece(i, j).isMarble() && canMove(i, j)) {
          return false;
        }

      }
    }
    return true;
  }


  @Override
  public boolean canMove(int row, int col) {
    int size = board.getSize();
    boolean upward = row >= 2 && board.getPiece(row - 1, col).isMarble()
            && board.getPiece(row - 2, col).isEmpty();
    boolean downward = row <= size - 3 && board.getPiece(row + 1, col).isMarble()
            && board.getPiece(row + 2, col).isEmpty();
    boolean leftward = col >= 2 && board.getPiece(row, col - 1).isMarble()
            && board.getPiece(row, col - 2).isEmpty();
    boolean rightward = col <= size - 3 && board.getPiece(row, col + 1).isMarble()
            && board.getPiece(row, col + 2).isEmpty();
    return upward || downward || leftward || rightward;
  }

  @Override
  public String getGameState() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < board.getSize(); i++) {
      for (int j = 0; j < board.getSize(); j++) {
        sb.append(board.getPiece(i, j));
        sb.append(" ");
      }
      String temp = sb.toString().replaceFirst("\\s++$", "");
      sb = new StringBuilder(temp);
      if (i != board.getSize() - 1) {
        sb.append("\n");
      }
    }
    return sb.toString();
  }

  @Override
  public int getScore() {
    return board.getScore();
  }
}
