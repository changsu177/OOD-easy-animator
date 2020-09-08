import org.junit.Before;
import org.junit.Test;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;
import cs5004.marblesolitaire.model.hw08.TriangleSolitaireModelImpl;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This function test methods from TriangleSolitaireModelImpl class.
 */
public class TriangleSolitaireModelImplTest {

  private MarbleSolitaireModel triangle1;
  private MarbleSolitaireModel triangle2;
  private MarbleSolitaireModel triangle3;

  @Before
  public void setUp() throws Exception {
    triangle1 = new TriangleSolitaireModelImpl();
    triangle3 = new TriangleSolitaireModelImpl(4);
    triangle3.move(2, 0, 0, 0);
    triangle3.move(2, 2, 2, 0);
    triangle3.move(0, 0, 2, 2);
    triangle3.move(3, 3, 1, 1);
    triangle3.move(3, 0, 1, 0);


  }


  /**
   * Test constructor with no parameter.
   */
  @Test
  public void testConstructor_NoParam() {
    String expected = "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O";

    assertEquals(expected, triangle1.getGameState());
  }


  /**
   * Test constructor with one parameter (dimensions).
   */
  @Test
  public void testConstructor_OneParam() {
    triangle2 = new TriangleSolitaireModelImpl(7);
    String expected = "      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O";
    assertEquals(expected, triangle2.getGameState());
  }

  /**
   * Test constructor with one parameter (dimensions), and there is only an empty slot being
   * created.
   */
  @Test
  public void testConstructor_OneParam_one() {
    triangle2 = new TriangleSolitaireModelImpl(1);
    String expected = "_";
    assertEquals(expected, triangle2.getGameState());
  }

