package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.IPhotoAlbum;

/**
 * The type Quit listener.
 */
public class QuitListener implements ActionListener {
  private GraphicalView view;
  private IPhotoAlbum album;

  /**
   * Instantiates a new Quit listener.
   *
   * @param view  the view
   * @param album the album
   */
  public QuitListener(GraphicalView view, IPhotoAlbum album) {
    this.view = view;
    this.album = album;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.exit(0);
  }
}
