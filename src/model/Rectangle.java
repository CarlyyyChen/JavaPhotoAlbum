package model;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * The type Rectangle.
 */
public class Rectangle extends AbstractShape {
  private int width;
  private int height;

  /**
   * Instantiates a new Rectangle.
   *
   * @param type  the type
   * @param name  the name
   * @param color the color
   */
  public Rectangle(String type, String name, Color color) {
    super(type, name, color);
  }

  public void setSize(int w, int h) throws IllegalArgumentException {
    if (w <= 0 || h <= 0) {
      throw new IllegalArgumentException("Measurements shall be positive!");
    }
    this.width = w;
    this.height = h;
  }

  public void changeSize(int w, int h) {
    this.setSize(w, h);
  }

  /**
   * Gets width.
   *
   * @return the width
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Gets height.
   *
   * @return the height
   */
  public int getHeight() {
    return this.height;
  }

  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("0.0");
    return "Name: " + this.getName() + "\n"
        + "Type: rectangle\n"
        + "Min corner: " + this.getPosition().toString()
        + " Width: " + df.format(this.getWidth())
        + ", Height: " + df.format(this.getHeight())
        + ", Color: " + this.getColor().toString();
  }

  public Rectangle copy() {
    Rectangle rectangleCopy = new Rectangle(this.getType(), this.getName(), this.getColor());
    rectangleCopy.setSize(this.getWidth(), this.getHeight());
    rectangleCopy.setPosition(this.getPosition().getX(), this.getPosition().getY());
    return rectangleCopy;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Rectangle)) return false;
    Rectangle other = (Rectangle) o;
    return Double.compare(other.width, width) == 0
        && Double.compare(other.height, height) == 0
        && other.getColor().equals(this.getColor())
        && other.getType().equals(this.getType())
        && other.getName().equals(this.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(width, height);
  }
}
