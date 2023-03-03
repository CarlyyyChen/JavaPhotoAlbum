package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Snapshot that implements the Snapshot Interface.
 */
public class Snapshot implements ISnapshot {
  private List<ICanvas> canvasList = new ArrayList<>();
  private Timestamp timestamp;
  private String ID;
  private String description;

  private static final SimpleDateFormat timeFormat1
      = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
  private static final SimpleDateFormat timeFormat2
      = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");

  /**
   * Instantiates a new Snapshot.
   * <p>
   * sets the snapshot timestamp and snapshot ID
   */
  public Snapshot() {
    this.timestamp = new Timestamp(System.currentTimeMillis());
    this.ID = timeFormat2.format(this.timestamp);
  }

  /**
   * Get canvas copy and add that to its canvas list.
   *
   * @param canvas the canvas
   */
  public void getCanvas(ICanvas canvas) {
    this.canvasList.add(canvas);
  }

  @Override
  public void setDescription(String description) {
    if (description == null) {
      this.description = "";
    }
    else this.description = description;
  }

  @Override
  public String getID() {
    return this.ID;
  }

  @Override
  public String getTimestamp() {
    return timeFormat1.format(this.timestamp);
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public String toString() {
    String s = "Snapshot ID: " + this.getID() + "\n"
        + "Timestamp: " + this.getTimestamp() + "\n"
        + "Description: " + this.getDescription() + "\n"
        + "Shape Information: \n";
    if (!canvasList.isEmpty()) {
      for (ICanvas each : this.canvasList) {
        s += each.toString() + "\n";
      }
      s = s.substring(0, s.length() - 1);
    }
    return s;
  }

  @Override
  public ICanvas getCanvas(int i) {
    return this.canvasList.get(i);
  }

  @Override
  public int getCanvasNumber() {
    return this.canvasList.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Snapshot)) return false;
    Snapshot other = (Snapshot) o;
    return this.canvasList.equals(other.canvasList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(canvasList, description);
  }

}
