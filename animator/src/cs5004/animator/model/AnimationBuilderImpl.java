package cs5004.animator.model;

import cs5004.animator.util.AnimationBuilder;

/**
 * This is a function to transfer the information read from files to the certain format that fit in
 * my model.
 */
public class AnimationBuilderImpl implements AnimationBuilder<IModel> {

  private IModel model;

  /**
   * This is a constructor for animationBuilder that initialize a new model.
   */
  public AnimationBuilderImpl() {
    model = new Model();
  }

  @Override
  public IModel build() {
    return model;
  }

  @Override
  public AnimationBuilder<IModel> setBounds(int x, int y, int width, int height) {
    model.setAnimationBounds(x, y, width, height);
    return this;
  }

  @Override
  public AnimationBuilder<IModel> declareShape(String name, String type) throws
          IllegalArgumentException {
    switch (type) {
      case "ellipse":
        model.addShape(ShapeType.OVAL, 0, 0, 0, 0, 0, 0, 0, name,
                0, 0);
        break;
      case "rectangle":
        model.addShape(ShapeType.RECTANGLE, 0, 0, 0, 0, 0, 0, 0, name,
                0, 0);
        break;
      default:
        throw new IllegalArgumentException("Unknown shape type.");
    }
    return this;
  }

  @Override
  public AnimationBuilder<IModel> addMotion(String name, int t1, int x1, int y1, int w1, int h1,
                                            int r1, int g1, int b1, int t2, int x2, int y2,
                                            int w2, int h2, int r2, int g2, int b2) {
    model.addScale(w1, h1, w2, h2, name, t1, t2);
    model.addMove(x1, y1, x2, y2, name, t1, t2);
    model.addChangeColor(r1, g1, b1, r2, g2, b2, name, t1, t2);

    return this;
  }

}

