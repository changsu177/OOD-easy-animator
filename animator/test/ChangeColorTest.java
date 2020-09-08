import org.junit.Test;

import java.util.Arrays;

import cs5004.animator.model.ChangeColor;
import cs5004.animator.model.IMotion;
import cs5004.animator.model.MotionType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This class tests functions from ChangeColor class in terms of the validity of inputs and
 * possible color change motion.
 */

public class ChangeColorTest {


  @Test
  public void testValidConstructor() {
    IMotion c = new ChangeColor(0, 0, 1, 0, 1, 0,
            "R", 50, 70);
    assertEquals(Arrays.asList(0, 0, 1, 0, 1, 0), c.getNum());
    assertEquals("Shape R changes color from (0,0,1) to (0,1,0) from t=50 to t=70",
            c.toString());
    assertEquals(MotionType.CHANGECOLOR, c.getType());
  }

  @Test
  public void testInvalidConstructorFromR() {
    try {
      IMotion c = new ChangeColor(256, 1, 0, 256, 1, 0,
              "R", 50, 70);
      fail("Invalid input");
    } catch (IllegalArgumentException e) {
      //pass.
    }
  }

  @Test
  public void testInvalidConstructorFromG() {
    try {
      IMotion c = new ChangeColor(0, 256, 0, 0, 256, 0,
              "R", 50, 70);
      fail("Invalid input");
    } catch (IllegalArgumentException e) {
      //pass.
    }
  }

  @Test
  public void testInvalidConstructorFromB() {
    try {
      IMotion c = new ChangeColor(0, 1, -20, 0, 1, 2,
              "R", 50, 70);
      fail("Invalid input");
    } catch (IllegalArgumentException e) {
      //pass.
    }
  }

  @Test
  public void testInvalidConstructorToR() {
    try {
      IMotion c = new ChangeColor(0, 1, 0, 256, 1, 0,
              "R", 50, 70);
      fail("Invalid input");
    } catch (IllegalArgumentException e) {
      //pass.
    }
  }

  @Test
  public void testInvalidConstructorToB() {
    try {
      IMotion c = new ChangeColor(254, 1, 0, 254, 1, -20,
              "R", 50, 70);
      fail("Invalid input");
    } catch (IllegalArgumentException e) {
      //pass.
    }
  }

  @Test
  public void testInvalidConstructorToG() {
    try {
      IMotion c = new ChangeColor(254, 1, 0, 254, -1, 0,
              "R", 50, 70);
      fail("Invalid input");
    } catch (IllegalArgumentException e) {
      //pass.
    }
  }
}
