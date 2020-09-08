package cs5004.animator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is ChangeColor that extends AbstractMotion class. It supports all operations that
 * listed in AbstractMotion. It takes int fromR, int fromG, int fromB, int toR, int toG, int toB and
 * int max in its field.
 */
public class ChangeColor extends AbstractMotion {
  private int fromR;
  private int fromG;
  private int fromB;
  private int toR;
  private int toG;
  private int toB;
  private static final int max = 255;
  private static final MotionType type = MotionType.CHANGECOLOR;

  /**
   * This is a constructor for class ChangeColor.
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
  public ChangeColor(int fromR, int fromG, int fromB, int toR, int toG, int toB, String name,
                     int atime, int dtime) throws IllegalArgumentException {
    super(name, atime, dtime);
    if (fromR < 0 || fromR > max || toR < 0 || toR > max || fromB < 0 || fromB > max
            || fromG < 0 || fromG > max || toG < 0 || toG > max || toB < 0 || toB > max) {
      throw new IllegalArgumentException("Wrong changing color.");
    }
    this.fromR = fromR;
    this.fromG = fromG;
    this.fromB = fromB;
    this.toR = toR;
    this.toG = toG;
    this.toB = toB;

  }

  @Override
  public IMotion copy() {
    return new ChangeColor(fromR, fromG, fromB, toR, toG, toB, name,
            atime, dtime);
  }

  /**
   * This is a method returns an array list of length information before and after the
   * transformation.
   *
   * @return a list of color information.
   */
  @Override
  public List<Integer> getNum() {
    List<Integer> nums = new ArrayList<>();

    nums.add(fromR);
    nums.add(fromG);
    nums.add(fromB);
    nums.add(toR);
    nums.add(toG);
    nums.add(toB);

    return nums;
  }

  /**
   * This method will return a toString signature of this class in a String format. For instance,
   * "Shape Rectangle changes color from (200,200,200) to (100,100,100) from t=1 to t=5"
   *
   * @return a text description of the changing color.
   */
  @Override
  public String toString() {
    return "Shape " + name + " changes color from (" + fromR + "," + fromG + "," + fromB + ") "
            + "to (" + toR + "," + toG + "," + toB + ") from t=" + atime + " to t=" + dtime;
  }

  /**
   * This is a getter method and return  the current motion type.
   *
   * @return the current motion type.
   */
  @Override
  public MotionType getType() {
    return type;
  }


}

