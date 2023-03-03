import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import controller.Controller;
import controller.IController;
import model.IPhotoAlbum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * The type Controller test.
 */
public class ControllerTest {
  private StringBuffer out = new StringBuffer();
  private Reader in;
  private Reader wrongIn;
  private StringBuilder log;
  private IPhotoAlbum album;
  private IController controller;
  private IController controller2;

  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    log = new StringBuilder();
    album = new MockModel(log);
    wrongIn = new StringReader("delete shape X");
    in = new StringReader("shape   myrect   rectangle  200  200 50  100  255  0  0\n" +
        "move myrect     300     200\n" +
        "resize myrect   25      100\n" +
        "snapShot After first selfie\n" +
        "color myrect    0  0  255\n" +
        "remove myrect\n");
    controller = new Controller(in, album);
  }

  /**
   * Test null input. Expected a fail since the input cannot be null.
   *
   * @throws IOException the io exception
   */
  @Test (expected = IOException.class)
  public void testNullIn() throws IOException {
    controller2 = new Controller(null, album);
  }

  /**
   * Test unsupported command. Expected a fail because the command is not supported.
   *
   * @throws IOException          the io exception
   * @throws InterruptedException the interrupted exception
   */
  @Test (expected = IllegalArgumentException.class)
  public void testUnsupportedCommand() throws IOException, InterruptedException {
    controller2 = new Controller(wrongIn,album);
    controller2.go();
  }

  /**
   * Test go method.
   *
   * @throws IOException          the io exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGo() throws IOException, InterruptedException {
    controller.go();
    Assert.assertEquals("Add canvas\n" +
        "Add shape myrect, shape type: rectangle, width: 50, height: 100, " +
        "x: 200, y: 200, Color: (255, 0, 0) \n" +
        "Move shape myrect to: (300, 200)\n" +
        "Resize shape myrect to: width 25 height 100\n" +
        "Take Snapshot: After first selfie \n" +
        "Change shape myrect color to (0, 0, 255)\n" +
        "Remove shape myrect\n", ((MockModel)album).getLog());
  }
}