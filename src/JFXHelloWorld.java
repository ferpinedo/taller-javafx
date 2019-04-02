import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class JFXHelloWorld extends Application {

  public static void main(String[] args) {
    /*
     * Launch a standalone application. This method is typically called
     * from the main method(). It must not be called more than once or an
     * exception will be thrown.
     * This is equivalent to launch(TheClass.class, args) where TheClass is the
     * immediately enclosing class of the method that called launch. It must
     * be a subclass of Application or a RuntimeException will be thrown.
     *
     * <p>
     * The launch method does not return until the application has exited,
     * either via a call to Platform.exit or all of the application windows
     * have been closed.
     */
    launch(args); // llama start
  }

  @Override
  public void start(Stage primaryStage) {
    /*  Title  */
    primaryStage.setTitle("¡Hola mundo!");

    /*  Position  */
    // The setX() and setY() methods set the position of the upper left corner of the window represented by the Stage related with the upper left corner of the screen.
    primaryStage.setX(20);
    primaryStage.setY(20);

    /*  Full Screen & Maximized  */
    // primaryStage.setMaximized(true); // pantalla maximizada
    // primaryStage.setFullScreen(true); //F11 para salir de full screen


    /*  initStyle   */
    // Tienen que ser estilos de StageStyle y no se puede llamar despues de que el stage haya sido mostrado (show)
    // primaryStage.initStyle(StageStyle.DECORATED); // is a standard window with OS decorations (title bar and minimize / maximize / close buttons), and a white background.
    // primaryStage.initStyle(StageStyle.UNDECORATED); // is a standard window without OS decorations, but still with a white background.
    // primaryStage.initStyle(StageStyle.TRANSPARENT); // is an undecorated window with transparent background.
    // primaryStage.initStyle(StageStyle.UNIFIED); // is like a decorated stage, except it has no border between the decoration area and the main content area.
//    primaryStage.initStyle(StageStyle.UTILITY); // is a decorated window, but with minimal decorations.

    primaryStage.show();
    /*  showAndWait   */
    //    Stage stage = new Stage();
    //    stage.setTitle("Ventana secundaria");
    //    stage.setScene(new Scene(new Pane(new Label("Label"))));
    //    stage.showAndWait();
    //
    //    System.out.println("Ya termine de esperar");

     /*  Stage modalities    */
//    Stage secondaryStage = new Stage();
//    secondaryStage.setTitle("Ventana 2");
//    secondaryStage.initOwner(primaryStage);
//
//    secondaryStage.initModality(Modality.WINDOW_MODAL);
//    secondaryStage.show();
//
//    Stage otherStage = new Stage();
//    otherStage.setTitle("Ventana 3");
//
//    otherStage.initModality(Modality.APPLICATION_MODAL);
//    otherStage.show();
//
//    Stage oneMoreStage = new Stage();
//    oneMoreStage.setTitle("Ventana 4");
//
//    oneMoreStage.initModality(Modality.NONE);
//    oneMoreStage.show();

    //    The second Stage has its modality set to Modality.APPLICATION_MODAL meaning it will block all other windows (stages) opened by this JavaFX application.
    //    You cannot access any other windows until this Stage window has been closed.
    //    The Modality.WINDOW_MODAL modality option means that the newly created Stage will block the Stage window that "owns" the newly created Stage, but only that.
    //    Not all windows in the application. See the next section below to see how to set the "owner" of a Stage.
    //    The Modality.NONE modality option means that this Stage will not block any other windows opened in this application.
    //    The Modality.APPLICATION_MODAL and Modality.WINDOW_MODAL modality modes are useful for Stage objects representing windows that function as "wizards" or "dialogs"
    //    which should block the application

    Scene scene = new Scene(new Pane(new Label("hola"))); // As parameter you must pass the root JavaFX GUI component that is to act as the root view to be displayed inside the Scene.
    primaryStage.setScene(scene);

    // It is possible to set the mouse cursor of a JavaFX Scene. The mouse cursor is the little icon that is being displayed at the location of the mouse cursor (pointer).
    scene.setCursor(Cursor.OPEN_HAND);


  }
}
