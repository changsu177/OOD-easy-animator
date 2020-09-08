package cs5004.animator.controller;

/**
 * This interface represents a Controller of an animation. It takes user inputs, tells model what to
 * do and view what to display. It has a run method to start the application.
 */
public interface IController {
  /**
   * This method starts the controller.
   */
  void run();
}
