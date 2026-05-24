package com.example.frontend_of_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class a10controller {
    @FXML
    RadioButton cumputorbackgroundradiobutton, artsbackgroungradiobutton, sciencebackgroungradiobutton;
    @FXML
    AnchorPane backgroundanchorpane, computoranchorpane, artsanchorpane, scienceanchorpane, commonanchorpane1, testanchorpane1, fscscienceselectoranchorpane, fieldchangeanchorpane,fieldchangeanchorpane2,fieldchangeanchorpane3;
    @FXML
    ToggleGroup backgroundselector;


    @FXML
    Button b1science , b2ics , b3arts ;



    @FXML
    CheckBox lastyearcheckbox, programmingcheckbox, internetcheckbox, operatingsystemcheckbox, datastructurecheckbox,
            artslastyearcheckbox, artssubjectcheckbox, drawingcheckbox, ethicscheckbox, culturalcheckbox,
            enjoy, oka, okay, okayy, ok,
            premedical1checkbox, premedical2checkbox, premedical3checkbox, premedical4checkbox, premedical5checkbox,
            preengineering5, preengineering4, preengineering3, preengineering2, preengineering1;
    @FXML
    TextArea questionArea;
    @FXML
    RadioButton option1, option2, option3, option4;

    @FXML
    Button nextButton, submitButton;
    @FXML
    ToggleGroup optionGroup = new ToggleGroup();
    private List<After10questions> currentQuestions;

    private int currentQuestionIndex = 0;
    private int correctAnswers1 = 0;
    int medical = 0,arts= 0 ,computor =0;

    // ye new bnaye maina
    private int medicalbackground = 0 ;
    private int computerbackground = 0 ;
    private int artsbackground = 0 ;

// after 10 ka object
    private After10 test;

    public a10controller() {
        test= new After10()    ;
    }

    @FXML
    public void background() {

        // aik hi select ho ga in ma sa
        backgroundselector = new ToggleGroup();
        cumputorbackgroundradiobutton.setToggleGroup(backgroundselector);
        artsbackgroungradiobutton.setToggleGroup(backgroundselector);
        sciencebackgroungradiobutton.setToggleGroup(backgroundselector);



        if (cumputorbackgroundradiobutton.isSelected()) {
            computerbackground = 1;
            backgroundanchorpane.setVisible(false);
            computoranchorpane.setVisible(true);


        } else if (artsbackgroungradiobutton.isSelected()) {
            artsbackground = 1;
            backgroundanchorpane.setVisible(false);
            computoranchorpane.setVisible(false);
            artsanchorpane.setVisible(true);


        } else if (sciencebackgroungradiobutton.isSelected()) {
            medicalbackground = 1;

            backgroundanchorpane.setVisible(false);
            scienceanchorpane.setVisible(true);
        }


    }


    @FXML
    private void startTestBasedOnInterest() {
        commonanchorpane1.setVisible(false);
        testanchorpane1.setVisible(true);



        currentQuestionIndex = 0;
        correctAnswers1 = 0;
        optionGroup = new ToggleGroup();
        option1.setToggleGroup(optionGroup);// Load first question
        option2.setToggleGroup(optionGroup);
        option3.setToggleGroup(optionGroup);
        option4.setToggleGroup(optionGroup);

        loadNextQuestion();


    }
    private void loadNextQuestion() {
        if (currentQuestionIndex < currentQuestions.size() - 1) {
            nextButton.setDisable(false);
            submitButton.setDisable(true);
        } else {
            nextButton.setDisable(true);
            submitButton.setDisable(false);
        }
        if (currentQuestionIndex < currentQuestions.size()) {

            // apni aaraylist sa question nikaal kar yaha store karwa raha cureentquestion ma
            // current question index matlab arraylist ka wo wala index par jo question para wo

            After10questions currentQuestion = currentQuestions.get(currentQuestionIndex);

            questionArea.setText(currentQuestion.questionText);

            option1.setText(currentQuestion.options.get(0));
            option2.setText(currentQuestion.options.get(1));
            option3.setText(currentQuestion.options.get(2));
            option4.setText(currentQuestion.options.get(3));

            optionGroup.selectToggle(null);
        } else {
            finishTest();
        }
    }

// next wala button jo ha na test ka neecha uska sath ye wala method link ha
    // is method ma validations hain jo test ko Hnadle karti hain sahi sa

    @FXML
    private void handleNextButton() {
        if (optionGroup == null) {
            showAlert("Option group is not initialized.");
            return;
        }

        RadioButton selectedOption = (RadioButton) optionGroup.getSelectedToggle();
        if (selectedOption == null) {
            showAlert("Please select an option");
            return;
        }

        // hamara answer check karna ka liya
        int selectedIndex = optionGroup.getToggles().indexOf(selectedOption) + 1;

        if (currentQuestions == null || currentQuestionIndex < 0 || currentQuestionIndex >= currentQuestions.size()) {
            showAlert("Invalid question index");
            return;
        }

        After10questions currentQuestion = currentQuestions.get(currentQuestionIndex);

        if (currentQuestion == null) {
            showAlert("Current question is null");
            return;
        }

        if (selectedIndex == currentQuestion.correctOption) {
            correctAnswers1++;
        }

        currentQuestionIndex++;

        if (currentQuestionIndex < currentQuestions.size()) {
            loadNextQuestion();
        } else {
            finishTest();
        }
    }




//is tariqa sa aik class ma dosri class integrate karni ha

    // ...?

//    @FXML
//    private void okay() throws IOException
//    {
//        Stage stage = (Stage) backgroundanchorpane.getScene().getWindow();
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("Personality.fxml"));
//        Parent parent = loader.load();
//
//
//        PersonalityController controller = loader.getController();
//        stage.setScene(new Scene(parent));
//        stage.show();
//        stage.setFullScreen(true);
//    }


    @FXML
    private void finishTest() {
showAlert("Your Test score is :"+test.calculateScore(correctAnswers1));

// iq integrate idher
        try {


            Stage currentStage = (Stage) submitButton.getScene().getWindow();


            FXMLLoader loader = new FXMLLoader(getClass().getResource("fsciq2.fxml"));
            Parent root = loader.load();


            fsciqController controller = loader.getController();
            controller.testscore(test.calculateScore(correctAnswers1),medical,prevarts,prevcomp);


            currentStage.setScene(new Scene(root));
            currentStage.show();
        } catch (IOException e) {
            showAlert("Error loading IQ test: " + e.getMessage());
            e.printStackTrace();
        }


    }



    public void artshyperlink() {
        prevarts = 1;

        currentQuestions = After10questions.getArtsQuestions();
        fieldchangeanchorpane3.setVisible(false);
        fieldchangeanchorpane2.setVisible(false);
        testanchorpane1.setVisible(true);


        currentQuestionIndex = 0;


        optionGroup = new ToggleGroup();
        option1.setToggleGroup(optionGroup);
        option2.setToggleGroup(optionGroup);
        option3.setToggleGroup(optionGroup);
        option4.setToggleGroup(optionGroup);
        optionGroup.selectToggle(null);

        loadNextQuestion();
    }

    public void computorhyperlink() {
        prevcomp = 1;

        currentQuestions = After10questions.getIcsQuestions();
        fieldchangeanchorpane2.setVisible(false);
        testanchorpane1.setVisible(true);


        currentQuestionIndex = 0;


        optionGroup = new ToggleGroup();
        option1.setToggleGroup(optionGroup);
        option2.setToggleGroup(optionGroup);
        option3.setToggleGroup(optionGroup);
        option4.setToggleGroup(optionGroup);
        optionGroup.selectToggle(null);

        loadNextQuestion();
    }


    public void completescore(int score, int medical, int arts, int comp)
    {
        if(score<=50 )

        {


            testanchorpane1.setVisible(false);
            backgroundanchorpane.setVisible(false);
            showAlert("u r not eligible for this due to low marks");
            showAlert("please select another field as u r not eligilbe for this .");
            if(medical==1)
            {

                fieldchangeanchorpane.setVisible(true);
            }
            else if (arts ==1)
            {

                fieldchangeanchorpane.setVisible(true);


            }
            else if(comp ==1){
                fieldchangeanchorpane.setVisible(true);
                b1science.setVisible(false);

            }
        }
        else{
            if(medical == 1)
            {
                backgroundanchorpane.setVisible(false);
                fscscienceselectoranchorpane.setVisible(true);
            }
            showAlert("Recomennded"+ medical);
        }
    }






    public void artsInterest1() {
        int interest = 0;

        if (artssubjectcheckbox.isSelected()) interest++;
        if (drawingcheckbox.isSelected()) interest++;
        if (ethicscheckbox.isSelected()) interest++;
        if (culturalcheckbox.isSelected()) interest++;
        if (artslastyearcheckbox.isSelected()) interest++;

        if (interest >= 3) {
            currentQuestions = After10questions.getArtsQuestions();
            arts =1;
            medical =0;
            artsanchorpane.setVisible(false);
            commonanchorpane1.setVisible(true);


        }else {
            artsanchorpane.setVisible(false);
            fieldchangeanchorpane3.setVisible(true);
        }

    }


    // interest check karna wala Method . Interest ko vlaid kara ga
    public void scienceInterest1() {
        int interest = 0;

        if (enjoy.isSelected()) interest++;
        if (ok.isSelected()) interest++;
        if (oka.isSelected()) interest++;
        if (okayy.isSelected()) interest++;
        if (okay.isSelected()) interest++;

        if (interest >=3) {
            medical = 2;
            scienceanchorpane.setVisible(false);
            commonanchorpane1.setVisible(true);

            currentQuestions = After10questions.getScienceQuestions();
            medical=1;
        }else {
            showAlert("It seems You didn't Enjoy your Previous Field.U Should Think to Switch field!");
            scienceanchorpane.setVisible(false);
            fieldchangeanchorpane.setVisible(true);
        }

    }

    // Jab Switch field kara ga . Tu wahan jo button hain . Wo in Methods ka sth Link ha
    public void ics()
    {   medical=0;
        prevcomp=1;
        currentQuestions = After10questions.getIcsQuestions();
        startTestBasedOnInterest();
        fieldchangeanchorpane.setVisible(false);
    }
    @FXML
    public void artss()
    {   prevarts=1;
        medical=0;
        fieldchangeanchorpane.setVisible(false);
        fieldchangeanchorpane3.setVisible(false);
        fieldchangeanchorpane2.setVisible(false);
        testanchorpane1.setVisible(true);
        currentQuestions = After10questions.getArtsQuestions();
        startTestBasedOnInterest();

    }
    public void sciece()
    {
        medical=1;
        fieldchangeanchorpane.setVisible(false);
        currentQuestions = After10questions.getScienceQuestions();
        startTestBasedOnInterest();

    }

    int prevarts=0;
    int prevcomp=0;

    @FXML
    public void computerInterest() {
        int interest = 0;
        if (programmingcheckbox.isSelected()) interest++;
        if (internetcheckbox.isSelected()) interest++;
        if (lastyearcheckbox.isSelected()) interest++;
        if (internetcheckbox.isSelected()) interest++;
        if (datastructurecheckbox.isSelected()) interest++;

        if (interest >= 3) {
            computoranchorpane.setVisible(false);
            commonanchorpane1.setVisible(true);
            computor=1;
            medical=0;
            currentQuestions = After10questions.getIcsQuestions();
        } else {
            computoranchorpane.setVisible(false);
            fieldchangeanchorpane2.setVisible(true);
        }

    }

    public void fieldChange() {
        fscscienceselectoranchorpane.setVisible(false);
        fieldchangeanchorpane.setVisible(true);
    }




    // ye fsc ma usko bta rha ka kiya choose karna (medical ya engineerning)
    @FXML
    public void fscselector(){
        int interest = 0;
        int interest2  = 0;
        if(premedical1checkbox.isSelected()) interest++;
        if(premedical2checkbox.isSelected()) interest++;
        if(premedical3checkbox.isSelected()) interest++;
        if(premedical4checkbox.isSelected()) interest++;
        if(premedical5checkbox.isSelected()) interest++;



        if(preengineering1.isSelected()) interest2++;
        if(preengineering2.isSelected()) interest2++;
        if(preengineering3.isSelected()) interest2++;
        if(preengineering4.isSelected()) interest2++;
        if (preengineering5.isSelected()) interest2++;

        if(interest>interest2)
        {
            showAlert("Pre Medicle RECOMENDED FIELD");
            backgroundanchorpane.setVisible(true);
            fscscienceselectoranchorpane.setVisible(false);
        }
        else if( interest2> interest)
        {
            showAlert("Pre Engineering  BESTLY RECOMENDED for You");
            backgroundanchorpane.setVisible(true);
            fscscienceselectoranchorpane.setVisible(false);
        }

        else if(interest2 == 0 && interest == 0){
            showAlert("Select Any Option To Proceed Further");
        }

        else  if (interest2 == interest){
            showAlert("Pre Medicle RECOMENDED FIELD");
            backgroundanchorpane.setVisible(true);
            fscscienceselectoranchorpane.setVisible(false);
        }





    }



    private void handleIQTestCompletion(int iqScore) {

        showAlert("IQ Test Completed! Your IQ Score: " + iqScore);


    }



    public void exit() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Stage stage = (Stage) computoranchorpane.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
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