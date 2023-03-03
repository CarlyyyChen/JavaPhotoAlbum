package model;

/**
 * The interface IShape.
 */
public interface IShape {
  /**
   * Gets the name of the shape.
   *
   * @return the name
   */
  String getName();

  /**
   * Gets the type of the shape.
   *
   * @return the type
   */
  String getType();

  /**
   * Gets the color of the shape.
   *
   * @return the color
   */
  Color getColor();

  /**
   * Sets position of the shape.
   *
   * @param x the x axis value
   * @param y the y axis value
   */
  void setPosition(int x, int y);

  /**
   * Sets size for the shape.
   *
   * @param x the x measurement
   * @param y the y measurement
   */
  void setSize(int x, int y);

  /**
   * Gets the position of the shape.
   *
   * @return the position
   */
  Point2D getPosition();

  /**
   * Copy the shape.
   *
   * @return the shape
   */
  IShape copy();

  String toString();

  /**
   * Change color to.
   *
   * @param color the color
   * @throws IllegalArgumentException the illegal argument exception
   */
  void changeColorTo(Color color) throws IllegalArgumentException;
}
