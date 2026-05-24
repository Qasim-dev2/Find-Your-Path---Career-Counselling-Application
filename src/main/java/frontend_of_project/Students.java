package com.example.frontend_of_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jdk.dynalink.beans.StaticClass;
import java.io.Serializable;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;





public class Students implements Serializable {

    public Students() {

    }
    Registration r = new Registration();

    String name,cnic,email,gender;
    String date;




    @FXML
    Hyperlink login, sign;
    @FXML
    Button Exit;
    @FXML
    AnchorPane anchorpane1,anchorpane2, anchorpane3;
    @FXML
    TextField username1;
    @FXML
    public PasswordField password1;

    static Scanner sc = new Scanner(System.in);
    String username;
    String password;

    public Students(String username, String password,String name,String cnic,String email,String date,String gender) {
        this.password = password;
        this.username = username;
        this.name = name;
        this.gender= gender;
        this.cnic = cnic;
        this.date  = date;
        this.email =email;

    }



    @FXML
    public void tapOnSigin(ActionEvent event)
    {
        anchorpane1.setVisible(false);
        anchorpane2.setVisible(true);
    }
    @FXML
    public void signup(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
        Stage stage = (Stage) anchorpane2.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    public void sigIn() throws IOException {
            System.out.println(name);


        username = username1.getText();
        password = password1.getText();

            boolean success = Main.signIn(username, password);

            if (!success) {

                showAlert("Sign-In Failed", "Incorrect username or password. Please try again.");
            } else {
                Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                Stage stage = (Stage) anchorpane2.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            }


    }






    public void exit(ActionEvent actionEvent){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Stage stage = (Stage) login.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();

        }


    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }







}
