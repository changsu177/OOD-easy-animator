package cs5004.animator.model;

/**
 * This is an readOnlyShape class that implements IReadOnlyShape interface. It implements all the
 * getter functions mentioned in the interface and have all variables that describe a shape in this
 * field.
 */
public abstract class ReadOnlyShape implements IReadOnlyShape {
  protected final String name;
  protected int atime;
  protected int dtime;
  protected int x;
  protected int y;
  protected int w;
  protected int h;
  protected int r;
  protected int g;
  protected int b;

  /**
   * Constructor AbstractShape that takes all the field listed above as the parameter.
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
  public ReadOnlyShape(int x, int y, int w, int h, int r, int g,
                          int b, String name, int atime, int dtime) {
    if (name == null) {
      throw new IllegalArgumentException("The name for this shape object cannot be null");
    }
    if (atime < 0 || dtime < 0 || dtime < atime) {
      throw new IllegalArgumentException("Invalid time interval.");
    }
    if (w < 0 || h < 0) {
      throw new IllegalArgumentException("Invalid size input.");
    }
    int max = 255;
    if (g < 0 || g > max || g < 0 || g > max || b < 0 || b > max) {
      throw new IllegalArgumentException("Invalid color code.");
    }
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.r = r;
    this.g = g;
    this.b = b;
    this.name = name;
    this.atime = atime;
    this.dtime = dtime;
  }



  @Override
  public int compareTo(IReadOnlyShape other) {
    return this.atime - other.getATime();
  }

  @Override
  public int getX() {
    return x;
  }

  @Override
  public int getY() {
    return y;
  }

  @Override
  public int getW() {
    return w;
  }

  @Override
  public int getH() {
    return h;
  }

  @Override
  public int getR() {
    return r;
  }

  @Override
  public int getG() {
    return g;
  }

  @Override
  public int getB() {
    return b;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getATime() {
    return atime;
  }

  @Override
  public int getDTime() {
    return dtime;
  }

  @Override
  public ShapeType getType() {
    return ShapeType.RECTANGLE;
  }
}
