import org.junit.Before;
import org.junit.Test;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;
import cs5004.marblesolitaire.model.hw08.EuropeanSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This function test methods from EuropeanSolitaireModelImpl class.
 */
public class EuropeanSolitaireModelImplTest {

  private MarbleSolitaireModel european1;
  private MarbleSolitaireModel european2;
  private MarbleSolitaireModel european3;


  @Before
  public void setUp() throws Exception {
    european1 = new EuropeanSolitaireModelImpl();
    european3 = new EuropeanSolitaireModelImpl(0, 2);
    european3.move(2, 2, 0, 2);
    european3.move(2, 0, 2, 2);
    european3.move(1, 4, 1, 2);
    european3.move(3, 4, 1, 4);
    european3.move(3, 2, 3, 4);
    european3.move(2, 3, 2, 1);

    european3.move(5, 3, 3, 3);
    european3.move(3, 0, 3, 2);
    european3.move(5, 1, 3, 1);
    european3.move(4, 5, 4, 3);
    european3.move(5, 5, 5, 3);
    european3.move(0, 4, 2, 4);


    european3.move(2, 1, 4, 1);
    european3.move(2, 4, 4, 4);
    european3.move(5, 2, 5, 4);
    european3.move(3, 6, 3, 4);
    european3.move(1, 1, 1, 3);
    european3.move(2, 6, 2, 4);
    european3.move(0, 3, 2, 3);

    european3.move(3, 2, 5, 2);
    european3.move(3, 4, 3, 2);
    european3.move(6, 2, 4, 2);
    european3.move(3, 2, 5, 2);
    european3.move(4, 0, 4, 2);
    european3.move(4, 3, 4, 1);

    european3.move(6, 4, 6, 2);
    european3.move(6, 2, 4, 2);
    european3.move(4, 1, 4, 3);
    european3.move(4, 3, 4, 5);
    european3.move(4, 6, 4, 4);

    european3.move(5, 4, 3, 4);
    european3.move(3, 4, 1, 4);
    european3.move(1, 5, 1, 3);
    european3.move(2, 3, 0, 3);


  }

  /**
   * Test constructor with no parameter.
   */
  @Test
  public void testConstructor_NoParam() {

    String expected = "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O";

    assertEquals(expected, european1.getGameState());

  }

  /**
   * Test constructor with one parameter (side length).
   */
  @Test
  public void testConstructor_OneParam() {
    european2 = new EuropeanSolitaireModelImpl(5);
    String expected = "        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O";
    assertEquals(expected, european2.getGameState());
  }

  /**
   * Test constructor with one parameter (side length), and there is only an empty slot being
   * created.
   */
  @Test
  public void testConstructor_OneParam_one() {
    european2 = new EuropeanSolitaireModelImpl(1);
    String expected = "_";
    assertEquals(expected, european2.getGameState());
  }

