package cs5004.animator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a Move class that extends the AbstractMotion class. And it supports all operations that
 * listed in the AbstractMotion class. It mains purpose is moving from the starting position to the
 * ending position.
 */
public class Move extends AbstractMotion {
  private int fromX;
  private int fromY;
  private int toX;
  private int toY;
  private static final MotionType type = MotionType.MOVE;

  /**
   * This is a constructor for class ChangeColor.
   *
   * @param fromX the x coordinate that this object is moving from.
   * @param fromY the y coordinate that this object is moving from.
   * @param toX   the y coordinate that this object is moving to.
   * @param toY   the y coordinate that this object is moving to.
   * @param name  the name of this onject.
   * @param atime the start time of this color changing operation.
   * @param dtime the end time of this color changing operation.
   * @throws IllegalArgumentException if the end time is earlier than the start time or a negative
   *                                  coordinate is put in.
   */
  public Move(int fromX, int fromY, int toX, int toY, String name,
              int atime, int dtime) {
    super(name, atime, dtime);
    this.fromX = fromX;
    this.fromY = fromY;
    this.toX = toX;
    this.toY = toY;
  }

  @Override
  public IMotion copy() {
    return new Move(fromX, fromX, toX, toY, name,
            atime, dtime);
  }

  /**
   * This is a method returns an array list of length information before and after the
   * transformation.
   *
   * @return a list of coordinate information.
   */
  @Override
  public List<Integer> getNum() {
    List<Integer> nums = new ArrayList<>();
    nums.add(fromX);
    nums.add(fromY);
    nums.add(toX);
    nums.add(toY);

    return nums;
  }


  /**
   * This is a method return the state in a string format. For instance, "Shape C moves from
   * (200,200) to (100,100) from t=1 to t=2"
   *
   * @return a text description of moving.
   */
  @Override
  public String toString() {
    return "Shape " + name + " moves from (" + fromX + "," + fromY + ") " + "to (" + toX + "," + toY
            + ") from t=" + atime + " to t=" + dtime;
  }

  /**
   * This is a getter method and return the current motion type.
   *
   * @return the current motion type.
   */
  @Override
  public MotionType getType() {
    return type;
  }


}
