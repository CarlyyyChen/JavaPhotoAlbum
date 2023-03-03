import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * The type Photo album main test.
 */
public class PhotoAlbumMainTest {
  private String[] wrongArgs1;
  private String[] wrongArgs2;
  private String[] wrongArgs3;
  private String[] args1;
  private String[] args2;
  private PhotoAlbumMain main;
  private ByteArrayOutputStream outContent;


  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    wrongArgs1 = new String[] {"-out", "myWeb.html", "-v", "web"};
    wrongArgs2 = new String[] {"-in", "buildings.txt", "-out", "myWeb.html"};
    wrongArgs3 = new String[] {"-in", "buildings.txt", "-v", "web"};
    args1 = new String[] {"-in", "buildings.txt", "-out", "myWeb.html", "-v", "web"};
    args2 = new String[] {"-in", "buildings.txt", "-v", "graphical", "-out", "graphical.html"};
    main = new PhotoAlbumMain();
  }

  /**
   * Test main wrong 1.
   * Expected an error message to show that there is no input provided.
   *
   * @throws IOException          the io exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testMainWrong1() throws IOException, InterruptedException {
    main.main(wrongArgs1);
    Assert.assertEquals("Please provide input file name." + System.lineSeparator(),
        outContent.toString());
  }

  /**
   * Test main wrong 2.
   * Expected an error message to show that there is no view type provided.
   *
   * @throws IOException          the io exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testMainWrong2() throws IOException, InterruptedException {
    main.main(wrongArgs2);
    Assert.assertEquals("Please provide view: graphical or web." + System.lineSeparator(),
        outContent.toString());
  }

  /**
   * Test main wrong 3.
   * Expected an error message to show that there is no output file if the view type is web.
   *
   * @throws IOException          the io exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testMainWrong3() throws IOException, InterruptedException {
    main.main(wrongArgs3);
    Assert.assertEquals("Please provide output html name if web view is wanted."
        + System.lineSeparator(), outContent.toString());
  }

  /**
   * Test if the web view command can correctly create the web view file.
   *
   * @throws IOException
   * @throws InterruptedException
   */
  @Test
  public void testMainoutput1() throws IOException, InterruptedException {
    main.main(args1);
    File webFile = new File("C:\\Users\\chy75\\IdeaProjects\\hw8\\src\\view\\myWeb.html");
    Assert.assertTrue(webFile.exists());
  }

  /**
   * test there will be no html output when the view is selected as graphical.
   *
   * @throws IOException
   * @throws InterruptedException
   */
  @Test
  public void testMainoutput2() throws IOException, InterruptedException {
    main.main(args2);
    File graphicalFile = new File(
        "C:\\Users\\chy75\\IdeaProjects\\hw8\\src\\view\\graphical.html");
    Assert.assertTrue(!graphicalFile.exists());
  }
}