package cs5004.animator.view;

/**
 * This is an interface that contains a method that could draw shapes on panel.
 */
public interface IDrawingPanel {
  /**
   * This function could draw shapes on panel.
   *
   * @param shape the shape object to be drawn on the panel.
   */
  void draw(IViewShapes shape);

}
