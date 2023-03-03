import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import controller.Controller;
import model.IPhotoAlbum;
import model.PhotoAlbum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import view.WebView;

/**
 * The type Web view test.
 */
public class WebViewTest {
  /**
   * the View.
   */
  private WebView view;
  /**
   * the wrong view for null output test.
   */
  private WebView viewWrong;
  /**
   * The Album.
   */
  private IPhotoAlbum album;
  /**
   * The input source in.
   */
  private Reader in;
  /**
   * The output out.
   */
  private StringBuffer out;


  /**
   * Sets up the test variables.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    album = new PhotoAlbum();
    in = new StringReader("shape background rectangle 0 0 800 800 33 94 248"
    + "\n" + "snapshot");
    Controller controller = new Controller(in, album);
    controller.go();
    out = new StringBuffer();
    view = new WebView(album, out);
  }

  /**
   * test null output constructor. Expected a fail since the output is null.
   * @throws IOException
   */
  @Test (expected = IOException.class)
  public void testWebviewNullOut() throws IOException {
    viewWrong = new WebView(album, null);
  }

  /**
   * Test generate html method.
   *
   * @throws IOException the io exception
   */
  @Test
  public void testGenerateHTML() throws IOException {
    String s1 = "<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "<style>\n" +
        "    .snapshot {\n" +
        "        border: 5px outset red;\n" +
        "        background-color: lightblue;\n" +
        "    }\n" +
        "</style>\n" +
        "</head>\n" +
        "<body>\n" +
        "<h1>Photo Album</h1>\n" +
        "<div class=\"snapshot\">";
    String s2 = "<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "<style>\n" +
        "    .snapshot {\n" +
        "        border: 5px outset red;\n" +
        "        background-color: lightblue;\n" +
        "    }\n" +
        "</style>\n" +
        "</head>\n" +
        "<body>\n" +
        "<h1>Photo Album</h1>\n" +
        "<div class=\"snapshot\">\n" +
        "<h2>2022-12-04T20:52:23.000266</h2>\n";
    String s3 = "<p> Description:</p>\n" +
        "<svg width=\"1000\" height=\"1000\">\n" +
        "<rect id=\"background\" x=\"0\" y=\"0\" width=\"800\" " +
        "height=\"800\" fill=\"rgb(33,94,248)\" visibility=\"visible\">\n" +
        "</rect>\n" + "</svg>\n" +
        "</div>\n" +
        "<p></p>\n" +
        "\n" +
        "</body>\n" +
        "</html>";
    int length1 = s1.length();
    int length2 = s2.length();
    view.generateHTML();
    Assert.assertEquals(s1, out.substring(0,length1));
    Assert.assertEquals(s3, out.substring(length2));
  }

  /**
   * Test generate svg method.
   *
   * @throws IOException the io exception
   */
  @Test
  public void testGenerateSVG() throws IOException {
    String s1 = "<div class=\"snapshot\">\n";
    String s2 = "<div class=\"snapshot\">\n" +
        "<h2>2022-12-04T20:52:23.000266</h2>\n";
    int length1 = s1.length();
    int length2 = s2.length();
    view.generateSVG();
    Assert.assertEquals("<div class=\"snapshot\">\n"
        , out.substring(0,length1));
    Assert.assertEquals("<p> Description:</p>\n" +
        "<svg width=\"1000\" height=\"1000\">\n" +
        "<rect id=\"background\" x=\"0\" y=\"0\" width=\"800\" " +
        "height=\"800\" fill=\"rgb(33,94,248)\" visibility=\"visible\">\n" +
        "</rect>\n" +
        "</svg>\n" +
        "</div>\n" +
        "<p></p>\n", out.substring(length2));
  }

  /**
   * Test set snapshot description method.
   *
   * @throws IOException the io exception
   */
  @Test
  public void testSetSnapshotDes() throws IOException {
    view.setSnapshotDes(0,"test");
    view.generateSVG();
    String s = "<div class=\"snapshot\">\n" +
        "<h2>2022-12-04T20:52:23.000266</h2>\n";
    int length = s.length();
    Assert.assertEquals("<p> Description: test</p>\n" +
        "<svg width=\"1000\" height=\"1000\">\n" +
        "<rect id=\"background\" x=\"0\" y=\"0\" width=\"800\" " +
        "height=\"800\" fill=\"rgb(33,94,248)\" visibility=\"visible\">\n" +
        "</rect>\n" +
        "</svg>\n" +
        "</div>\n" +
        "<p></p>\n", out.substring(length));
  }

  /**
   * Test display snapshots method.
   *
   * @throws IOException the io exception
   */
  @Test
  public void testDisplaySnapshots() throws IOException {
    view.displaySnapshots(0);
    Assert.assertEquals("<rect id=\"background\" x=\"0\" y=\"0\" " +
        "width=\"800\" height=\"800\" fill=\"rgb(33,94,248)\" visibility=\"visible\">\n" +
        "</rect>\n", out.toString());
  }
}