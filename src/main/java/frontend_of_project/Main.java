package com.example.frontend_of_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Students> Student = new ArrayList<>();
    static File myfile = new File("Student.txt");

    public static void main(String[] args) throws IOException {

        loadStudentsFromFile();

}
static int i=0;
    public static boolean signIn(String username, String password) {
        for (Students student : Student) {

            if (username.equals(student.username) && password.equals(student.password)) {
                Menu.takeIndexfrommain(i);


                i=0;
                return true;
            }
            i++;
        }
        return false;
    }

    @FXML
    Hyperlink hypeUser, hypeExit;



    @FXML
    public void StudentsSignin(ActionEvent actionEvent) throws IOException {
        loadStudentsFromFile();
        Parent root = FXMLLoader.load(getClass().getResource("Students.fxml"));
        Stage stage = (Stage) hypeUser.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void Exit(ActionEvent actionEvent) {
        System.out.println("Exiting the application...");
        javafx.application.Platform.exit();
    }


    // Load students from file
    public static void loadStudentsFromFile() {
        try {
            if (!myfile.exists()) {
                myfile.createNewFile();

            }
            Scanner fileScanner = new Scanner(myfile);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 7) {

                    Student.add(new Students(parts[0], parts[1],parts[2],parts[3],parts[4],parts[5],parts[6]));
                }
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void saveStudentsToFile() {
        try (FileWriter writer = new FileWriter(myfile)) {
            for (Students student : Student) {
                writer.write(student.username + "," + student.password +","+student.name +","+ student.cnic+"," +student.email +","+student.date +","+student.gender +"\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

