package cs5004.animator.view;

import java.io.IOException;

/**
 * This is a TextualView class that implements IView. It will convert the animation including
 * motions and shapes to a text format and render a String that containing all the message to the
 * caller.
 */
public class TextualView implements IView {
  private Appendable ap;
  private int speed;

  /**
   * This is a constructor for the TextualView. Fields are initialized in here.
   *
   * @param speed the speed of the frame to be delivered.
   */
  public TextualView(int speed) {
    ap = new StringBuilder();
    this.speed = speed;
    helper("Shapes:\n");
  }

  /**
   * Generate a text message when creating a rectangle object and append this message to the global
   * StringBuilder.
   *
   * @param x     the x coordinate of the position of this object.
   * @param y     the y coordinate of the position of this object.
   * @param w     the width of this rectangle.
   * @param h     the height of this rectangle.
   * @param r     the red code of this shape.
   * @param g     the green code of this shape.
   * @param b     the blue code of this shape.
   * @param name  the name of this shape.
   * @param atime the time that this shape will be added to the frame.
   * @param dtime the time that this shape will be removed from the frame.
   */
  public void rectangleToText(String name, int x, int y, int w, int h, int r, int g, int b,
                              int atime, int dtime) {
    String text =
            "Name: " + name + "\n" + "Type: RECTANGLE" + "\n"
                    + "Min corner: (" + x + "," + y + "), Width: " + w + ","
                    + "Height: " + h + ", Color: (" + r + ", " + g + ", " + b + ")\n"
                    + "Appears at t=" + atime / speed + "\n"
                    + "Disappears at t=" + dtime / speed + "\n";
    helper(text);
  }

  /**
   * Generate a text message when creating a oval object and append this message to the global
   * StringBuilder.
   *
   * @param x     the x coordinate of the position of this object.
   * @param y     the y coordinate of the position of this object.
   * @param w     the width of this rectangle.
   * @param h     the height of this rectangle.
   * @param r     the red code of this shape.
   * @param g     the green code of this shape.
   * @param b     the blue code of this shape.
   * @param name  the name of this shape.
   * @param atime the time that this shape will be added to the frame.
   * @param dtime the time that this shape will be removed from the frame.
   */
  public void ovalToText(String name, int x, int y, int w, int h, int r, int g, int b,
                         int atime, int dtime) {
    String text = "Name: " + name + "\n" + "Type: OVAL" + "\n"
            + "Center: (" + x + "," + y + ") X radius: " + w
            + ", Y radius: " + h + ", Color: (" + r + ", " + g + ", " + b + ")"
            + "\nAppears at t=" + atime / speed + "\n"
            + "Disappears at t=" + dtime / speed + "\n";
    helper(text);

  }

  /**
   * Generate a text message when moving a shape object and append this message to the global
   * StringBuilder.
   *
   * @param name  The name of the shape
   * @param f1    The initial x-position of the shape
   * @param f2    The initial y-position of the shape
   * @param t1    The final x-position of the shape
   * @param t2    The final y-position of the shape
   * @param atime The start time of this transformation
   * @param dtime The end time of this transformation
   */
  public void moveToText(String name, int f1, int f2, int t1, int t2, int atime, int dtime) {
    String text = "\nShape " + name + " moves from (" + f1 + "," + f2 + ") " + "to (" + t1 + ","
            + t2 + ") from t=" + atime / speed + " to t=" + dtime / speed + "\n";
    helper(text);

  }

  /**
   * Generate a text message when scaling a shape object and append this message to the global
   * StringBuilder.
   *
   * @param name  The name of the shape.
   * @param f1    The initial width of the shape
   * @param f2    The initial height of the shape
   * @param t1    The final width of the shape
   * @param t2    The final height of the shape
   * @param atime The start time of this transformation
   * @param dtime The end time of this transformation
   */
  public void scaleToText(String name, int f1, int f2, int t1, int t2, int atime, int dtime) {
    String text = "\nShape " + name + " scales from Width: " + f1 + ", Height: " + f2 +
            " to Width: " + t1 + ", Height: " + t2 + " from t=" + atime / speed + " to t=" +
            dtime / speed + "\n";
    helper(text);
  }

  /**
   * Generate a text message when changing the color of a shape object and append this message to
   * the global StringBuilder.
   *
   * @param name  The name of the shape
   * @param f1    The initial red color-value of the shape
   * @param f2    The initial green color-value of the shape
   * @param f3    The initial blue color-value of the shape
   * @param t1    The final red color-value of the shape
   * @param t2    The final green color-value of the shape
   * @param t3    The final blue color-value of the shape
   * @param atime The start time of this transformation
   * @param dtime The end time of this transformation
   */
  public void changeColorToText(String name, int f1, int f2, int f3, int t1, int t2, int t3,
                                int atime, int dtime) {
    String text = "\nShape " + name + " changes color from (" + f1 + "," + f2 + "," + f3 + ") "
            + "to (" + t1 + "," + t2 + "," + t3 + ") from t=" + atime / speed + " to t="
            + dtime / speed + "\n";
    helper(text);
  }

  /**
   * Return the textual animation.
   *
   * @return a string that holds all message that has been appended to the StringBuilder so fae.
   */
  public String render() {
    return ap.toString();
  }

  /**
   * This is a helper function to append the text message to the stringBuilder, and catch
   * IOException when it occurs.
   *
   * @param text the text to be appended to the stringBuilder.
   */
  private void helper(String text) {
    try {
      ap.append(text);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}

