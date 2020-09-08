package cs5004.animator.view;

import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JScrollPane;


/**
 * This is a Visual View class that extends JFrame and implements IView. It takes drawingPanel and
 * JScrollPane in its field. And its function is to display the visual animation on the screen.
 */
public class VisualView extends JFrame implements IView {
  private DrawingPanel panel;


  /**
   * This is a constructor of the VisualView class. It adds and initializes all features that would
   * be shown on the screen. Fields are initialized in here.
   *
   * @param width  the width of the panel.
   * @param height the height of the panel.
   */
  public VisualView(int width, int height) {
    super();
    setSize(1000, 1000);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    panel = new DrawingPanel(width, height);
    JScrollPane scrollPane = new JScrollPane(panel);
    add(scrollPane);
    setVisible(true);
  }

  /**
   * This method could draw a rectangle on the panel.
   *
   * @param name  the name of the shape object.
   * @param x     the x coordinate of the position of this object.
   * @param y     the y coordinate of the position of this object.
   * @param w     the width of this rectangle.
   * @param h     the height of this rectangle.
   * @param r     the red code of this shape.
   * @param g     the green code of this shape.
   * @param b     the blue code of this shape.
   * @param atime the time that this shape will be added to the frame.
   * @param dtime the time that this shape will be removed from the frame.
   */
  public void drawRectangle(String name, int x, int y, int w, int h, int r, int g,
                            int b, int atime, int dtime) {
    IViewShapes rect = new ViewRectangle(name, x, y, w, h, new Color(r, g, b), atime, dtime);
    panel.draw(rect);
  }

  /**
   * This method could draw an oval on the panel.
   *
   * @param name  the name of the shape object.
   * @param x     the x coordinate of the position of this object.
   * @param y     the y coordinate of the position of this object.
   * @param w     the width of this rectangle.
   * @param h     the height of this rectangle.
   * @param r     the red code of this shape.
   * @param g     the green code of this shape.
   * @param b     the blue code of this shape.
   * @param atime the time that this shape will be added to the frame.
   * @param dtime the time that this shape will be removed from the frame.
   */
  public void drawOval(String name, int x, int y, int w, int h, int r, int g, int b, int atime,
                       int dtime) {
    IViewShapes oval = new ViewOval(name, x, y, w, h, new Color(r, g, b), atime, dtime);
    panel.draw(oval);
  }

  /**
   * The method refreshes the screen.
   */
  public void refresh() {
    panel.repaint();
  }

}
