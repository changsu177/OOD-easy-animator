package cs5004.animator.model;

/**
 * This is a generic shape interface that extends IReadOnlyShape interface. It inherits all the
 * getter method from IReadOnlyShape and has additional setter functions that can set values
 * of all its attributes.
 */
public interface IShape extends IReadOnlyShape {

  /**
   * Set the position of this object.
   *
   * @param x the new x coordinate.
   */
  void setX(int x);

  /**
   * Set the position of this object.
   *
   * @param y the new x coordinate.
   */
  void setY(int y);

  /**
   * Set the first size attribute of this object.
   *
   * @param w new size.
   */
  void setW(int w);

  /**
   * Set the second size attribute of this object.
   *
   * @param h new size.
   */
  void setH(int h);

  /**
   * Set the red code of this object to a new value.
   *
   * @param r the new red code.
   */
  void setR(int r);

  /**
   * Set the green code of this object to a new value.
   *
   * @param g the new red code.
   */
  void setG(int g);

  /**
   * Set the blue code of this object to a new value.
   *
   * @param b the new red code.
   */
  void setB(int b);


  /**
   * Set the appear time of this shape object.
   *
   * @param aTime the appear time of this shape.
   */
  void setAtime(int aTime);

  /**
   * Set the disappear time of this shape object.
   *
   * @param dtime the disappear time of this shape.
   */
  void setDtime(int dtime);


}
