import org.junit.Before;
import org.junit.Test;

import cs5004.animator.view.TextualView;

import static org.junit.Assert.assertEquals;

/**
 * This function tests functions from the TextualView class. It is to test all the validity of the
 * input and * possible way to view the animation in formatted string..
 */
public class TextualViewTest {
  private TextualView view;

  @Before
  public void setUp() throws Exception {
    view = new TextualView(100);
  }

  @Test
  public void textRectangleToText() {
    view.rectangleToText("j", 12, 12, 45, 56, 34, 45, 12, 1,
            100);
    assertEquals("Shapes:\n" +
            "Name: j\n" +
            "Type: RECTANGLE\n" +
            "Min corner: (12,12), Width: 45,Height: 56, Color: (34, 45, 12)\n" +
            "Appears at t=0\n" +
            "Disappears at t=1\n", view.render());
  }

  @Test
  public void textOvalToText() {
    view.ovalToText("b", 12, 12, 45, 56, 34, 45, 12, 1,
            100);
    assertEquals("Shapes:\n" +
            "Name: b\n" +
            "Type: OVAL\n" +
            "Center: (12,12) X radius: 45, Y radius: 56, Color: (34, 45, 12)\n" +
            "Appears at t=0\n" +
            "Disappears at t=1\n", view.render());
  }

  @Test
  public void textScaleToText() {
    view.ovalToText("b", 12, 12, 45, 56, 34, 45, 12, 1,
            100);
    view.scaleToText("b", 45, 56, 59, 60, 34, 100);

    assertEquals("Shapes:\n" +
            "Name: b\n" +
            "Type: OVAL\n" +
            "Center: (12,12) X radius: 45, Y radius: 56, Color: (34, 45, 12)\n" +
            "Appears at t=0\n" +
            "Disappears at t=1\n" +
            "\n" +
            "Shape b scales from Width: 45, Height: 56 to Width: 59, Height: 60 from t=0 to t=1\n",
            view.render());
  }

  @Test
  public void textChangeColorToText() {
    view.ovalToText("b", 12, 12, 45, 56, 0, 0, 0, 1, 100);
    view.changeColorToText("b", 0, 0, 0, 0, 0, 255, 10,
            60);

    assertEquals("Shapes:\n" +
            "Name: b\n" +
            "Type: OVAL\n" +
            "Center: (12,12) X radius: 45, Y radius: 56, Color: (0, 0, 0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=1\n" +
            "\n" +
            "Shape b changes color from (0,0,0) to (0,0,255) from t=0 to t=0\n", view.render());
  }

  @Test
  public void text() {
    view.ovalToText("b", 12, 12, 45, 56, 0, 0, 0, 1, 100);
    view.moveToText("b", 12, 12, 20, 20, 1, 60);

    assertEquals("Shapes:\n" +
            "Name: b\n" +
            "Type: OVAL\n" +
            "Center: (12,12) X radius: 45, Y radius: 56, Color: (0, 0, 0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=1\n" +
            "\n" +
            "Shape b moves from (12,12) to (20,20) from t=0 to t=0\n", view.render());
  }

}