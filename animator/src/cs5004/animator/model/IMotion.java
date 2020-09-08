package cs5004.animator.model;

import java.util.List;

/**
 * This interface represents a motion of an animation. It includes the following methods: getATime,
 * getDtime, getName, getType and getNum. They are all the getter method for the motion class.
 */
public interface IMotion extends Comparable<IMotion> {

  /**
   * This function will copy the original object and return a new object with the same methods and
   * field values.
   *
   * @return a cloned Motion object.
   */
  IMotion copy();


  /**
   * This is a getter method and return the appear time of the motion.
   *
   * @return the start time of this moving.
   */
  int getATime();

  /**
   * This is a getter method and return the disappear time of the motion.
   *
   * @return the end time of this moving.
   */
  int getDTime();

  /**
   * This is a getter method and return the name of the object.
   *
   * @return the name of the object to be moved.
   */
  String getName();

  /**
   * This is a getter method and return the current motion type.
   *
   * @return the type of this movement.
   */
  MotionType getType();

  /**
   * This is a getter method and return a list that stores all the integer data in it.
   */
  List<Integer> getNum();
}
