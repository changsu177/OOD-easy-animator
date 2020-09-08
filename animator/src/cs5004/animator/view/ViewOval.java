package cs5004.animator.view;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class represents a oval in view.
 */
public class ViewOval extends AbstractViewShapes {

  /**
   * This is the constructor for the viewOval class.
   *
   * @param name   the name of the Oval object.
   * @param x      the x coordinate of the position of this object.
   * @param y      the y coordinate of the position of this object.
   * @param width  the width of this rectangle.
   * @param height the height of this rectangle.
   * @param color  the code of this shape.
   * @param atime  the time that this shape will be added to the frame.
   * @param dtime  the time that this shape will be removed from the frame.
   */
  public ViewOval(String name, int x, int y, int width, int height, Color color, int atime,
                  int dtime) {
    super(name, x, y, width, height, color, atime, dtime);
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(color);
    g.fillOval(x, y, width, height);
  }

}