  /**
   * Negative test: test constructor with one parameter, and an even side length is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_OneParam_evenSideLength() {
    MarbleSolitaireModel em = new EuropeanSolitaireModelImpl(4);
  }

  /**
   * Negative test: test constructor with one parameter, and a negative odd side length is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_OneParam_negativeSideLength() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl(-3);
  }

  /**
   * Negative test: test constructor with one parameter, and 0 is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_OneParam_zero() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl(0);
  }

  /**
   * Test constructor with two parameter (row, col).
   */
  @Test
  public void testConstructor_twoParam() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl(2, 2);
    String expected = "    O O O\n" +
            "  O O O O O\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O";
    assertEquals(expected, m.getGameState());
  }

  /**
   * Test constructor with two parameter (row, col), and an invalid position is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_twoParam_Invalid1() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl(0, 0);
  }

  /**
   * Test constructor with two parameter (row, col), and an invalid position is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_twoParam_Invalid2() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl(5, 0);
  }

  /**
   * Test constructor with two parameter (row, col), and an invalid position (out of the whole
   * rectangle boundary) is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_twoParam_Invalid3() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl(-1, 3);
  }

  /**
   * Test constructor with three parameter (lens, sRow, sCol).
   */
  @Test
  public void testConstructor_threeParam() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl(5, 3, 3);
    String expected = "        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O _ O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O";
    assertEquals(expected, m.getGameState());
  }

  /**
   * Test constructor with three parameter (lens, sRow, sCol), and an even lens is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_threeParam_even_lens() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl(4, 4, 3);
  }

  /**
   * Test constructor with three parameter (lens, sRow, sCol), and an negative lens is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_threeParam_negative_lens() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl(-1, 1, 3);
  }

  /**
   * Test constructor with three parameter (lens, sRow, sCol), and an invalid center position is put
   * in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_threeParam_invalid_center() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl(4, 0, 3);
  }

  /**
   * Test move function when valid 'from' position and 'to' position are put in and the marble is
   * moving rightward.
   */
  @Test
  public void testCanMove_moveRightward() {
    european1.move(3, 1, 3, 3);
    String expected = "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O";

    assertEquals(expected, european1.getGameState());
  }

  /**
   * Test move function when valid 'from' position and 'to' position are put in and the marble is
   * moving leftward.
   */
  @Test
  public void testCanMove_moveLeftward() {
    european1.move(3, 1, 3, 3);
    european1.move(3, 4, 3, 2);
    String expected = "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O";

    assertEquals(expected, european1.getGameState());
  }

  /**
   * Test move function when valid 'from' position and 'to' position are put in and the marble is
   * moving upward.
   */
  @Test
  public void testCanMove_moveUpward() {
    european1.move(3, 1, 3, 3);
    european1.move(5, 1, 3, 1);
    String expected = "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O _ O O O O\n" +
            "O _ O O O O O\n" +
            "  _ O O O O\n" +
            "    O O O";

    assertEquals(expected, european1.getGameState());
  }

  /**
   * Test move function when valid 'from' position and 'to' position are put in and the marble is
   * moving downward.
   */
  @Test
  public void testCanMove_moveDownward() {
    european1.move(3, 1, 3, 3);
    european1.move(1, 1, 3, 1);
    String expected = "    O O O\n" +
            "  _ O O O O\n" +
            "O _ O O O O O\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O";

    assertEquals(expected, european1.getGameState());
  }

  /**
   * Negative test: Test move function when there is no marble in the from position.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_noMarble_fromP() {
    european1.move(3, 3, 3,
            1);
  }

  /**
   * Negative test: Test move function when the to position is not empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_notEmpty_toP() {
    european1.move(3, 0, 3,
            2);
  }

  /**
   * Negative test: Test move function when the from position is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_invalid_fromP() {
    european1.move(0, 0, 0,
            2);
  }

  /**
   * Negative test: Test move function when the to position is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_invalid_toP() {
    european1.move(0, 2, 0,
            0);
  }

  /**
   * Negative test: Test move function when the marble is trying to jumping over more than one
   * marbles.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_invalid_jumpOverTwoMarbles() {
    european1.move(3, 0,
            3, 3);
  }

  /**
   * Negative test: Test move function when there is no marble between the from and the to
   * position.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_noMarbleInMiddle() {
    european1.move(3, 1, 3, 3);
    european1.move(3, 0, 3, 2);
  }


  /**
   * This function tests isGameOver function when only one marble is left.
   */
  @Test
  public void testIsGameOver_true() {
    european3.move(0, 2, 0, 4);
    assertTrue(european3.isGameOver());
  }

  /**
   * This function tests isGameOver function when there is movable marble.
   */
  @Test
  public void testIsGameOver_false() {
    assertFalse(european3.isGameOver());
  }

  /**
   * Test getGameState function when the game is over.
   */
  @Test
  public void testGetGameState() {
    String expected = "    _ _ O\n" +
            "  _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "  _ _ _ _ _\n" +
            "    _ _ _";

    european3.move(0, 2, 0, 4);
    assertEquals(expected, european3.getGameState());
  }

  /**
   * Test getGameState function for the initial game board.
   */
  @Test
  public void testGetGameState_initialBoard() {
    String expected = "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O";

    assertEquals(expected, european1.getGameState());
  }

  /**
   * Test getGameState function when the game board is empty.
   */
  @Test
  public void testGetGameState_EmptyBoard() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl(1);
    String expected = "_";
    assertEquals(expected, m.getGameState());
  }

  /**
   * Test getGameState function for the initial game board.
   */
  @Test
  public void testGetScore() {
    assertEquals(36, european1.getScore());
  }

  /**
   * Test getGameState function after one move.
   */
  @Test
  public void testGetScore_oneMove() {
    european1.move(3, 1, 3, 3);
    assertEquals(35, european1.getScore());
  }

  /**
   * Test getGameState function when there is no marble on the board.
   */
  @Test
  public void testGetScore_NoMarble() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl(1);
    assertEquals(0, m.getScore());
  }

  /**
   * This function tests getGameState function when the game is over.
   **/
  @Test
  public void testGetScore_gameOver() {
    european3.move(0, 2, 0, 4);
    assertEquals(1, european3.getScore());
  }


}