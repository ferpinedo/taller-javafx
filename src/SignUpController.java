import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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

  public void initialize() {
    comboBox.getItems().addAll(
        "Sistemas",
        "Materiales",
        "Mecatrónica"
    );

    toggleGroup = new ToggleGroup();
    radioBtnMale.setToggleGroup(toggleGroup);
    radioBtnFemale.setToggleGroup(toggleGroup);
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

    Student student = new Student(name, controlNumber,
                                  password, sex, career);

    System.out.println(student);
  }

}
