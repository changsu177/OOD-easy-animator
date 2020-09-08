package cs5004.marblesolitaire.controller;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;

/**
 * This interface represents the controller of the marble solitaire game.
 */
public interface MarbleSolitaireController {

  /**
   * This method play a new game of Marble Solitaire using the provided model.
   *
   * @param model represents the model of the marble solitaire game.
   * @throws IllegalArgumentException if the provided model is null
   * @throws IllegalStateException if the controller is unable to successfully receive input or
   *          transmit output.
   */
  void playGame(MarbleSolitaireModel model) throws IllegalArgumentException, IllegalStateException;
}


