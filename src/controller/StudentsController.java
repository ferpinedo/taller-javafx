package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Student;
import util.StudentGenerator;

import javax.swing.plaf.basic.BasicGraphicsUtils;

public class StudentsController {

  @FXML
  private TableView<Student> studentsTable;

  @FXML
  private AnchorPane tablePane;

  @FXML
  private AnchorPane barChartPane;

  @FXML
  private CheckMenuItem btnTable;

  @FXML
  private CheckMenuItem btnChart;

  @FXML
  private BarChart barChart;

  @FXML
  private CategoryAxis xAxis;

  @FXML
  private NumberAxis yAxis;

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


    // BarChart
    xAxis.setLabel("Carreras");
    yAxis.setLabel("Alumnos");

    fillUpChart();

  }

  public void fillUpChart() {
    XYChart.Series maleBars = new XYChart.Series();
    maleBars.setName("Hombres");

    XYChart.Series femaleBars = new XYChart.Series();
    femaleBars.setName("Mujeres");

    String[] carreras = {
            "Sistemas",
            "Mecatrónica",
            "Mecánica",
            "Gestión Empresarial",
            "Materiales",
            "Industrial",
            "Electrónica",
            "Eléctrica"
    };

    List<Student> students = studentsTable.getItems();

    for (String career: carreras) {
      int maleStudents = 0;
      int femaleStudents = 0;
      for (Student student: students) {
        if (student.getCareer().equals(career)) {
          if (student.getSex().equals("Femenino")) {
            femaleStudents++;
          } else {
            maleStudents++;
          }
        }
      }
      maleBars.getData().add(new XYChart.Data<>(career, maleStudents));
      femaleBars.getData().add(new XYChart.Data<>(career, femaleStudents));

    }

    barChart.getData().clear();
    barChart.getData().add(maleBars);
    barChart.getData().add(femaleBars);
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

  public void handleGenerateStudents() {
    studentsTable.getItems().addAll(StudentGenerator.getRandomStudents());
    fillUpChart();
  }

  public void handleTableView() {
    barChartPane.setVisible(false);
    tablePane.setVisible(true);

    btnChart.setSelected(false);
  }

  public void handleChartView() {
    barChartPane.setVisible(true);
    tablePane.setVisible(false);
    btnTable.setSelected(false);




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
