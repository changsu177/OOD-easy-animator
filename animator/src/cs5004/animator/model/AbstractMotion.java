package cs5004.animator.model;

/**
 * This is an AbstractMotion class that implements all the operations that IMotion listed. Any
 * motion class that extends this abstract class will support all the operations. It takes the name
 * of the object, appear time and disappear time in its field.
 */
public abstract class AbstractMotion implements IMotion {

  String name;
  int atime;
  int dtime;

  /**
   * Constructor for AbstractMotion that take the name of the object, appear time and disappear time
   * as parameters.
   *
   * @param name  the name of shape object to conduct this movement.
   * @param atime the time point that this movement gets started.
   * @param dtime the time point that this movement will end.
   * @throws IllegalArgumentException if the end time is earlier than the start time.
   */
  public AbstractMotion(String name, int atime, int dtime) throws IllegalArgumentException {
    if (atime < 0 || dtime < 0 || dtime < atime) {
      throw new IllegalArgumentException("Invalid time interval to perform this motion");
    }
    this.name = name;
    this.atime = atime;
    this.dtime = dtime;
  }

  @Override
  public int getATime() {
    return this.atime;
  }


  @Override
  public int getDTime() {
    return this.dtime;
  }


  @Override
  public String getName() {
    return this.name;
  }


  @Override
  public int compareTo(IMotion other) {
    return this.atime - other.getATime();
  }

}
