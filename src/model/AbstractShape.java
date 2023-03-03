package model;

/**
 * The type Abstract shape.
 */
public abstract class AbstractShape implements IShape, IAction {
  private String name;
  private String type;
  private Color color;
  private Point2D position;

  /**
   * Instantiates a new Abstract shape.
   *
   * @param type  the type of the shape
   * @param name  the name of the shape
   * @param color the color of the shape
   * @throws IllegalArgumentException the illegal argument exception
   */
  public AbstractShape(String type, String name, Color color) throws IllegalArgumentException {
    if (type == null || name == null || color == null) {
      throw new IllegalArgumentException("Type, Name and Color cannot be null!");
    }
    this.type = type;
    this.name = name;
    this.color = color;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getType() {
    return this.type;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public void setPosition(int x, int y) {
    position = new Point2D(x, y);
  }

  @Override
  public Point2D getPosition() {
    return position;
  }

  @Override
  public void placeBy(ICanvas canvas) {
    canvas.place(this);
  }

  @Override
  public void removeBy(ICanvas canvas) {
    canvas.remove(this);
  }

  @Override
  public void moveTo(int x, int y) {
    this.setPosition(x, y);
  }

  @Override
  public void changeColorTo(Color color) throws IllegalArgumentException {
    if (color == null) {
      throw new IllegalArgumentException("Color cannot be changed to null!");
    }
    this.color = color;
  }

}
