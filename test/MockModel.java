import model.ICanvas;
import model.IPhotoAlbum;
import model.ISnapshot;
import model.Snapshot;

/**
 * The type Mock model.
 */
public class MockModel implements IPhotoAlbum {
  private StringBuilder log;

  /**
   * Instantiates a new Mock model.
   *
   * @param log the log
   */
  public MockModel(StringBuilder log) {
    this.log = log;
  }

  @Override
  public ICanvas addCanvas() {
    log.append("Add canvas\n");
    return null;
  }

  @Override
  public void deleteCanvas(ICanvas canvas) throws IllegalStateException {
    log.append("Delete canvas\n");
  }

  @Override
  public Snapshot takeSnapshot(String des) {
    log.append("Take Snapshot: " + des + "\n");
    return null;
  }

  @Override
  public String getSnapshotList() {
    log.append("Get snapshot list\n");
    return null;
  }

  @Override
  public String getSnapshotsDetails() {
    log.append("Get snapshot details\n");
    return null;
  }

  @Override
  public void moveShape(String name, int x, int y) {
    log.append("Move shape " + name + " to: (" + x + ", " + y + ")\n");
  }

  @Override
  public void resizeShape(String name, int width, int height) {
    log.append("Resize shape " + name + " to: width " + width + " height " + height + "\n");
  }

  @Override
  public void changeShapeColor(String name, int r, int g, int b) {
    log.append("Change shape " + name + " color to (" + r + ", " + g + ", " + b + ")\n");
  }

  @Override
  public void removeShape(String name) {
    log.append("Remove shape " + name + "\n");
  }

  @Override
  public ISnapshot getSnapshot(int i) {
    log.append("Get snapshot " + i + "\n");
    return null;
  }

  @Override
  public int getSnapshotNumber() {
    log.append("Get Snapshot Count\n");
    return 0;
  }

  @Override
  public void addShape(String shapeName, String shapeType, int width, int height, int x, int y,
                       int r, int g, int b) {
    log.append("Add shape " + shapeName + ", shape type: " + shapeType + ", width: " + width
        + ", height: " + height + ", x: " + x + ", y: " + y
        + ", Color: (" + r + ", " + g + ", " + b + ") \n");
  }

  /**
   * Gets log.
   *
   * @return the log
   */
  public String getLog() {
    return this.log.toString();
  }
}
