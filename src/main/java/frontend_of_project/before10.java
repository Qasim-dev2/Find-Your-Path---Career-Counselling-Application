package com.example.frontend_of_project;

import java.util.Scanner;
import java.util.*;

public class before10 extends Test {
    IQtest iq = new IQtest();
    static int flag;
    static Scanner sc = new Scanner(System.in);
    List<b10questions> questions;
    List<b10questions> questions2;
    int interest;
    public before10(String testName, List<b10questions> questions) {
        super(testName);
        this.questions = questions;
        this.questions2 = null;
    }

    public before10() {
        super("Before 10");
        this.questions = new ArrayList<>();
        this.questions2 = new ArrayList<>();
        flag=1;
    }
    public void findInterest() {
        Scanner scanner = new Scanner(System.in);
        int scienceScore = 0, artsScore = 0, computerScore = 0;

        System.out.println("Answer the following questions (1 for Yes, 0 for No):");


        System.out.println("Do you enjoy study Fictions?");
        scienceScore += scanner.nextInt();

        System.out.println("Are you curious about how things work (e.g., machines, engines)?");
        scienceScore += scanner.nextInt();

        System.out.println("Do you enjoy conducting experiments?");
        scienceScore += scanner.nextInt();


        System.out.println("Do you enjoy drawing, painting, or creating art?");
        artsScore += scanner.nextInt();

        System.out.println("Are you interested in literature, poetry, or storytelling?");
        artsScore += scanner.nextInt();

        System.out.println("Do you enjoy music, acting, or performing?");
        artsScore += scanner.nextInt();


        System.out.println("Do you enjoy playing or designing video games?");
        computerScore += scanner.nextInt();

        System.out.println("Are you curious about how software and apps work?");
        computerScore += scanner.nextInt();

        System.out.println("Do you enjoy working with gadgets or coding?");
        computerScore += scanner.nextInt();


        if (scienceScore > artsScore && scienceScore > computerScore) {
            interest = 1;
            System.out.println("your interest is in science ");
            System.out.println("Do u want to check whether u continue in it or not by giving a test");
            questions = b10questions.getScienceQuestions();

        } else if (artsScore > scienceScore && artsScore > computerScore) {
            interest = 2;
            System.out.println("your interest is in arts ");
            System.out.println("Do u want to check whether u continue in it or not by giving a test");
            questions = b10questions.getComputerQuestions();

        } else if (computerScore > scienceScore && computerScore > artsScore) {
            interest = 3;
            System.out.println("your interest is in computers ");

            System.out.println("Do u want to check whether u continue in it or not by giving a test");
            questions = b10questions.getArtsQuestions();

        } else if (scienceScore == computerScore&& artsScore == 0) {
            interest = 4;
            System.out.println("your interest is in both science and computer");
            questions = b10questions.getComputerQuestions();
            questions2 = b10questions.getScienceQuestions();


        }
    }

    @Override
    public void startTest() {
        int correctAnswers1 = 0, correctAnswers2 = 0;

        System.out.println("Starting your test...");

        System.out.println(" first u have to take iq test!!!");
        iq.startTest();
        System.out.println("iq score"+iq.calculateScore(iq.correctAnswers));


        for (int i = 0; i < questions.size(); i++) {
            b10questions question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.questionText);
            System.out.println("Options are: " + question.options);
            int answer = 0;


            System.out.print("Enter your choice (1-" + question.options.size() + "): ");
            answer = Integer.parseInt(sc.nextLine());


            if (answer == question.correctOptions) {
                correctAnswers1++;
            }
        }


        System.out.println("Test completed! Your score: " + calculateScore(correctAnswers1));


        if (questions2 != null) {
            for (int i = 0; i < questions2.size(); i++) {
                b10questions question = questions2.get(i);
                System.out.println("Question " + (i + 1) + ": " + question.questionText);
                System.out.println("Options are: " + question.options);
                int answer = 0;


                System.out.print("Enter your choice (1-" + question.options.size() + "): ");
                answer = Integer.parseInt(sc.nextLine());


                if (answer == question.correctOptions) {
                    correctAnswers2++;
                }
                System.out.println("Test completed! Your score: " + calculateScore(correctAnswers2));
            }


            if (correctAnswers1 > correctAnswers2) {
                System.out.println("interest is in computer");
            } else if (correctAnswers2 > correctAnswers1) {
                System.out.println("Interest is in science");

            }
        }
    }





    @Override
    public int calculateScore(int correctAnswers) {
        return correctAnswers * 10;
    }
}
