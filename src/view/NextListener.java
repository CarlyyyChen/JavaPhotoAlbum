package view;

import javax.swing.Action;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.IPhotoAlbum;

/**
 * The type Next listener.
 */
public class NextListener implements ActionListener {
  private GraphicalView view;
  private IPhotoAlbum album;

  /**
   * Instantiates a new Next listener.
   *
   * @param view  the view
   * @param album the album
   */
  public NextListener(GraphicalView view, IPhotoAlbum album) {
    this.view = view;
    this.album = album;
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    int index = this.view.getSnapshotIndex();
    if (index < this.album.getSnapshotNumber() - 1) {
      index++;
      this.view.setSnapshotID(this.album.getSnapshot(index).getID());
      this.view.setSnapshotDes(index, this.album.getSnapshot(index).getDescription());
      this.view.updateGraphPanel(index);
    } else {
      JOptionPane.showMessageDialog(this.view,
          "End of the photo album. No next snapshot!");
    }

  }
}
