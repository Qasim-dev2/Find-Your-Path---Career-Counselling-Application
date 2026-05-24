package com.example.frontend_of_project;

import java.util.List;

public abstract class   Questions {

    String questionText;
    List<String> options;
    int correctOption;

    public Questions(int correctOption, List<String> options, String questionText) {
        this.correctOption = correctOption;
        this.options = options;
        this.questionText = questionText;
    }







}
