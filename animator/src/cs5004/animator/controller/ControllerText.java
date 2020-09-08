package cs5004.animator.controller;

import java.io.PrintStream;
import java.util.List;

import cs5004.animator.model.IModel;
import cs5004.animator.model.IMotion;
import cs5004.animator.model.IReadOnlyShape;
import cs5004.animator.view.TextualView;


/**
 * This is a controller for a text output. It will run the TextualView and print out the textual
 * output that returned by the view.
 */
public class ControllerText extends AbstractController {

  private PrintStream ap;
  private TextualView view;

  /**
   * This is the constructor for the ControllerText. It takes in a model and a view and mediate
   * between these two to run the application. Plus, it will take in a speed to tell the view how
   * fast to delivery the frame and a PrintStream object ap to receive the output of the view.
   *
   * @param model the model to realize the functionality of this application.
   * @param view  the view to display the message.
   * @param ap    a PrintSteam object to receive the view output.
   * @param speed the speed to display the frame.
   */
  public ControllerText(IModel model, TextualView view, PrintStream ap, int speed) {
    this.model = model;
    this.view = view;
    this.ap = ap;
    this.speed = speed;
  }

  @Override
  public void run() {
    for (IReadOnlyShape shape : model.outputShapes()) {
      int x = shape.getX();
      int y = shape.getY();
      int w = shape.getW();
      int h = shape.getH();
      int r = shape.getR();
      int g = shape.getG();
      int b = shape.getB();
      switch (shape.getType()) {
        case RECTANGLE:
          view.rectangleToText(shape.getName(), x, y, w, h, r, g, b, shape.getATime(),
                  shape.getDTime());
          break;
        case OVAL:
          view.ovalToText(shape.getName(), x, y, w, h, r, g, b, shape.getATime(), shape.getDTime());
          break;
        default:
          break;

      }
    }

    for (IMotion motion : model.outputMotions()) {
      List<Integer> data = motion.getNum();
      switch (motion.getType()) {
        case MOVE:
          view.moveToText(motion.getName(), data.get(0), data.get(1), data.get(2), data.get(3),
                  motion.getATime(), motion.getDTime());
          break;
        case CHANGECOLOR:
          view.changeColorToText(motion.getName(), data.get(0), data.get(1), data.get(2),
                  data.get(3), data.get(4), data.get(5), motion.getATime(), motion.getDTime());
          break;
        case SCALE:
          view.scaleToText(motion.getName(), data.get(0), data.get(1), data.get(2),
                  data.get(3), motion.getATime(), motion.getDTime());
          break;
        default:
          break;
      }
    }
    ap.println(view.render());

  }

}
