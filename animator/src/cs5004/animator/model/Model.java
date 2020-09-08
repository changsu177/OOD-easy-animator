package cs5004.animator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a Model class that implements IModel interface. This model will provides all functions to
 * make animations. New created shapes and animations will be added to several data structures which
 * are a shape_name-shape map, a shape_name-motions map, and a list holding all motions being added
 * so far. Here I make names of those shapes as their unique id, so no duplicate name is allowed. A
 * newly created motion must meet four requirements: 1. the shape with the input name that this
 * motion will be executed on must exist. 2. The time interval during which this motion will be
 * executed must be within this shape's existing time. 3. Two same type of motions cannot be
 * executed on a shape object during a overlapping time interval. (All the above three requirements
 * will be checked by the private checkValidity function) 4. For this motion itself, it must meet
 * all the validity requirements specified in their own class including valid time interval, valid
 * lengths, and so on. When the description of animations is requested, we first sort all the shape
 * and motions according to their start time and use a stringBuilder to append all the descriptions
 * in a specific format.
 */
public class Model implements IModel {

  private Map<String, IShape> shapesMap;

  private List<IMotion> motions;

  private List<IReadOnlyShape> shapes;

  private Map<String, List<IMotion>> motionMap;

  private int endTime;

  private int x;
  private int y;
  private int width;
  private int height;

  /**
   * This is constructor for the Model that initialize  all its fields.
   */
  public Model() {
    shapesMap = new LinkedHashMap<>();
    motions = new ArrayList<>();
    shapes = new ArrayList<>();
    motionMap = new LinkedHashMap<>();

    endTime = 0;
    x = 0;
    y = 0;
    width = 0;
    height = 0;
  }

  @Override
  public int getEndTime() {
    return this.endTime;
  }

  @Override
  public java.awt.Rectangle getAnimationBounds() {
    return new java.awt.Rectangle(x, y, width, height);
  }

