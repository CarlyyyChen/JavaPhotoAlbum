package model;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * The type Oval.
 */
public class Oval extends AbstractShape {

  private int xRadius;
  private int yRadius;

  /**
   * Instantiates a new Oval.
   *
   * @param type  the type
   * @param name  the name
   * @param color the color
   */
  public Oval(String type, String name, Color color) {
    super(type, name, color);
  }

  public void setSize(int xr, int yr) throws IllegalArgumentException {
    if (xr <= 0 || yr <= 0) {
      throw new IllegalArgumentException("Measurements shall be positive!");
    }
    this.xRadius = xr;
    this.yRadius = yr;
  }

  public void changeSize(int xr, int yr) {
    this.setSize(xr, yr);
  }

  /**
   * Gets x radius.
   *
   * @return the x radius
   */
  public int getXRadius() {
    return this.xRadius;
  }

  /**
   * Gets y radius.
   *
   * @return the y radius
   */
  public int getYRadius() {
    return this.yRadius;
  }

  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("0.0");
    return "Name: " + this.getName() + "\n" +
        "Type: oval\n"
        + "Center: " + this.getPosition().toString()
        + ", X radius: " + df.format(this.getXRadius())
        + ", Y radius: " + df.format(this.getYRadius())
        + ", Color: " + this.getColor().toString();
  }

  public Oval copy() {
    Oval ovalCopy = new Oval(this.getType(), this.getName(), this.getColor());
    ovalCopy.setSize(this.getXRadius(), this.getYRadius());
    ovalCopy.setPosition(this.getPosition().getX(), this.getPosition().getY());
    return ovalCopy;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Oval)) return false;
    Oval other = (Oval) o;
    return Double.compare(other.xRadius, xRadius) == 0
        && Double.compare(other.yRadius, yRadius) == 0
        && other.getColor().equals(this.getColor())
        && other.getType().equals(this.getType())
        && other.getName().equals(this.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(xRadius, yRadius);
  }
}
