package com.example.frontend_of_project;

public abstract class Test {
    private String testName;
    int correctAnswers = 0;

    int score = 0;

    public Test(String testName) {
        this.testName = testName;
    }


    public abstract void startTest();
    public abstract int calculateScore(int correctAnswers);


    public String getTestName() {
        return testName;
    }
}
