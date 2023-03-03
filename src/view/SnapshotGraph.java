package view;

import java.awt.*;

import javax.swing.*;
import model.IPhotoAlbum;
import model.IShape;
import model.Rectangle;
import model.Oval;

/**
 * The type Snapshot graph.
 */
public class SnapshotGraph extends JPanel {
  private IPhotoAlbum album;
  private int index;

  /**
   * Instantiates a new Snapshot graph.
   *
   * @param album the album
   * @param i     the
   */
  public SnapshotGraph(IPhotoAlbum album, int i) {
    this.album = album;
    this.index = i;
    this.setBackground(Color.lightGray);
  }

  /**
   * Gets index.
   *
   * @return the index
   */
  public int getIndex() {
    return this.index;
  }

  /**
   * Update graph.
   *
   * @param i the index of the snapshot
   */
  public void updateGraph(int i) {
    this.index = i;
    this.repaint();
  }

  /**
   * paint the components on snapshot graph.
   * @param g the <code>Graphics</code> object to protect
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (int i = 0; i < this.album.getSnapshot(this.index).getCanvasNumber(); i++) {
      for (int j = 0; j < this.album.getSnapshot(this.index).getCanvas(i).getShapeNumber(); j++) {
        IShape shape = this.album.getSnapshot(this.index).getCanvas(i).getShape(j);
        if (shape.getType().equalsIgnoreCase("rectangle")) {
          g.drawRect(shape.getPosition().getX(),shape.getPosition().getY(),
              ((Rectangle)shape).getWidth(),((Rectangle)shape).getHeight());
          g.setColor(new Color(shape.getColor().getR(),
              shape.getColor().getG(),
              shape.getColor().getB()));
          g.fillRect(shape.getPosition().getX(),shape.getPosition().getY(),
              ((Rectangle)shape).getWidth(),((Rectangle)shape).getHeight());
        }
        else {
          g.drawOval(shape.getPosition().getX(),shape.getPosition().getY(),
              ((Oval)shape).getXRadius(),((Oval)shape).getYRadius());
          g.setColor(new Color(shape.getColor().getR(),
              shape.getColor().getG(),
              shape.getColor().getB()));
          g.fillOval(shape.getPosition().getX(),shape.getPosition().getY(),
              ((Oval)shape).getXRadius(),((Oval)shape).getYRadius());
        }
      }
    }
  }
}
