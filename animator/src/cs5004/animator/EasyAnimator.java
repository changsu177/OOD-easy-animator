package cs5004.animator;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import cs5004.animator.controller.ControllerFactory;
import cs5004.animator.controller.IController;
import cs5004.animator.model.IModel;
import cs5004.animator.model.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.IView;
import cs5004.animator.view.ViewFactory;


/**
 * This is a class that represent the EasyAnimator class. This class is the main() method and the
 * entry point of the program. It creates the model through reading file and command-line arguments,
 * creates an appropriate view, creates a controller, passing it the model and view and gives
 * control to the controller.
 */
public class EasyAnimator {
  /**
   * This is the main method that takes array of strings as argument. It throws IOException and
   * IllegalArgumentException if the strings contains none of the command -in, -view, -out -speed
   * indicator for the command-line arguments. It uses switch clause to parse the command line. -in
   * indicates the name of the the animation file. -view indicates the type of the view. -out
   * indicates where output show. -speed indicates tricks per second.
   */
  public static void main(String[] args) throws IOException {

    AnimationReader fileReader = new AnimationReader();
    Map<String, String> parsedArgs = new HashMap<>();
    PrintStream output = System.out;
    int speed = 1;
    try {
      for (int i = 0; i < args.length; i++) {
        switch (args[i]) {
          case "-in":
            parsedArgs.put("-in", args[i + 1]);
            break;
          case "-view":
            parsedArgs.put("-view", args[i + 1]);
            break;
          case "-out":
            //parsedArgs.put("-out", args[i + 1]);
            output = new PrintStream(new File(args[i + 1]));
            break;
          case "-speed":
            speed = Integer.parseInt(args[i + 1]);
            break;
          default:
            continue;
        }
      }
      if (!parsedArgs.containsKey("-in") || !parsedArgs.containsKey("-view")) {
        throw new IllegalArgumentException("missing required input");
      }
      IModel model = fileReader.parseFile(new FileReader(parsedArgs.get("-in")),
              new AnimationBuilderImpl());
      IView view = ViewFactory.getView(parsedArgs.get("-view"), model.getAnimationBounds().width,
              model.getAnimationBounds().height, speed);
      IController controller = ControllerFactory.getController(parsedArgs.get("-view"),
              model, view, output, speed);
      controller.run();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }

  }
}



