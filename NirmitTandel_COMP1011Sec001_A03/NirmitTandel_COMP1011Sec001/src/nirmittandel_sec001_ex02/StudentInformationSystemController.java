package nirmittandel_sec001_ex02;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class StudentInformationSystemController extends Application {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField provinceField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField postalCodeField;
    @FXML
    private TextField emailField;
    @FXML
    private CheckBox basketballCheckbox;
    @FXML
    private CheckBox volleyballCheckbox;
    @FXML
    private CheckBox studentCouncilCheckbox;
    @FXML
    private CheckBox footballCheckbox;
    @FXML
    private CheckBox volunteerWorkCheckbox;
    @FXML
    private CheckBox swimmingCheckbox;
    @FXML
    private RadioButton Business;
    @FXML
    private RadioButton Computer;
    @FXML
    private ComboBox<String> subjectsComboBox;
    @FXML
    private Button displayButton;
    @FXML
    private TextArea outputTextArea;
    @FXML
    private ToggleGroup toggleGroup;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentInformationSystem.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        primaryStage.setTitle("Student Information System");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    @FXML
    private void initialize() {
        subjectsComboBox.getItems().addAll("Python", "Swift", "PHP", "Database", "Process Management", "Supply Chain", "Resource Planning");
        toggleGroup = new ToggleGroup();
        Computer.setToggleGroup(toggleGroup);
        Business.setToggleGroup(toggleGroup);
    }

    @FXML
    private void displayInfo() {
        StringBuilder info = new StringBuilder();
        info.append("First Name: ").append(firstNameField.getText()).append("\n");
        info.append("Address: ").append(addressField.getText()).append("\n");
        info.append("Province: ").append(provinceField.getText()).append("\n");
        info.append("City: ").append(cityField.getText()).append("\n");

        String phoneNumber = phoneNumberField.getText();
        if (isValidPhoneNumber(phoneNumber)) {
            info.append("Phone Number: ").append(phoneNumber).append("\n");
        } else {
            info.append("Invalid Phone Number").append("\n");
        }

        String postalCode = postalCodeField.getText();
        if (isValidPostalCode(postalCode)) {
            info.append("Postal Code: ").append(postalCode).append("\n");
        } else {
            info.append("Invalid Postal Code").append("\n");
        }

        String email = emailField.getText();
        if (isValidEmail(email)) {
            info.append("Email ID: ").append(email).append("\n");
        } else {
            info.append("Invalid Email ID").append("\n");
        }

        info.append("STUDENT INFORMATION SYSTEM\n");
        info.append("Activities Opted:\n");
        if (basketballCheckbox.isSelected()) info.append("- Basketball\n");
        if (volleyballCheckbox.isSelected()) info.append("- Volleyball\n");
        if (studentCouncilCheckbox.isSelected()) info.append("- Student Council\n");
        if (footballCheckbox.isSelected()) info.append("- Football\n");
        if (volunteerWorkCheckbox.isSelected()) info.append("- Volunteer Work\n");
        if (swimmingCheckbox.isSelected()) info.append("- Swimming\n");

        if (Computer.isSelected()) {
            info.append("Student's Major: Computer Science\n");
        } else if (Business.isSelected()) {
            info.append("Student's Major: Business Analyst\n");
        }
        info.append("Select Subjects: ").append(subjectsComboBox.getValue()).append("\n");

        outputTextArea.setText(info.toString());
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}");
    }

    private boolean isValidPostalCode(String postalCode) {
        return postalCode.matches("[A-Za-z]\\d[A-Za-z]\\d[A-Za-z]\\d");
    }

    private boolean isValidEmail(String email) {
        return email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");
    }

    public static void main(String[] args) {
        launch(args);
    }
}