  @Override
  public void setAnimationBounds(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  @Override
  public List<IMotion> outputMotions() {
    Collections.sort(motions);
    List<IMotion> copyMotion = new ArrayList<>();
    for (IMotion motion : motions) {
      copyMotion.add(motion.copy());

    }
    return copyMotion;
  }

  @Override
  public List<IReadOnlyShape> outputShapes() {
    Collections.sort(shapes);
    List<IReadOnlyShape> copyShape = new ArrayList<>();
    for (IReadOnlyShape shape : shapes) {
      copyShape.add(shape.copy());

    }
    return copyShape;
  }

  @Override
  public void addShape(ShapeType type, int x, int y, int w, int h, int r, int g,
                       int b, String name, int atime, int dtime) throws IllegalArgumentException {
    if (shapesMap.containsKey(name)) {
      throw new IllegalArgumentException("This name is occupied.");
    }
    IShape shape;
    switch (type) {
      case RECTANGLE:
        shape = new Rectangle(x, y, w, h, r, g, b, name, atime, dtime);
        break;
      case OVAL:
        shape = new Oval(x, y, w, h, r, g, b, name, atime, dtime);
        break;
      default:
        throw new IllegalArgumentException("Unprovided shape.");
    }
    shapesMap.put(name, shape);
    shapes.add(shape);
    motionMap.put(name, new ArrayList<>());
    endTime = Math.max(endTime, dtime);
  }


  @Override
  public void addMove(int fromX, int fromY, int toX, int toY, String name,
                      int atime, int dtime) throws IllegalArgumentException {

    checkValidity(name, MotionType.MOVE, atime, dtime, name);
    IMotion move = new Move(fromX, fromY, toX, toY, name, atime, dtime);
    updateTime(name, atime, dtime);
    motions.add(move);
    motionMap.get(name).add(move);
    endTime = Math.max(endTime, dtime);
  }

  /**
   * This function helps to update the appear time and disappear time for shape objects whose atime
   * and dtime haven't been specified when being created.
   *
   * @param name  the name of the object.
   * @param atime the start time of this shape's motion.
   * @param dtime the end time of this shape's motion.
   */
  private void updateTime(String name, int atime, int dtime) {
    IShape shape = shapesMap.get(name);
    if (shape.getATime() == 0) {
      shape.setAtime(atime);
    } else {
      shape.setAtime(Math.min(shape.getATime(), atime));
    }
    shape.setDtime(Math.max(shape.getDTime(), dtime));
  }

  @Override
  public void addChangeColor(int fromR, int fromG, int fromB, int toR, int toG, int toB,
                             String name, int atime, int dtime) throws IllegalArgumentException {

    checkValidity(name, MotionType.CHANGECOLOR, atime, dtime, name);
    IMotion changecolor = new ChangeColor(fromR, fromG, fromB, toR,
            toG, toB, name, atime, dtime);
    updateTime(name, atime, dtime);
    motions.add(changecolor);
    motionMap.get(name).add(changecolor);
    endTime = Math.max(endTime, dtime);
  }

  @Override
  public void addScale(int fromW, int fromH, int toW, int toH, String name,
                       int atime, int dtime) throws IllegalArgumentException {


    checkValidity(name, MotionType.SCALE, atime, dtime, name);
    IMotion scale = new Scale(fromW, fromH, toW, toH, name, atime, dtime);


    updateTime(name, atime, dtime);
    motions.add(scale);
    motionMap.get(name).add(scale);
    endTime = Math.max(endTime, dtime);
  }

  @Override
  public String getState() {
    Collections.sort(shapes);
    Collections.sort(motions);

    StringBuilder sb = new StringBuilder();
    sb.append("Shapes:\n");
    for (IReadOnlyShape shape : shapes) {
      sb.append(shape.toString()).append("\n");
    }
    if (motions.size() > 0) {
      sb.append("\n");
    }
    for (IMotion motion : motions) {
      sb.append(motion.toString()).append("\n");
    }

    return sb.toString();
  }

  @Override
  public List<String> getAllShapeIds() {
    return new ArrayList<>(shapesMap.keySet());
  }

  @Override
  public IReadOnlyShape getShape(String name) {
    IReadOnlyShape copyShape = shapesMap.get(name).copy();
    return copyShape;
  }

  /**
   * This method evaluate the following conditions to check the validity of the motion.
   *
   * @param shapeName the name of the shape object.
   * @param type      the shape type of this object.
   * @param startT    the start time be be checked.
   * @param endT      the end time to be checked.
   * @throws IllegalArgumentException if the motion being added to the model is overlapping with the
   *                                  current motion
   */
  public void checkValidity(String shapeName, MotionType type, int startT, int endT, String name)
          throws IllegalArgumentException {
    //1. the shape with the input name that this motion will be executed on must exist.
    if (!shapesMap.containsKey(name)) {
      throw new IllegalArgumentException("Shape with this name has not been added.");
    }
    //2. Two same type of motions cannot be executed on a shape object during a overlapping time
    // interval.
    for (IMotion motion : motionMap.get(name)) {
      if ((type == motion.getType())
              && (motion.getName().equals(shapeName))
              && ((motion.getATime() < startT && endT < motion.getDTime()
              || motion.getATime() < startT && endT < motion.getDTime()
              || motion.getATime() < startT && endT < motion.getDTime())
              || (motion.getATime() > startT && endT > motion.getDTime()))) {
        throw new IllegalArgumentException("Same type of motion in overlapping time interval.");
      }
    }
  }

  /**
   * This is a method returns a new array lists that stores all the shape at the current frame.
   */
  @Override
  public void animateShapesForFrame(int frame) {
    for (IMotion m : motions) {
      if (m.getATime() <= frame && frame <= m.getDTime()) {
        IShape shape = shapesMap.get(m.getName());
        switch (m.getType()) {
          case MOVE:
            shape.setX((int) tween(m.getNum().get(0), m.getATime(),
                    m.getNum().get(2), m.getDTime(), frame));
            shape.setY((int) tween(m.getNum().get(1), m.getATime(),
                    m.getNum().get(3), m.getDTime(), frame));
            break;
          case CHANGECOLOR:
            shape.setR((int) tween(m.getNum().get(0), m.getATime(),
                    m.getNum().get(3), m.getDTime(), frame));
            shape.setG((int) tween(m.getNum().get(1), m.getATime(),
                    m.getNum().get(4), m.getDTime(), frame));
            shape.setB((int) tween(m.getNum().get(2), m.getATime(),
                    m.getNum().get(5), m.getDTime(), frame));
            break;
          case SCALE:
            shape.setW((int) tween(m.getNum().get(0), m.getATime(),
                    m.getNum().get(2), m.getDTime(), frame));
            shape.setH((int) tween(m.getNum().get(1), m.getATime(),
                    m.getNum().get(3), m.getDTime(), frame));
            break;
          default:
            break;
        }
      }
    }

  }

  /**
   * This function helps to produce shapes within an animation.
   *
   * @param fromState   the initial state of the transformation.
   * @param startTime   the start time of the transformation.
   * @param endState    the target of the transformation.
   * @param toTime      the end time of the transformation.
   * @param currentTime current time.
   * @return
   */
  private float tween(float fromState, float startTime, float endState, float toTime,
                      float currentTime) {
    return fromState * ((toTime - currentTime) / (toTime - startTime))
            + endState * ((currentTime - startTime) / (toTime - startTime));
  }


}

