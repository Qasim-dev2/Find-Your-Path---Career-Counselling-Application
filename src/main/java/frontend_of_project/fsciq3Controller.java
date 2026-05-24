package com.example.frontend_of_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public class fsciq3Controller {
    private IQtest iqTest;


    int finalScore;
    @FXML
    private Label questionLabel;

    @FXML
    private RadioButton option1;

    @FXML
    private RadioButton option2;

    @FXML
    private RadioButton option3;

    @FXML
    private RadioButton option4;

    @FXML
    private Button nextButton;

    @FXML
    private Label scoreLabel;

    private ToggleGroup optionsToggleGroup;

    private List<IQquestions> questions;
    private int currentQuestionIndex = 0;
    private Consumer<Integer> onTestComplete;


    public void setOnTestComplete(Consumer<Integer> callback) {
        this.onTestComplete = callback;
    }
    int testscore,cchecker;
    public void testscore(int score,int checker)
    {
        testscore= score;
        cchecker= checker;
    }
    @FXML

    private void initialize() {

        optionsToggleGroup = new ToggleGroup();
        option1.setToggleGroup(optionsToggleGroup);
        option2.setToggleGroup(optionsToggleGroup);
        option3.setToggleGroup(optionsToggleGroup);
        option4.setToggleGroup(optionsToggleGroup);

        iqTest = new IQtest();
        questions = IQquestions.getIQQuestionsforUni();

        loadQuestion();
    }




    private void loadQuestion() {
        if (currentQuestionIndex < questions.size()) {
            IQquestions currentQuestion = questions.get(currentQuestionIndex);


            questionLabel.setText(currentQuestion.questionText);
            List<String> options = currentQuestion.options;
            option1.setText(options.get(0));
            option2.setText(options.get(1));
            option3.setText(options.get(2));
            option4.setText(options.get(3));


            optionsToggleGroup.selectToggle(null);
        } else {

            showResults();
        }
    }

    @FXML
    private void handleNextButton() {
        Toggle selectedToggle = optionsToggleGroup.getSelectedToggle();
        if (selectedToggle == null) {
            showAlert("Please select an answer before proceeding.");
            return;
        }


        int selectedOptionIndex = optionsToggleGroup.getToggles().indexOf(selectedToggle);
        IQquestions currentQuestion = questions.get(currentQuestionIndex);


        if (selectedOptionIndex + 1 == currentQuestion.correctOption) {
            iqTest.incrementCorrectAnswers();
        }


        currentQuestionIndex++;
        loadQuestion();
    }


    private void showResults() {
        finalScore = iqTest.calculateScore(iqTest.getCorrectAnswers());
        scoreLabel.setText("Your IQ Score: " + finalScore);


        showAlert("Test Completed!\nYour IQ Score: " + finalScore);


        if (onTestComplete != null) {
            onTestComplete.accept(finalScore);
        }




        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("After12controller.fxml"));
            Parent root = loader.load();


            After12Controller controller = loader.getController();


            controller.completescore((testscore+finalScore),cchecker);


            Stage currentStage = (Stage) nextButton.getScene().getWindow();
            currentStage.setScene(new Scene(root));
        }catch (IOException e )
        {

        }

    }


    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("IQ Test Results");
        alert.setHeaderText("Test Completed");
        alert.setContentText(message);
        alert.showAndWait();
    }


    public int getFinalScore()
    {
        return finalScore;
    }
}