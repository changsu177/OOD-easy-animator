package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import cs5004.animator.model.IModel;
import cs5004.animator.model.IReadOnlyShape;
import cs5004.animator.view.VisualView;

/**
 * This is a controller for a visual output. It will run the VisualView and and display the
 * animation on the screen.
 */

public class ControllerGui extends AbstractController {

  private Timer timer;


  /**
   * This is the constructor for the ControllerGui. It takes in a model and a view and mediate
   * between these two to run the application. Plus, it will take in a speed to tell the view how
   * fast to delivery the frame.
   *
   * @param model the model to realize the functionality of this application.
   * @param view  the view to display the message.
   * @param speed the speed to display the frame.
   */
  public ControllerGui(IModel model, VisualView view, int speed) {
    this.model = model;
    this.speed = speed;
    this.timer = new Timer(1000 / speed, new ActionListener() {
      int currentFrame = 0;

      @Override
      public void actionPerformed(ActionEvent e) {
        if (currentFrame == model.getEndTime()) {
          timer.stop();
          return;
        }
        model.animateShapesForFrame(currentFrame++);
        for (String name : model.getAllShapeIds()) {
          IReadOnlyShape shape = model.getShape(name);
          int x = shape.getX();
          int y = shape.getY();
          int w = shape.getW();
          int h = shape.getH();
          int r = shape.getR();
          int g = shape.getG();
          int b = shape.getB();
          switch (shape.getType()) {
            case RECTANGLE:
              view.drawRectangle(shape.getName(), x, y, w, h, r, g, b, shape.getATime(),
                      shape.getDTime());
              break;
            case OVAL:
              view.drawOval(shape.getName(), x, y, w, h, r, g, b, shape.getATime(),
                      shape.getDTime());
              break;
            default:
              break;
          }
          view.refresh();
          System.out.println(currentFrame);
        }
      }
    });
  }

  @Override
  public void run() {
    timer.start();

  }
}
