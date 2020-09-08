package cs5004.animator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a Scales class that extends the AbstractMotion class. And it supports all operations that
 * listed in the AbstractMotion class. Its main purpose is to modify the scale of the current shape
 * from the current width and height to the desired width and height.
 */
public class Scale extends AbstractMotion {
  private int fromW;
  private int fromH;
  private int toW;
  private int toH;
  private static final MotionType type = MotionType.SCALE;

  /**
   * Constructor for the scaling animation.
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
  public Scale(int fromW, int fromH, int toW, int toH, String name,
               int atime, int dtime) throws IllegalArgumentException {
    super(name, atime, dtime);
    if (fromW < 0 || fromH < 0 || toW < 0 || toH < 0) {
      throw new IllegalArgumentException("Invalid scale");
    }
    this.fromW = fromW;
    this.fromH = fromH;
    this.toW = toW;
    this.toH = toH;
  }

  @Override
  public IMotion copy() {
    return new Scale(fromW, fromH, toW, toH, name,
            atime, dtime);
  }

  /**
   * This is a method returns an array list of length information before and after the
   * transformation.
   *
   * @return a list of scaling information.
   */
  @Override
  public List<Integer> getNum() {
    List<Integer> nums = new ArrayList<>();
    nums.add(fromW);
    nums.add(fromH);
    nums.add(toW);
    nums.add(toH);

    return nums;
  }

  /**
   * This is a method return the state in a string format. The format is "Shape c scales from Width:
   * 1, Height: 1 to Width: 3, Height: 3 from t=1 to t=5".
   *
   * @return a text description of scaling
   */
  @Override
  public String toString() {
    return "Shape " + name + " scales from Width: " + fromW + ", Height: " + fromH + " to Width: "
            + toW + ", Height: " + toH + " from t=" + atime + " to t=" + dtime;
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
