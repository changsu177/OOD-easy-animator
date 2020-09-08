package cs5004.animator.controller;


import cs5004.animator.model.IModel;

/**
 * This is an abstract controller that holds two common fields for both ControllerGui and
 * ControllerText, which are model and speed.
 */
public abstract class AbstractController implements IController {

  protected IModel model;
  protected int speed;

}
