package cs5004.animator.view;

import java.awt.Color;

/**
 * This is abstractViewShapes class. It has all attributes of a view shape as its filed.
 */
public abstract class AbstractViewShapes implements IViewShapes {
  protected String name;
  protected int x;
  protected int y;
  protected int width;
  protected Color color;
  protected int height;
  protected int atime;
  protected int dtime;

  /**
   * This is the constructor for the abstractViewShapes class.
   *
   * @param name the name of the shape object.
   * @param x     the x coordinate of the position of this object.
   * @param y     the y coordinate of the position of this object.
   * @param width     the width of this rectangle.
   * @param height     the height of this rectangle.
   * @param color     the code of this shape.
   * @param atime the time that this shape will be added to the frame.
   * @param dtime the time that this shape will be removed from the frame.
   */
  public AbstractViewShapes(String name, int x, int y, int width, int height, Color color,
                            int atime, int dtime) {
    this.name = name;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.color = color;
    this.atime = atime;
    this.dtime = dtime;
  }

}
