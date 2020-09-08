
import org.junit.Test;

import cs5004.animator.model.IShape;
import cs5004.animator.model.Oval;

import static org.junit.Assert.assertEquals;

/**
 * This class tests functions from the Rectangle class.
 */
public class OvalTest {

  /**
   * Test constructor for the Oval class when the time interval is invalid (atime is greater
   * dtime).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_invalidTime() {
    IShape t = new Oval(200, 200, 50, 100, 1, 0, 0, "R",
            30, 25);
  }

  /**
   * Test constructor for the Oval class when its width or height is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_invalidSize() {
    IShape t = new Oval(200, 200, -3, 100, 1, 0, 0, "R",
            3, 25);
  }

  /**
   * Test constructor for the Oval class when its color code is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_invalidColor() {
    IShape t = new Oval(200, 200, 3, 100, 1, -1, 0, "R",
            3, 25);
  }

  /**
   * Test all getter functions from the Rectangle class.
   */
  @Test
  public void testValidConstructor() {
    IShape o = new Oval(200, 200, 50, 100, 1, 0, 0, "R",
            1, 100);
    assertEquals(200, o.getX(), 0.01);
    assertEquals(200, o.getY(), 0.01);
    assertEquals(50, o.getW(), 0.01);
    assertEquals(100, o.getH(), 0.01);
    assertEquals(1, o.getR(), 0.01);
    assertEquals(0, o.getG(), 0.01);
    assertEquals(0, o.getB(), 0.01);
    assertEquals("R", o.getName());
    assertEquals(1, o.getATime(), 0.01);
    assertEquals(100, o.getDTime(), 0.01);
  }

  /**
   * This function tests toString method.
   */
  @Test
  public void testToString() {
    IShape o = new Oval(200, 200, 50, 100, 1, 0, 0, "R",
            1, 100);
    assertEquals("Name: R\n" +
            "Type: oval\n" +
            "Center: (200,200) X radius: 50 Y radius: 100, Color: (1,0,0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n", o.toString());
  }
}
