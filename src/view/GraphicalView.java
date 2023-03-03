package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import model.IPhotoAlbum;

import javax.swing.*;

/**
 * The type Graphical view.
 */
public class GraphicalView extends JFrame implements IView {
  private JButton btnPrev;
  private JButton btnSelect;
  private JButton btnNext;
  private JButton btnQuit;
  private JLabel snapshotID;
  private JLabel snapshotDes;
  private IPhotoAlbum album;
  private SnapshotGraph snapshotGraph;
  private int maxWidth;
  private int maxHeight;
  private final int defaultWidth = 1000;
  private final int defaultHeight = 1000;

  /**
   * Instantiates a new Graphical view.
   *
   * @param caption the caption
   * @param album   the album
   * @throws IOException the io exception
   */
  public GraphicalView(String caption, IPhotoAlbum album) throws IOException {
    super(caption);
    this.album = album;
    this.maxWidth = defaultWidth;
    this.maxHeight = defaultHeight;
    this.setSize(this.defaultWidth, this.defaultHeight);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout());

    displaySnapshots(0);

    //orangePanel is to display the buttons
    JPanel orangePanel = new JPanel();
    orangePanel.setBackground(Color.ORANGE);
    orangePanel.setPreferredSize(new Dimension(this.maxWidth,50));
    this.add(orangePanel);

    btnPrev = new JButton("<< Prev <<");
    PrevListener prevListener = new PrevListener(this, this.album);
    btnPrev.addActionListener(prevListener);
    orangePanel.add(btnPrev);

    btnSelect = new JButton("^^ Select ^^");
    SelectListener selectListener = new SelectListener(this,this.album);
    btnSelect.addActionListener(selectListener);
    orangePanel.add(btnSelect);

    btnNext = new JButton(">> Next >>");
    NextListener nextListener = new NextListener(this,this.album);
    btnNext.addActionListener(nextListener);
    orangePanel.add(btnNext);

    btnQuit = new JButton("xx Quit xx");
    QuitListener quitListener = new QuitListener(this,this.album);
    btnQuit.addActionListener(quitListener);
    orangePanel.add(btnQuit);
  }

  /**
   * Sets window size.
   *
   * @param x the x
   * @param y the y
   */
  public void setWindowSize(int x, int y) {
    this.setSize(x,y);
    this.maxWidth = x;
    this.maxHeight = y;
  }

  /**
   * Sets snapshot id.
   *
   * @param id the id
   */
  public void setSnapshotID(String id) {
    snapshotID.setText(id);
  }

  @Override
  public void setSnapshotDes(int i, String des) {
    snapshotDes.setText(des);
  }

  @Override
  public void displaySnapshots(int index) throws IOException {
    this.snapshotGraph = new SnapshotGraph(album, index);
    JPanel pinkPanel = new JPanel();
    pinkPanel.setBackground(Color.PINK);
    pinkPanel.setPreferredSize(new Dimension(this.maxWidth,50));
    pinkPanel.setLayout(new GridLayout(2,1));
    snapshotID = new JLabel(this.album.getSnapshot(0).getID());
    pinkPanel.add(snapshotID);
    snapshotDes = new JLabel(this.album.getSnapshot(0).getDescription());
    pinkPanel.add(snapshotDes);
    this.add(pinkPanel);

    //snapshotPanel is the main panel to display the snapshot
    //it is at the middle
    JPanel snapshotPanel = new JPanel();
    snapshotPanel.setBackground(Color.lightGray);
    snapshotGraph.setPreferredSize(new Dimension(this.maxWidth,this.maxHeight));
    snapshotPanel.add(snapshotGraph);
    JScrollPane snapshotScroll = new JScrollPane(snapshotPanel);
    snapshotScroll.setBackground(Color.lightGray);
    snapshotScroll.setPreferredSize(new Dimension(this.maxWidth,500));
    this.add(snapshotScroll);
  }

  /**
   * Update graph panel.
   *
   * @param i the
   */
  public void updateGraphPanel(int i) {
    this.snapshotGraph.updateGraph(i);
  }


  /**
   * Gets snapshot graph.
   *
   * @return the snapshot graph
   */
  public SnapshotGraph getSnapshotGraph() {
    return this.snapshotGraph;
  }

  /**
   * Gets snapshot index.
   *
   * @return the snapshot index
   */
  public int getSnapshotIndex() {
    return this.getSnapshotGraph().getIndex();
  }
}
