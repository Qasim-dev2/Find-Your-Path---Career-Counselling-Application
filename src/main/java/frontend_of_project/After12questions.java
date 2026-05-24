
package com.example.frontend_of_project;

import java.util.*;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class After12questions extends Questions {

    public After12questions(String questionText, List<String> options, int correctOption) {
        super(correctOption, options, questionText);
    }

        public static List<Questions> getRandomMedicalQuestions() {
        List<Questions> questions = new ArrayList<>();
        questions.add(new After12questions("What is the function of the heart?", Arrays.asList("Pumps blood", "Filters toxins", "Digests food", "None"), 1));
        questions.add(new After12questions("What organ filters blood in the human body?", Arrays.asList("Heart", "Kidney", "Liver", "Lungs"), 2));
        questions.add(new After12questions("Which part of the brain controls balance and coordination?", Arrays.asList("Cerebrum", "Cerebellum", "Medulla", "Hypothalamus"), 2));
        questions.add(new After12questions("Which system is responsible for transporting nutrients and oxygen?", Arrays.asList("Respiratory", "Digestive", "Circulatory", "Excretory"), 3));
        questions.add(new After12questions("Which blood type is known as the universal donor?", Arrays.asList("A", "B", "AB", "O"), 4));
        questions.add(new After12questions("What is the powerhouse of the cell?", Arrays.asList("Nucleus", "Mitochondria", "Ribosome", "Golgi Apparatus"), 2));
        questions.add(new After12questions("What is the normal human body temperature in Celsius?", Arrays.asList("36.5", "37.0", "38.5", "39.0"), 2));
        questions.add(new After12questions("Which bone is the longest in the human body?", Arrays.asList("Femur", "Tibia", "Humerus", "Fibula"), 1));
        questions.add(new After12questions("What is the function of red blood cells?", Arrays.asList("Transport oxygen", "Fight infections", "Clot blood", "Produce energy"), 1));
        questions.add(new After12questions("What is the main component of hemoglobin?", Arrays.asList("Iron", "Calcium", "Magnesium", "Potassium"), 1));
        // aur questions dal lena

        Collections.shuffle(questions);
        return questions.subList(0, 5);
    }


    public static List<Questions> getRandomEngineeringQuestions() {
        List<Questions> questions = new ArrayList<>();
        questions.add(new After12questions("What instrument measures atmospheric pressure?", Arrays.asList("Thermometer", "Barometer", "Hygrometer", "Anemometer"), 2));
        questions.add(new After12questions("What is the hardest natural substance on Earth?", Arrays.asList("Gold", "Iron", "Diamond", "Platinum"), 3));
        questions.add(new After12questions("What is the main function of a transformer?", Arrays.asList("Store energy", "Convert AC to DC", "Change voltage", "Measure current"), 3));
        questions.add(new After12questions("Which energy source is renewable?", Arrays.asList("Coal", "Solar", "Natural Gas", "Petroleum"), 2));
        questions.add(new After12questions("What is the SI unit of electric current?", Arrays.asList("Volt", "Ampere", "Watt", "Ohm"), 2));
        questions.add(new After12questions("What material is commonly used in semiconductors?", Arrays.asList("Silicon", "Iron", "Copper", "Aluminum"), 1));
        questions.add(new After12questions("What is the purpose of a resistor?", Arrays.asList("Store energy", "Resist current flow", "Generate power", "None"), 2));
        questions.add(new After12questions("What is Hooke's Law related to?", Arrays.asList("Elasticity", "Thermodynamics", "Fluid mechanics", "Electromagnetism"), 1));
        questions.add(new After12questions("Which programming language is used for Android development?", Arrays.asList("C++", "Java", "Python", "Swift"), 2));
        questions.add(new After12questions("What does a capacitor do in a circuit?", Arrays.asList("Amplify current", "Store electrical energy", "Reduce resistance", "Convert energy"), 2));
        // yahan bhiii

        Collections.shuffle(questions);
        return questions.subList(0, 5);
    }

    public static List<Questions> getRandomArtsQuestions() {
        List<Questions> questions = new ArrayList<>();
        questions.add(new After12questions("Who painted the Last Supper?", Arrays.asList("Van Gogh", "Da Vinci", "Monet", "Picasso"), 2));
        questions.add(new After12questions("Who painted the Starry Night?", Arrays.asList("Picasso", "Da Vinci", "Van Gogh", "Rembrandt"), 3));
        questions.add(new After12questions("Who created the sculpture of David?", Arrays.asList("Michelangelo", "Da Vinci", "Rodin", "Bernini"), 1));
        questions.add(new After12questions("Who painted The Scream?", Arrays.asList("Munch", "Picasso", "Dali", "Kandinsky"), 1));
        questions.add(new After12questions("What is the style of painting that uses dots?", Arrays.asList("Pointillism", "Cubism", "Surrealism", "Impressionism"), 1));
        questions.add(new After12questions("Who wrote 'The Odyssey'?", Arrays.asList("Homer", "Virgil", "Sophocles", "Aristotle"), 1));
        questions.add(new After12questions("What art movement did Salvador Dali belong to?", Arrays.asList("Surrealism", "Impressionism", "Cubism", "Futurism"), 1));
        questions.add(new After12questions("What does the term 'Fresco' refer to?", Arrays.asList("A type of sculpture", "A painting technique", "A type of pottery", "A style of architecture"), 2));
        questions.add(new After12questions("Who painted 'Girl with a Pearl Earring'?", Arrays.asList("Van Gogh", "Da Vinci", "Vermeer", "Rembrandt"), 3));
        questions.add(new After12questions("What is the primary color of the sky in a clear day?", Arrays.asList("Blue", "Green", "Red", "Yellow"), 1));
        // aur dal lena

        Collections.shuffle(questions);
        return questions.subList(0, 5);
    }
}
