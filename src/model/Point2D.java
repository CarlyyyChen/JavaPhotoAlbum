package model;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * The type Point 2D.
 */
public class Point2D {
  private int x;
  private int y;

  /**
   * Instantiates a new Point.
   *
   * @param x the x axis value
   * @param y the y axis value
   */
  public Point2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Gets x.
   *
   * @return the x axis value
   */
  public int getX() {
    return this.x;
  }

  /**
   * Gets y.
   *
   * @return the y axis value
   */
  public int getY() {
    return this.y;
  }

  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("0.0");
    return "(" + df.format(this.getX()) + "," + df.format(this.getY()) + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Point2D)) return false;
    Point2D other = (Point2D) o;
    return Double.compare(other.x, x) == 0 && Double.compare(other.y, y) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
