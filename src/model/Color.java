package model;

/**
 * The type Color.
 */
public class Color {
  private int r;
  private int g;
  private int b;

  /**
   * Instantiates a new Color.
   *
   * @param r the r value
   * @param g the g value
   * @param b the b value
   */
  public Color (int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Gets r value.
   *
   * @return the r value
   */
  public int getR() {
    return this.r;
  }

  /**
   * Gets g value.
   *
   * @return the g value
   */
  public int getG() {
    return this.g;
  }

  /**
   * Gets b value.
   *
   * @return the b value
   */
  public int getB() {
    return this.b;
  }

  public String toString() {
    return "(" + this.r + "," + this.g + "," + this.b + ")";
  }
}
