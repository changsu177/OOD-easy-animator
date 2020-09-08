
import org.junit.Test;

import cs5004.animator.model.IShape;
import cs5004.animator.model.Rectangle;

import static org.junit.Assert.assertEquals;

/**
 * This class tests functions from the Rectangle class.
 */
public class RectangleTest {

  /**
   * Test constructor for the Rectangle class when the time interval is invalid (atime is greater
   * dtime).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_invalidTime() {
    IShape t = new Rectangle(200, 200, 50, 100, 1, 0, 0, "R",
            30, 25);
  }

  /**
   * Test constructor for the Rectangle class when its width or height is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_invalidSize() {
    IShape t = new Rectangle(200, 200, -3, 100, 1, 0, 0, "R",
            3, 25);
  }

  /**
   * Test constructor for the Rectangle class when its color code is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_invalidColor() {
    IShape t = new Rectangle(200, 200, 3, 100, 1, -1, 0, "R",
            3, 25);
  }

  /**
   * Test all getter functions from the Rectangle class.
   */
  @Test
  public void testGetterFunc() {
    IShape t = new Rectangle(200, 200, 50, 100, 1, 0, 0, "R",
            1, 100);
    assertEquals(200, t.getX(), 0.01);
    assertEquals(200, t.getY(), 0.01);
    assertEquals(50, t.getW(), 0.01);
    assertEquals(100, t.getH(), 0.01);
    assertEquals(1, t.getR(), 0.01);
    assertEquals(0, t.getG(), 0.01);
    assertEquals(0, t.getB(), 0.01);
    assertEquals("R", t.getName());
    assertEquals(1, t.getATime(), 0.01);
    assertEquals(100, t.getDTime(), 0.01);
  }

  /**
   * This function tests toString method.
   */
  @Test
  public void testToString() {
    IShape t = new Rectangle(200, 200, 50, 100, 1, 0, 0, "R",
            1, 100);
    assertEquals("Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200,200), Width: 50, Height: 100, Color: (1,0,0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100", t.toString());
  }
}
