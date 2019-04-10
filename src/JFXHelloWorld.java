import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class JFXHelloWorld extends Application {

  public static void main(String[] args) {
    launch(args);
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



    /*  Pane    */
    VBox pane = new VBox();
    pane.setAlignment(Pos.CENTER);
    pane.setSpacing(10);
    pane.setPadding(new Insets(10));


    /*  Label    */
    Label label = new Label("Inserta tu nombre aquí: ");
    pane.getChildren().add(label);
//    Scene scene = new Scene(label, 200, 100);

    /*  TextField    */
    TextField textField = new TextField();
    pane.getChildren().add(textField);


    /*  Button    */
    Button button = new Button("Ok");

    // Las expresiones lambda son funciones anónimas, es decir, funciones que no necesitan una clase.
    button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        label.setText("¡Gracias!");
        System.out.println(textField.getText());
//        textField.setVisible(false);
//        button.setVisible(false);
      }
    });

//    button.setOnAction(value ->  {
//      label.setText("¡Gracias!");
//    });

    pane.getChildren().add(button);

    // Mnemonic:  A mnemonic is a keyboard key which activates the button when pressed in conjunction with the ALT key.   MNEMOTECNICO
    //    button.setMnemonicParsing(true);
    //    button.setText("_Click");

//    button.setMinWidth()
//    button.setMaxWidth()
//    button.setPrefWidth()
//
//    button.setMinHeight()
//    button.setMaxHeight()
//    button.setPrefHeight()
//
//    button.setMinSize()
//    button.setMaxSize()
//    button.setPrefSize()

//    The methods setMinSize(), setMaxSize() and setPrefSize() sets both width and height for the button in a single call. Thus, these methods takes both a width and a height parameter. For instance, calling
//    button.setMaxSize(100, 200);

//    Styles
//    button1.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;")

//    Tooltip
//    button.setTooltip(new Tooltip("Presiona este botón para guardar tu nombre"));

    // Visible


    Scene basicWindow = new Scene(pane);
    primaryStage.setScene(basicWindow);


  }
}
