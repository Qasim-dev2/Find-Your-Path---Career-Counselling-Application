package com.example.frontend_of_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IQquestions extends Questions {


    public IQquestions(String questionText, List<String> options, int correctAnswer) {
        super(correctAnswer, options, questionText);

    }

     static ArrayList<IQquestions> questions = new ArrayList<>();
    public static List<IQquestions> getIQQuestions() {

        try {
            questions.add(new IQquestions("What comes next in the series: 2, 4, 6, 8, ?", Arrays.asList("10", "11", "12", "14"), 1));
            questions.add(new IQquestions("What is 12 + 15?", Arrays.asList("25", "26", "27", "28"), 3));
            questions.add(new IQquestions("Which shape is different?", Arrays.asList("Circle", "Square", "Triangle", "Rectangle"), 2));
            questions.add(new IQquestions("If all roses are flowers and some flowers fade quickly, then:", Arrays.asList("All roses fade quickly", "Some roses fade quickly", "No roses fade quickly", "Cannot determine"), 2));
            questions.add(new IQquestions("Complete the pattern: 1, 3, 6, 10, ?", Arrays.asList("13", "14", "15", "16"), 3));
            questions.add(new IQquestions("Which word does NOT belong in the group?", Arrays.asList("Apple", "Orange", "Banana", "Carrot"), 4));
            questions.add(new IQquestions("If a car travels 60 miles per hour, how far will it travel in 2.5 hours?", Arrays.asList("120 miles", "150 miles", "180 miles", "200 miles"), 2));
            questions.add(new IQquestions("What number should come next: 25, 24, 22, 19, 15, ?", Arrays.asList("10", "11", "12", "13"), 1));
            questions.add(new IQquestions("If FISH is coded as EHRG, then BIRD is coded as:", Arrays.asList("AHQC", "BHQC", "CHQC", "DHQC"), 2));
            questions.add(new IQquestions("Which number does not belong? 2, 3, 5, 7, 8, 11, 13", Arrays.asList("2", "3", "8", "13"), 3));
            questions.add(new IQquestions("Complete the analogy: Book is to Reading as Fork is to:", Arrays.asList("Kitchen", "Eating", "Cooking", "Food"), 2));
            questions.add(new IQquestions("If yesterday was Monday, what day will it be in 100 days?", Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday"), 3));
            questions.add(new IQquestions("What letter comes next: A, C, F, J, ?", Arrays.asList("N", "O", "P", "Q"), 2));
            questions.add(new IQquestions("If all A's are B's, and all B's are C's, then:", Arrays.asList("All C's are A's", "All A's are C's", "No A's are C's", "Some B's are not C's"), 2));
            questions.add(new IQquestions("Which fraction is largest? 3/4, 2/3, 5/6, 7/9", Arrays.asList("3/4", "2/3", "5/6", "7/9"), 3));
            questions.add(new IQquestions("What comes next in the pattern: Triangle, Square, Pentagon, ?", Arrays.asList("Circle", "Rectangle", "Hexagon", "Octagon"), 3));
            questions.add(new IQquestions("If RED = 27, and BLUE = 37, then GREEN = ?", Arrays.asList("47", "57", "67", "77"), 2));
            questions.add(new IQquestions("Complete the series: 2, 6, 12, 20, ?", Arrays.asList("28", "30", "32", "35"), 2));
            questions.add(new IQquestions("Which word is the odd one out?", Arrays.asList("Swift", "Eagle", "Penguin", "Sparrow"), 3));
            questions.add(new IQquestions("If 5 cats catch 5 mice in 5 minutes, how many cats are needed to catch 100 mice in 100 minutes?", Arrays.asList("5", "25", "50", "100"), 1));
            questions.add(new IQquestions("What comes next in the series: 1, 2, 3, 4, ?", Arrays.asList("5", "6", "7", "8"), 1));
            questions.add(new IQquestions("What is 3 + 2?", Arrays.asList("4", "5", "6", "7"), 2));
            questions.add(new IQquestions("Which shape is different?", Arrays.asList("Circle", "Square", "Triangle", "Hexagon"), 4));
            questions.add(new IQquestions("If all apples are fruits and some fruits are red, then:", Arrays.asList("All apples are red", "Some apples are red", "No apples are red", "Cannot determine"), 2));
            questions.add(new IQquestions("Complete the pattern: 1, 2, 3, 4, ?", Arrays.asList("5", "6", "7", "8"), 1));
            questions.add(new IQquestions("Which word does NOT belong in the group?", Arrays.asList("Cat", "Dog", "Elephant", "Car"), 4));
            questions.add(new IQquestions("If a car travels 30 miles per hour, how far will it travel in 1 hour?", Arrays.asList("20 miles", "30 miles", "40 miles", "50 miles"), 2));
            questions.add(new IQquestions("What number should come next: 5, 6, 7, 8, ?", Arrays.asList("9", "10", "11", "12"), 1));
            questions.add(new IQquestions("If DOG is coded as EPH, then CAT is coded as:", Arrays.asList("DBU", "DPT", "DUR", "DVS"), 1));
            questions.add(new IQquestions("Which number does not belong? 2, 4, 6, 8, 9", Arrays.asList("2", "4", "6", "9"), 4));
            questions.add(new IQquestions("Complete the analogy: Sun is to Day as Moon is to:", Arrays.asList("Night", "Morning", "Evening", "Afternoon"), 1));
            questions.add(new IQquestions("If today is Sunday, what day will it be in 2 days?", Arrays.asList("Tuesday", "Wednesday", "Thursday", "Friday"), 2));
            questions.add(new IQquestions("What letter comes next: A, B, C, D, ?", Arrays.asList("E", "F", "G", "H"), 1));
            questions.add(new IQquestions("If all pens are blue, and all blue items are pens, then:", Arrays.asList("All blue items are pens", "No blue items are pens", "Some blue items are pens", "Cannot determine"), 1));
            questions.add(new IQquestions("Which fraction is largest? 1/2, 1/3, 1/4, 1/5", Arrays.asList("1/2", "1/3", "1/4", "1/5"), 1));
            questions.add(new IQquestions("What comes next in the pattern: Circle, Square, Circle, Square, ?", Arrays.asList("Circle", "Square", "Triangle", "Rectangle"), 1));





        } catch (Exception e) {
            System.out.println("Error initializing questions: " + e.getMessage());
        }
        Collections.shuffle(questions);
        return questions.subList(0,5);
    }

    public static List<IQquestions> getIQQuestionsfor12() {

        try {
            questions.add(new IQquestions("What is the next number in the sequence: 5, 10, 15, 20, ?", Arrays.asList("25", "30", "35", "40"), 1));
            questions.add(new IQquestions("Which of these words is the odd one out?", Arrays.asList("Lion", "Tiger", "Elephant", "Cat"), 3));
            questions.add(new IQquestions("If 3 apples cost 12 dollars, how much do 5 apples cost?", Arrays.asList("15 dollars", "20 dollars", "25 dollars", "30 dollars"), 2));
            questions.add(new IQquestions("Which shape is different from the others?", Arrays.asList("Circle", "Square", "Triangle", "Cylinder"), 4));
            questions.add(new IQquestions("If A = 1, B = 2, and C = 3, what is the sum of the letters in the word 'CAB'?", Arrays.asList("6", "7", "8", "9"), 2));
            questions.add(new IQquestions("Which number comes next in the series: 2, 4, 8, 16, ?", Arrays.asList("32", "24", "48", "64"), 1));
            questions.add(new IQquestions("What comes next in the pattern: A, C, E, G, ?", Arrays.asList("H", "I", "J", "K"), 1));
            questions.add(new IQquestions("Which number does not belong: 1, 3, 5, 7, 9, 11, 12", Arrays.asList("1", "3", "9", "12"), 4));
            questions.add(new IQquestions("Complete the analogy: Foot is to Shoe as Hand is to:", Arrays.asList("Glove", "Ring", "Wrist", "Sleeve"), 1));
            questions.add(new IQquestions("What is the sum of the angles of a triangle?", Arrays.asList("180 degrees", "360 degrees", "90 degrees", "270 degrees"), 1));
            questions.add(new IQquestions("If a car travels 45 miles in 1 hour, how far will it travel in 4 hours?", Arrays.asList("150 miles", "160 miles", "170 miles", "180 miles"), 1));
            questions.add(new IQquestions("Which fraction is the largest?", Arrays.asList("2/3", "3/4", "1/2", "4/5"), 2));
            questions.add(new IQquestions("If all roses are flowers and some flowers are red, then:", Arrays.asList("All roses are red", "Some roses are red", "No roses are red", "Cannot determine"), 2));
            questions.add(new IQquestions("What is the next number in the sequence: 1, 4, 9, 16, ?", Arrays.asList("25", "26", "27", "28"), 1));
            questions.add(new IQquestions("Which word does NOT belong in the group?", Arrays.asList("Carrot", "Potato", "Cucumber", "Apple"), 4));
            questions.add(new IQquestions("If 2 is to 4 as 3 is to what?", Arrays.asList("6", "9", "8", "5"), 1));


        } catch (Exception e) {
            System.out.println("Error initializing questions: " + e.getMessage());
        }
        Collections.shuffle(questions);
        return questions.subList(0,5);
    }

    public static List<IQquestions> getIQQuestionsforUni() {

        try {
            questions.add(new IQquestions("What is the next number in the sequence: 2, 3, 5, 8, 12, 17, ?", Arrays.asList("22", "23", "24", "25"), 1));
            questions.add(new IQquestions("Which word does not belong to the group?", Arrays.asList("Apple", "Banana", "Orange", "Carrot"), 4));
            questions.add(new IQquestions("If the day before yesterday was Wednesday, what day will it be 100 days from now?", Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday"), 3));
            questions.add(new IQquestions("What number should come next: 3, 9, 27, 81, ?", Arrays.asList("162", "243", "324", "405"), 2));
            questions.add(new IQquestions("If five cats can catch five mice in five minutes, how many cats are needed to catch 100 mice in 100 minutes?", Arrays.asList("5", "10", "50", "100"), 1));
            questions.add(new IQquestions("What is the result of 2 to the power of 5 minus 3?", Arrays.asList("29", "30", "31", "32"), 3));
            questions.add(new IQquestions("Which of the following is an odd one out?", Arrays.asList("16", "25", "36", "49", "52"), 5));
            questions.add(new IQquestions("What is the next number in the series: 1, 1, 2, 3, 5, 8, 13, ?", Arrays.asList("21", "24", "25", "26"), 1));
            questions.add(new IQquestions("Which figure completes the pattern?", Arrays.asList("Square", "Circle", "Triangle", "Rectangle"), 2));
            questions.add(new IQquestions("If all men are mortal and Socrates is a man, then:", Arrays.asList("Socrates is mortal", "Socrates is immortal", "Socrates is not a man", "Cannot be determined"), 1));
            questions.add(new IQquestions("Which of the following fractions is the largest?", Arrays.asList("5/8", "4/7", "6/9", "3/5"), 1));
            questions.add(new IQquestions("If two pencils cost $1.50, how much would seven pencils cost?", Arrays.asList("$5.25", "$6.00", "$7.00", "$7.50"), 1));
            questions.add(new IQquestions("If a train moves at a speed of 60 miles per hour for 3 hours, how far will it have traveled?", Arrays.asList("180 miles", "150 miles", "200 miles", "250 miles"), 1));
            questions.add(new IQquestions("Which of these words is the odd one out?", Arrays.asList("Apple", "Orange", "Banana", "Carrot", "Potato"), 5));
            questions.add(new IQquestions("What is the sum of all the angles in a hexagon?", Arrays.asList("540 degrees", "720 degrees", "360 degrees", "900 degrees"), 1));


        } catch (Exception e) {
            System.out.println("Error initializing questions: " + e.getMessage());
        }
        Collections.shuffle(questions);
        return questions.subList(0,5);
    }







}
