package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Student;

public class SignUpController {

  @FXML
  private TextField txtName;

  @FXML
  private TextField txtControlNumber;

  @FXML
  private PasswordField txtPassword;

  @FXML
  private PasswordField txtRepeatPassword;

  @FXML
  private ComboBox<String> comboBox;

  @FXML
  private RadioButton radioBtnFemale;

  @FXML
  private RadioButton radioBtnMale;

  private ToggleGroup toggleGroup;

  private StudentsController studentsController;

  public void initialize() {
    comboBox.getItems().addAll(
            "Sistemas",
            "Mecatrónica",
            "Mecánica",
            "Gestión Empresarial",
            "Materiales",
            "Industrial",
            "Electrónica",
            "Eléctrica"
    );

    toggleGroup = new ToggleGroup();
    radioBtnMale.setToggleGroup(toggleGroup);
    radioBtnFemale.setToggleGroup(toggleGroup);

    radioBtnFemale.setSelected(true);
    comboBox.getSelectionModel().select(0);
  }

  public void handleDone() {
    String name = txtName.getText();
    String controlNumber = txtControlNumber.getText();
    String password = txtPassword.getText();
    String repeatPassword = txtRepeatPassword.getText();
    String career = comboBox.getValue();
    RadioButton selectedRadioBtn =
        (RadioButton) toggleGroup.getSelectedToggle();
    String sex = selectedRadioBtn.getText();

    if (!password.equals(repeatPassword)) {
      txtPassword.setStyle("-fx-text-box-border: red");
      txtRepeatPassword.setStyle("-fx-text-box-border: red");
      return;
    }

    try {
      Integer.parseInt(controlNumber);
    } catch (NumberFormatException e) {
      txtControlNumber.setStyle("-fx-text-box-border: red");
      return;
    }



    Student student = new Student(name, controlNumber,
                                  password, sex, career);

    studentsController.getStudentsTable().getItems().add(student);
    studentsController.fillUpChart();

    System.out.println(student);

    ((Stage)studentsController.getStudentsTable().getScene().getWindow()).close();
  }




  public void setStudentsController(StudentsController studentsController) {
    this.studentsController = studentsController;
  }
}
