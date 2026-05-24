package com.example.frontend_of_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {


    @FXML
    Hyperlink matric1 , inter1 , university1 ;

    @FXML
    Button exit1;
    @FXML
    AnchorPane profileanchorpane , mainanchorpane;
@FXML
    Label namelabername,cniclaber,dateofbirthlabel,emaillabel,genderlabel;

    static int i;
    public Menu() {

    }

    @FXML
    public void exit() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Stage stage = (Stage) matric1.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML

    public void matriculation() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("before10Controller.fxml"));
        Stage stage = (Stage) matric1.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    public void intermediate() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("a10.fxml"));
        Stage stage = (Stage) matric1.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void university() throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("After12Controller.fxml"));
        Stage stage = (Stage) matric1.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
public void back()
{
    mainanchorpane.setVisible(true);
    profileanchorpane.setVisible(false);
}
public void seeprofile()
{

    mainanchorpane.setVisible(false);
    profileanchorpane.setVisible(true);

    dateofbirthlabel.setText(Main.Student.get(i).date);
    namelabername.setText(Main.Student.get(i).name);
    cniclaber.setText(Main.Student.get(i).cnic);
    emaillabel.setText(Main.Student.get(i).email);
    dateofbirthlabel.setText(Main.Student.get(i).date);
    genderlabel.setText(Main.Student.get(i).gender);


}
    public void delete(){
    showAlert("added sooon");
    }

    public void ShowResults(){
        showAlert("This Feature will be Added Soon!!!");
    }


    public static void takeIndexfrommain(int index){
        i=index;
    }


    @FXML
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
