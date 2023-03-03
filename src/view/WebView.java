package view;

import java.io.IOException;
import model.IPhotoAlbum;
import model.IShape;
import model.Oval;
import model.Rectangle;

/**
 * The type Web view.
 */
public class WebView implements IView {
  private IPhotoAlbum album;
  /**
   * The Out.
   */
  final Appendable out;

  /**
   * Instantiates a new Web view.
   *
   * @param album the album
   * @param out   the out
   */
  public WebView(IPhotoAlbum album, Appendable out) throws IOException{
    if (out == null) {
      throw new IOException("Please provide output file.");
    }
    this.album = album;
    this.out = out;
  }

  /**
   * Generate html.
   *
   * @throws IOException the io exception
   */
  public void generateHTML() throws IOException {
    out.append("<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "<style>\n" +
        "    .snapshot {\n" +
        "        border: 5px outset red;\n" +
        "        background-color: lightblue;\n" +
        "    }\n" +
        "</style>\n" +
        "</head>\n" +
        "<body>\n");
    out.append("<h1>Photo Album</h1>\n");
    generateSVG();
    out.append("\n");
    out.append("</body>\n" +
        "</html>");
  }

  /**
   * Generate svg.
   *
   * @throws IOException the io exception
   */
  public void generateSVG() throws IOException {
    for (int index = 0; index < this.album.getSnapshotNumber(); index++) {
      out.append("<div class=\"snapshot\">\n");
      out.append("<h2>");
      out.append(this.album.getSnapshot(index).getID());
      out.append("</h2>\n");
      out.append("<p> Description: ");
      out.append(this.album.getSnapshot(index).getDescription());
      out.append("</p>\n");
      out.append("<svg width=\"1000\" height=\"1000\">\n");
      displaySnapshots(index);
      out.append("</svg>\n" + "</div>\n" + "<p></p>\n");
    }
  }

  @Override
  public void setSnapshotDes(int i, String des) throws IOException {
    this.album.getSnapshot(i).setDescription(des);
  }

  @Override
  public void displaySnapshots(int index) throws IOException {
    for (int i = 0; i < this.album.getSnapshot(index).getCanvasNumber(); i++) {
      for (int j = 0; j < this.album.getSnapshot(index).getCanvas(i).getShapeNumber(); j++) {
        IShape shape = this.album.getSnapshot(index).getCanvas(i).getShape(j);
        if (shape.getType().equalsIgnoreCase("rectangle")) {
          String shapeID = shape.getName();
          int x = shape.getPosition().getX();
          int y = shape.getPosition().getY();
          int width = ((Rectangle) shape).getWidth();
          int height = ((Rectangle) shape).getHeight();
          int r = shape.getColor().getR();
          int g = shape.getColor().getG();
          int b = shape.getColor().getB();
          out.append("<rect id=\"" + shapeID + "\" " +
              "x=\"" + x + "\" y=\"" + y + "\" " +
              "width=\"" + width + "\" height=\"" + height + "\" " +
              "fill=\"rgb(" + r + "," + g + "," + b + ")\" visibility=\"visible\">\n" +
              "</rect>\n");
        } else {
          String shapeID1 = shape.getName();
          int x1 = shape.getPosition().getX();
          int y1 = shape.getPosition().getY();
          int xRadius = ((Oval) shape).getXRadius();
          int yRadius = ((Oval) shape).getYRadius();
          int r1 = shape.getColor().getR();
          int g1 = shape.getColor().getG();
          int b1 = shape.getColor().getB();
          out.append("<ellipse id=\"" + shapeID1 + "\" " +
              "cx=\"" + x1 + "\" cy=\"" + y1 + "\" " +
              "rx=\"" + xRadius + "\" ry=\"" + yRadius + "\" " +
              "fill=\"rgb(" + r1 + "," + g1 + "," + b1 + ")\" visibility=\"visible\">\n" +
              "</ellipse>\n");
        }
      }
    }
  }
}
