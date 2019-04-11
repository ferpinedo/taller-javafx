package controller;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Student;

public class StudentsController {

  @FXML
  private TableView<Student> studentsTable;

  public void initialize() {
    TableColumn<Student, String> columnaNombre =
        new TableColumn<>("Nombre");
    columnaNombre.setCellValueFactory(
        new PropertyValueFactory<>("name"));

    TableColumn<Student, String> columnaNumControl =
        new TableColumn<>("No. Control");
    columnaNumControl.setCellValueFactory(
        new PropertyValueFactory<>("controlNumber"));

    TableColumn<Student, String> columnaCarrera =
        new TableColumn<>("Carrera");
    columnaCarrera.setCellValueFactory(
        new PropertyValueFactory<>("career"));

    TableColumn<Student, String> columnaSexo =
        new TableColumn<>("Sexo");
    columnaSexo.setCellValueFactory(
        new PropertyValueFactory<>("sex"));

    studentsTable.getColumns().add(columnaCarrera);
    studentsTable.getColumns().add(columnaNombre);
    studentsTable.getColumns().add(columnaNumControl);
    studentsTable.getColumns().add(columnaSexo);

  }

  public void handleNewStudent() {
    try {
      URL fxml = getClass().getClassLoader().getResource(
          "resources/views/SignUp.fxml");
      FXMLLoader fxmlLoader = new FXMLLoader(fxml);
      Parent parent = fxmlLoader.load();
      SignUpController signUpController =
          fxmlLoader.getController();
      signUpController.setStudentsController(this);
      Scene scene = new Scene(parent);
      Stage dialogo = new Stage();
      dialogo.initModality(Modality.APPLICATION_MODAL);
      dialogo.setScene(scene);
      dialogo.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public TableView<Student> getStudentsTable() {
    return studentsTable;
  }

}
