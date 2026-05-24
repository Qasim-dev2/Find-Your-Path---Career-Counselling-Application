package com.example.frontend_of_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Registration {

    public Registration() {
    }

    @FXML
    private AnchorPane anchorpane1, anchorPane2;

    @FXML
    private TextField fullname1, cnic1, email1;

    @FXML
    private DatePicker dateofbirth1;

    @FXML
    private RadioButton female1, male1;

    static   String name, cnic, email, gender,date;
    static   LocalDate date1;

    @FXML
    public void initialize() {
        setupCnicFormatting();
        setupEmailFormatting();
    }


    private void setupCnicFormatting() {
        cnic1.textProperty().addListener((observable, oldValue, newValue) -> {
            String digits = newValue.replaceAll("\\D", "");
            if (digits.length() > 13) {
                digits = digits.substring(0, 13);
            }
            StringBuilder formatted = new StringBuilder(digits);
            if (digits.length() > 5) {
                formatted.insert(5, "-");
            }
            if (digits.length() > 12) {
                formatted.insert(13, "-");
            }
            cnic1.setText(formatted.toString());
        });
    }

    // Dynamically appends "@gmail.com" while typing
    private void setupEmailFormatting() {
        email1.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.endsWith("@gmail.com")) {
                email1.setText(newValue.replace("@gmail.com", "") + "@gmail.com");
                email1.positionCaret(newValue.length()); // Keeps cursor in the correct position
            }
        });
    }

    @FXML
    public void fillForm() {
        if (!validateFields()) {
            return;
        }

        name = fullname1.getText();
         cnic = cnic1.getText();
        email = email1.getText();
        date1 = dateofbirth1.getValue();
        if (male1.isSelected()) {
            gender = "Male";
        } else if (female1.isSelected()) {
            gender = "Female";
        }

        afterRegistration();
    }

    private boolean validateFields() {
        StringBuilder errors = new StringBuilder();

        if (fullname1.getText().isEmpty()) {
            errors.append("- Full Name is required.\n");
        }

        if (cnic1.getText().isEmpty()) {

            errors.append("- CNIC is required.\n");
        } else if (cnic1.getText().length() != 15 || !cnic1.getText().matches("\\d{5}-\\d{7}-\\d")) {
            errors.append("- CNIC must follow the format 34111-0000000-0.\n");
        }

        if (email1.getText().isEmpty()) {
            errors.append("- Email is required.\n");
        } else if (!email1.getText().contains("@")) {
            errors.append("- Email must be valid.\n");
        }

        if (dateofbirth1.getValue() == null) {
            errors.append("- Date of Birth is required.\n");
        }

        if (!male1.isSelected() && !female1.isSelected()) {
            errors.append("- Gender must be selected.\n");
        }

        if (errors.length() > 0) {
            showAlert("Invalid Input", "Please correct the following errors:", errors.toString());
            return false;
        }

        return true;
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }


    public void afterRegistration() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
         date = date1.format(formatter);

        anchorpane1.setVisible(false);
        anchorPane2.setVisible(true);
    }


    @FXML
    public void signInAfterRegistration() throws IOException {
        Main.Student.add(new Students(Signup.username, Signup.password,Registration.name,Registration.cnic,Registration.email,Registration.date,Registration.gender));
        Main.saveStudentsToFile();
        Parent root = FXMLLoader.load(getClass().getResource("Students.fxml"));
        Stage stage = (Stage) anchorpane1.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }



}
