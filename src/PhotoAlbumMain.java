import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import controller.Controller;
import controller.IController;
import model.IPhotoAlbum;
import model.PhotoAlbum;
import view.GraphicalView;
import view.IView;
import view.WebView;

/**
 * The type Photo album main.
 */
public class PhotoAlbumMain {
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws IOException          the io exception
   * @throws InterruptedException the interrupted exception
   */
  public static void main(String[] args) throws IOException, InterruptedException {
    String fileName = "";
    String viewType = "";
    String outputName = "";
    int xmax = 1000;
    int ymax = 1000;
    if (!Arrays.asList(args).contains("-in")) {
      System.out.println("Please provide input file name.");
      return;
    }
    if ((!Arrays.asList(args).contains("-v")) && (!Arrays.asList(args).contains("-view"))) {
      System.out.println("Please provide view: graphical or web.");
      return;
    }
    int i = 0;
    while (i < args.length ) {
      if (args[i].equalsIgnoreCase("-in")) {
        fileName = args[i + 1];
        i++;
      }
      if (args[i].equalsIgnoreCase("-v")
          || args[i].equalsIgnoreCase("-view")) {
        viewType = args[i + 1];
        i++;
      }
      if (args[i].equalsIgnoreCase("-out")) {
        outputName = args[i + 1];
        i++;
      }
      else {
        try {
          xmax = Integer.parseInt(args[i]);
          ymax = Integer.parseInt(args[i + 1]);
          i += 2;
        } catch (NumberFormatException e) {
          i++;
        }
      }
    }

    if (viewType.equalsIgnoreCase("web") && outputName.equals("")) {
      System.out.println("Please provide output html name if web view is wanted.");
      return;
    }

    FileInputStream file =
        new FileInputStream("C:\\Users\\chy75\\IdeaProjects\\hw8\\" + fileName);
    InputStreamReader input = new InputStreamReader(file);
    IPhotoAlbum album = new PhotoAlbum();
    IController controller = new Controller(input, album);
    controller.go();

    if (viewType.equalsIgnoreCase("graphical")) {
      GraphicalView view = new GraphicalView("Photo Album", album);
      view.setWindowSize(xmax, ymax);
      view.setVisible(true);
    }

    if (viewType.equalsIgnoreCase("web")) {
      BufferedWriter out = new BufferedWriter(
          new FileWriter("C:\\Users\\chy75\\IdeaProjects\\hw8\\src\\view\\" + outputName));
      IView webview = new WebView(album, out);
      ((WebView)webview).generateHTML();
      out.close();
    }

  }
}
