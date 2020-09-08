package cs5004.marblesolitaire.model;

/**
 * This class implements the Iboard interface representing an abstract game board. It has a game
 * board represented by a 2-d array and a count of the number of pieces on the board.
 */
public class AbstractBoard implements Iboard {
  protected IPiece[][] board;
  protected int numOfPiece = 0;

  @Override
  public int getScore() {
    return numOfPiece;
  }

  @Override
  public int getSize() {
    return board.length;
  }


  @Override
  public IPiece getPiece(int row, int col) throws IllegalArgumentException {
    if (row < 0 || row >= board.length || col < 0 || col >= board.length) {
      throw new IllegalArgumentException("Invalid input position.");
    }
    return board[row][col];
  }

  @Override
  public IPiece[][] makeBoard(int size, int eRow, int eCol) {
    board = new IPiece[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (i == eRow && j == eCol) {
          board[i][j] = new EmptyPiece();
        } else if (inArea(i, j)) {
          board[i][j] = new MarblePiece();
          numOfPiece++;
        } else {
          board[i][j] = new InvalidPiece();
        }
      }
    }

    return board;
  }

  @Override
  public void setPiece(int row, int col, IPiece piece) throws IllegalArgumentException {
    if (board[row][col].isInValid()) {
      throw new IllegalArgumentException("Invalid position.");
    }

    if (board[row][col].isMarble() && piece.isEmpty()) {
      numOfPiece--;
    } else if (board[row][col].isEmpty() && piece.isMarble()) {
      numOfPiece++;
    }
    board[row][col] = piece;
  }

  @Override
  public boolean inArea(int i, int j) {
    return false;
  }

}
