package controller;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import model.ICanvas;
import model.IPhotoAlbum;
import model.ISnapshot;

/**
 * The type Controller.
 */
public class Controller implements IController {
  private final Readable in;
  private IPhotoAlbum album;

  /**
   * Instantiates a new Controller.
   *
   * @param in    the input source
   * @param album the album model
   * @throws IOException the io exception
   */
  public Controller(Readable in, IPhotoAlbum album) throws IOException {
    if (in == null) {
      throw new IOException("please provide valid input method");
    }
    Objects.requireNonNull(album);
    this.in = in;
    this.album = album;
  }

  @Override
  public void go() throws InterruptedException {
    ICanvas canvas = this.album.addCanvas();
    Scanner scan = new Scanner(this.in);
    while (scan.hasNext()) {
      String line = scan.nextLine();
      if (line.startsWith("#") || line.equals("")) {
        continue;
      }
      Scanner scan2 = new Scanner(line);
      String firstCommand = scan2.next().toLowerCase();
      switch(firstCommand) {
        case "shape":
          String shapeName = scan2.next();
          String shapeType = scan2.next();
          int x = scan2.nextInt();
          int y = scan2.nextInt();
          int width = scan2.nextInt();
          int height = scan2.nextInt();
          int r = scan2.nextInt();
          int g = scan2.nextInt();
          int b = scan2.nextInt();
          this.album.addShape(shapeName, shapeType, width, height, x, y, r, g, b);
          break;

        case "snapshot":
          String snapshotName = "";
          while(scan2.hasNext()) {
            snapshotName = snapshotName + scan2.next() + " ";
          }
          ISnapshot snapshot = this.album.takeSnapshot(snapshotName);
          TimeUnit.SECONDS.sleep(1);
          //snapshot.setDescription(snapshotName);
          break;

        case "move":
          String shapeName2 = scan2.next();
          int xNew = scan2.nextInt();
          int yNew = scan2.nextInt();
          this.album.moveShape(shapeName2, xNew, yNew);
          break;

        case "resize":
          String shapeName3 = scan2.next();
          int widthNew = scan2.nextInt();
          int heightNew = scan2.nextInt();
          this.album.resizeShape(shapeName3, widthNew, heightNew);
          break;

        case "color":
          String shapeName4 = scan2.next();
          int rNew = scan2.nextInt();
          int gNew = scan2.nextInt();
          int bNew = scan2.nextInt();
          this.album.changeShapeColor(shapeName4,rNew, gNew,bNew);
          break;

        case "remove":
          String shapeName5 = scan2.next();
          this.album.removeShape(shapeName5);
          break;

        default:
          throw new IllegalArgumentException("Such command is not supported!");
      }
    }
  }

}
