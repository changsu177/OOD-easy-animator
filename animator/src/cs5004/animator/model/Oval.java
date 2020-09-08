package cs5004.animator.model;

/**
 * This class represent a oval class that extends AbstractShape. It supports all the operations from
 * AbstractShape and shares the same features with other shape class.
 */
public class Oval extends Shape {

  /**
   * Constructor for the rectangle class.
   *
   * @param x     the x coordinate of the position of this object.
   * @param y     the y coordinate of the position of this object.
   * @param w     the x radius of this oval.
   * @param h     the y radius of this oval.
   * @param r     the red code of this shape.
   * @param g     the green code of this shape.
   * @param b     the blue code of this shape.
   * @param name  the name of this shape.
   * @param atime the time that this shape will be added to the frame.
   * @param dtime the time that this shape will be removed from the frame.
   */
  public Oval(int x, int y, int w, int h, int r, int g, int b, String name,
              int atime, int dtime) throws IllegalArgumentException {
    super(x, y, w, h, r, g, b, name, atime, dtime);
  }

  @Override
  public IReadOnlyShape copy() {
    return new Oval(x, y, w, h, r, g, b, name, atime, dtime);
  }

  /**
   * This is a method that returns a toString signature of this class in a String format. Format:
   * "Name: OvalOne Type: OVAL Center: (100,100) X radius: 1 Y radius: 1, Color: (150,150,150)
   * Appears at t=1 Disappears at t=3 "
   *
   * @return a text description of creating this object.
   */
  @Override
  public String toString() {
    return "Name: " + name + "\n" + "Type: " + "oval" + "\n"
            + "Center: (" + x + "," + y + ") X radius: " + w
            + " Y radius: " + h + ", Color: (" + r + "," + g + "," + b + ")\n"
            + "Appears at t=" + atime + "\n" + "Disappears at t=" + dtime + "\n";
  }


  /**
   * This is a method that returns the type as Oval.
   *
   * @return the shape type.
   */
  @Override
  public ShapeType getType() {
    return ShapeType.OVAL;
  }
}
