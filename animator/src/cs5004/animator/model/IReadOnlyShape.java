package cs5004.animator.model;

/**
 * This interface for a read-only shape interface. It onlu has getter functions to return the values
 * of all its attributes. Users using objects driven out of this interface cannot modify any of its
 * attributes.
 */
public interface IReadOnlyShape extends Comparable<IReadOnlyShape> {

  /**
   * This function will copy the original object and return a new object with the same methods and
   * field values.
   *
   * @return a cloned readOnlyShape object.
   */
  IReadOnlyShape copy();

  /**
   * This is a getter method and return x coordinate of the object.
   */
  int getX();

  /**
   * This is a getter method and return  y coordinate of the object.
   */
  int getY();

  /**
   * This is a getter method and return  the width of the object.
   */
  int getW();

  /**
   * This is a getter method and return the height of the object.
   */
  int getH();

  /**
   * This is a getter method and return  the red of the color code of the object.
   */
  int getR();

  /**
   * TThis is a getter method and return the green of the color code of the object.
   */
  int getG();

  /**
   * This is a getter method and return the blue of the color code of the object.
   */
  int getB();

  /**
   * This is a getter method and return the name of the object.
   */
  String getName();

  /**
   * This is a getter method and return the appear time of the object.
   */
  int getATime();

  /**
   * This is a getter method and return the disappear time of the object.
   */
  int getDTime();

  /**
   * This is a getter method and return the type of the object.
   */
  ShapeType getType();

}
