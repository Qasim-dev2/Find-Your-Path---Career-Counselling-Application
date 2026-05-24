package com.example.frontend_of_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class After12Controller {

    int tscore;



    @FXML
    private AnchorPane mainPane, medicalPane, engineeringPane, artsPane, testPane, newfieldPane,personalityanchorpane;

    @FXML
    private ComboBox<String> fieldComboBox;

    @FXML
    private Button startTestButton, switchFieldButton, submitTestButton;

    @FXML
    private TextArea questionArea;

    @FXML
    private CheckBox option1, option2, option3, option4, option5, option6, option7, option8, option9, option10, option11, option12;
    @FXML

    private RadioButton radiooption1, radiooption2, radiooption3, radiooption4,artsradiobutton,engineeringradiobutton,medicalfieldradiobutton;
    private Label scoreLabel;
    @FXML
    private ToggleGroup optionsGroup;
    @FXML
    ToggleGroup newfieldtogglegroup;


    //...
    private List<Questions> currentQuestions;
    private int currentQuestionIndex = 0;
    private int correctAnswers = 0;
    private After12 test = new After12();
    private int checker = 0;

    @FXML
    public void initialize() {

        fieldComboBox.getItems().addAll("Pre-Medical", "Pre-Engineering", "Arts");
    }

    @FXML
    public void startTest() {




        String selectedField = fieldComboBox.getValue();
        if (selectedField == null) {
            showAlert("Please select a field before starting the test.");
            return;
        }

        switch (selectedField) {
            case "Pre-Medical":
                medicalPane.setVisible(true);
                checker = 1;
                break;
            case "Pre-Engineering":
                engineeringPane.setVisible(true);
                checker = 2;
                break;
            case "Arts":
                artsPane.setVisible(true);
                checker = 3;
                break;
        }

        mainPane.setVisible(false);
    }

    @FXML
    public void submitInterestQuestions() {

        int artsScore = 0;
        int engineeringscore = 0;
        int medicalScore = 0;
        if (option1.isSelected()) medicalScore++;
        if (option2.isSelected()) medicalScore++;
        if (option3.isSelected()) medicalScore++;
        if (option4.isSelected()) medicalScore++;


        if (option5.isSelected()) engineeringscore++;
        if (option6.isSelected()) engineeringscore++;
        if (option7.isSelected()) engineeringscore++;
        if (option8.isSelected()) engineeringscore++;


        if (option9.isSelected()) artsScore++;
        if (option10.isSelected()) artsScore++;
        if (option11.isSelected())  artsScore++;
        if (option12.isSelected()) artsScore++;

        if (medicalScore >= 3||artsScore>=3||engineeringscore>=3) {
            showAlert("You seem to enjoy this field!");
            engineeringPane.setVisible(false);
            medicalPane.setVisible(false);
            artsPane.setVisible(false);
            loadQuestionsForField();
        } else {
            newfieldtogglegroup = new ToggleGroup();
            medicalfieldradiobutton.setToggleGroup(newfieldtogglegroup);
            engineeringradiobutton.setToggleGroup(newfieldtogglegroup);
            artsradiobutton.setToggleGroup(newfieldtogglegroup);
            testPane.setVisible(false);
            medicalPane.setVisible(false);
            artsPane.setVisible(false);
            engineeringPane.setVisible(false);
            showAlert("You might want to consider another field.");


            if(checker == 1 )
            {
                newfieldPane.setVisible(true);
                medicalfieldradiobutton.setVisible(true);
                engineeringradiobutton.setVisible(true);
                artsradiobutton.setVisible(false);
            }
            if(checker == 2)
            {
                newfieldPane.setVisible(true);
                medicalfieldradiobutton.setVisible(false);
                engineeringradiobutton.setVisible(true);
                artsradiobutton.setVisible(false);
            }
            if(checker == 3)
            {
                newfieldPane.setVisible(true);
                medicalfieldradiobutton.setVisible(false);
                engineeringradiobutton.setVisible(false);
                artsradiobutton.setVisible(true);
            }


        }
    }

    private void loadQuestionsForField() {
        optionsGroup = new ToggleGroup();
        radiooption1.setToggleGroup(optionsGroup);
        radiooption2.setToggleGroup(optionsGroup);
        radiooption3.setToggleGroup(optionsGroup);
        radiooption4.setToggleGroup(optionsGroup);
        if (checker == 1) {
            currentQuestions = After12questions.getRandomMedicalQuestions();
        } else if (checker == 2) {
            currentQuestions = After12questions.getRandomEngineeringQuestions();
        } else {
            currentQuestions = After12questions.getRandomArtsQuestions();
        }

        if (currentQuestions != null && !currentQuestions.isEmpty()) {
            testPane.setVisible(true);
            loadNextQuestion();
        } else {
            showAlert("No questions available for the selected field.");
        }
    }











    private void loadNextQuestion() {
        Questions currentQuestion = currentQuestions.get(currentQuestionIndex);

        questionArea.setText(currentQuestion.questionText);
        radiooption1.setText(currentQuestion.options.get(0));
        radiooption2.setText(currentQuestion.options.get(1));
        radiooption3.setText(currentQuestion.options.get(2));
        radiooption4.setText(currentQuestion.options.get(3));

        optionsGroup.selectToggle(radiooption1);
        optionsGroup.selectToggle(radiooption2);
        optionsGroup.selectToggle(radiooption3);
        optionsGroup.selectToggle(radiooption4);

    }

    @FXML
    public void handleSubmitAnswer() {
        RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();

        if (selectedOption == null) {
            showAlert("Please select an option before submitting.");
            return;
        }

        int selectedAnswerIndex = optionsGroup.getToggles().indexOf(selectedOption) + 1;
        if (selectedAnswerIndex == currentQuestions.get(currentQuestionIndex).correctOption) {
            correctAnswers++;
        }

        currentQuestionIndex++;
        if (currentQuestionIndex < currentQuestions.size()) {
            loadNextQuestion();
        } else {

            showAlert("Test completed! Your score: " + calculateScore(correctAnswers));
            testPane.setVisible(false);
            iqtest();

        }
    }

    // field yahan sa change kara gas
    public void newfield()
    {   medicalPane.setVisible(false);
        artsPane.setVisible(false);
        engineeringPane.setVisible(false);
        newfieldPane.setVisible(false);

        if(medicalfieldradiobutton.isSelected()) {
            checker=1;

        }
        else if(engineeringradiobutton.isSelected()) {
            checker=2;
        }
        else if(artsradiobutton.isSelected()) {
            checker = 3;
        }
        testPane.setVisible(true);
        currentQuestionIndex=0;
        loadQuestionsForField();

    }

    public void iqtest()
    {
        try {

            Stage currentStage = (Stage) artsPane.getScene().getWindow();


            FXMLLoader loader = new FXMLLoader(getClass().getResource("fsciq3.fxml"));
            Parent root = loader.load();


            fsciq3Controller controller = loader.getController();
            controller.testscore(test.calculateScore(correctAnswers),checker);

            currentStage.setScene(new Scene(root));
            currentStage.show();
        } catch (IOException e) {
            showAlert("Error loading IQ test: " + e.getMessage());
            e.printStackTrace();
        }



    }




    private int calculateScore(int correctAnswers) {
        return correctAnswers * 10;
    }

    private void callToCareerClass() {
        mainPane.setVisible(false);
        personalityanchorpane.setVisible(true);
        if (checker == 1) {
            field = "medical";
            subfield= String.valueOf(Career.suggestMedicalField((double) tscore));
            showAlert("Based on your results, you are eligible for: " +

                    Career.suggestMedicalField((double) tscore));
        } else if (checker == 2) {
            field = "engineering";
            subfield= String.valueOf(Career.suggestEngineeringField((double) tscore));
            showAlert("Based on your results, you are eligible for: " +
                    Career.suggestEngineeringField((double) tscore));
        } else if (checker == 3) {
            field = "arts";
            subfield= String.valueOf(Career.suggestArtsField((double) tscore));
            showAlert("Based on your results, you are eligible for: " +
                    Career.suggestArtsField((double)    tscore));
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public void completescore(int totalscore,int cchecker)
    {
        checker=cchecker;
        tscore = totalscore;
        callToCareerClass();
        System.out.println("complete test");

    }

    public void exit(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Stage stage = (Stage) testPane.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void personalityno(){
        mainPane.setVisible(true);
        personalityanchorpane.setVisible(false);


    }
    public void personalityload(){
        try {

            Stage currentStage = (Stage) artsPane.getScene().getWindow();


            FXMLLoader loader = new FXMLLoader(getClass().getResource("Personality.fxml"));
            Parent root = loader.load();


            PersonalityController controller = loader.getController();
            controller.fieldfinder(field,subfield);

            currentStage.setScene(new Scene(root));
            currentStage.show();
        } catch (IOException e) {
            showAlert("Error loading IQ test: " + e.getMessage());
            e.printStackTrace();
        }

    }

    String field;
    String subfield;




}


