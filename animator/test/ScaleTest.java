import org.junit.Test;

import java.util.Arrays;

import cs5004.animator.model.IMotion;
import cs5004.animator.model.MotionType;
import cs5004.animator.model.Scale;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

/**
 * This class tests functions from the Scale class in terms of the validity of inputs and possible
 * scale motion.
 */

public class ScaleTest {

  private IMotion s;

  public ScaleTest() {
    s = new Scale(50, 100, 25, 100, "R",
            51, 70);
  }

  /**
   * This function tests getNum function.
   */
  @Test
  public void testGetNum() {
    assertEquals(Arrays.asList(50, 100, 25, 100), s.getNum());
  }

  /**
   * This function tests getNum function.
   */
  @Test
  public void testToString() {
    assertEquals("Shape R scales from Width: 50, Height: 100 "
                    + "to Width: 25, Height: 100 from t=51 to t=70",
            s.toString());
  }

  /**
   * This function tests getType function.
   */
  @Test
  public void testGetType() {
    assertEquals(MotionType.SCALE, s.getType());
  }

  /**
   * This function tests constructor when the fromX is invalid.
   */
  @Test
  public void testInvalidConstructorFromX() {
    try {
      IMotion s = new Scale(-20, 200, 300, 300, "R", 10,
              50);
      fail("Invalid input");
    } catch (IllegalArgumentException e) {
      //pass.
    }
  }

  /**
   * This function tests constructor when the fromY is invalid.
   */
  @Test
  public void testInvalidConstructorFromY() {
    try {
      IMotion s = new Scale(200, -200, 300, 300, "R", 10,
              50);
      fail("Invalid input");
    } catch (IllegalArgumentException e) {
      //pass.
    }
  }

  /**
   * This function tests constructor when the ToX is invalid.
   */
  @Test
  public void testInvalidConstructorToX() {
    try {
      IMotion s = new Scale(200, 200, -300, 300, "R", 10,
              50);
      fail("Invalid input");
    } catch (IllegalArgumentException e) {
      //pass.
    }
  }

  /**
   * This function tests constructor when the ToY is invalid.
   */
  @Test
  public void testInvalidConstructorToY() {
    try {
      IMotion s = new Scale(200, 200, 300, -300, "R", 10,
              50);
      fail("Invalid input");
    } catch (IllegalArgumentException e) {
      //pass.
    }
  }

}