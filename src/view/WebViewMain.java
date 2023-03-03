package view;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import controller.Controller;
import model.IPhotoAlbum;
import model.PhotoAlbum;

/**
 * The type Web view main.
 */
public class WebViewMain {
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
    BufferedWriter out = new BufferedWriter(new FileWriter("./src/view/buildingsout.html"));
    WebView webview = new WebView(album,out);
    webview.generateHTML();
    out.close();
  }
}
