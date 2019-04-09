import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class SignInController {
  @FXML
  private TextField txtName;

  @FXML
  private ComboBox comboBox;

  @FXML
  private RadioButton radioBtnFemale;

  @FXML
  private RadioButton radioBtnMale;

  public void done() {
    String name = txtName.getText();
    System.out.println(name);
    System.out.println(comboBox.getValue());
  }

  public void initialize() {
    comboBox.getItems().addAll(
        "Sistemas",
        "Materiales",
        "Mecatrónica"
    );
    radioBtnFemale.setOnMouseReleased(event -> {
      radioBtnMale.setSelected(false);
      radioBtnFemale.setSelected(true);
    } );

    radioBtnMale.setOnMouseReleased(event -> {
      radioBtnMale.setSelected(true);
      radioBtnFemale.setSelected(false);
    } );
  }

}
