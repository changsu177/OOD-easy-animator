package cs5004.animator.model;

/**
 * This is a generic shape class. It has all getter and setter functions for its fields.
 */
public class Shape extends ReadOnlyShape implements IShape {

  /**
   * This is constructor for the generic shape class.
   *
   * @param x     the x coordinate of the position of this object.
   * @param y     the y coordinate of the position of this object.
   * @param w     the first size attribute of this shape.
   * @param h     the second size attribute of this shape.
   * @param r     the red code of this shape.
   * @param g     the green code of this shape.
   * @param b     the blue code of this shape.
   * @param name  the name of this shape.
   * @param atime the time that this shape will be added to the frame.
   * @param dtime the tiem that this shape will be removed from the frame.
   */
  protected Shape(int x, int y, int w, int h, int r, int g, int b, String name, int atime,
                  int dtime) {
    super(x, y, w, h, r, g, b, name, atime, dtime);
  }


  @Override
  public void setX(int x) {
    this.x = x;

  }

  @Override
  public void setY(int y) {
    this.y = y;

  }

  @Override
  public void setW(int w) {
    this.w = w;

  }

  @Override
  public void setH(int h) {
    this.h = h;

  }

  @Override
  public void setR(int r) {
    this.r = r;

  }

  @Override
  public void setG(int g) {
    this.g = g;

  }

  @Override
  public void setB(int b) {
    this.b = b;

  }

  @Override
  public void setAtime(int aTime) {
    this.atime = aTime;

  }

  @Override
  public void setDtime(int dtime) {
    this.dtime = dtime;

  }

  @Override
  public IReadOnlyShape copy() {
    return null;
  }
}
