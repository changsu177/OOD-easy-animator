
import org.junit.Test;

import java.util.Arrays;

import cs5004.animator.model.IMotion;
import cs5004.animator.model.MotionType;
import cs5004.animator.model.Move;

import static org.junit.Assert.assertEquals;

/**
 * This class tests functions from the Move class in terms of the validity of inputs and possible
 * move motion.
 */

public class MoveTest {


  private IMotion m;

  public MoveTest()  {
    m = new Move(200, 200, 300, 300, "R", 10,
            50);
  }

  /**
   * This function tests getNum function.
   */
  @Test
  public void testGetNum() {
    assertEquals(Arrays.asList(200, 200, 300, 300), m.getNum());
  }

  /**
   * This function tests getNum function.
   */
  @Test
  public void testToString() {
    assertEquals("Shape R moves from (200,200) to (300,300) from t=10 to t=50",
            m.toString());
  }

  /**
   * This function tests getType function.
   */
  @Test
  public void testGetType() {
    assertEquals(MotionType.MOVE, m.getType());
  }


}
