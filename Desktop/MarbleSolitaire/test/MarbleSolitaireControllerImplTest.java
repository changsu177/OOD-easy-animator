import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs5004.marblesolitaire.controller.MarbleSolitaireController;
import cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs5004.marblesolitaire.model.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * This class test methods from the MarbleSolitaireControllerImpl class.
 */
public class MarbleSolitaireControllerImplTest {
  private StringBuilder sb;
  private MarbleSolitaireModel game;
  private MarbleSolitaireModel game1;
  private MarbleSolitaireController controller;
  private MarbleSolitaireController controller1;

  @Before
  public void setUp() throws Exception {
    game = new MarbleSolitaireModelImpl();
    game1 = new MarbleSolitaireModelImpl();

    Reader in1 = new StringReader("2 4 4 4 "
            + "3 6 3 4 "
            + "1 5 3 5 "
            + "4 5 2 5 "
            + "6 5 4 5 "
            + "5 7 5 5 "
            + "5 4 5 6 "
            + "3 7 5 7 "
            + "5 7 5 5 "
            + "3 3 3 5 "
            + "3 1 3 3 "
            + "5 2 5 4 "
            + "5 4 5 6 "
            + "5 6 3 6 "
            + "3 6 3 4 "
            + "3 4 3 2 "
            + "7 3 5 3 "
            + "4 3 6 3 "
            + "7 5 7 3 "
            + "7 3 5 3 "
            + "5 1 3 1 "
            + "3 1 3 3 "
            + "1 3 1 5 "
            + "1 5 3 5 "
            + "3 5 5 5 "
            + "2 3 4 3 "
            + "4 3 6 3 "
            + "6 3 6 5 "
            + "6 5 4 5 q"
    );
    sb = new StringBuilder();
    controller = new MarbleSolitaireControllerImpl(in1, sb);
    controller.playGame(game);
  }

  /**
   * This function tests when there is a "q" at the end and no illegal characters in the
   * input String. The game will quite as expected.
   */
  @Test
  public void test_withq() {
    sb = new StringBuilder();
    controller = new MarbleSolitaireControllerImpl(new StringReader("4 5 4 3 4 2 q"), sb);
    controller.playGame(game);
    assertEquals("    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O O _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O O _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 2\n", sb.toString());

  }

  /**
   * This function tests when there is a "Q" at the end and no illegal characters in the
   * input String. The game will quite as expected.
   */
  @Test
  public void test_withQ() {
    sb = new StringBuilder();
    controller = new MarbleSolitaireControllerImpl(new StringReader("4 5 4 3 4 2 Q"), sb);
    controller.playGame(game);
    assertEquals("    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O O _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O O _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 2\n", sb.toString());

  }

  /**
   * This function test when the input String has characters other than positive number,
   * the scanner will keep scanning until find the next valid input without throwing exception.
   */
  @Test
  public void test_containingInvalidChar() {
    sb = new StringBuilder();
    controller = new MarbleSolitaireControllerImpl(new StringReader("4 @& 5 4 egg 3 q"), sb);
    controller.playGame(game);
    assertEquals("    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O O _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O O _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 2\n", sb.toString());
  }


  /**
   * This function test when the input String has non-positive number,
   * the scanner will keep scanning until find the next valid input without throwing exception.
   */
  @Test
  public void test_containingNonPositiveNum() {
    sb = new StringBuilder();
    controller = new MarbleSolitaireControllerImpl(new StringReader("4 -1 5 4 0 3 q"), sb);
    controller.playGame(game);
    assertEquals("    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O O _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O O _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 2\n", sb.toString());
  }


  /**
   * This function tests when the input movement makes the game over, even though no "q" at the end,
   * the controller will work without throwing an exception.
   */
  @Test
  public void test_gameOver_noQq() {
    sb = new StringBuilder();
    controller = new MarbleSolitaireControllerImpl(new StringReader("4 5 4 3 4 2 4 4"), sb);
    controller.playGame(game);
    assertEquals("    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O O _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1\n", sb.toString());
  }

  /**
   * This function tests when the input movement doesn't make the game over and at the same time
   * there is no "q" at the end, the controller will throw an IllegalStateException.
   */
  @Test(expected = IllegalStateException.class)
  public void test_gameNotOver_noQq() {
    sb = new StringBuilder();
    controller = new MarbleSolitaireControllerImpl(new StringReader("4 5 4 3 4 2 4"), sb);
    controller.playGame(game);
  }


