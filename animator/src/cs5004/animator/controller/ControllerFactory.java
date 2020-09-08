package cs5004.animator.controller;

import java.io.PrintStream;

import cs5004.animator.model.IModel;
import cs5004.animator.view.IView;
import cs5004.animator.view.TextualView;
import cs5004.animator.view.VisualView;

/**
 * This class represents a Controller factory. It currently has two kinks of controller:
 * ControllerText for textual animation display, ControllerGui for visual animation display. This
 * factory will provide corresponding controller specified by the caller.
 */
public class ControllerFactory {

  /**
   * This is a getter method that would return the corresponding type of controller specified by the
   * controllerType: ControllerGui for "visual" and ControllerText for "text", otherwise throws
   * IllegalArgumentException.
   */
  public static IController getController(String controllerType, IModel model,
                                          IView view, PrintStream ap, int speed)
          throws IllegalArgumentException {
    if (controllerType.equals("visual")) {
      return new ControllerGui(model, (VisualView) view, speed);
    } else if (controllerType.equals("text")) {
      return new ControllerText(model, (TextualView) view, ap, speed);
    } else {
      throw new IllegalArgumentException("Invalid view type");
    }
  }

}
