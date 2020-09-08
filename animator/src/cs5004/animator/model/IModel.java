package cs5004.animator.model;

import java.awt.Rectangle;
import java.util.List;

/**
 * This interface represents a model of an animation. It includes the following methods:
 * addRectangle, addOval, addMove, addScale, addChangeColor, outputShapeMap, outputShapeList and
 * outputActionList. The first two methods add shapes to the model. The next three add actions to
 * the model. The last three output the shapes, shapes and actions respectively.
 */
public interface IModel {
  /**
   * This is a method that takes in all the features of a shape, adds a new shape shape to the
   * model. It implements switch clause to evaluate which shape is being added and in this case, we
   * only have two kind of shapes being registered which are RECTANGLE and OVAL.
   *
   * @param type  the type of the shape.
   * @param x     the x coordinate of this shape's position.
   * @param y     the y coordinate of this shape's position.
   * @param w     the first size attribute of this shape.
   * @param h     the second size attribute of this shape.
   * @param r     the red portion code of this object.
   * @param g     the green portion code of this object.
   * @param b     the blue portion code of this object.
   * @param name  the name of this object.
   * @param atime the appear time.
   * @param dtime the disappear time.
   * @throws IllegalArgumentException if the name has been occupied or any other parameter is
   *                                  invalid.
   */
  void addShape(ShapeType type, int x, int y, int w, int h, int r, int g, int b,
                String name, int atime, int dtime) throws IllegalArgumentException;

  /**
   * Add a moving animation to model.
   *
   * @param fromX the x coordinate that this object is moving from.
   * @param fromY the y coordinate that this object is moving from.
   * @param toX   the y coordinate that this object is moving to.
   * @param toY   the y coordinate that this object is moving to.
   * @param name  the name of this onject.
   * @param atime the start time of this color changing operation.
   * @param dtime the end time of this color changing operation.
   * @throws IllegalArgumentException if the end time is earlier than the start time.
   */
  void addMove(int fromX, int fromY, int toX, int toY, String name,
               int atime, int dtime) throws IllegalArgumentException;

  /**
   * This is a method takes all the features of a color, adds the color changing to model.
   *
   * @param fromR the red portion code of this object.
   * @param fromG the green portion code of this object.
   * @param fromB the blue portion code of this object.
   * @param toR   the red portion code this object is change to.
   * @param toG   the green portion code this object is change to.
   * @param toB   the blue portion code this object is change to.
   * @param name  the name of this shape object.
   * @param atime the start time of this color changing operation.
   * @param dtime the end time of this color changing operation.
   * @throws IllegalArgumentException if the end time is earlier than the start time or the color
   *                                  code is out of range.
   */
  void addChangeColor(int fromR, int fromG, int fromB, int toR, int toG, int toB, String name,
                      int atime, int dtime) throws IllegalArgumentException;

  /**
   * This is a method takes the features of a shape such as width and height, add a scaling to
   * model.
   *
   * @param fromW the current width of the shape.
   * @param fromH the current height of the shape.
   * @param toW   the desired width.
   * @param toH   the desired height.
   * @param name  the name of the object to be scaled.
   * @param atime the start time of the scaling.
   * @param dtime the end time of the scaling.
   * @throws IllegalArgumentException if negative length is put in or the end time is earlier than
   *                                  the start time.
   */
  void addScale(int fromW, int fromH, int toW, int toH, String name,
                int atime, int dtime) throws IllegalArgumentException;

  /**
   * This is a method return the current states in a string format. It sorts the list of shapes and
   * motion based on the appear time, and transform the create and animation information into
   * String.
   *
   * @return the state in a string format.
   */
  String getState();


  /**
   * Get all names of the shapes have been added so far.
   *
   * @return a list of shapes' names.
   */
  List<String> getAllShapeIds();


  /**
   * Retrieve a readOnlyShape object by given name.
   *
   * @param name the name of the shape to be retrieved.
   * @return a readOnlyShape based on the given name.
   */
  IReadOnlyShape getShape(String name);


  /**
   * Traverse over all motions and execute those whose start time and end time cover the input
   * frame. And set corresponding shape to a new state.
   *
   * @param frame the current frame provided by the controller.
   */
  void animateShapesForFrame(int frame);


  /**
   * Get the end time of the animation.
   *
   * @return the time when all animations finish.
   */
  int getEndTime();

  /**
   * Get the bounds of the canvas.
   *
   * @return a rectangle object whose size is the same as that of the canvas.
   */
  Rectangle getAnimationBounds();

  /**
   * Set the boundary of the canvas.
   *
   * @param x      the offset of x coordinate.
   * @param y      the offset of y coordinate.
   * @param width  the width of the canvas.
   * @param height the height of the canvas.
   */
  void setAnimationBounds(int x, int y, int width, int height);

  /**
   * Get a list of motion objects.
   *
   * @return a list of motion objects.
   */
  List<IMotion> outputMotions();

  /**
   * Get a list of readOnlyShape objects.
   *
   * @return a list of readOnlyShape objects.
   */
  List<IReadOnlyShape> outputShapes();


}
