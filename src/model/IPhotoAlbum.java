package model;

/**
 * The interface Photo album.
 * This is my Model Interface
 */
public interface IPhotoAlbum {
  /**
   * Add canvas method.
   * A canvas is a like a page on the album. On it, you can have many shapes
   *
   * @return the canvas
   */
  ICanvas addCanvas();

  /**
   * Delete canvas.
   * throws IllegalStateException of the canvas list is empty
   *
   * @param canvas the canvas
   * @throws IllegalStateException the illegal state exception
   */
  void deleteCanvas(ICanvas canvas) throws IllegalStateException;

  /**
   * Take snapshot method.
   *
   * @return the snapshot
   */
  Snapshot takeSnapshot(String des);

  /**
   * Gets snapshot list.
   *
   * @return the snapshot list
   */
  String getSnapshotList();

  /**
   * Gets snapshots details.
   *
   * @return the snapshots detail
   */
  String getSnapshotsDetails();

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
   * Gets snapshot.
   *
   * @param i the index of the snapshot
   * @return the snapshot
   */
  ISnapshot getSnapshot(int i);

  /**
   * Gets snapshot number.
   *
   * @return the count of snapshots
   */
  int getSnapshotNumber();
  void addShape(String shapeName, String shapeType, int width, int height, int x, int y, int r,
                int g, int b);

}
