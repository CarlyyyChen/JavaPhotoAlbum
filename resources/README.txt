0. Changes made to my Model and Reasoning
1) I have added shape action methods to the IPhotoAlbum and ICanvas interface, 
including add shape, move shape, resize shape, change color, remove shape. 
Because client will only use the album class to complete those operations.
Previously those methods are implemented by the shape class. 
Now in those methods, I still delegate to the shape class to implement.
2) I have added methods to count for snapshot, canvas and shape number. 
Because I need to use that count in for loop to display snapshots and shapes in the view
3) I have changed the position x and y values, measurement width and height values, and color r, g, b values
from double type to integers. Because it seems all those inputs from the input text are int values instead of 
double values. 

******************************************************************

1. Controller setup
I have a controller interface IController which provides a simple go() method
The Controller class is implementing this interface, and it is used by both graphical and web view
The Controller constructor will take an input source and a photo album model
The go() method will read commands and pass to the model to build shapes and perform actions on the shapes

******************************************************************

2. View setup
I have a view interface IView which provides two methods: displaySnapshots() and setSnapshotDes()
The GraphicalView and WebView are implementing the IView interface
The GraphicalView is a JFrame, which sets a frame to display snapshot ID and description, as well as paiting shapes
It is the GUI as well. User can clicks on four buttons: Prev, Select, Next and Quit to view a snapshot or to quit
Each button will have an action listener class in order to complete interaction with the user
The SnapshotGraph is a component of GraphicalView and its job is to paint the shapes
The GraphicalViewListener is the action listener. It helps display specific snapshot as per user actions on the
four buttons.

The WebView is used to output the html file with SVG marks to display a static album website

******************************************************************

3. PhotoAlbumMain
This is the entry point for my project. It will first read command line arguments and then asks the model,
controller and view to perform their job accordingly

******************************************************************

4. My Tests
I have created three tests for hw8: controller test, webView test, and PhotoAlbumMain test
- Controller test:
I have made a mock model, which provides isolation between the controller and the model
then I test using the mock model so that I can test if the controller correctly pass command to the model
- WebView test:
I have made up some input commands and to test WebView output result
- PhotoAlbumMain test:
I have tested for error handling: if the main function can print error messages if the user's command line 
arguments are not valid.
I have also tested for the output files: if the view type is html, I tested if a correct html file will be created;
and if the view type is graphical, I tested if no html file is created

******************************************************************

(Below is the README text for hw7)
5. Model setup
My Photo Album has three layers: the album, the canvas, and the shapes. The Album will include a list
of canvas, and the canvas will include a list of shapes. Besides, my album also contains a snapshot list, which
consists a list of Snapshot instances. Those Snapshot instances are just copies of the canvas list and the shape
list, to present what is currently in the album.

To achieve above, I have created five Interfaces: IPhotoAlbum, ICanvas, ISnapshot, IShape and IAction.

IPhotoAlbum is the Interface for the Model. It allows user to add canvas (pages) to the album,
delete canvas, take snapshot, get snapshot list, and get snapshot details. 
The PhotoAlbum class is implementing the IPhotoAlbum Interface. It escentially contains two lists:
list of canvas, and list of snapshots. 

ICanvas is the Interface for a canvas. It allows user to place a shape, remove a shape, clear
the whole page, and make shape copies to be used in the snapshot.
The Canvas class implements the ICanvas Interface. It contains a list of shapes.

ISnapshot is the Interface for a snapshot. It allows user to set and get the snapshot description,
get snapshot ID, get snapshot timestamp and get string representation of the snapshot.
The Snapshot class implements the ISnapshot interface. It contains a list of canvas, where actually
each canvas is a copy of that in the actual album. So that if we change the canvas in snapshot, 
that change will not happen on the actual album.

IShape is the interface for any shape that we want to include in the photo album. It
supports user to get name, type, colorEnum, position of the shape.
IAction is the interface for shape actions, including getting a shape placed or removed by a canvas,
moving a shape, changing shape size, and changing shape colorEnum.
AbstractShape is the abstract class implementing both IShape and IAction Interface. It is built for code
reuse. Rectangle and Oval are two concrete classes that extends AbstractShape. 

Point2D is used for the position (x,y) for any shapes
Color is a class for different colors. It contains three double value for r, g and b values.
ShapeType is another ENUM for the shape types that are currently supported. Currently there are only
RECTANGLE and OVAL, but we can add other shapes to this ENUM as well if further required.

***************************************
6. Model output
I have included a Main class in my package, so that you can run the main method there to see the output
of my model

***************************************
7. Special Notes for Model Tests
Since the timestamp for a snapshot is unique, I am not able to replicate that in my unit tests
and therefore, when testing for the Snapshot class, I could only test other strings excluding the snapshot ID
(since it is associated with the snapshot timestamp) and snapshot timestamp.