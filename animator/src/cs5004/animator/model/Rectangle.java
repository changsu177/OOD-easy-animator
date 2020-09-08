package cs5004.animator.model;

/**
 * This class represent a Rectangle class that extends AbstractShape. It supports all the operations
 * from AbstractShape and shares the same features with other shape class.
 */
public class Rectangle extends Shape {

  /**
   * Constructor for the rectangle class.
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
  public Rectangle(int x, int y, int w, int h, int r, int g, int b, String name,
                   int atime, int dtime) throws IllegalArgumentException {
    super(x, y, w, h, r, g, b, name, atime, dtime);
  }

  @Override
  public IReadOnlyShape copy() {
    return new Rectangle(x, y, w, h, r, g, b, name, atime, dtime);
  }

  /**
   * This method will return a toString signature of this class in a String format. For instance,
   *
   * @return a text description of creating this object.
   */
  public String toString() {
    return "Name: " + name + "\n" + "Type: " + "rectangle" + "\n"
            + "Min corner: (" + x + "," + y + "), Width: " + w + ","
            + " Height: " + h + "," + " Color: (" + r + "," + g + "," + b + ")\n" + "Appears at t="
            + atime + "\n" + "Disappears at t=" + dtime;
  }

  /**
   * This is a method that returns the type as RECTANGLE.
   *
   * @return the shape type.
   */
  @Override
  public ShapeType getType() {
    return ShapeType.RECTANGLE;
  }
}
