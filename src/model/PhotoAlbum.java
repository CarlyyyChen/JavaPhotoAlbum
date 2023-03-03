package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Photo album that is implementing the interface IPhotoAlbum.
 */
public class PhotoAlbum implements IPhotoAlbum {
  private List<ICanvas> canvasList = new ArrayList<>();
  private List<ISnapshot> snapshotList = new ArrayList<>();

  @Override
  public ICanvas addCanvas() {
    Canvas canvas = new Canvas();
    this.canvasList.add(canvas);
    return canvas;
  }

  @Override
  public void deleteCanvas(ICanvas canvas) throws IllegalStateException {
    if (!this.canvasList.contains(canvas) || this.canvasList.isEmpty()) {
      throw new IllegalStateException("Canvas does not exist!");
    }
    this.canvasList.remove(canvas);
  }

  @Override
  public Snapshot takeSnapshot(String des) {
    Snapshot snapshot = new Snapshot();
    snapshot.setDescription(des);
    for (ICanvas each : this.canvasList) {
      snapshot.getCanvas(each.copy());
    }
    this.snapshotList.add(snapshot);
    return snapshot;
  }

  @Override
  public String getSnapshotList() {
    String s = "";
    for (ISnapshot each : this.snapshotList) {
      s += each.getID() + ", ";
    }
    s = s.substring(0, s.length() - 2);
    return s;
  }

  @Override
  public String getSnapshotsDetails() {
    String s = "Printing Snapshots\n";
    for (ISnapshot each : this.snapshotList) {
      s += each.toString() + "\n\n";
    }
    return s;
  }

  @Override
  public String toString() {
    String s = "";
    if (!this.canvasList.isEmpty()) {
      for (ICanvas each : this.canvasList) {
        s += each.toString();
      }
    }
    return s;
  }

  @Override
  public void moveShape(String name, int x, int y) {
    for (ICanvas each: this.canvasList) {
      each.moveShape(name, x, y);
    }
  }

  @Override
  public void resizeShape(String name, int width, int height) {
    for (ICanvas each: this.canvasList) {
      each.resizeShape(name, width, height);
    }
  }

  @Override
  public void changeShapeColor(String name, int r, int g, int b) {
    for (ICanvas each: this.canvasList) {
      each.changeShapeColor(name, r, g, b);
    }
  }

  @Override
  public void removeShape(String name) {
    for (ICanvas each: this.canvasList) {
      each.removeShape(name);
    }
  }

  @Override
  public ISnapshot getSnapshot(int i) {
    return this.snapshotList.get(i);
  }

  @Override
  public int getSnapshotNumber() {
    return this.snapshotList.size();
  }

  @Override
  public void addShape(String shapeName, String shapeType, int width, int height, int x, int y,
                       int r, int g, int b) {
    if (shapeType.equalsIgnoreCase("rectangle")) {
      IShape shape = new Rectangle(shapeType, shapeName, new Color(r,g,b));
      shape.setPosition(x,y);
      shape.setSize(width,height);
      this.canvasList.get(canvasList.size()-1).place(shape);
    }
    else {
      IShape shape2 = new Oval(shapeType, shapeName, new Color(r,g,b));
      shape2.setPosition(x,y);
      shape2.setSize(width,height);
      this.canvasList.get(canvasList.size()-1).place(shape2);
    }
  }
}
