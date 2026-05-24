package com.example.frontend_of_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class before10Controller {



    @FXML
    private CheckBox fictionCheckBox;
    @FXML
    private CheckBox machinesCheckBox;
    @FXML
    private CheckBox experimentsCheckBox;
    @FXML
    private CheckBox universecheckbox;
    @FXML
    private CheckBox chemicalreactioncheckbox;
    @FXML
    private CheckBox drawingCheckBox;
    @FXML
    private CheckBox literatureCheckBox;
    @FXML
    private CheckBox performingCheckBox;
    @FXML
    private CheckBox videogamesCheckBox;
    @FXML
    private CheckBox softwareCheckBox;
    @FXML
    private CheckBox codingCheckBox;
    @FXML
    private CheckBox aicheckbox;
    @FXML
    private Button discoverButton;
    @FXML
    private Label resultLabel;
    @FXML
    private Label againTest;
    @FXML
    private Hyperlink reconduct;
    @FXML
    private Hyperlink fieldswitch;

    @FXML
    private TextArea questionArea;
    @FXML
    private RadioButton option1, option2, option3,option4  ;
    @FXML
    private ToggleGroup optionGroup;
    @FXML
    private Button nextButton, submitButton;
    @FXML
    private Label scoreLabel, interestLabel, titleLabel;
    @FXML
    private VBox interestDiscoveryContainer;
    @FXML
    private VBox testContainer;
    @FXML
    private AnchorPane againtestanchorpane,fieldselectionanchorpane,exitanchorpane;
    @FXML
    Button back;
    @FXML
    private RadioButton artsradiobutton,scienceradiobutton,computorradiobutton;
    @FXML
    private ToggleGroup fieldselector;
    private before10 test;
    private List<b10questions> currentQuestions;

    private int currentQuestionIndex = 0;
    private int correctAnswers1 = 0;
    private int scienceScore = 0, artsScore = 0, computerScore = 0;
    private int totalScore;
    ArrayList<Integer> b10marks = new ArrayList<>();

    public void initialize() {



        {
            loadfromfile();
            interestDiscoveryContainer.setVisible(true);
            testContainer.setVisible(false);



        }




        test = new before10();



        optionGroup = new ToggleGroup();
        option1.setToggleGroup(optionGroup);
        option2.setToggleGroup(optionGroup);
        option3.setToggleGroup(optionGroup);
        option4.setToggleGroup(optionGroup);


        submitButton.setDisable(true);
    }

    @FXML
    private void handleDiscoverInterest() {

        scienceScore = 0;
        artsScore = 0;
        computerScore = 0;


        if (fictionCheckBox.isSelected()) scienceScore++;
        if (machinesCheckBox.isSelected()) scienceScore++;
        if (experimentsCheckBox.isSelected()) scienceScore++;
        if(chemicalreactioncheckbox.isSelected()) scienceScore++;
        if (universecheckbox.isSelected()) scienceScore++;




        if (drawingCheckBox.isSelected()) artsScore++;
        if (literatureCheckBox.isSelected()) artsScore++;
        if (performingCheckBox.isSelected()) artsScore++;



        if (videogamesCheckBox.isSelected()) computerScore++;
        if (softwareCheckBox.isSelected()) computerScore++;
        if (codingCheckBox.isSelected()) computerScore++;
        if(aicheckbox.isSelected()) computerScore++;




        String primaryInterest = determinePrimaryInterest();


        resultLabel.setText("Your primary interest is: " + primaryInterest);


        interestDiscoveryContainer.setVisible(false);
        testContainer.setVisible(true);


        startTestBasedOnInterest();





    }

    private String determinePrimaryInterest(){
        if (scienceScore > artsScore && scienceScore > computerScore) {
            currentQuestions =b10questions.getScienceQuestions();
            test.interest = 1;
            return "Science";
        } else if (artsScore > scienceScore && artsScore > computerScore) {
            currentQuestions =b10questions.getArtsQuestions();

            test.interest = 2;
            return "Arts";
        } else if (computerScore > scienceScore && computerScore > artsScore) {
            test.interest = 3;
            currentQuestions =b10questions.getComputerQuestions();

            return "Computers";

        }else if (computerScore > scienceScore && artsScore > scienceScore && computerScore == artsScore) {
            test.interest = 3;
            currentQuestions =b10questions.getComputerQuestions();

            return "Computers";

        }
        else  {
            currentQuestions =b10questions.getScienceQuestions();
            return "Science";
        }


    }



    private void startTestBasedOnInterest() {



        currentQuestionIndex = 0;
        correctAnswers1 = 0;

        loadNextQuestion();
    }

    private void loadNextQuestion() {
        if(currentQuestionIndex<currentQuestions.size()-1)
        {
            nextButton.setDisable(false);
            submitButton.setDisable(true);
        }
        else {
            nextButton.setDisable(true);
            submitButton.setDisable(false);
        }
        if (currentQuestionIndex < currentQuestions.size()) {
            b10questions currentQuestion = currentQuestions.get(currentQuestionIndex);


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


    @FXML
    private void handleNextButton() {

        RadioButton selectedOption = (RadioButton) optionGroup.getSelectedToggle();
        if (selectedOption == null) {
            showAlert("Please select an option");
            return;
        }


        int selectedIndex = optionGroup.getToggles().indexOf(selectedOption) + 1;
        b10questions currentQuestion = currentQuestions.get(currentQuestionIndex);
        if (selectedIndex == currentQuestion.correctOptions) {

            correctAnswers1++;

        }


        currentQuestionIndex++;


        if (currentQuestionIndex < currentQuestions.size()) {

            loadNextQuestion();

        } else {
            finishTest();
        }
    }
    @FXML
    private void finishTest() {
        showAlert("your score in knowledge test is"+ test.calculateScore(correctAnswers1));
        try{
            startIQTest(test.calculateScore(correctAnswers1));
        }catch (IOException e)
        {

        }

    }
    public void completescore(int score){
        totalScore = score;
        b10marks.add(totalScore);
        savetofile();
        if (score <= 50) {
            againtestanchorpane.setVisible(true);
            nextButton.setDisable(false);
            submitButton.setDisable(true);
            testContainer.setVisible(false);

            againTest.setText("Your score is " + score+
                    " which is too low! You should retake the test, change your field, or work harder in the future.");
            interestDiscoveryContainer.setVisible(false);

            fieldselectionanchorpane.setVisible(false);
        } else {
            interestDiscoveryContainer.setVisible(false);
            againtestanchorpane.setVisible(false);
            testContainer.setVisible(false);
            fieldselectionanchorpane.setVisible(false);


            System.out.println("llllllllllllllllll");
            exitanchorpane.setVisible(true);
           showAlert("Recommended "+determinePrimaryInterest());


        }
}

@FXML void exit()
{
    try {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Stage stage = (Stage) exitanchorpane.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();


    } catch (IOException e) {
        e.printStackTrace();
    }

}



    private String determineInterestText() {
        switch (test.interest) {
            case 1: return "Science";
            case 2: return "Arts";
            case 3: return "Computers";
            case 4: return "Science and Computers";
            default: return "Undetermined";
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
    @FXML
    private void testReconduct(ActionEvent e)
    {
        if(e.getSource() ==reconduct)
        {
            currentQuestionIndex =0;
            interestDiscoveryContainer.setVisible(false);
            againtestanchorpane.setVisible(false);
            fieldselectionanchorpane.setVisible(false);
            switch (test.interest)
            {
                case 1:
                    currentQuestions = b10questions.getScienceQuestions();
                    break;
                case 2:
                    currentQuestions = b10questions.getArtsQuestions();

                    break;
                case 3:
                    currentQuestions = b10questions.getComputerQuestions();

                    break;
                default:
                    currentQuestions = b10questions.getScienceQuestions();

            }
            startTestBasedOnInterest();
            testContainer.setVisible(true);

        }
        if(e.getSource() == fieldswitch)
        {
            interestDiscoveryContainer.setVisible(false);
            againtestanchorpane.setVisible(false);
            testContainer.setVisible(false);
            fieldselectionanchorpane.setVisible(true);
            fieldselector = new ToggleGroup();
            artsradiobutton.setToggleGroup(fieldselector);
            scienceradiobutton.setToggleGroup(fieldselector);
            computorradiobutton.setToggleGroup(fieldselector);

        }

    }
    @FXML
    private void fieldswitchsubmit()
    {
        currentQuestions = null;
        currentQuestionIndex=0;
        if(artsradiobutton.isSelected())
        {
            currentQuestions= b10questions.getArtsQuestions();
            fieldselectionanchorpane.setVisible(false);
            testContainer.setVisible(true);
            startTestBasedOnInterest();
        }
        else if(scienceradiobutton.isSelected())
        {
            currentQuestions = b10questions.getScienceQuestions();
            fieldselectionanchorpane.setVisible(false);
            testContainer.setVisible(true);
            startTestBasedOnInterest();
        }
        else if(computorradiobutton.isSelected())
        {
            currentQuestions = b10questions.getComputerQuestions();
            fieldselectionanchorpane.setVisible(false);
            testContainer.setVisible(true);
            startTestBasedOnInterest();

        }




    }

    public void startIQTest( int testscore) throws IOException {
        Stage currentStage = (Stage) againtestanchorpane.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("IQTestController.fxml"));
        Parent root = loader.load();


        IQTestController iqTestController = loader.getController();
        iqTestController.testscore(testscore);



        Scene scene = new Scene(root);
        currentStage.setScene(scene);
        currentStage.show();

    }


    private void handleIQTestCompletion(int iqScore) {

        showAlert("IQ Test Completed! Your IQ Score: " + iqScore);


    }
@FXML
    public void back(ActionEvent actionEvent) throws IOException{
    try {
        Parent root = FXMLLoader.load(getClass().getResource("Students.fxml"));
        Stage stage = (Stage) againtestanchorpane.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();


    } catch (IOException e) {
        e.printStackTrace();
    }


}

//...?
static int i;
public static void Studentindex(int index)
{
    i =index;
}
    public void loadfromfile() {
        Scanner filereader = new Scanner("btest" + i + ".txt");
        while(!filereader.hasNextLine())
        {
         b10marks.add(filereader.nextInt());
        }



    }


    File myfile = new File("btest" + i + ".txt");


public void savetofile() {
    try{
    if(!myfile.exists())
    {
        myfile.createNewFile();
    }
        FileWriter writer = new FileWriter("btest" + i + ".txt");
    for(int n:b10marks) {
        writer.write(totalScore+"\n");
    }
    writer.close();
    }catch (IOException e)
    {
        System.out.println("b 1o file not opened");
    }


}
}