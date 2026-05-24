package com.example.frontend_of_project;

import java.util.Scanner;
import java.util.List;

public class After10 extends Test {
    static int flag = 0;
    static Scanner sc = new Scanner(System.in);
    List<After10questions> selectedQuestions;
    IQtest iq = new IQtest();


    public After10() {
        super("After 10");
        this.correctAnswers = 0;
        this.score = 0;
        flag =1;
        IQtest iq = new IQtest();
    }

    @Override
    public void startTest() {
        System.out.println("Welcome to the After 10 Test!");

        int medicalquestions = 0;
        int engineeringquestions = 0;
        int artsquestions = 0;


        int interest = 0;
        int choice;
        boolean validInterest = false;

        System.out.println("First Tell me About ur BackGround");
        System.out.println("In which Subjects u have Passed Matriculation:");
                System.out.println("1. Science");
                System.out.println("2. Computer");
                System.out.println("3. Arts");
        System.out.println("Answer... ");
        choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Your History is in Science");
                System.out.println("Lets Tell me Some Questions About You. So I will better Understand you and Accomodate u well.");
                System.out.println("Questions...");
                System.out.println("Press 1 for Yes / 0 for No");

                System.out.println("Did u Enjoy the Last Two years of ur Study");
                medicalquestions += sc.nextInt();

                System.out.println("Did you enjoy the Biology");
                medicalquestions += sc.nextInt();

                System.out.println("Did you Enjoy Doing New Experiments");
                medicalquestions += sc.nextInt();

                System.out.println("Did you Enjoy Frog Operation");
                medicalquestions += sc.nextInt();

                System.out.println("Did you Enjoy Chemistry");
                medicalquestions += sc.nextInt();

                if (medicalquestions >= 4 ){

                    System.out.println("Seems u Enjoy Science");
                    selectedQuestions = After10questions.getScienceQuestions();
                }
                else {
                    System.out.println("Seems Like ur Not Interested in this Field");
                    System.out.println("Wanna Switch");
                    System.out.println(" U have an Option to Switch To Pre-Engineering");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    choice = sc.nextInt();
                    switch (choice){
                        case 1:
                            System.out.println("Field Switched...");
                            System.out.println("Lets Give a Test to check ur Knowlege");
                            selectedQuestions = After10questions.getIcsQuestions();
                            break;
                        case 2:
                            System.out.println("Stick to Medical");
                            System.out.println("Lets Give a Test to check ur Knowlege");
                            selectedQuestions = After10questions.getScienceQuestions();
                    }
                }
                break;
            case 2:
                System.out.println("Your History is in Computer");
                System.out.println("Lets Tell me Some Questions About You. So I will better Understand you and Accomodate u well.");
                System.out.println("Questions...");
                System.out.println("Press 1 for Yes / 0 for No");

                System.out.println("Did u Enjoy the Last Two years of ur Study");
                engineeringquestions += sc.nextInt();

                System.out.println("Did you enjoy the Programming");
                engineeringquestions += sc.nextInt();

                System.out.println("Did you Enjoy the Internet");
                engineeringquestions += sc.nextInt();

                System.out.println("Did you Enjoy the Operating Systems");
                engineeringquestions += sc.nextInt();

                System.out.println("Did you Enjoy the Data Structures");
                engineeringquestions += sc.nextInt();

                if (engineeringquestions >= 4 ){
                    interest = 2;
                    System.out.println("Seems u Enjoy Computer Science");
                    selectedQuestions = After10questions.getIcsQuestions();
                }
                else {
                    System.out.println("Seems Like ur Not Interested in this Field");
                    System.out.println("Wanna Switch");
                    System.out.println(" U have an Option to Switch To Arts");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    choice = sc.nextInt();
                    switch (choice){
                        case 1:
                            System.out.println("Field Switched...");
                            System.out.println("Lets Give a Test to check ur Knowlege");
                            selectedQuestions = After10questions.getArtsQuestions();
                            break;
                        case 2:
                            System.out.println("Stick to Computer");
                            System.out.println("Lets Give a Test to check ur Knowlege");
                            selectedQuestions = After10questions.getIcsQuestions();
                    }
                }
                break;
            case 3:
                System.out.println("Your History is in Arts");
                System.out.println("Lets Tell me Some Questions About You. So I will better Understand you and Accomodate u well.");
                System.out.println("Questions...");
                System.out.println("Press 1 for Yes / 0 for No");

                System.out.println("Did u Enjoy the Last Two years of ur Study");
                artsquestions += sc.nextInt();

                System.out.println("Did you enjoy the Dance");
                artsquestions += sc.nextInt();

                System.out.println("Did you enjoy the Music");
                artsquestions += sc.nextInt();

                System.out.println("Did you Enjoy the Theater");
                artsquestions += sc.nextInt();

                System.out.println("Did you Enjoy the Visual Art");
                artsquestions += sc.nextInt();

                if (artsquestions >= 4 ){
                    interest = 3;
                    System.out.println("Seems u Enjoy Arts");
                    selectedQuestions = After10questions.getArtsQuestions();
                }
                else {
                    System.out.println("Seems u not Enjoyed.No options u have . Go with it ." +
                            "Or Repeat the Matriculations With the Subjects of ur Interest");
                }
                break;
        }





        System.out.println("Starting your test...");
        System.out.println(" first u have to take iq test!!!");
        iq.startTest();
        System.out.println("iq score "+iq.calculateScore(iq.correctAnswers));


        for (int i = 0; i < selectedQuestions.size(); i++) {
            Questions question = selectedQuestions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.questionText);
            System.out.println("Options are: " + question.options);

            int answer = 0;
            boolean validAnswer = false;


            while (!validAnswer) {
                try {
                    System.out.print("Enter your choice: ");
                    answer = Integer.parseInt(sc.nextLine());
                    if (answer < 1 || answer > question.options.size()) {
                        throw new IllegalArgumentException("Invalid choice, please select a valid option.");
                    }
                    validAnswer = true;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (answer == question.correctOption) {
                correctAnswers++;
            }
        }

        score = calculateScore(correctAnswers);
        System.out.println("Test completed! Your score: " + score);

    }

    @Override
    public int calculateScore(int correctAnswers) {
        return correctAnswers * 10;
    }
}
