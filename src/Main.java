import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    URL fxml = getClass().getClassLoader().getResource("resources/views/Students.fxml");
    FXMLLoader fxmlLoader = new FXMLLoader(fxml);
    Parent parent = fxmlLoader.load();
    primaryStage.getIcons().add(
            new Image(getClass().getResource
                    ("resources/images/keyhole.png").toExternalForm()));

    // mac
    URL iconURL = Main.class.getResource("resources/images/keyhole.png");
    java.awt.Image image = new ImageIcon(iconURL).getImage();
    com.apple.eawt.Application.getApplication().setDockIconImage(image);
    primaryStage.setTitle("Registro de estudiantes");

    primaryStage.setScene(new Scene(parent));
    primaryStage.show();

  }
}
