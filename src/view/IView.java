package view;

import java.io.IOException;

/**
 * The interface View.
 */
public interface IView {
  /**
   * Display snapshots.
   *
   * @param index the index of the snapshot
   * @throws IOException the io exception
   */
  void displaySnapshots(int index) throws IOException;

  /**
   * Sets snapshot des.
   *
   * @param des the description of the snapshot
   * @throws IOException the io exception
   */
  void setSnapshotDes(int i, String des) throws IOException;
}
