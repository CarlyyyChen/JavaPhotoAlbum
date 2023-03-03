package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Canvas implementing the ICanvas interface.
 */
public class Canvas implements ICanvas {

  private List<IShape> shapeList;

  /**
   * Instantiates a new Canvas.
   * It contains a list of shapes.
   */
  public Canvas() {
    this.shapeList = new ArrayList<>();
  }

  @Override
  public void place(IShape shape) {
    this.shapeList.add(shape);
  }

  @Override
  public void remove(IShape shape) throws IllegalStateException, IllegalArgumentException {
    if (this.shapeList.isEmpty()) {
      throw new IllegalStateException("There's nothing to remove on the canvas!");
    }
    if (!this.shapeList.contains(shape)) {
      throw new IllegalArgumentException("There's no such shape on the canvas!");
    }
    this.shapeList.remove(shape);
  }

  @Override
  public void clear() {
    shapeList.clear();
  }

  @Override
  public Canvas copy() {
    Canvas canvasCopy = new Canvas();
    for (IShape each : this.shapeList) {
      canvasCopy.shapeList.add(each.copy());
    }
    return canvasCopy;
  }

  @Override
  public String toString() {
    String s = "";
    if (!this.shapeList.isEmpty()) {
      for (IShape each : this.shapeList) {
        s += each.toString() + "\n";
      }
    }
    return s;
  }

  @Override
  public void moveShape(String name, int x, int y) {
    for (IShape each: this.shapeList) {
      if (each.getName().equals(name)) {
        each.setPosition(x,y);
      }
    }
  }

  @Override
  public void resizeShape(String name, int width, int height) {
    for (IShape each: this.shapeList) {
      if (each.getName().equals(name)) {
        each.setSize(width, height);
      }
    }
  }

  @Override
  public void changeShapeColor(String name, int r, int g, int b) {
    for (IShape each: this.shapeList) {
      if (each.getName().equals(name)) {
        each.changeColorTo(new Color(r,g,b));
      }
    }
  }

  @Override
  public void removeShape(String name) {
    for (IShape each: this.shapeList) {
      if (each.getName().equals(name)) {
        this.remove(each);
      }
    }

  }

  @Override
  public IShape getShape(int i) {
    return this.shapeList.get(i);
  }

  @Override
  public int getShapeNumber() {
    return this.shapeList.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Canvas)) return false;
    Canvas other = (Canvas) o;
    return this.shapeList.equals(other.shapeList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shapeList);
  }
}