  /**
   * This function test when the input readable object is null, an IllegalArgumentException is
   * expected to be thrown.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test_nullRd() {
    sb = new StringBuilder();
    controller = new MarbleSolitaireControllerImpl(null, sb);
    controller.playGame(game);
  }

  /**
   * This function test when the input appendable is null, an IllegalArgumentException is expected
   * to be thrown.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test_nullAp() {
    controller = new MarbleSolitaireControllerImpl(new StringReader("4 5 4 3 4 2 4 q"),
            null);
    controller.playGame(game);
  }


  /**
   * This function test when the appendable object cannot transmit the output, an
   * IllegalStateException
   * is expected to be thrown.
   */
  @Test(expected = IllegalStateException.class)
  public void test_Ap() {
    Appendable mockAp = new IOExceptionTester();
    controller = new MarbleSolitaireControllerImpl(new StringReader("4 5 4 3 q"), mockAp);
    controller.playGame(game);
  }


  /**
   * This function test when the input MarbleSolitaireModel is null, an IllegalArgumentException is
   * expected to be thrown.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test_nullModel() {
    sb = new StringBuilder();
    controller = new MarbleSolitaireControllerImpl(new StringReader("4 5 4 3 4 2 4 q"), sb);
    controller.playGame(null);
  }

  /**
   * This function test when the StringBuilder is taking in a empty String, an IllegalStateException
   * is expected to be thrown.
   */
  @Test(expected = IllegalStateException.class)
  public void test_emptyString() {
    sb = new StringBuilder();
    controller = new MarbleSolitaireControllerImpl(new StringReader(""), sb);
    controller.playGame(game);
  }

  /**
   * This function test when the StringBuilder is taking in a single "q", the controller will exit
   * directly and no movement would be made.
   */
  @Test
  public void test_singleQ() {
    sb = new StringBuilder();
    controller = new MarbleSolitaireControllerImpl(new StringReader("Q"), sb);
    controller.playGame(game);
    assertEquals("Game quit!\n" +
            "State of game when quit:\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O _ O O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 3\n", sb.toString());
  }

  /**
   * This function test when the input valid coordinates are less than 4, no movement would be
   * made.
   */
  @Test
  public void test_3Coordinates() {
    sb = new StringBuilder();
    controller = new MarbleSolitaireControllerImpl(new StringReader("4 5 4 Q"), sb);
    controller.playGame(game);
    assertEquals("Game quit!\n" +
            "State of game when quit:\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O _ O O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 3\n", sb.toString());
  }


  /**
   * This function test the model can successfully move leftwards followed the instruction from the
   * controller.
   */
  @Test
  public void test_move2cellsLeftwards() {
    sb = new StringBuilder();
    controller1 = new MarbleSolitaireControllerImpl(new StringReader("4 2 4 4 4 5 4 3 Q"), sb);
    controller1.playGame(game1);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n", sb.toString());
  }

  /**
   * This function test the model can successfully move rightwards followed the instruction from the
   * controller.
   */
  @Test
  public void test_move2cellsRightwards() {
    sb = new StringBuilder();
    controller1 = new MarbleSolitaireControllerImpl(new StringReader("4 2 4 4 Q"), sb);
    controller1.playGame(game1);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", sb.toString());
  }

  /**
   * This function test the model can successfully move upwards followed the instruction from the
   * controller.
   */
  @Test
  public void test_move2cellsUpwards() {
    sb = new StringBuilder();
    controller1 = new MarbleSolitaireControllerImpl(new StringReader("4 2 4 4 6 3 4 3 Q"), sb);
    controller1.playGame(game1);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "O O _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "O O _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 30\n", sb.toString());
  }

