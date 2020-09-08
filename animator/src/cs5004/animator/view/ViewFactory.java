package cs5004.animator.view;

/**
 * This is an abstract class ViewFactory. There is only 1 method: getView(). The method returns to a
 * view object specified by the input string.
 */
public class ViewFactory {

  /**
   * This is a method that returns to either TextualView class or VisualView class. The method
   * implements a switch clause to determine which viewType to return.
   *
   * @param viewType the type of the view class to be returned.
   * @param width    the width of the panel.
   * @param height   the height of the panel.
   * @param speed    the speed of the frame to be delivered.
   * @return a view object.
   * @throws IllegalArgumentException if the view type doesn't exist.
   */
  public static IView getView(String viewType, int width, int height, int speed)
          throws IllegalArgumentException {
    switch (viewType) {
      case "text":
        return new TextualView(speed);
      case "visual":
        return new VisualView(width, height);
      default:
        throw new IllegalArgumentException("Invalid type.");
    }

  }
}
