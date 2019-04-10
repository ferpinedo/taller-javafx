import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

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
  private ComboBox comboBox;

  @FXML
  private RadioButton radioBtnFemale;

  @FXML
  private RadioButton radioBtnMale;

  public void initialize() {
    comboBox.getItems().addAll(
        "Sistemas",
        "Materiales",
        "Mecatrónica"
    );

  }

  public void handleDone() {
    String name = txtName.getText();
    System.out.println(name);
    System.out.println(comboBox.getValue());
  }

}