  /**
   * Negative test: test constructor with one parameter, and a negative dimensions is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_OneParam_negativeDimensions() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(-3);
  }

  /**
   * Negative test: test constructor with one parameter, and 0 is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_OneParam_zero() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(0);
  }

  /**
   * Test constructor with two parameter (row, col).
   */
  @Test
  public void testConstructor_twoParam1() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(4, 3);
    String expected = "    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O _ O";
    assertEquals(expected, m.getGameState());
  }

  /**
   * Test constructor with two parameter (row, col).
   */
  @Test
  public void testConstructor_twoParam2() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(4, 4);
    String expected = "    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O _";
    assertEquals(expected, m.getGameState());
  }

  /**
   * Test constructor with two parameter (row, col), and an invalid position is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_twoParam_Invalid1() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(0, 1);
  }

  /**
   * Test constructor with two parameter (row, col), and an invalid position is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_twoParam_Invalid2() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(3, 4);
  }

  /**
   * Test constructor with two parameter (row, col), and an invalid position (out of the whole
   * rectangle boundary) is put in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_twoParam_Invalid3() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(-1, 3);
  }


  /**
   * Test constructor with three parameter (dimensions, row, col).
   */
  @Test
  public void testConstructor_threeParam1() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(6, 5, 5);
    String expected = "     O\n" +
            "    O O\n" +
            "   O O O\n" +
            "  O O O O\n" +
            " O O O O O\n" +
            "O O O O O _";
    assertEquals(expected, m.getGameState());

  }

  /**
   * Test constructor with three parameter (dimensions, row, col).
   */
  @Test
  public void testConstructor_threeParam2() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(3, 1, 1);
    String expected = "  O\n" +
            " O _\n" +
            "O O O";
    assertEquals(expected, m.getGameState());
  }

  /**
   * Test constructor with three parameter (dimensions, row, col), the empty position is out of the
   * board boundary.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_threeParam_invalid_empty() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(4, 4, 3);
  }

  /**
   * Test constructor with three parameter (dimensions, row, col), the empty position is out of the
   * board boundary.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_threeParam_invalid_empty2() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(2, 0, 1);
  }

  /**
   * Test constructor with three parameter (dimensions, row, col), and an negative dimensions is put
   * in.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_threeParam_negative_dimension() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(-4, 3, 1);
  }

  /**
   * Test move function when valid 'from' position and 'to' position are put in and the marble is
   * moving 2 slots away diagonally to its upper right slot.
   */
  @Test
  public void testCanMove_upperRight() {
    triangle1.move(2, 0, 0, 0);
    String expected = "    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O";

    assertEquals(expected, triangle1.getGameState());
  }

  /**
   * Test move function when valid 'from' position and 'to' position are put in and the marble is
   * moving 2 slots away diagonally to its upper left slot.
   */
  @Test
  public void testCanMove_upperLeft() {
    triangle1.move(2, 2, 0, 0);
    String expected = "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O";

    assertEquals(expected, triangle1.getGameState());
  }

  /**
   * Test move function when valid 'from' position and 'to' position are put in and the marble is
   * moving rightward to the empty slot 2 slots away.
   */
  @Test
  public void testCanMove_rightward() {
    triangle1.move(2, 2, 0, 0);
    triangle1.move(2, 0, 2, 2);
    String expected = "    O\n" +
            "   O _\n" +
            "  _ _ O\n" +
            " O O O O\n" +
            "O O O O O";

    assertEquals(expected, triangle1.getGameState());
  }

  /**
   * Test move function when valid 'from' position and 'to' position are put in and the marble is
   * moving leftward to the empty slot 2 slots away.
   */
  @Test
  public void testCanMove_leftward() {
    triangle1.move(2, 0, 0, 0);
    triangle1.move(2, 2, 2, 0);
    String expected = "    O\n" +
            "   _ O\n" +
            "  O _ _\n" +
            " O O O O\n" +
            "O O O O O";

    assertEquals(expected, triangle1.getGameState());
  }

  /**
   * Test move function when valid 'from' position and 'to' position are put in and the marble is
   * moving 2 slots away diagonally to its lower left slot.
   */
  @Test
  public void testCanMove_lowerLeft() {
    triangle2 = new TriangleSolitaireModelImpl(3, 1);
    triangle2.move(1, 1, 3, 1);

    String expected = "    O\n" +
            "   O _\n" +
            "  O _ O\n" +
            " O O O O\n" +
            "O O O O O";

    assertEquals(expected, triangle2.getGameState());
  }

  /**
   * Test move function when valid 'from' position and 'to' position are put in and the marble is
   * moving 2 slots away diagonally to its lower left slot.
   */
  @Test
  public void testCanMove_lowerRight() {
    triangle2 = new TriangleSolitaireModelImpl(3, 2);
    triangle2.move(1, 0, 3, 2);

    String expected = "    O\n" +
            "   _ O\n" +
            "  O _ O\n" +
            " O O O O\n" +
            "O O O O O";

    assertEquals(expected, triangle2.getGameState());
  }

  /**
   * Negative test: Test move function when the marble is trying to move to the empty slot 2 rows
   * right below it.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_downward() {
    triangle2 = new TriangleSolitaireModelImpl(3, 2);
    triangle2.move(1, 0, 3, 2);
    triangle2.move(0, 0, 2, 1);

    String stateBeforeMove =
            "        O\n" +
                    "      _   O\n" +
                    "    O   _   O\n" +
                    "  O   O   O   O\n" +
                    "O   O   O   O   O";


  }

  /**
   * Negative test: Test move function when the marble is trying to move to the empty slot 2 rows
   * right above it.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_upward() {
    triangle2 = new TriangleSolitaireModelImpl(3, 2);
    triangle2.move(1, 0, 3, 2);
    triangle2.move(4, 2, 2, 1);

    String stateBeforeMove =
            "        O\n" +
                    "      _   O\n" +
                    "    O   _   O\n" +
                    "  O   O   O   O\n" +
                    "O   O   O   O   O";

  }


  /**
   * Negative test: Test move function when there is no marble in the "from" position.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_noMarble_fromP() {
    triangle1.move(0, 0, 2,
            0);
  }

  /**
   * Test move function when the "to" position is not empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_notEmpty_toP() {
    triangle1.move(3, 0, 1,
            0);
  }

  /**
   * Negative test: Test move function when the from position is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_invalid_fromP() {
    triangle1.move(2, 3, 2,
            1);
  }

  /**
   * Negative test: Test move function when the to position is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_invalid_toP() {
    triangle1.move(2, 1, 2,
            3);
  }

  /**
   * Negative test: Test move function when the marble is trying to jumping over more than one
   * marbles.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_invalid_jumpOverTwoMarbles() {
    triangle1.move(3, 0,
            0, 0);
  }

  /**
   * Negative test: Test move function when there is no marble between the from and the to
   * position.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCanMove_noMarbleInMiddle() {
    triangle2 = new TriangleSolitaireModelImpl(3, 2);
    triangle2.move(1, 0, 3, 2);
    triangle2.move(3, 2, 1, 0);

  }

  /**
   * This function tests isGameOver function when more than one marble are left but none of them can
   * move any more.
   */
  @Test
  public void testIsGameOver_true_MoreThanOneMarble() {

    triangle3.move(3, 2, 3, 0);
    assertTrue(triangle3.isGameOver());
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
   * This function tests isGameOver function when there is movable marble. (right)
   */
  @Test
  public void testIsGameOver_false1() {
    assertFalse(triangle3.isGameOver());
  }

  /**
   * This function tests isGameOver function when there is movable marble. (upper left / upper
   * right)
   */
  @Test
  public void testIsGameOver_false2() {
    assertFalse(triangle1.isGameOver());
  }

  /**
   * This function tests isGameOver function when there is movable marble. (upper left / upper
   * right)
   */
  @Test
  public void testIsGameOver_false3() {
    triangle2 = new TriangleSolitaireModelImpl(3, 2, 2);
    assertFalse(triangle2.isGameOver());
  }


  /**
   * Test getGameState function when the game is over.
   */
  @Test
  public void testGetGameState() {
    String expected = "   _\n" +
            "  O O\n" +
            " _ _ _\n" +
            "O _ _ _";
    triangle3.move(3, 2, 3, 0);
    assertEquals(expected, triangle3.getGameState());
  }

  /**
   * Test getGameState function for the initial game board.
   */
  @Test
  public void testGetGameState_initialBoard() {
    String expected = "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O";

    assertEquals(expected, triangle1.getGameState());
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
    assertEquals(14, triangle1.getScore());
  }

  /**
   * Test getGameState function after one move.
   */
  @Test
  public void testGetScore_oneMove() {
    triangle1.move(2, 0, 0, 0);
    assertEquals(13, triangle1.getScore());
  }

  /**
   * Test getGameState function when there is no marble on the board.
   */
  @Test
  public void testGetScore_NoMarble() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(1);
    assertEquals(0, m.getScore());
  }

  /**
   * This function tests getGameState function when the game is over.
   **/
  @Test
  public void testGetScore_gameOver() {
    triangle3.move(3, 2, 3, 0);
    assertEquals(3, triangle3.getScore());
  }
}
