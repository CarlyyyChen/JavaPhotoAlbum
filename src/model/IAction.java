package model;

/**
 * The interface Action.
 */
public interface IAction {
  /**
   * Place by the canvas.
   *
   * @param canvas the canvas
   */
  void placeBy(ICanvas canvas);

  /**
   * Remove by the canvas.
   *
   * @param canvas the canvas
   */
  void removeBy(ICanvas canvas);

  /**
   * Move to a new position.
   *
   * @param x the x
   * @param y the y
   */
  void moveTo(int x, int y);

  /**
   * Change size.
   *
   * @param x the x
   * @param y the y
   */
  void changeSize(int x, int y);

  /**
   * Change to a new color.
   * throws IllegalArgumentException if sets a null color
   *
   * @param color the color
   */
  void changeColorTo(Color color) throws IllegalArgumentException;
}
