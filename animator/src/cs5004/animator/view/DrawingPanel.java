package cs5004.animator.view;

import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * This is a drawingPanel class that extends JPanel and implements IDrawingPanel. It has all the
 * features and characteristics of a JPanel and also inherited all method form the IDrawingPanel. It
 * takes a list of IViewShapes as its field and draw these shapes on the panel when called.
 */
public class DrawingPanel extends JPanel implements IDrawingPanel {
  private List<IViewShapes> shapesToDraw;


  /**
   * This is a Constructor for drawingPanel class that set the default color and size of the panel.
   * Fields are initialized in here.
   *
   * @param width  the width of the panel.
   * @param height the height of the panel.
   */
  public DrawingPanel(int width, int height) {
    super();
    setPreferredSize(new Dimension(width, height));
    setBackground(Color.white);
    shapesToDraw = new ArrayList<>();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (IViewShapes shape : shapesToDraw) {
      shape.draw(g);
    }
    shapesToDraw.clear();
  }

  @Override
  public void draw(IViewShapes shape) {
    shapesToDraw.add(shape);
  }

}
