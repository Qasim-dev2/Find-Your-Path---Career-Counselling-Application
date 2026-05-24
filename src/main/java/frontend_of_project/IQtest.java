package com.example.frontend_of_project;

import java.util.List;
import java.util.Scanner;

public class IQtest extends Test {
    static Scanner sc = new Scanner(System.in);
    static int iqscore = 0;
    private List<IQquestions> questions;

    int correctAnswers = 0;

    public IQtest() {
        super("IQ Test");
        this.questions = IQquestions.getIQQuestions();
    }


    public List<IQquestions> getQuestions() {
        return questions;
    }


    public void incrementCorrectAnswers() {
        correctAnswers++;
    }


    public int getCorrectAnswers() {
        return correctAnswers;
    }

    @Override
    public void startTest() {
        System.out.println("Starting " + getTestName() + "...");


        correctAnswers = 0;

        for (int i = 0; i < questions.size(); i++) {
            IQquestions question = questions.get(i);
            System.out.println("Q" + (i + 1) + ": " + question.questionText);
            System.out.println("Options: " + question.options);
            System.out.println("Enter your choice (1-" + question.options.size() + "): ");

            int userAnswer = sc.nextInt();

            if (question.correctOption == userAnswer) {
                correctAnswers++;
            }
        }

        iqscore = calculateScore(correctAnswers);

        System.out.println("Test Completed. Your IQ Score is: " + calculateScore(correctAnswers));
    }

    @Override
    public int calculateScore(int correctAnswers) {
        return correctAnswers * 10;
    }
}