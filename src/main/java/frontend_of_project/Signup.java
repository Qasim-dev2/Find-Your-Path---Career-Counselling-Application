package com.example.frontend_of_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Signup {

    public Signup() {
    }

    @FXML
    Pane pane1;
    @FXML
    AnchorPane anchorPane1;

    @FXML
    TextField username1;

    @FXML
    PasswordField password1, confirmpassword1;

    @FXML
    Button enter, exit;

    static String username;
    static String password;
    String passwordconfirmation;

    @FXML
    public void enter() throws IOException {
        username = username1.getText().trim();
        password = password1.getText();
        passwordconfirmation = confirmpassword1.getText();


        if (username.isEmpty()) {
            showAlert("Error", "Username cannot be empty!");
            return;
        }
        for(Students student : Main.Student)
        {
            if(student.username.equals(username))
            {
                showAlert("Already taken","kindly write another username");
            return;
            }
        }

        if (password.isEmpty()) {
            showAlert("Error", "Password cannot be empty!");
            return;
        }

        if (passwordconfirmation.isEmpty()) {
            showAlert("Error", "Confirm Password cannot be empty!");
            return;
        }

        if (!password.equals(passwordconfirmation)) {
            showAlert("Error", "Passwords do not match!");
            return;
        }





        registration();
    }

    public void registration() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        Stage stage = (Stage) pane1.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


    public void exit()
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Students.fxml"));
            Stage stage = (Stage) pane1.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void back()
    {

    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
