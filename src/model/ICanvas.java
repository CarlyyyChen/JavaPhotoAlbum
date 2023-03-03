package model;

/**
 * The interface Canvas.
 */
public interface ICanvas {
  /**
   * Place a shape. Add a shape onto the canvas.
   *
   * @param shape the shape
   */
  void place(IShape shape);

  /**
   * Remove the shape from the canvas.
   * throws IllegalStateException if the shape list is already empty
   * throws IllegalArgumentException if the shape is not on this canvas
   *
   * @param shape the shape
   * @throws IllegalStateException    the illegal state exception
   * @throws IllegalArgumentException the illegal argument exception
   */
  void remove(IShape shape) throws IllegalStateException, IllegalArgumentException;

  /**
   * Clear the canvas. Removes all the shapes on the canvas.
   */
  void clear();

  /**
   * Copy the canvas. Copy all the shapes on the canvas.
   *
   * @return the canvas
   */
  Canvas copy();

  String toString();

  /**
   * Move shape.
   *
   * @param name the name of the shape
   * @param x    the x
   * @param y    the y
   */
  void moveShape(String name, int x, int y);

  /**
   * Resize shape.
   *
   * @param name   the name of the shape
   * @param width  the width
   * @param height the height
   */
  void resizeShape(String name, int width, int height);

  /**
   * Change shape color.
   *
   * @param name the name of the shape
   * @param r    the r
   * @param g    the g
   * @param b    the b
   */
  void changeShapeColor(String name, int r, int g, int b);

  /**
   * Remove shape.
   *
   * @param name the name of the shape
   */
  void removeShape(String name);

  /**
   * Gets shape.
   *
   * @param i the index of the shape
   * @return the shape
   */
  IShape getShape(int i);

  /**
   * Gets shape number.
   *
   * @return the number of shapes
   */
  int getShapeNumber();
}
