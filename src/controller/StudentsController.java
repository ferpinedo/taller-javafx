package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Student;
import util.StudentGenerator;

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
  private CheckMenuItem btnBarChart;

  @FXML
  private BarChart barChart;

  public void fillUpBarChart() {
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
    XYChart.Series maleBars = new XYChart.Series();
    maleBars.setName("Hombres");

    XYChart.Series femaleBars = new XYChart.Series();
    femaleBars.setName("Mujeres");

    for (String carrera: carreras) {
      int maleStudents = 0;
      int femaleStudents = 0;
      for (Student thisStudent: students) {
        if (thisStudent.getCareer().equals(carrera)) {
          if (thisStudent.getSex().equals("Femenino")) {
            femaleStudents++;
          } else {
            maleStudents++;
          }
        }
      }

      maleBars.getData().add(new XYChart.Data<>(carrera, maleStudents));
      femaleBars.getData().add(new XYChart.Data<>(carrera, femaleStudents));
    }

    barChart.getData().clear();

    barChart.getData().add(maleBars);
    barChart.getData().add(femaleBars);

  }

  public void handleAbout() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION)
    studentsTable.getItems().addAll(StudentGenerator.getRandomStudents());
    fillUpBarChart();
  }

  public void handleTable() {
    tablePane.setVisible(true);
    barChartPane.setVisible(false);

    btnTable.setSelected(true);
    btnBarChart.setSelected(false);
  }

  public void handleBarChart() {
    tablePane.setVisible(false);
    barChartPane.setVisible(true);

    btnTable.setSelected(false);
    btnBarChart.setSelected(true);
  }



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
