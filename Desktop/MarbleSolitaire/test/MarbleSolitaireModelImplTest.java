import org.junit.Before;
import org.junit.Test;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This function test methods from MarbleSolitaireModelImpl class.
 */
public class MarbleSolitaireModelImplTest {

  private MarbleSolitaireModel ms;
  private MarbleSolitaireModel mo;

  @Before
  public void setUp() throws Exception {
    ms = new MarbleSolitaireModelImpl();
    mo = new MarbleSolitaireModelImpl();
    mo.move(1, 3, 3, 3);
    mo.move(2, 5, 2, 3);
    mo.move(0, 4, 2, 4);
    mo.move(3, 4, 1, 4);
    mo.move(0, 2, 0, 4);
    mo.move(0, 4, 2, 4);

    mo.move(5, 4, 3, 4);
    mo.move(4, 6, 4, 4);
    mo.move(4, 3, 4, 5);
    mo.move(2, 6, 4, 6);
    mo.move(4, 6, 4, 4);
    mo.move(4, 1, 4, 3);


    mo.move(6, 2, 4, 2);
    mo.move(3, 2, 5, 2);
    mo.move(6, 4, 6, 2);
    mo.move(6, 2, 4, 2);
    mo.move(1, 2, 3, 2);
    mo.move(2, 0, 2, 2);
    mo.move(2, 3, 2, 1);

    mo.move(4, 0, 2, 0);
    mo.move(2, 0, 2, 2);
    mo.move(4, 3, 4, 5);
    mo.move(4, 5, 2, 5);
    mo.move(2, 5, 2, 3);
    mo.move(2, 3, 2, 1);

    mo.move(2, 1, 4, 1);
    mo.move(4, 1, 4, 3);
    mo.move(3, 3, 3, 5);
    mo.move(5, 3, 3, 3);
  }

  /**
   * Test constructor with no parameter.
   */
  @Test
  public void testConstructor_NoParam() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    String expected = "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O";

    assertEquals(expected, m.getGameState());

  }

  /**
   * Test constructor with one parameter (armLength).
   */
  @Test
  public void testConstructor_OneParam_armLenght() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl(5);
    String expected = "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O";
    assertEquals(expected, m.getGameState());
  }

  /**
   * Test constructor with one parameter (armLength), and the input param is 1.
   */
  @Test
  public void testConstructor_OneParam_one() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl(1);
    String expected = "_";
    assertEquals(expected, m.getGameState());
  }

  /**
   * Negative test: test constructor with one parameter, and a even armLength is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_OneParam_evenArmLength() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl(4);
  }

  /**
   * Negative test: test constructor with one parameter, and a negative odd armLength is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_OneParam_negativeArmLength() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl(-3);
  }

  /**
   * Negative test: test constructor with one parameter, and 0 is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_OneParam_zero() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl(0);
  }

  /**
   * Test constructor with two parameter (sRow, sCol).
   */
  @Test
  public void testConstructor_twoParam_sRowsCol() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl(2, 2);
    String expected = "    O O O\n" +
            "    O O O\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O";
    assertEquals(expected, m.getGameState());
  }

  /**
   * Test constructor with two parameter (sRow, sCol), and an invalid position is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_twoParam_Invalid1() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl(1, 1);
  }

  /**
   * Test constructor with two parameter (sRow, sCol), and an invalid position (out of the whole
   * rectangle boundary) is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_twoParam_Invalid2() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl(-1, 3);
  }

  /**
   * Test constructor with two parameter (sRow, sCol), and an invalid position (out of the whole
   * rectangle boundary) is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_twoParam_Invalid3() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl(1, 1);
  }

  /**
   * Test constructor with three parameter (armLength, sRow, sCol).
   */
  @Test
  public void testConstructor_threeParam() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl(5, 5, 5);
    String expected = "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O";
    assertEquals(expected, m.getGameState());
  }

  /**
   * Test constructor with three parameter (armLength, sRow, sCol), and an even armLength is put
   * in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_threeParam_even_armLength() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl(4, 4, 3);
  }

  /**
   * Test constructor with three parameter (armLength, sRow, sCol), and an negative armLength is put
   * in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_threeParam_negative_armLength() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl(-1, 1, 3);
  }

  /**
   * Test constructor with three parameter (armLength, sRow, sCol), and an invalid center position
   * is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_threeParam_invalid_empty() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl(3, 1, 1);
  }


  /**
   * Test move function when valid from position and to position are put in.
   */
  @Test
  public void testCanMove() {

    ms.move(3, 1, 3, 3);
    String expected = "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O _ _ O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O";

    assertEquals(expected, ms.getGameState());

  }

  /**
   * Test move function when there is no marble in the from position.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_noMarble_fromP() {
    ms.move(3, 3, 3, 1);
  }

  /**
   * Test move function when the to position is not empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_notEmpty_toP() {
    ms.move(3, 0, 3, 2);
  }

  /**
   * Test move function when the from position is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_invalid_fromP() {
    ms.move(3, 3, 3, 1);
  }

  /**
   * Test move function when the to position is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_invalid_toP() {
    ms.move(3, 0, 3, 2);
  }

  /**
   * Test move function when the to position is invalid (not empty).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_invalid_jumpOverTwoMarbles() {
    ms.move(3, 0, 3, 3);
  }

  /**
   * Test move function when there is no marble between the from and the to position.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_noMarbleInMiddle() {
    ms.move(3, 1, 3, 3);
    ms.move(3, 0, 3, 2);
  }

  /**
   * This function tests isGameOver function when only one marble is left.
   */
  @Test
  public void testIsGameOver_true_oneMarble() {
    mo.move(3, 2, 3, 4);
    mo.move(3, 5, 3, 3);
    assertTrue(mo.isGameOver());
  }

  /**
   * This function tests isGameOver function when more than one marble are left but none of them can
   * move any more.
   */
  @Test
  public void testIsGameOver_true_MoreThanOneMarble() {

    mo.move(3, 3, 3, 1);
    assertTrue(mo.isGameOver());
  }

  /**
   * This function tests isGameOver function when there is no marble on the game board.
   */
  @Test
  public void testIsGameOver_true_noMarble() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl(1);
    assertTrue(m.isGameOver());
  }

  /**
   * This function tests isGameOver function when there is movable marble.
   */
  @Test
  public void testIsGameOver_false() {

    mo.move(3, 2, 3, 4);
    assertFalse(mo.isGameOver());
  }

  /**
   * Test getGameState function when the game is over.
   */
  @Test
  public void testGetGameState() {
    String expected = "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O _ _ _ O _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _";

    mo.move(3, 3, 3, 1);
    assertEquals(expected, mo.getGameState());
  }

  /**
   * Test getGameState function for the initial game board.
   */
  @Test
  public void testGetGameState_initialBoard() {
    String expected = "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O";

    assertEquals(expected, ms.getGameState());
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
    assertEquals(32, ms.getScore());
  }

  /**
   * Test getGameState function after one move.
   */
  @Test
  public void testGetScore_oneMove() {
    ms.move(3, 1, 3, 3);
    assertEquals(31, ms.getScore());
  }

  /**
   * Test getGameState function when there is no marble on the board.
   */
  @Test
  public void testGetScore_NoMarble() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl(1);
    assertEquals(0, m.getScore());
  }

  /**
   * This function tests getGameState function when the game is over.
   **/
  @Test
  public void testGetScore_gameOver() {
    mo.move(3, 3, 3, 1);
    assertEquals(2, mo.getScore());
  }

}