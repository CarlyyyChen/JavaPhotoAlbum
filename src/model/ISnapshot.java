package model;

/**
 * The interface ISnapshot.
 */
public interface ISnapshot {
  /**
   * Sets description.
   *
   * @param description the description
   */
  void setDescription(String description);

  /**
   * Gets ID of the snapshot.
   *
   * @return the id
   */
  String getID();

  /**
   * Gets timestamp of the snapshot.
   *
   * @return the timestamp
   */
  String getTimestamp();

  /**
   * Gets description of the snapshot.
   *
   * @return the description
   */
  String getDescription();

  String toString();

  /**
   * Gets canvas.
   *
   * @param i the index of the canvas
   * @return the canvas
   */
  ICanvas getCanvas(int i);

  /**
   * Gets canvas number.
   *
   * @return the canvas count
   */
  int getCanvasNumber();
}
