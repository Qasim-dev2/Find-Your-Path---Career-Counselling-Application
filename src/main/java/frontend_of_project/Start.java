package com.example.frontend_of_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class Start {

    @FXML
    Button button;



    public void start(ActionEvent   actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) button.getScene().getWindow();
        stage.setTitle("Student Career Counselling Application...");
        stage.setScene(scene);
        stage.show();
    }


}
