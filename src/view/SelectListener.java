package view;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.IPhotoAlbum;

/**
 * The type Select listener.
 */
public class SelectListener implements ActionListener {
  private GraphicalView view;
  private IPhotoAlbum album;

  /**
   * Instantiates a new Select listener.
   *
   * @param view  the view
   * @param album the album
   */
  public SelectListener(GraphicalView view, IPhotoAlbum album) {
    this.view = view;
    this.album = album;
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    String[] options = this.album.getSnapshotList().split(",");
    String choice = (String) JOptionPane.showInputDialog(this.view,
        "Choose:",
        "Menu", JOptionPane.INFORMATION_MESSAGE,
        null, options, options[0]);
    int choiceInt = 0;
    for (int i = 0; i < options.length; i++) {
      if (options[i].equals(choice)) {
        choiceInt = i;
        break;
      }
    }
    this.view.setSnapshotID(this.album.getSnapshot(choiceInt).getID());
    this.view.setSnapshotDes(choiceInt, this.album.getSnapshot(choiceInt).getDescription());
    this.view.updateGraphPanel(choiceInt);
    this.view.repaint();
  }
}
