package com.example.frontend_of_project;

import java.util.*;

public class After12 extends Test {
    static Scanner sc = new Scanner(System.in);
    List<Questions> questions;
    int correctAnswers = 0;
    int score;
    static int flag = 0;
    IQtest iq = new IQtest();
    int checker=0;

    // personality ka object
    PersonalityTest2 personalityTest2 = new PersonalityTest2();

    public After12() {
        super("After 12");
        this.questions = new ArrayList<>();
        flag = 1;
    }

    @Override
    public void startTest() {
        int medicalquestions = 0;
        int engineeringquestions = 0;
        int artsQuestions = 0;



        System.out.println("Welcome to the After 12 Test!");
        System.out.println("Select your History:");
        System.out.println("1. pre-Medical");
        System.out.println("2. pre-Engineering");
        System.out.println("3. Arts");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Your History is Pre-Medical");
                System.out.println("Tell me some basic Questions about ur field");
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

                if (medicalquestions >= 4) {
                    System.out.println("Seems u Enjoy...");
                    System.out.println("Lets Narrow Down the Medical Fields for u");
                    medicaloptions();
                } else {
                    System.out.println("Seems not Enjoy");
                    System.out.println("Switch to Engineering");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Switch to Engineering");
                            engineeringoptions();
                            break;
                        case 2:
                            System.out.println("Stick to Medical");
                            medicaloptions();
                            break;
                    }
                }
                break;

            case 2:
                System.out.println("Your History is Pre-Engineering");
                System.out.println("Tell me some basic Questions about ur field");
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

                if (engineeringquestions >= 4) {
                    System.out.println("Seems u Enjoy...");
                    System.out.println("Lets Narrow Down the Engineering Fields for u");
                    engineeringoptions();
                } else {
                    System.out.println("Seems not Enjoy");
                    System.out.println("You have only this Option left.");
                    System.out.println("Go back to inter Level and Repeat");
                    System.out.println("Find ur Interest their in any other field");
                }
                break;
            case 3:
                System.out.println("Your History is Arts");
                System.out.println("Tell me some basic Questions about ur field");
                System.out.println("Questions...");
                System.out.println("Press 1 for Yes / 0 for No");

                System.out.println("Did u Enjoy the Last Two years of ur Study");
                artsQuestions += sc.nextInt();

                System.out.println("Did you enjoy the Painting");
                artsQuestions += sc.nextInt();

                System.out.println("Did you Enjoy the Drawing");
                artsQuestions += sc.nextInt();

                System.out.println("Did you Enjoy the Music");
                artsQuestions += sc.nextInt();

                System.out.println("Did you Enjoy the Theater");
                artsQuestions += sc.nextInt();

                if (artsQuestions >= 4) {
                    System.out.println("Seems u Enjoy...");
                    System.out.println("Good");
                    artsOptions();
                } else {
                    System.out.println("Go Back.");
                    System.out.println("Find ur Interest their in any other field");
                }
                break;
        }


        for (int i = 0; i < questions.size(); i++) {
            Questions question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.questionText);
            System.out.println("Options are: " + question.options);
            int answer = 0;
            boolean validAnswer = false;


            while (!validAnswer) {
                try {
                    System.out.print("Enter your choice (1-" + question.options.size() + "): ");
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
        System.out.println("Test Completed. Your Score is: " + score);
        callToCareerClass();



    }


    @Override
    public int calculateScore(int correctAnswers) {
        return correctAnswers * 10;
    }

    public void engineeringoptions() {
        System.out.println("You have Differnent options in Engineering");
        System.out.println("1. Chemical Engineering");
        System.out.println("2. Mechnical Engineering");
        System.out.println("3. Civil Engineering");
        System.out.println("4. Computer Engineering");
        questions = After12questions.getRandomEngineeringQuestions();
        checker =2;


    }

    public void medicaloptions() {
        System.out.println("Options You Hvae...");
        System.out.println("1."+MedicalSubField.MBBS);
        System.out.println("2."+MedicalSubField.BDS);
        System.out.println("3."+MedicalSubField.DPt);
        System.out.println("4." +MedicalSubField.PHARMACY);
        System.out.println("5."+MedicalSubField.NURSING);
        System.out.println("6."+MedicalSubField.DIPLOMA);
        questions = After12questions.getRandomMedicalQuestions();
        checker = 1;
    }

    public void artsOptions() {
        System.out.println("Options You Have...");
        System.out.println("1. Fine Arts");
        System.out.println("2. Literature");
        System.out.println("3. History");
        System.out.println("4. Music");
        System.out.println("5. Other");
        questions = After12questions.getRandomArtsQuestions();
        checker = 3;
    }



    public void callToCareerClass()
    {
        if(checker == 1)
        {
            System.out.println( "Based on your merit. you r eligible for  "+
            Career.suggestMedicalField(1.0*(calculateScore(correctAnswers)+iq.calculateScore(iq.correctAnswers))));

            System.out.println("do u want to check your personality and then job which suits u");
            System.out.println("Enter 1:");
            int check = sc.nextInt();
             if(check ==1) {
                 PersonalityTest2 p = new PersonalityTest2();
                 p.startTest();
                 p.suggestMedicalJob(Career.suggestMedicalField(1.0 * (calculateScore(correctAnswers) + iq.calculateScore(iq.correctAnswers))),p.personality);
             }



        }
        else if(checker == 2)
        {
            System.out.println(Career.suggestEngineeringField(1.0*(calculateScore(correctAnswers)+iq.calculateScore(iq.correctAnswers))));
            PersonalityTest2 p = new PersonalityTest2();
            p.startTest();
            p.suggestEngineeringJob(Career.suggestEngineeringField(1.0*(calculateScore(correctAnswers)+iq.calculateScore(iq.correctAnswers))),p.personality);
        }
        else {
            System.out.println(Career.suggestArtsField(1.0*(calculateScore(correctAnswers)+iq.calculateScore(iq.correctAnswers))));

        }

    }
    }