package controller;

import java.io.IOException;

/**
 * The controller interface.
 */
public interface IController {
  /**
   * Go method for the Controller.
   *
   * @throws IOException          the io exception
   * @throws InterruptedException the interrupted exception
   */
  void go() throws IOException, InterruptedException;
}