  /**
   * This function test the model can successfully move downwards followed the instruction from the
   * controller.
   */
  @Test
  public void test_move2cellsDownwards() {
    sb = new StringBuilder();
    controller1 = new MarbleSolitaireControllerImpl(new StringReader("4 2 4 4 2 3 4 3 Q"), sb);
    controller1.playGame(game1);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    _ O O\n" +
            "O O _ O O O O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    _ O O\n" +
            "O O _ O O O O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n", sb.toString());
  }


  /**
   * This function test when the input coordinates are out of the board boundary, the controller
   * should transmit a message to the Appendable object and the scanner will keeping scanning the
   * following String.
   */
  @Test
  public void test_model_CoordinatesOutOfBoundary() {
    sb = new StringBuilder();
    controller = new MarbleSolitaireControllerImpl(new StringReader("20 15 4 5 4 5 4 3 Q"), sb);
    controller.playGame(game);
    assertEquals("Invalid move. Play again. Error message:Invalid input position.\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O O _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O O _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 2\n", sb.toString());
  }

  /**
   * This function test when the input movement is invalid ( case 1: no marble in the "from"
   * position ), the controller should transmit a message to the Appendable object and the scanner
   * will keeping scanning the following String.
   */
  @Test
  public void test_model_invalidMove_noMarbleInFromP() {
    sb = new StringBuilder();
    controller = new MarbleSolitaireControllerImpl(new StringReader("4 3 4 1 Q"), sb);
    controller.playGame(game);
    assertEquals("Invalid move. Play again. Error message:No marble in the position" +
            " that marble is moving from.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O _ O O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 3\n", sb.toString());
  }

  /**
   * This function test when the input movement is invalid ( case 2: the "to" position is not empty
   * ), the controller should transmit a message to the Appendable object and the scanner will
   * keeping scanning the following String.
   */
  @Test
  public void test_model_invalidMove_toPIsNotEmpty() {
    sb = new StringBuilder();
    controller1 = new MarbleSolitaireControllerImpl(new StringReader("4 3 4 1 Q"), sb);
    controller1.playGame(game1);
    assertEquals("Invalid move. Play again. Error message:The position that the " +
            "marble is moving to is not empty.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", sb.toString());
  }

  /**
   * This function test when the input movement is invalid ( case 3: the marble is trying to jump
   * over more than 1 adjacent marbles), the controller should transmit a message to the Appendable
   * object and the scanner will keeping scanning the following String.
   */
  @Test
  public void test_model_invalidMove_JumpOverTooManyMarbles() {
    sb = new StringBuilder();
    controller = new MarbleSolitaireControllerImpl(new StringReader("4 5 4 1 Q"), sb);
    controller.playGame(game);
    assertEquals("Invalid move. Play again. Error message:Cannot move: didn't jump over " +
            "one adjacent marble.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O _ O O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 3\n", sb.toString());
  }

  /**
   * This function test when the input movement is invalid ( case 4: no marble between the "from"
   * and the "to" position), the controller should transmit a message to the Appendable object and
   * the scanner will keeping scanning the following String.
   */
  @Test
  public void test_model_invalidMove_noMarbleBetween() {
    sb = new StringBuilder();
    controller = new MarbleSolitaireControllerImpl(new StringReader("4 5 4 1 Q"), sb);
    controller.playGame(game);
    assertEquals("Invalid move. Play again. Error message:Cannot move: didn't jump over " +
            "one adjacent marble.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O _ O O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 3\n", sb.toString());
  }

  /**
   * This function test when the input movement is invalid ( case 5: trying to jump diagonally), the
   * controller should transmit a message to the Appendable object and the scanner will keeping
   * scanning the following String.
   */
  @Test
  public void test_model_invalidMove_jumpDiagonally() {
    sb = new StringBuilder();
    controller1 = new MarbleSolitaireControllerImpl(new StringReader("4 2 4 4 2 4 4 2 Q"), sb);
    controller1.playGame(game1);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Invalid move. Play again. Error message:Cannot move: didn't jump over one" +
            " adjacent marble.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", sb.toString());
  }

  /**
   * This function test the quit command works as expected, quit the game and show corresponding
   * message.
   */
  @Test
  public void test_quit() {
    sb = new StringBuilder();
    controller = new MarbleSolitaireControllerImpl(new StringReader("4 5 4 3 Q"), sb);
    controller.playGame(game);
    assertEquals("    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O O _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O O _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 2\n", sb.toString());
  }

  /**
   * This function test when game is over, the "Game over!" message and score would be the output.
   */
  @Test
  public void test_win() {
    sb = new StringBuilder();
    controller = new MarbleSolitaireControllerImpl(new StringReader("4 5 4 3 4 2 4 4 Q"), sb);
    controller.playGame(game);
    assertEquals("    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O O _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1\n", sb.toString());
  }
}