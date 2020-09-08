import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.IModel;
import cs5004.animator.model.IMotion;
import cs5004.animator.model.IReadOnlyShape;
import cs5004.animator.model.Model;
import cs5004.animator.model.ShapeType;

import static org.junit.Assert.assertEquals;

/**
 * Test functions from model class.
 */
public class ModelTest {
  IModel m = new Model();

  @Before
  public void setUp() throws Exception {
    m.addShape(ShapeType.RECTANGLE, 0, 50, 50, 50, 0, 0, 1, "C",
            3, 90);
    m.addShape(ShapeType.OVAL, 10, 10, 40, 55, 0, 1, 3, "J",
            0, 100);
  }

  /**
   * Test addShape function. Shape "C" with latter appear time was added first, but in the printed
   * state, it was printed after "J" which has earlier appear time. So the sort works.
   */
  @Test
  public void testAddShape() {
    assertEquals("Shapes:\n" +
            "Name: J\n" +
            "Type: oval\n" +
            "Center: (10,10) X radius: 40 Y radius: 55, Color: (0,1,3)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: C\n" +
            "Type: rectangle\n" +
            "Min corner: (0,50), Width: 50, Height: 50, Color: (0,0,1)\n" +
            "Appears at t=3\n" +
            "Disappears at t=90\n", m.getState());
  }

  /**
   * This function tests addMove function.
   */
  @Test
  public void testAddMove() {

    m.addMove(10, 10, 50, 50, "C", 20, 50);
    m.addMove(10, 10, 50, 50, "J", 10, 50);

    assertEquals("Shapes:\n" +
            "Name: C\n" +
            "Type: rectangle\n" +
            "Min corner: (0,50), Width: 50, Height: 50, Color: (0,0,1)\n" +
            "Appears at t=3\n" +
            "Disappears at t=90\n" +
            "Name: J\n" +
            "Type: oval\n" +
            "Center: (10,10) X radius: 40 Y radius: 55, Color: (0,1,3)\n" +
            "Appears at t=10\n" +
            "Disappears at t=100\n" +
            "\n" +
            "\n" +
            "Shape J moves from (10,10) to (50,50) from t=10 to t=50\n" +
            "Shape C moves from (10,10) to (50,50) from t=20 to t=50\n", m.getState());
  }

  /**
   * This function tests addChangeColor function.
   */
  @Test
  public void testChangeColor() {

    m.addChangeColor(0, 0, 1, 0, 1, 0, "C", 50,
            80);
    assertEquals("Shapes:\n" +
            "Name: J\n" +
            "Type: oval\n" +
            "Center: (10,10) X radius: 40 Y radius: 55, Color: (0,1,3)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: C\n" +
            "Type: rectangle\n" +
            "Min corner: (0,50), Width: 50, Height: 50, Color: (0,0,1)\n" +
            "Appears at t=3\n" +
            "Disappears at t=90\n" +
            "\n" +
            "Shape C changes color from (0,0,1) to (0,1,0) from t=50 to t=80\n", m.getState());
  }

  /**
   * This function tests addScale function.
   */
  @Test
  public void testAddScales() {
    m.addScale(50, 100, 25, 100, "J", 51, 70);
    assertEquals("Shapes:\n" +
            "Name: C\n" +
            "Type: rectangle\n" +
            "Min corner: (0,50), Width: 50, Height: 50, Color: (0,0,1)\n" +
            "Appears at t=3\n" +
            "Disappears at t=90\n" +
            "Name: J\n" +
            "Type: oval\n" +
            "Center: (10,10) X radius: 40 Y radius: 55, Color: (0,1,3)\n" +
            "Appears at t=51\n" +
            "Disappears at t=100\n" +
            "\n" +
            "\n" +
            "Shape J scales from Width: 50, Height: 100 to Width: 25, Height: 100 from t=51 " +
            "to t=70\n", m.getState());
  }

  /**
   * Test outPutShapes function.
   */
  @Test
  public void testOutPutShapes() {
    StringBuilder sb = new StringBuilder();
    for (IReadOnlyShape shape : m.outputShapes()) {
      sb.append(shape.toString());
    }

    assertEquals("Name: J\n" +
            "Type: oval\n" +
            "Center: (10,10) X radius: 40 Y radius: 55, Color: (0,1,3)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "Name: C\n" +
            "Type: rectangle\n" +
            "Min corner: (0,50), Width: 50, Height: 50, Color: (0,0,1)\n" +
            "Appears at t=3\n" +
            "Disappears at t=90", sb.toString());

  }

  /**
   * Test getState function.
   */
  @Test
  public void testGetState() {
    m.addScale(50, 100, 25, 100, "J", 51, 70);
    m.addMove(10, 10, 50, 50, "J", 10, 50);
    m.addChangeColor(0, 0, 1, 0, 1, 0, "C", 50,
            80);

    assertEquals("Shapes:\n" +
            "Name: C\n" +
            "Type: rectangle\n" +
            "Min corner: (0,50), Width: 50, Height: 50, Color: (0,0,1)\n" +
            "Appears at t=3\n" +
            "Disappears at t=90\n" +
            "Name: J\n" +
            "Type: oval\n" +
            "Center: (10,10) X radius: 40 Y radius: 55, Color: (0,1,3)\n" +
            "Appears at t=10\n" +
            "Disappears at t=100\n" +
            "\n" +
            "\n" +
            "Shape J moves from (10,10) to (50,50) from t=10 to t=50\n" +
            "Shape C changes color from (0,0,1) to (0,1,0) from t=50 to t=80\n" +
            "Shape J scales from Width: 50, Height: 100 to Width: 25, Height: 100 from t=51 " +
            "to t=70\n", m.getState());
  }

  /**
   * Test outputMotions function.
   */
  @Test
  public void testOutputMotions() {
    m.addMove(10, 10, 50, 50, "C", 20, 50);
    m.addMove(10, 10, 50, 50, "J", 10, 50);
    StringBuilder sb = new StringBuilder();
    for (IMotion motion : m.outputMotions()) {
      sb.append(motion.toString() + "\n");
    }

    assertEquals("Shape J moves from (10,10) to (50,50) from t=10 to t=50\n" +
            "Shape C moves from (10,10) to (50,50) from t=20 to t=50\n", sb.toString());
  }

  // Negative tests from now on

  /**
   * Test addShape function when two shapes with the same name are added.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddShape_dupName() {
    m.addShape(ShapeType.RECTANGLE, 1, 50, 10, 50, 0, 0, 1, "C",
            10, 90);
  }

  /**
   * Test addShape function when adding a shape with wrong time interval.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddShape_wrongTime() {
    m.addShape(ShapeType.RECTANGLE, 1, 50, 10, 50, 0, 0, 1, "B",
            10, 5);
  }


  /**
   * Test addMotion function when there is no corresponding shape created.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddMotion_noShape() {
    m.addMove(10, 10, 50, 50, "B",
            20, 50);
  }


}