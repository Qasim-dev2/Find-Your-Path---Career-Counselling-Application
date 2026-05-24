package com.example.frontend_of_project;

import java.util.*;
import java.util.Arrays;

public class b10questions {

    String questionText;
    List<String> options;
    int correctOptions;

    public b10questions(String questionText, List<String> options, int correctOptions) {
        this.correctOptions = correctOptions;
        this.options = options;
        this.questionText = questionText;
    }


    public static List<b10questions> getScienceQuestions() {
        List<b10questions> scienceQuestions = new ArrayList<>();
        scienceQuestions.add(new b10questions("What is the chemical symbol for water?", Arrays.asList("H2O", "O2", "CO2", "HO2"), 1));
        System.out.println();
        scienceQuestions.add(new b10questions("What is the largest planet in our solar system?",
                Arrays.asList("Mars", "Venus", "Jupiter", "Saturn"), 3));

        scienceQuestions.add(new b10questions("Which gas do plants absorb during photosynthesis?",
                Arrays.asList("Oxygen", "Carbon dioxide", "Nitrogen", "Hydrogen"), 2));

        scienceQuestions.add(new b10questions("What is the atomic number of Oxygen?",
                Arrays.asList("6", "7", "8", "9"), 3));

        scienceQuestions.add(new b10questions("Which of these is a unit of force?",
                Arrays.asList("Watt", "Joule", "Newton", "Pascal"), 3));

        scienceQuestions.add(new b10questions("What is the process by which liquid turns into gas?",
                Arrays.asList("Condensation", "Evaporation", "Freezing", "Melting"), 2));

        scienceQuestions.add(new b10questions("What type of cell does not have a nucleus?",
                Arrays.asList("Plant cell", "Animal cell", "Bacterial cell", "Fungal cell"), 3));

        scienceQuestions.add(new b10questions("Which blood type is known as the universal donor?",
                Arrays.asList("A+", "B+", "AB+", "O-"), 4));

        scienceQuestions.add(new b10questions("What is the speed of light in kilometers per second?",
                Arrays.asList("250,000", "300,000", "350,000", "400,000"), 2));


        scienceQuestions.add(new b10questions("What is the powerhouse of the cell?", Arrays.asList("Nucleus", "Mitochondria", "Ribosome", "Cytoplasm"), 2));

        Collections.shuffle(scienceQuestions);
        return scienceQuestions.subList(0,5);
    }


    public static List<b10questions> getComputerQuestions() {
        List<b10questions> computerQuestions = new ArrayList<>();
        computerQuestions.add(new b10questions("What does CPU stand for?", Arrays.asList("Central Processing Unit", "Central Power Unit", "Computer Processing Unit", "Central Program Unit"), 1));
        computerQuestions.add(new b10questions("Which is a programming language?", Arrays.asList("Python", "HTML", "CSS", "Photoshop"), 1));
        computerQuestions.add(new b10questions("What does RAM stand for?",
                Arrays.asList("Random Access Memory", "Read Access Memory", "Read Active Memory", "Random Active Memory"), 1));

        computerQuestions.add(new b10questions("Which company created Windows?",
                Arrays.asList("Apple", "Microsoft", "Google", "IBM"), 2));

        computerQuestions.add(new b10questions("What is the file extension for a Java source file?",
                Arrays.asList(".exe", ".txt", ".java", ".class"), 3));

        computerQuestions.add(new b10questions("What does URL stand for?",
                Arrays.asList("Universal Resource Link", "Uniform Resource Locator", "Universal Reference Link", "Uniform Reference Locator"), 2));

        computerQuestions.add(new b10questions("Which of these is not a web browser?",
                Arrays.asList("Chrome", "Firefox", "Excel", "Safari"), 3));

        computerQuestions.add(new b10questions("What does PDF stand for?",
                Arrays.asList("Personal Document Format", "Portable Document Format", "Printable Document Format", "Public Document Format"), 2));

        computerQuestions.add(new b10questions("Which symbol represents the Boolean AND operator in most programming languages?",
                Arrays.asList("&&", "||", "!!", "##"), 1));

        computerQuestions.add(new b10questions("What is the standard port number for HTTP?",
                Arrays.asList("443", "80", "21", "25"), 2));
Collections.shuffle(computerQuestions);


        return computerQuestions.subList(0,5);
    }


    public static List<b10questions> getArtsQuestions() {
        List<b10questions> artsQuestions = new ArrayList<>();
        artsQuestions.add(new b10questions("Who painted the Starry Night?", Arrays.asList("Van Gogh", "Picasso", "Monet", "Da Vinci"), 1));
        artsQuestions.add(new b10questions("What is a haiku?", Arrays.asList("A type of painting", "A short poem", "A sculpture", "A dance form"), 2));
        artsQuestions.add(new b10questions("Who painted the Mona Lisa?",
                Arrays.asList("Van Gogh", "Michelangelo", "Da Vinci", "Rembrandt"), 3));

        artsQuestions.add(new b10questions("Which musical instrument has 88 keys?",
                Arrays.asList("Guitar", "Piano", "Violin", "Flute"), 2));

        artsQuestions.add(new b10questions("What art movement did Andy Warhol belong to?",
                Arrays.asList("Impressionism", "Pop Art", "Cubism", "Surrealism"), 2));

        artsQuestions.add(new b10questions("In which city is the Louvre Museum located?",
                Arrays.asList("London", "Rome", "Paris", "New York"), 3));

        artsQuestions.add(new b10questions("What colors must be mixed to make green?",
                Arrays.asList("Red and Blue", "Blue and Yellow", "Red and Yellow", "Blue and White"), 2));

        artsQuestions.add(new b10questions("Who composed the 'Fifth Symphony'?",
                Arrays.asList("Mozart", "Bach", "Beethoven", "Tchaikovsky"), 3));

        artsQuestions.add(new b10questions("Which of these is not a type of dance?",
                Arrays.asList("Ballet", "Waltz", "Sonnet", "Tango"), 3));

        artsQuestions.add(new b10questions("What nationality was Pablo Picasso?",
                Arrays.asList("French", "Italian", "Spanish", "Portuguese"), 3));

Collections.shuffle(artsQuestions);
        return artsQuestions.subList(0,5);
    }
}
