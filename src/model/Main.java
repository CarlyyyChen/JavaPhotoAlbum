package model;

/**
 * The Main class to show the album output.
 */
public class Main {
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    Color RED = new Color(1,0,0);
    Color BLUE = new Color(0,0,1);
    Color YELLOW = new Color(0,1,1);
    Color GREEN = new Color(0,1,0);

    IPhotoAlbum album = new PhotoAlbum();
    IShape rectangle = new Rectangle("RECTANGLE", "R", GREEN);
    rectangle.setSize(200, 200);
    rectangle.setPosition(2, 2);
    IShape oval = new Oval("OVAL", "O", YELLOW);
    oval.setPosition(1, -1);
    oval.setSize(15, 20);

    album.addCanvas().place(rectangle);
    ISnapshot snapshot1 = album.takeSnapshot("Place R");
    ((Rectangle) rectangle).changeColorTo(RED);
    ISnapshot snapshot2 = album.takeSnapshot("Change R's color to RED");
    ((Rectangle) rectangle).moveTo(1, 1);
    ISnapshot snapshot3 = album.takeSnapshot("Move R to (1.0,1.0)");
    ICanvas canvas = album.addCanvas();
    canvas.place(oval);
    ISnapshot snapshot4 = album.takeSnapshot("Place O");
    album.deleteCanvas(canvas);
    ISnapshot snapshot5 = album.takeSnapshot("Delete O");

    System.out.println(album.getSnapshotList());
    System.out.println("***********************************");
    System.out.println(album.getSnapshotsDetails());
  }
}
