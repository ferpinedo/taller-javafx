package controller;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Student;

import javax.swing.*;

public class StudentsController {

  @FXML
  private TableView<Student> studentsTable;

  @FXML
  private AnchorPane viewPane;

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

  public void handleTableView() {

  }

  public void handleChartView() {

  }

  public void handleDeleteStudent() {
    studentsTable.getItems().remove(studentsTable.getItems().size() - 1);
  }

  public void handleAbout() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Información");
    alert.setHeaderText("Taller de JavaFX");
    alert.setContentText("Proyecto desarrollado por Fernando Pinedo \n\r " +
            "Versión 0.5");

    alert.showAndWait();
  }

  public void handleClose() {
    ((Stage)studentsTable.getScene().getWindow()).close();
  }

}
