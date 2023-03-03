package view;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.IPhotoAlbum;

/**
 * The type Prev listener.
 */
public class PrevListener implements ActionListener {
  private GraphicalView view;
  private IPhotoAlbum album;

  /**
   * Instantiates a new Prev listener.
   *
   * @param view  the view
   * @param album the album
   */
  public PrevListener(GraphicalView view, IPhotoAlbum album) {
    this.view = view;
    this.album = album;
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    int index = this.view.getSnapshotIndex();
    if (index > 0) {
      index--;
      this.view.setSnapshotID(this.album.getSnapshot(index).getID());
      this.view.setSnapshotDes(index, this.album.getSnapshot(index).getDescription());
      this.view.updateGraphPanel(index);
      this.view.repaint();
    } else {
      JOptionPane.showMessageDialog(this.view,
          "No previous snapshot!");
    }
  }
}
