package view;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import controller.Controller;
import model.IPhotoAlbum;
import model.PhotoAlbum;

/**
 * The type Graphical view main.
 */
public class GraphicalViewMain {
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws IOException          the io exception
   * @throws InterruptedException the interrupted exception
   */
  public static void main(String [] args) throws IOException, InterruptedException {
    FileInputStream file = new FileInputStream("buildings.txt");
    InputStreamReader input = new InputStreamReader(file);
    IPhotoAlbum album = new PhotoAlbum();
    Controller controller = new Controller(input, album);
    controller.go();
    GraphicalView view = new GraphicalView("Photo Album", album);
    view.setVisible(true);
  }
}
